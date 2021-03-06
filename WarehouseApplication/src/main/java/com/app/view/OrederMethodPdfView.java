package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrederMethodPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		//file name+download
		response.addHeader("contenet-Disposition","attachment;filename-Orders.pdf");
		//read data
		@SuppressWarnings("unchecked")
		List<OrderMethod> list=(List<OrderMethod>) model.get("list");
		Paragraph p=new Paragraph("Welcome to OrderMethod");
		document.add(p);
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("MODE");
		table.addCell("CODE");
		table.addCell("TYPE");
		table.addCell("ACCEPT");
		table.addCell("NOTE");

		for(OrderMethod s:list) {
			table.addCell(s.getId().toString());
			table.addCell(s.getOrderMode());
			table.addCell(s.getOrderCode());
			table.addCell(s.getExeuteType());
			table.addCell(s.getOrderAccept());
			table.addCell(s.getNote());
		}
		document.add(table);

	}


}
