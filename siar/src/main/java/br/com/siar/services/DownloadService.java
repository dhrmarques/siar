package br.com.siar.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.siar.models.AcidenteSiar;
import br.com.siar.models.AtualizacaoMissaoSiar;
import br.com.siar.models.MissaoSiar;
import br.com.siar.models.TipoMissaoSiar;
import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.response.MissaoResponse;

public class DownloadService extends BasicService {

	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	@Override
	public MongoTemplate getSiarmongoTemplate() {
		return siarmongoTemplate;
	}

	@Override
	public void setSiarmongoTemplate(MongoTemplate siarmongoTemplate) {
		this.siarmongoTemplate = siarmongoTemplate;
	}

	@Override
	protected String getCollectionName() {
		return null;
	}

	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(this.getClass());
	}
	
	public HSSFWorkbook reportAcidentes() throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sh = wb.createSheet("Acidentes");
		
		// Listing the AcidenteSiar elements.
		List<AcidenteSiar> acidentes = siarmongoTemplate.findAll(AcidenteSiar.class, AcidenteSiar.COLLECTION_NAME);
		
		//Creating header row
		HSSFRow headRow = sh.createRow(0);
		HSSFCell cell0 = headRow.createCell(0);
		HSSFCell cell1 = headRow.createCell(1);
		HSSFCell cell2 = headRow.createCell(2);
		
		cell0.setCellValue("Prioridade");
		cell1.setCellValue("Descrição");
		cell2.setCellValue("Data de Criação");
		
		int i = 2;
		for (AcidenteSiar acidente : acidentes) {
			HSSFRow row = sh.createRow(i);
			HSSFCell rowCell0 = row.createCell(0);
			HSSFCell rowCell1 = row.createCell(1);
			HSSFCell rowCell2 = row.createCell(2);
			
			rowCell0.setCellValue(acidente.getPrioridade().getDesc());
			rowCell1.setCellValue(acidente.getDescricao());
			rowCell2.setCellValue(acidente.getDataCriacao1());
			
			i++;
		}
		
		return wb;
	}

	public HSSFWorkbook reportMissoes(Date start, Date end) {
		// TODO
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sh = wb.createSheet("Missoes");
		
		// Lista de Missões iniciadas entre as datas escolhidas start 
		Query q = new Query();
		ObjectId startId = new ObjectId(start);
		ObjectId endId = new ObjectId(end);
		q.addCriteria(Criteria.where("_id").gte(startId).lt(endId));
		System.out.println(q.toString());
		
		List<MissaoSiar> missoes = siarmongoTemplate.find(q, MissaoSiar.class, MissaoSiar.COLLECTION_NAME);
		List<MissaoResponse> missoesResponse = new ArrayList<MissaoResponse>();
		Map<ObjectId, List<AtualizacaoMissaoSiar>> attsMap = new HashMap<ObjectId, List<AtualizacaoMissaoSiar>>();
		for (MissaoSiar missao : missoes) {
			missoesResponse.add(responseFromModel(missao));
			ObjectId missaoId = missao.getId();
			
			Query qq = new Query(Criteria.where("missaoId").is(missaoId));
			List<AtualizacaoMissaoSiar> atts = siarmongoTemplate.find(qq, AtualizacaoMissaoSiar.class, AtualizacaoMissaoSiar.COLLECTION_NAME);
			
			attsMap.put(missaoId, atts);
		}
		
		//Creating header row
		HSSFRow headRow = sh.createRow(0);
		HSSFCell cell0 = headRow.createCell(0);
		HSSFCell cell1 = headRow.createCell(1);
		HSSFCell cell2 = headRow.createCell(2);
		HSSFCell cell3 = headRow.createCell(3);
		HSSFCell cell4 = headRow.createCell(4);
		
		cell0.setCellValue("Data Missão");
		cell1.setCellValue("Chefe atribuído");
		cell2.setCellValue("Acidente");
		cell3.setCellValue("Tipo de missão");
		cell4.setCellValue("Status atual");
		
		int i = 1;
		for (MissaoResponse mr : missoesResponse) {
			// uma linha a mais para separação
			i+=2;
			
			HSSFRow row = sh.createRow(i);
			HSSFCell rowCell0 = row.createCell(0);
			HSSFCell rowCell1 = row.createCell(1);
			HSSFCell rowCell2 = row.createCell(2);
			HSSFCell rowCell3 = row.createCell(3);
			HSSFCell rowCell4 = row.createCell(4);
			
			rowCell0.setCellValue(mr.getMissao().getDataCriacao1());
			rowCell1.setCellValue(mr.getChefe() != null ? mr.getChefe().getNome() : "Sem chefe");
			rowCell2.setCellValue(mr.getAcidente().getDescricao());
			rowCell3.setCellValue(mr.getTipoMissao().getTitulo());
			rowCell4.setCellValue(mr.getMissao().getStatus().getLegivel());

			i++;

			for (AtualizacaoMissaoSiar ams : attsMap.get(mr.getMissao().getId())) {
				i++;
				
				HSSFRow subrow = sh.createRow(i);
				HSSFCell subrowCell0 = subrow.createCell(0);
				HSSFCell subrowCell1 = subrow.createCell(1);
				HSSFCell subrowCell2 = subrow.createCell(2);
				
				subrowCell0.setCellValue(ams.getDataCriacao1());
				subrowCell1.setCellValue(ams.getStatus().getLegivel());
				subrowCell2.setCellValue(ams.getComentario() != null ? ams.getComentario() : "...");
				
			}
		}
		
		return wb;
	}
	
	private MissaoResponse responseFromModel(MissaoSiar missao) {
		
		return new MissaoResponse(missao,
				siarmongoTemplate.findById(missao.getAcidenteId(), AcidenteSiar.class),
				siarmongoTemplate.findById(missao.getTipoMissaoId(), TipoMissaoSiar.class),
				siarmongoTemplate.findById(missao.getChefeId(), UsuarioSiar.class));
	}
	
}
