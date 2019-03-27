package br.edu.ifpb.venda.api;

import br.edu.ifpb.venda.dao.ProdutoDaoIF;
import br.edu.ifpb.venda.entity.Produto;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author Amanda
 */
@Stateless//(mappedName = "consumirCliente")
//@Remote(ProdutoDaoIF.class)
public class ProdutoClient{ //implements ProdutoDaoIF{
    
    private final String url = "http://localhost:8081/venda/api/produtos";
    private final Client client = ClientBuilder.newClient();
    private final WebTarget produtos = client.target(url);

//    @Override
    public void salvar(Produto produto) {
        produtos.request().
            post(
                Entity.json(produto)
            );
    }

//    @Override
    public Produto buscar(long id) {
        WebTarget produtoComId = produtos.path("{id}").resolveTemplate("id",id);
        Response resposta = produtoComId.request().get();
        String corpo = resposta.readEntity(String.class);
        return toProduto(corpo);
    }

//    @Override
    public List<Produto> listar() {
        Response response = produtos.request().get();
        String corpo = response.readEntity(String.class);
        System.out.println(corpo);
        JsonArray jsonArray = Json.createReader(
                new StringReader(corpo)
        ).readArray();
        
        return jsonArray.stream()
            .map(obj -> new Produto((JsonObject) obj))
            .collect(Collectors.toList());
    }
    
    public Produto toProduto(String json) {
        JsonObject jsonObject = Json.createReader(
                new StringReader(json)
        ).readObject();
        
        return new Produto(jsonObject);
    }
}
