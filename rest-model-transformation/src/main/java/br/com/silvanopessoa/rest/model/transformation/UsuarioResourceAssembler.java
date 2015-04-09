package br.com.silvanopessoa.rest.model.transformation;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import br.com.silvanopessoa.model.usuario.v1.UsuarioType;
import br.com.silvanopessoa.rest.model.Usuario;

/**
 * O(a) Class UsuarioResourceAssembler.
 *
 * @author silvano.pessoa
 * @since 07/04/2015 - 22:18:50
 */
public class UsuarioResourceAssembler extends ResourceAssemblerSupport<Usuario, UsuarioType>{
	
	private final Class<?> controllerClass;
	
    /**
     * Instantiates a new usuario resource assembler.
     *
     * @param controllerClass o(a) controller class
     * @param resourceType o(a) resource type
     */
    public UsuarioResourceAssembler(Class<?> controllerClass, Class<UsuarioType> resourceType) {
        super(controllerClass, resourceType);
        this.controllerClass = controllerClass;
    }

    /* (non-Javadoc)
     * @see org.springframework.hateoas.ResourceAssembler#toResource(java.lang.Object)
     * 
     * @see http://docs.spring.io/spring-hateoas/docs/current/reference/pdf/spring-hateoas-reference.pdf
     */
    @Override
    public UsuarioType toResource(Usuario entity) {
        UsuarioType usuarioType = new UsuarioType();
        usuarioType.setLogin(entity.getId());
        Link link = linkTo(this.controllerClass).slash(entity).withSelfRel();
        usuarioType.add(link);
        return usuarioType;
    }

}
