/**
 * 
 */
package br.com.siar.models;


/**
 * @author Leo
 *
 */
public enum StatusMissao {
	PENDENTE, // aguardando aloca��o por parte do coordenador
	AGUARDANDO_RECURSOS, // ap�s aloca��o, enquanto o Chefe de Miss�o ainda n�o fez nenhuma Atualiza��o
	EM_ANDAMENTO_FALTANDO_RECURSOS, // Quando parte dos recursos chegou e p�de ser iniciada a miss�o
	EM_ANDAMENTO, // Quando todos os recursos chegaram e a miss�o j� foi iniciada
	FINALIZANDO, // Quando a miss�o parece finalizada, mas o Chefe de Miss�o quer ter certeza disso
	FINALIZADA_SUCESSO, // Miss�o conclu�da com sucesso
	FINALIZADA_PROBLEMA; // A miss�o falhou (em parte? especificar no coment�rio)
	
	private StatusMissao(String legivel) {
		this.legivel = legivel;
	}
	private StatusMissao() {
		this.legivel = this.toString();
	}
	
	private final String legivel;
	public String getLegivel() {
		return legivel;
	}
	
	public StatusMissao[] proximos() {
		switch (this) {
			
		case AGUARDANDO_RECURSOS:
			return new StatusMissao[]{EM_ANDAMENTO_FALTANDO_RECURSOS, EM_ANDAMENTO, FINALIZADA_PROBLEMA};

		case EM_ANDAMENTO_FALTANDO_RECURSOS:
			return new StatusMissao[]{EM_ANDAMENTO, FINALIZANDO, FINALIZADA_PROBLEMA};
			
		case EM_ANDAMENTO:
			return new StatusMissao[]{FINALIZANDO, FINALIZADA_SUCESSO, FINALIZADA_PROBLEMA};
			
		case FINALIZANDO:
			return new StatusMissao[]{EM_ANDAMENTO, FINALIZADA_SUCESSO, FINALIZADA_PROBLEMA};
			
		default: // Pendentes ou finalizadas: respectivamente, n�o podem ainda ou n�o podem mais ser atualizadas
			return null;
			
		}
	}
}
