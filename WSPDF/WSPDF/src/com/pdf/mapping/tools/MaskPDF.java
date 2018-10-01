package com.pdf.mapping.tools;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public class MaskPDF {

	public static void main(String[] args) throws InvalidPasswordException, IOException {
		
		File file = new File(args[0]);
		
		PDDocument document = PDDocument.load(file);
		
		
		
		

	}

}
