package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// TODO Auto-generated method stub
		
		//set file name
		response.addHeader("Content-Disposition", "attachment;filename=WhUser.xlsx");
		
		//read data from model
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>)model.get("list");
		
		//create sheet
		Sheet sheet=workbook.createSheet("WhUsers");
		
		//create header
		setHead(sheet);
		//create body
		setBody(sheet,list);
	}
	
	private void setHead(Sheet sheet) {
		// TODO Auto-generated method stub
		Row row=sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("TYPE");
			row.createCell(2).setCellValue("CODE");
			row.createCell(3).setCellValue("USER");
			row.createCell(4).setCellValue("EMAIL");
			row.createCell(5).setCellValue("CONACT");
			row.createCell(6).setCellValue("ID TYPE");
			row.createCell(7).setCellValue("ID NUMBER");
		
	}
	
	private void setBody(Sheet sheet, List<WhUserType> list) {
		// TODO Auto-generated method stub
		int rowNum=1;
		for(WhUserType s:list) {
			Row row=sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(s.getId());
				row.createCell(1).setCellValue(s.getUserType());
				row.createCell(2).setCellValue(s.getUserCode());
				row.createCell(3).setCellValue(s.getUserFor());
				row.createCell(4).setCellValue(s.getUserEmail());
				row.createCell(5).setCellValue(s.getUserContact());
				row.createCell(6).setCellValue(s.getUserIdtype());
				row.createCell(7).setCellValue(s.getIdNumber());
		}
		
	}   
}
