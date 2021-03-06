package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
@Component
public class ShipmentTypePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		//file name+download
		response.addHeader("contenet-Disposition","attachment;filename-Shipments.pdf");
		//read data
		@SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		Paragraph p=new Paragraph("Welcome to ShipmntType");
		document.add(p);
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("MODE");
		table.addCell("CODE");
		table.addCell("ENABLE");
		table.addCell("GRADE");
		table.addCell("NOTE");

		for(ShipmentType s:list) {
			table.addCell(s.getId().toString());
			table.addCell(s.getShipmentMode());
			table.addCell(s.getShipmentCode());
			table.addCell(s.getEnableShipment());
			table.addCell(s.getShipmentGrade());
			table.addCell(s.getNote());
		}
		document.add(table);

	}

}

