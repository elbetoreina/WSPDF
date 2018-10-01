package com.pdf.mapping.model;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class ContratoHFCUp {

	private File archivoBase;
	private String nombre;
	private String dpi;
	private String codigoCliente;
	private String direccionInstalacion;	
	private String telefonoContacto;	
	private String servicioIndividual;
	private String combo;
	private String servicioAdicional;
	private String cajaAdicional;
	private String premiumPack;
	private String observaciones;
	

	public File escribirDatosMovilHorizontal() {

		PDDocument doc;
		try {
			doc = PDDocument.load(archivoBase);
			PDPage page = doc.getPage(1);
			PDFont font = PDType1Font.TIMES_ROMAN;

			int fontSize = 7;

			EscribirPalabraHorizontal(font, page, doc, nombre, fontSize, 60, 365);
			

			if (direccionInstalacion.length() <= 50) {
				EscribirPalabraHorizontal(font, page, doc, direccionInstalacion, fontSize, 60, 310);
			} else {
				String[] lineas = direccionInstalacion.split(" ");
				int conteoLinea1 = lineas.length / 2;

				String Linea1 = "";

				for (int i = 0; i < conteoLinea1; i++) {

					if (i == (conteoLinea1 - 1)) {
						Linea1 += lineas[i];
					} else {
						Linea1 += lineas[i] + " ";
					}
				}

				String Linea2 = "";

				for (int i = conteoLinea1; i < lineas.length; i++) {

					if (i == (lineas.length - 1)) {
						Linea2 += lineas[i];
					} else {
						Linea2 += lineas[i] + " ";
					}
				}

				EscribirPalabraHorizontal(font, page, doc, Linea1, fontSize, 60, 310);
				EscribirPalabraHorizontal(font, page, doc, Linea2, fontSize, 60, 295);

			}
			
			EscribirPalabraHorizontal(font, page, doc, telefonoContacto, fontSize, 60, 240);
			
			EscribirPalabraHorizontal(font, page, doc, codigoCliente, fontSize, 60, 200);
			
			EscribirPalabraHorizontal(font, page, doc, dpi, fontSize, 500, 458);

			// Services Definition
			if (servicioIndividual != "") {
				switch (servicioIndividual) {
				case "Cable Básico":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 739, 555);
					break;				
				case "Tv HD":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 739, 537);
					break;				
				}

			}

			if (combo != "") {
				switch (combo) {
				case "C1D":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 715, 442);
					break;
				case "C2D":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 715, 433);
					break;
				case "C3D":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 715, 424);
					break;
				case "C4D":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 715, 415);
					break;
				case "C1H":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 786, 442);
					break;
				case "C2H":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 786, 433);
					break;
				case "C3H":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 786, 424);
					break;
				case "C4H":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 786, 415);
					break;
				}

			}

			if (servicioAdicional.toUpperCase().contains("Y")) {
				EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 788, 295);
			}
			
			//Hook Full Para Jenkins test

			if (cajaAdicional != "") {
				switch (cajaAdicional) {
				case "1 CAJA DIGITAL PAGO MENSUAL":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 701, 247);
					break;				
				case "1 CAJA HD PAGO MENSUAL":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 701, 228);
					break;				
				case "2 CAJAS DIGITAL PAGO MENSUAL":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 745, 247);
					break;				
				case "2 CAJAS HD PAGO MENSUAL":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 745, 228);
					break;				
				case "3 CAJAS DIGITAL PAGO MENSUAL":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 789, 247);
					break;				
				case "3 CAJAS HD PAGO MENSUAL":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 789, 228);
					break;				
				case "1 CAJA DIGITAL PAGO UNICO":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 831, 248);
					break;
				case "2 CAJAS DIGITAL PAGO UNICO":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 831, 248);
					break;
				case "3 CAJAS DIGITAL PAGO UNICO":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 831, 248);
					break;				
				case "1 CAJA HD PAGO UNICO":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 831, 229);
					break;
				case "2 CAJAS HD PAGO UNICO":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 831, 229);
					break;
				case "3 CAJAS HD PAGO UNICO":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 831, 229);
					break;
				}

			}
			
			if(premiumPack.contains("PP1"))
				EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 739, 179);
			if(premiumPack.contains("PP2"))
				EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 739, 171);
			if(premiumPack.contains("PP3"))
				EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 739, 163);
			if(premiumPack.contains("PP4"))
				EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 739, 154);
			if(premiumPack.contains("PP5"))
				EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 739, 146);
			if(premiumPack.contains("PP6"))
				EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 739, 138);
			if(premiumPack.contains("PP7"))
				EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 739, 130);
			if(premiumPack.contains("PP8"))
				EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 739, 121);

			EscribirPalabraHorizontal(font, page, doc, observaciones, fontSize, 715, 100);

			page = doc.getPage(0);

			EscribirPalabraHorizontal(font, page, doc, nombre, fontSize, 350, 478);

			doc.save(archivoBase);
			doc.close();

		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return archivoBase;

	}

	private void EscribirPalabraHorizontal(PDFont font, PDPage page, PDDocument doc, String message, int fontSize,
			int x, int y) {

		try {

			PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, true);
			contentStream.beginText();

			contentStream.setFont(font, fontSize);
			contentStream.newLineAtOffset(x, y);
			contentStream.showText(message);
			contentStream.endText();
			contentStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ContratoHFCUp() {
		super();
	}

	public File getArchivoBase() {
		return archivoBase;
	}

	public void setArchivoBase(File archivoBase) {
		this.archivoBase = archivoBase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	

	public String getDpi() {
		return dpi;
	}

	public void setDpi(String dpi) {
		this.dpi = dpi;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setDpiExtendido(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getDireccionInstalacion() {
		return direccionInstalacion;
	}

	public void setDireccionInstalacion(String direccionInstalacion) {
		this.direccionInstalacion = direccionInstalacion;
	}
	
	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getServicioIndividual() {
		return servicioIndividual;
	}

	public void setServicioIndividual(String servicioIndividual) {
		this.servicioIndividual = servicioIndividual;
	}

	public String getCombo() {
		return combo;
	}

	public void setCombo(String combo) {
		this.combo = combo;
	}

	public String getServicioAdicionale() {
		return servicioAdicional;
	}

	public void setServicioAdicionale(String servicioAdicionale) {
		this.servicioAdicional = servicioAdicionale;
	}

	public String getCajaAdicional() {
		return cajaAdicional;
	}

	public void setCajaAdicional(String cajaAdicional) {
		this.cajaAdicional = cajaAdicional;
	}

	public String getPremiumPack() {
		return premiumPack;
	}

	public void setPremiumPack(String premiumPack) {
		this.premiumPack = premiumPack;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	

}
