package br.edu.ifpb.venda.api;

import br.edu.ifpb.venda.dao.ProdutoDao;
import br.edu.ifpb.venda.entity.Produto;
import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("produtos")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ProdutoResource {

    @Inject
    private ProdutoDao service;
    @Context
    private UriInfo uriInfo;

    @POST
    public Response novoProduto(Produto produto) {
        this.service.salvar(produto);
        String id = String.valueOf(produto.getId());
        URI location = uriInfo.getAbsolutePathBuilder()
                .path(id)
                .build();

        // Retorna uri ../api/produtos/<id_do_produto_salvo>
        return Response.created(location)
                .entity(produto)
                .build();
    }

}
