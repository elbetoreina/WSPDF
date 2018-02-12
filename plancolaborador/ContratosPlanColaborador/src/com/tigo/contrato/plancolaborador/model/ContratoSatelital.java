package com.tigo.contrato.plancolaborador.model;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ContratoSatelital {

	private File archivoBase;
	private String nombre;
	private String dpi;
	private String dpiExtendido;
	private String direccionInstalacion;
	private String telefonoCasa;
	private String telefonoCelular;
	private String telefonoOficina;
	private String telefonoContacto;
	private String sexo;
	private String estadoCivil;
	private String facturaNombre;
	private String nit;
	private String email;
	private String tipoTecho;
	private String combo;
	private String servicioAdicional;
	private String cajaAdicional;
	private String premiumPack;
	private String observaciones;
	private Date fechaNacimiento;
	private Integer edad;

	public File escribirDatosMovilHorizontal() {

		PDDocument doc;
		try {
			doc = PDDocument.load(archivoBase);
			PDPage page = doc.getPage(1);
			PDFont font = PDType1Font.TIMES_ROMAN;

			int fontSize = 7;

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			EscribirPalabraHorizontal(font, page, doc, nombre, fontSize, 20, 585);
			EscribirPalabraHorizontal(font, page, doc, nombre, fontSize, 20, 470);
			EscribirPalabraHorizontal(font, page, doc, df.format(fechaNacimiento).toString(), fontSize, 105, 407);
			EscribirPalabraHorizontal(font, page, doc, edad.toString(), fontSize, 190, 407);
			EscribirPalabraHorizontal(font, page, doc, dpi, fontSize, 50, 443);
			EscribirPalabraHorizontal(font, page, doc, dpiExtendido, fontSize, 75, 420);

			if (direccionInstalacion.length() <= 50) {
				EscribirPalabraHorizontal(font, page, doc, direccionInstalacion, fontSize, 20, 330);
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

				EscribirPalabraHorizontal(font, page, doc, Linea1, fontSize, 20, 333);
				EscribirPalabraHorizontal(font, page, doc, Linea2, fontSize, 20, 321);

			}

			EscribirPalabraHorizontal(font, page, doc, telefonoCasa, fontSize, 20, 288);
			EscribirPalabraHorizontal(font, page, doc, telefonoCelular, fontSize, 120, 288);
			EscribirPalabraHorizontal(font, page, doc, telefonoOficina, fontSize, 20, 269);
			EscribirPalabraHorizontal(font, page, doc, telefonoContacto, fontSize, 120, 269);

			EscribirPalabraHorizontal(font, page, doc, estadoCivil, fontSize, 70, 220);
			EscribirPalabraHorizontal(font, page, doc, facturaNombre, fontSize, 20, 180);
			EscribirPalabraHorizontal(font, page, doc, nit, fontSize, 40, 168);
			EscribirPalabraHorizontal(font, page, doc, email, fontSize, 85, 141);

			// Services Definition

			if (tipoTecho != "") {
				switch (tipoTecho) {
				case "CON":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 361, 545);
					break;
				case "LAM":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 404, 545);
					break;
				case "MAD":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 447, 545);
					break;
				}

			}

			if (cajaAdicional != "") {
				EscribirPalabraHorizontal(font, page, doc, cajaAdicional, fontSize, 320, 460);

			}

			if (premiumPack != "") {
				if (premiumPack.contains("SAT"))
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 411, 507);
				if (premiumPack.contains("PP1"))
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 411, 493);
				if (premiumPack.contains("PP2"))
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 411, 481);
				if (premiumPack.contains("PP3"))
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 411, 469);
			}

			EscribirPalabraHorizontal(font, page, doc, nombre, fontSize, 330, 185);

			doc.save(archivoBase);
			doc.close();

		} catch (

		InvalidPasswordException e) {
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

	public ContratoSatelital() {
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getDpi() {
		return dpi;
	}

	public void setDpi(String dpi) {
		this.dpi = dpi;
	}

	public String getDpiExtendido() {
		return dpiExtendido;
	}

	public void setDpiExtendido(String dpiExtendido) {
		this.dpiExtendido = dpiExtendido;
	}

	public String getDireccionInstalacion() {
		return direccionInstalacion;
	}

	public void setDireccionInstalacion(String direccionInstalacion) {
		this.direccionInstalacion = direccionInstalacion;
	}

	public String getTelefonoCasa() {
		return telefonoCasa;
	}

	public void setTelefonoCasa(String telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getTelefonoOficina() {
		return telefonoOficina;
	}

	public void setTelefonoOficina(String telefonoOficina) {
		this.telefonoOficina = telefonoOficina;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getFacturaNombre() {
		return facturaNombre;
	}

	public void setFacturaNombre(String facturaNombre) {
		this.facturaNombre = facturaNombre;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoTecho() {
		return tipoTecho;
	}

	public void setTipoTecho(String tipoTecho) {
		this.tipoTecho = tipoTecho;
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
