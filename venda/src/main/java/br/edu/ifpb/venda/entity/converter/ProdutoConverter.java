package br.edu.ifpb.venda.entity.converter;

import br.edu.ifpb.venda.dao.ProdutoDao;
import br.edu.ifpb.venda.dao.ProdutoDaoIF;
import br.edu.ifpb.venda.entity.Produto;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Amanda
 */
@FacesConverter(value = "produtoConverter", forClass = Produto.class)
public class ProdutoConverter implements Converter {
    
    private final ProdutoDaoIF dao = new ProdutoDao();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty()){
            return null;
        }else{
            Long id = Long.parseLong(value);
            Produto p = dao.buscar(id);
            System.out.println(p.getDescricao());
            return p;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Produto p = (Produto) value;
       if(p != null){
            return String.valueOf(p.getId());
        }else{
            return null;
        }
    }

}
