package br.com.silvanopessoa.rest.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.six2six.fixturefactory.Fixture;

public class DoubleTest {

	/**
	 * Deve_exemplo_dummy.
	 * 
	 * Objects são repassados mas nunca utilizados. 
	 * Normalmente são usados para preencher listas de parâmetros.
	 * 
	 */
	@Test
	public void deve_exemplo_dummy(){
		Usuario cliente = Mockito.mock(Usuario.class);
		System.out.println(cliente);
	}
	
	/**
	 * Deve_exemplo_stub.
	 * 
	 * Providenciam respostas pré configuradas para as chamadas feitas durante os testes, 
	 * normalmente não respondem a nada que não esteja programado para o teste. 
	 * 
	 * Stubs também podem gravar informações sobre as chamadas, 
	 * como um gateway que lembra as mensagens que 'enviou', 
	 * ou talvez apenas quantas mensagens 'enviou'.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void deve_exemplo_stub(){
		List<SimpleGrantedAuthority> mockedList = Mockito.mock(ArrayList.class);
		SimpleGrantedAuthority simpleGrantedAuthority= new SimpleGrantedAuthority("asdasd");
		Mockito.stub(mockedList.get(0)).toReturn(simpleGrantedAuthority);
		System.out.println(mockedList.get(0));
	}
	
	
	/**
	 * Deve_exemplo.
	 * 
	 * Outro exemplo são objetos padrão, pré definidos e usados diversas vezes nos testes. 
	 * Em um sistema acadêmico um aluno inscrito ou com matricula cancelada, pode ser criado dessa forma. 
	 * É comum que um objeto Fake tenha apenas os atributos importantes para representar o estado necessário ao teste. 
	 * Assim, um aluno inscrito provavelmente terá apenas o valor "inscrito" para o atributo "situação".
	 * 
	 * http://www.danielcastellani.com.br/2013/09/test-double.html
	 */
	@Test
	public void deve_exemplo_fake(){
		Usuario usuarioFake = loadUsuario("valid");
		System.out.println(usuarioFake);
	}
	
	/**
	 * Deve_exemplo_mock.
	 */
	@Test
	public void deve_exemplo_mock(){
		
	}
	
	/**
	 * Deve_exemplo_spy.
	 * 
	 * http://examples.javacodegeeks.com/core-java/mockito/mockito-spy-example/
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void deve_exemplo_spy(){
		List<SimpleGrantedAuthority> spy = Mockito.mock(ArrayList.class);
		SimpleGrantedAuthority simpleGrantedAuthority= new SimpleGrantedAuthority("asdasd");
		Mockito.stub(spy.get(0)).toReturn(simpleGrantedAuthority);
		System.out.println(spy.get(0));
		Mockito.verify(spy, Mockito.times(1)).get(0);
	}
	
	
    /**
     * Load usuario.
     *
     * @param nome O(a)(s) nome
     * @return O(a)(s) usuario
     */
    public static Usuario loadUsuario(String nome) {
        return Fixture.from(Usuario.class).gimme(nome);
    }

}
