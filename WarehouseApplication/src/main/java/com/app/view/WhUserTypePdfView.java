package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//file name+download
		response.addHeader("contenet-Disposition","attachment;filename-WhUsers.pdf");
		//read data
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		Paragraph p=new Paragraph("Welcome to WhUserType");
		document.add(p);
		PdfPTable table=new PdfPTable(8);
		table.addCell("ID");
		table.addCell("TYPE");
		table.addCell("CODE");
		table.addCell("USER");
		table.addCell("EMAIL");
		table.addCell("CONTACT");
		table.addCell("Id TYPE");
		table.addCell("ID NUMBER");


		for(WhUserType s:list) {
			table.addCell(s.getId().toString());
			table.addCell(s.getUserType());
			table.addCell(s.getUserCode());
			table.addCell(s.getUserFor());
			table.addCell(s.getUserEmail());
			table.addCell(s.getUserContact());
			table.addCell(s.getUserIdtype());
			table.addCell(s.getIdNumber());
		
		}
		document.add(table);

}

}
