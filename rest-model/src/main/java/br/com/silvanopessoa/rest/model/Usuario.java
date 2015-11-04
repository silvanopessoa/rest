/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  05/06/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.model;

import java.util.Collection;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.silvanopessoa.rest.lang.base.JsonToStringStyle;
import br.com.silvanopessoa.rest.model.base.AbstractPersistable;

/**
 * O(a) Class Usuario.
 *
 * @author silvano.pessoa
 * @since 28/10/2014 - 21:31:26
 */
@Entity
public class Usuario extends AbstractPersistable<String> implements UserDetails{

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a) data alteracao. */
    private DateTime dataAlteracao;
    
    /** O(a)(s) cliente id. */
    private String clienteId;
    
    /** O(a)(s) enabled. */
    private Boolean enabled;
    
    /** O(a)(s) data expiracao credencial. */
    private DateTime dataExpiracaoCredencial;
    
    /** O(a)(s) data expiracao conta. */
    private DateTime dataExpiracaoConta;
    
    /** O(a)(s) account non locked. Bloqueia com tentativa de ataque. */
    private Boolean accountNonLocked;
    
    /** O(a)(s) password. */
    private String password;
    
    /** O(a)(s) authorities. */
    private Collection<? extends GrantedAuthority> authorities;

	//-------------------------------------------------------------------------------------------//
	//-------------------------------------- CODIGO CLIENTE -------------------------------------//
	//-------------------------------------------------------------------------------------------//
    
    /**
     * Obtém o valor do(a)(s) cliente id.
     *
     * @return O(a)(s) cliente id
     */
    public String getClienteId() {
		return clienteId;
	}

	/**
	 * Define o valor do(a)(s) cliente id.
	 *
	 * @param clienteId o novo valor do(a)(s) cliente id
	 */
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	//-------------------------------------------------------------------------------------------//
	//-------------------------------------- DATA ALTERACAO -------------------------------------//
	//-------------------------------------------------------------------------------------------//
	
	/**
     * Obtém o valor do(a)(s) data alteracao.
     *
     * @author silvano.pessoa
     * @return o(a) data alteracao
     */
    public DateTime getDataAlteracao() {
        return dataAlteracao;
    }

    /**
     * Determina o(a) data alteracao.
     *
     * @author silvano.pessoa
     * @param dataAlteracao
     *            o(a) novo(a) data alteracao
     */
    public void setDataAlteracao(DateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
	
	//-------------------------------------------------------------------------------------------//
	//---------------------------------------- AUTHORITIES --------------------------------------//
	//-------------------------------------------------------------------------------------------//
    
    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
     */
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
    
    /**
     * Define o valor do(a)(s) authorities.
     *
     * @param authorities o novo valor do(a)(s) authorities
     */
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
    	this.authorities = authorities;
    }

	//-------------------------------------------------------------------------------------------//
	//----------------------------------------- PASSWORD ----------------------------------------//
	//-------------------------------------------------------------------------------------------//

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Define o valor do(a)(s) password.
	 *
	 * @param password o novo valor do(a)(s) password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	//-------------------------------------------------------------------------------------------//
	//-------------------------------------- IDENTIFICADOR --------------------------------------//
	//-------------------------------------------------------------------------------------------//

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return super.getId();
	}
	
    /* (non-Javadoc)
     * @see br.com.silvanopessoa.rest.model.base.AbstractPersistable#setId(java.io.Serializable)
     */
    @Override
    public void setId(String id) {
        super.setId(id);
    }

	//-------------------------------------------------------------------------------------------//
	//----------------------------------- EXPIRAÇÃO DA CONTA ------------------------------------//
	//-------------------------------------------------------------------------------------------//
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return dataExpiracaoConta == null || DateTime.now().isBefore(dataExpiracaoConta);
	}
	
	/**
	 * Define o valor do(a)(s) data expiracao conta.
	 *
	 * @param dataExpiracaoConta o novo valor do(a)(s) data expiracao conta
	 */
	public void setDataExpiracaoConta(DateTime dataExpiracaoConta) {
		this.dataExpiracaoConta = dataExpiracaoConta;
	}

	//-------------------------------------------------------------------------------------------//
	//--------------------------------------- BLOQUEADO -----------------------------------------//
	//-------------------------------------------------------------------------------------------//

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		if(accountNonLocked == null){
			throw new IllegalStateException("Informações sobre a situação da conta bloqueada não encontrado.");
		}
		return accountNonLocked;
	}
	
	/**
	 * Define o valor do(a)(s) account non locked.
	 *
	 * @param accountNonLocked o novo valor do(a)(s) account non locked
	 */
	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	//-------------------------------------------------------------------------------------------//
	//--------------------------------------- CREDENCIAL ----------------------------------------//
	//-------------------------------------------------------------------------------------------//
	

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return dataExpiracaoCredencial == null || DateTime.now().isBefore(dataExpiracaoCredencial);
	}
	
    /**
     * Define o valor do(a)(s) data expiracao credencial.
     *
     * @param dataExpiracaoCredencial o novo valor do(a)(s) data expiracao credencial
     */
    public void setDataExpiracaoCredencial(DateTime dataExpiracaoCredencial) {
        this.dataExpiracaoCredencial = dataExpiracaoCredencial;
    }
    
	//-------------------------------------------------------------------------------------------//
	//----------------------------------------- ATIVO -------------------------------------------//
	//-------------------------------------------------------------------------------------------//
    
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
        if (enabled == null) {
            throw new IllegalStateException("Informações sobre a ativação do usuário não encontrado.");
        }
        return enabled;
	}

	/**
	 * Define o valor do(a)(s) enabled.
	 *
	 * @param enabled o novo valor do(a)(s) enabled
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	//-------------------------------------------------------------------------------------------//
	//--------------------------------- TO_STRING/EQUALS/HASHCODE -------------------------------//
	//-------------------------------------------------------------------------------------------//
	
    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new JsonToStringStyle());
    }

}
