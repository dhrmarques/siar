package br.com.siar.services;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.siar.models.AcidenteSiar;

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
	
}
