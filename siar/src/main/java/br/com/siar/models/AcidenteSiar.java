package br.com.siar.models;

import java.util.Locale;

import org.springframework.format.number.NumberFormatter;


public class AcidenteSiar extends BasicModel {
	
	public static final String COLLECTION_NAME = "acidenteSiar";

	private Prioridade prioridade;
	private String descricao;

	// Local
	private float latitude;
	private float longitude;
	private String logradouro;
	private int numero;
	private String referencia;
	private String cidade;
	private String uf;
	
	public String getLocalResumido() {
		String str = "";
		
		if (logradouro == null || logradouro.isEmpty())
			logradouro = "???";
		str += logradouro;
		if (numero > 0)
			str += String.format(", %d", numero);
		str += "\n";
		
		if (latitude != 0 && longitude != 0)
			str += String.format("( %.4f , %.4f )", latitude, longitude);
		
		return str;
	}
	
	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public enum Prioridade implements Comparable<Prioridade> {
		MUITO_BAIXA("Muito baixa"),
		BAIXA("Baixa"),
		NORMAL("Normal"),
		ALTA("Alta"),
		MUITO_ALTA("Muito alta");
		
		Prioridade(String str) {
			desc = str;
		}
		
		private String desc;
		
		public String getDesc() {
			return desc;
		}
	}

}
