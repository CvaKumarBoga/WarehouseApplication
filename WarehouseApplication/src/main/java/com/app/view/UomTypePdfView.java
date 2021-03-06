package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.UomType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomTypePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//file name+download
		response.addHeader("contenet-Disposition","attachment;filename-Uoms.pdf");
		//read data
		@SuppressWarnings("unchecked")
		List<UomType> list=(List<UomType>) model.get("list");
		Paragraph p=new Paragraph("Welcome to UomType");
		document.add(p);
		PdfPTable table=new PdfPTable(4);
		table.addCell("ID");
		table.addCell("TYPE");
		table.addCell("MODEL");
		table.addCell("NOTE");

		for(UomType s:list) {
			table.addCell(s.getId().toString());
			table.addCell(s.getUomType());
			table.addCell(s.getUomModel());
			table.addCell(s.getNote());
		}
		document.add(table);

}
}