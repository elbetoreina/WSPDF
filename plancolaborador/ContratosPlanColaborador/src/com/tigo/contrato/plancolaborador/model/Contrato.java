package com.tigo.contrato.plancolaborador.model;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import java.text.SimpleDateFormat;


//ADDED A COMMENT IN PROGRAM TEST prueba
public class Contrato {

	private File archivoBase;
	private Date fechaCreacion;
	private Integer cantidadLineas;
	private String planSeleccionado;
	private String modeloTelefono;
	private String observaciones;
	private String nombreCliente;
	private Date fechaNacimiento;
	private String nacionalidad;
	private String direccionResidencia;
	private String dpi;
	private String telContacto;
	private String nit;
	private String email;

	public Contrato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public File escribirDatosMovilHorizontal() {

		PDDocument doc;
		try {
			doc = PDDocument.load(archivoBase);
			PDPage page = doc.getPage(1);
			PDFont font = PDType1Font.TIMES_ROMAN;

			int fontSize = 5;

			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			EscribirPalabraHorizontal(font, page, doc, nombreCliente, fontSize, 840, 560);
			EscribirPalabraHorizontal(font, page, doc, telContacto, fontSize, 840, 510);
			EscribirPalabraHorizontal(font, page, doc, planSeleccionado, fontSize, 840, 415);
			EscribirPalabraHorizontal(font, page, doc, modeloTelefono, fontSize, 975, 250);
			EscribirPalabraHorizontal(font, page, doc, df.format(fechaCreacion).toString(), fontSize, 1020, 580);
			
			EscribirPalabraHorizontal(font, page, doc, "Firmar Aquí X", 9, 600, 350);
			EscribirPalabraHorizontal(font, page, doc, "Firmar Aquí X", 9, 940, 90);

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
	
	public File escribirDatosMovilHorizontalFirmas() {

		PDDocument doc;
		try {
			doc = PDDocument.load(archivoBase);
			PDPage page = doc.getPage(1);
			PDFont font = PDType1Font.TIMES_ROMAN;

			

		
			
			EscribirPalabraHorizontal(font, page, doc, "Firmar Aquí X", 9, 600, 350);
			EscribirPalabraHorizontal(font, page, doc, "Firmar Aquí X", 9, 940, 90);

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

	@SuppressWarnings("unchecked")
	public File escribirDatosMovilVertical(boolean FechaDeNacimiento) {

		try {

			PDDocument doc = PDDocument.load(archivoBase);
			PDPage page = doc.getPage(0);
			PDFont font = PDType1Font.TIMES_ROMAN;
			PDRectangle pageSize = page.getMediaBox();
			int fontSize = 5;

			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			EscribirPalabraVertical(font, page, pageSize, doc, nombreCliente, fontSize, -60, 154, Color.BLACK);
			EscribirPalabraVertical(font, page, pageSize, doc, planSeleccionado, fontSize, -80, 186, Color.BLACK);
			EscribirPalabraVertical(font, page, pageSize, doc, modeloTelefono, fontSize, -80, 179, Color.BLACK);
			EscribirPalabraVertical(font, page, pageSize, doc, observaciones, fontSize, -80, 171, Color.BLACK);
			EscribirPalabraVertical(font, page, pageSize, doc, df.format(fechaCreacion).toString(), fontSize, -140,
					193, Color.BLACK);
			EscribirPalabraVertical(font, page, pageSize, doc, cantidadLineas.toString(), fontSize, 40, 193, Color.BLACK);
			
			if (FechaDeNacimiento)
				EscribirPalabraVertical(font, page, pageSize, doc, df.format(fechaNacimiento).toString(), fontSize,
						-110, 147, Color.BLACK);
			
			EscribirPalabraVertical(font, page, pageSize, doc, direccionResidencia, fontSize, 0, 139, Color.BLACK);
			EscribirPalabraVertical(font, page, pageSize, doc, dpi, fontSize, -80, 130, Color.BLACK);
			EscribirPalabraVertical(font, page, pageSize, doc, nit, fontSize, 165, 130, Color.BLACK);
			EscribirPalabraVertical(font, page, pageSize, doc, email, fontSize, 145, 119, Color.BLACK);

			String numeroTelRegularizado = telContacto.replaceAll("[^0-9]", "");

			@SuppressWarnings("rawtypes")
			List listaNumeros = new ArrayList();

			if (numeroTelRegularizado.length() >= 8) {

				for (int i = 0; i < numeroTelRegularizado.length(); i++) {

					listaNumeros.add(Character.toString(numeroTelRegularizado.charAt(i)));

				}

				EscribirPalabraVertical(font, page, pageSize, doc, listaNumeros.get(0).toString(), fontSize, -148, 117, Color.BLACK);
				EscribirPalabraVertical(font, page, pageSize, doc, listaNumeros.get(1).toString(), fontSize, -137, 117, Color.BLACK);
				EscribirPalabraVertical(font, page, pageSize, doc, listaNumeros.get(2).toString(), fontSize, -126, 117, Color.BLACK);
				EscribirPalabraVertical(font, page, pageSize, doc, listaNumeros.get(3).toString(), fontSize, -115, 117, Color.BLACK);
				EscribirPalabraVertical(font, page, pageSize, doc, listaNumeros.get(4).toString(), fontSize, -100, 117, Color.BLACK);
				EscribirPalabraVertical(font, page, pageSize, doc, listaNumeros.get(5).toString(), fontSize, -89, 117, Color.BLACK);
				EscribirPalabraVertical(font, page, pageSize, doc, listaNumeros.get(6).toString(), fontSize, -78, 117, Color.BLACK);
				EscribirPalabraVertical(font, page, pageSize, doc, listaNumeros.get(7).toString(), fontSize, -67, 117, Color.BLACK);

			}
			
			
			EscribirPalabraVertical(font, page, pageSize, doc, "X Firmar Aquí", 9, -80, -185, Color.black);

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

	private void EscribirPalabraVertical(PDFont font, PDPage page, PDRectangle pageSize, PDDocument doc, String message,
			int fontSize, int x, int y, Color color) {

		float stringWidth;
		try {
			stringWidth = font.getStringWidth(message) * fontSize / 1000f;

			// calculate to center of the page
			int rotation = page.getRotation();
			boolean rotate = rotation == 90 || rotation == 270;
			float pageWidth = rotate ? pageSize.getHeight() : pageSize.getWidth();
			float pageHeight = rotate ? pageSize.getWidth() : pageSize.getHeight();
			float centerX = rotate ? pageHeight / 2f : (pageWidth - stringWidth) / 2f;
			float centerY = rotate ? (pageWidth - stringWidth) / 2f : pageHeight / 2f;

			PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, true);
			contentStream.beginText();
			contentStream.setTextMatrix(Matrix.getRotateInstance(Math.PI / 2, centerX, centerY));

			contentStream.setNonStrokingColor(color);
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

	public File getArchivoBase() {
		return archivoBase;
	}

	public void setArchivoBase(File archivoBase) {
		this.archivoBase = archivoBase;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getCantidadLineas() {
		return cantidadLineas;
	}

	public void setCantidadLineas(Integer cantidadLineas) {
		this.cantidadLineas = cantidadLineas;
	}

	public String getPlanSeleccionado() {
		return planSeleccionado;
	}

	public void setPlanSeleccionado(String planSeleccionado) {
		this.planSeleccionado = planSeleccionado;
	}

	public String getModeloTelefono() {
		return modeloTelefono;
	}

	public void setModeloTelefono(String modeloTelefono) {
		this.modeloTelefono = modeloTelefono;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDireccionResidencia() {
		return direccionResidencia;
	}

	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = direccionResidencia;
	}

	public String getDpi() {
		return dpi;
	}

	public void setDpi(String dpi) {
		this.dpi = dpi;
	}

	public String getTelContacto() {
		return telContacto;
	}

	public void setTelContacto(String telContacto) {
		this.telContacto = telContacto;
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

	@Override
	public String toString() {
		return "Contrato [archivoBase=" + archivoBase + ", fechaCreacion=" + fechaCreacion + ", cantidadLineas="
				+ cantidadLineas + ", planSeleccionado=" + planSeleccionado + ", modeloTelefono=" + modeloTelefono
				+ ", observaciones=" + observaciones + ", nombreCliente=" + nombreCliente + ", fechaNacimiento="
				+ fechaNacimiento + ", nacionalidad=" + nacionalidad + ", direccionResidencia=" + direccionResidencia
				+ ", dpi=" + dpi + ", telContacto=" + telContacto + ", nit=" + nit + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((archivoBase == null) ? 0 : archivoBase.hashCode());
		result = prime * result + ((cantidadLineas == null) ? 0 : cantidadLineas.hashCode());
		result = prime * result + ((direccionResidencia == null) ? 0 : direccionResidencia.hashCode());
		result = prime * result + ((dpi == null) ? 0 : dpi.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((modeloTelefono == null) ? 0 : modeloTelefono.hashCode());
		result = prime * result + ((nacionalidad == null) ? 0 : nacionalidad.hashCode());
		result = prime * result + ((nit == null) ? 0 : nit.hashCode());
		result = prime * result + ((nombreCliente == null) ? 0 : nombreCliente.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((planSeleccionado == null) ? 0 : planSeleccionado.hashCode());
		result = prime * result + ((telContacto == null) ? 0 : telContacto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrato other = (Contrato) obj;
		if (archivoBase == null) {
			if (other.archivoBase != null)
				return false;
		} else if (!archivoBase.equals(other.archivoBase))
			return false;
		if (cantidadLineas == null) {
			if (other.cantidadLineas != null)
				return false;
		} else if (!cantidadLineas.equals(other.cantidadLineas))
			return false;
		if (direccionResidencia == null) {
			if (other.direccionResidencia != null)
				return false;
		} else if (!direccionResidencia.equals(other.direccionResidencia))
			return false;
		if (dpi == null) {
			if (other.dpi != null)
				return false;
		} else if (!dpi.equals(other.dpi))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (modeloTelefono == null) {
			if (other.modeloTelefono != null)
				return false;
		} else if (!modeloTelefono.equals(other.modeloTelefono))
			return false;
		if (nacionalidad == null) {
			if (other.nacionalidad != null)
				return false;
		} else if (!nacionalidad.equals(other.nacionalidad))
			return false;
		if (nit == null) {
			if (other.nit != null)
				return false;
		} else if (!nit.equals(other.nit))
			return false;
		if (nombreCliente == null) {
			if (other.nombreCliente != null)
				return false;
		} else if (!nombreCliente.equals(other.nombreCliente))
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (planSeleccionado == null) {
			if (other.planSeleccionado != null)
				return false;
		} else if (!planSeleccionado.equals(other.planSeleccionado))
			return false;
		if (telContacto == null) {
			if (other.telContacto != null)
				return false;
		} else if (!telContacto.equals(other.telContacto))
			return false;
		return true;
	}

}
