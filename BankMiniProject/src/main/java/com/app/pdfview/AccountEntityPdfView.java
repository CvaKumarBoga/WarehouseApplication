package com.app.pdfview;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.AccountEntity;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
@Component
public class AccountEntityPdfView extends AbstractPdfView{

	//link for itext example
	//https://www.codejava.net/frameworks/spring/spring-web-mvc-with-pdf-view-example-using-itext-5x
	//https://stackoverflow.com/questions/26628678/manipulating-width-and-height-of-rows-and-cells-in-itextsharp

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//set file name + download
		response.addHeader("contenet-Disposition","attachment;filename-AccountEntity.pdf");
		//read file data in list
		@SuppressWarnings("unchecked")
		List<AccountEntity> list=(List<AccountEntity>) model.get("list");

		//create paragraph
		Paragraph paragraph = new Paragraph("Hello..."+((AccountEntity) list.get(0)).getHolderName()+"\nWelcome to CIT Bank.Please check below your account details.");
		paragraph.setAlignment(Element.ALIGN_JUSTIFIED);

		String url="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS3QLI980SXhDNKqCRd30rFe4pgr24EK3t-BuWaDZU_zFMu84_I&usqp=CAU";

		Image image = Image.getInstance(url);
		image.scaleAbsoluteHeight(80);
		image.scaleAbsoluteWidth(80);
		document.add(image);
		document.add(paragraph);

		float[] columns = { 5, 5};

		//create table and add cells
		PdfPTable table = new PdfPTable(columns);
		table.getDefaultCell().setUseAscender(true);
		table.getDefaultCell().setUseDescender(true);
		Font font = new Font();
		font.setColor(Color.BLACK);;
		PdfPCell cell = new PdfPCell(new Phrase("Accountant Details",font));
		cell.setBackgroundColor(GrayColor.GRAYWHITE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(new GrayColor(0.75f));
		cell.setColspan(2);
		table.addCell(cell);

		table.setHeaderRows(2);
		table.setWidthPercentage(100f);
		table.setSpacingBefore(15);
		//	font.setColor(BaseColor.WHITE);
		document.setMargins(10f, 10f, 10f, 10f);

		for(AccountEntity ae:list) {
			table.addCell("A/C NO");
			table.addCell(ae.getAccountNumber());

			table.addCell("IFC CODE");
			table.addCell(ae.getIFCCode());

			table.addCell("NAME");
			table.addCell(ae.getHolderName());

			table.addCell("MOBILE NO");
			table.addCell(ae.getMobileNo().toString());

			table.addCell("EMAIL");
			table.addCell(ae.getHolderEmail());

			table.addCell("DOB");
			table.addCell(ae.getDob());

			table.addCell("TYPE");
			table.addCell(ae.getAccountType());

			table.addCell("ADDRESS");
			table.addCell(ae.getAddress());

			table.addCell("DATE");
			table.addCell(ae.getDate().toString());
		}
		document.add(table);

		Paragraph paragraph2 = new Paragraph("Signature");
		paragraph2.setSpacingBefore(20);
		paragraph2.setAlignment(Element.ALIGN_RIGHT);
		document.add(paragraph2);

		String url2="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQP0UJjEQxyWbRSXNEMDUVkmxuj2tl6ombk7bfubvDGfAuOT9el&usqp=CAU";
		Image image2 = Image.getInstance(url2);
		image2.scaleAbsoluteHeight(60);
		image2.scaleAbsoluteWidth(60);
		image2.setAlignment(Element.ALIGN_RIGHT);
		document.add(image2);
	}
	
	
	

}
