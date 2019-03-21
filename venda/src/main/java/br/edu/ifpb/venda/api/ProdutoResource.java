package br.edu.ifpb.venda.api;

import br.edu.ifpb.venda.dao.ProdutoDao;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("produtos")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ProdutoResource {
    
    @Inject
    private ProdutoDao service;
    @Context
    private UriInfo uriInfo;
    
}
