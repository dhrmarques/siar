package br.com.siar.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class UsuarioSiar {

	@Id
	private ObjectId id;
	private String email;
	private String nome;
	private String cpf;
	private String senha;
	private TipoUsuario tipoUsuario;
	
	
	
	public ObjectId getId() {
		return id;
	}



	public void setId(ObjectId id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}



	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}



	public enum TipoUsuario {
		ADMINISTRADOR,
		COORDENADOR,
		ESPECIALISTA,
		CHEFE_MISSAO
	}
}