package br.com.siar.models;


public class UsuarioSiar extends BasicModel {
	
	public static final String COLLECTION_NAME = "usuarioSiar";

	private String email;
	private String nome;
	private String cpf;
	private String senha;
	private TipoUsuario tipoUsuario;
	
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
		ADMINISTRADOR("Administrador", "admin"),
		COORDENADOR("Coordenador", "coordenador"),
		ESPECIALISTA("Especialista", "especialista"),
		CHEFE_MISSAO("Chefe de missão", "chefemissao");
		
		TipoUsuario(String str, String str2) {
			desc = str;
			homefile = str2;
		}
		
		private String desc;
		public String homefile;
		
		public String getDesc() {
			return desc;
		}
	}
}