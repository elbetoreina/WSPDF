package com.pdf.mapping.tools;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public class MaskPDF {

	public static void main(String[] args) throws InvalidPasswordException, IOException {

		File file = new File(args[0]);

		PDDocument document = PDDocument.load(file);

		PDPage page = document.getPage(Integer.parseInt(args[1]));

		@SuppressWarnings("resource")
		PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true);

		
		contentStream.setNonStrokingColor(Color.DARK_GRAY);

		contentStream.addRect(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]),
				Integer.parseInt(args[5]));
		
		contentStream.fill();
		
		
		
		contentStream.close();
		
		File newFile = new File(args[6]);
		document.save(newFile);
		
		
		document.close();

	}

}
