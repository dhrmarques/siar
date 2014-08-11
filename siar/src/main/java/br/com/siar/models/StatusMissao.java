/**
 * 
 */
package br.com.siar.models;


/**
 * @author Leo
 *
 */
public enum StatusMissao {
	PENDENTE("Pendente"), // aguardando alocação por parte do coordenador
	AGUARDANDO_RECURSOS("Aguardando recursos"), // após alocação, enquanto o Chefe de Missão ainda não fez nenhuma Atualização
	EM_ANDAMENTO_FALTANDO_RECURSOS("Em andamento, mas faltando recursos"), // Quando parte dos recursos chegou e pôde ser iniciada a missão
	EM_ANDAMENTO("Em andamento"), // Quando todos os recursos chegaram e a missão já foi iniciada
	FINALIZANDO("Finalizando"), // Quando a missão parece finalizada, mas o Chefe de Missão quer ter certeza disso
	FINALIZADA_SUCESSO("Finalizada com sucesso"), // Missão concluída com sucesso
	FINALIZADA_PROBLEMA("Encerrada devido a problemas"); // A missão falhou (em parte? especificar no comentário)
	
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
			
		default: // Pendentes ou finalizadas: respectivamente, não podem ainda ou não podem mais ser atualizadas
			return null;
			
		}
	}
}
