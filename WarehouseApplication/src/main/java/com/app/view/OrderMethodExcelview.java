package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelview extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// TODO Auto-generated method stub
		
		//set file name
		response.addHeader("Content-Disposition", "attachment;filename=Order.xlsx");
		
		//read data from model
		@SuppressWarnings("unchecked")
		List<OrderMethod> list=(List<OrderMethod>)model.get("list");
		
		//create sheet
		Sheet sheet=workbook.createSheet("Orders");
		
		//create header
		setHead(sheet);
		//create body
		setBody(sheet,list);
	}
	
	private void setHead(Sheet sheet) {
		// TODO Auto-generated method stub
		Row row=sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("MODE");
			row.createCell(2).setCellValue("CODE");
			row.createCell(3).setCellValue("TYPE");
			row.createCell(4).setCellValue("ACCEPT");
			row.createCell(5).setCellValue("NOTE");
		
	}
	
	private void setBody(Sheet sheet, List<OrderMethod> list) {
		// TODO Auto-generated method stub
		int rowNum=1;
		for(OrderMethod s:list) {
			Row row=sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(s.getId());
				row.createCell(1).setCellValue(s.getOrderMode());
				row.createCell(2).setCellValue(s.getOrderCode());
				row.createCell(3).setCellValue(s.getExeuteType());
				row.createCell(4).setCellValue(s.getOrderAccept());
				row.createCell(5).setCellValue(s.getNote());
		}
		
	}   

}
