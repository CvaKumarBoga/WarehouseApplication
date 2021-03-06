package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;


import com.app.model.UomType;


@Component
public class UomTypeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// TODO Auto-generated method stub
		
		//set file name
		response.addHeader("Content-Disposition", "attachment;filename=Uom.xlsx");
		
		//read data from model
		@SuppressWarnings("unchecked")
		List<UomType> list=(List<UomType>)model.get("list");
		
		//create sheet
		Sheet sheet=workbook.createSheet("Uom");
		
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
			row.createCell(2).setCellValue("MODEL");
			row.createCell(5).setCellValue("NOTE");
		
	}
	
	private void setBody(Sheet sheet, List<UomType> list) {
		// TODO Auto-generated method stub
		int rowNum=1;
		for(UomType s:list) {
			Row row=sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(s.getId());
				row.createCell(1).setCellValue(s.getUomType());
				row.createCell(2).setCellValue(s.getUomModel());
				row.createCell(5).setCellValue(s.getNote());
		}
		
	}   
}