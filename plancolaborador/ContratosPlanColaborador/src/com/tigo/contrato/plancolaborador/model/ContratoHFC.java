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

public class ContratoHFC {

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
	private String servicioIndividual;
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

			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			EscribirPalabraHorizontal(font, page, doc, nombre, fontSize, 20, 580);
			EscribirPalabraHorizontal(font, page, doc, nombre, fontSize, 20, 470);
			EscribirPalabraHorizontal(font, page, doc, df.format(fechaNacimiento).toString(), fontSize, 105, 447);
			EscribirPalabraHorizontal(font, page, doc, edad.toString(), fontSize, 190, 447);
			EscribirPalabraHorizontal(font, page, doc, dpi, fontSize, 50, 436);
			EscribirPalabraHorizontal(font, page, doc, dpiExtendido, fontSize, 75, 413);

			if (direccionInstalacion.length() <= 50) {
				EscribirPalabraHorizontal(font, page, doc, direccionInstalacion, fontSize, 20, 342);
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

				EscribirPalabraHorizontal(font, page, doc, Linea1, fontSize, 20, 342);
				EscribirPalabraHorizontal(font, page, doc, Linea2, fontSize, 20, 329);

			}

			EscribirPalabraHorizontal(font, page, doc, telefonoCasa, fontSize, 20, 308);
			EscribirPalabraHorizontal(font, page, doc, telefonoCelular, fontSize, 120, 308);
			EscribirPalabraHorizontal(font, page, doc, telefonoOficina, fontSize, 20, 289);
			EscribirPalabraHorizontal(font, page, doc, telefonoContacto, fontSize, 120, 289);

			if (sexo.toUpperCase().contains("M")) {
				EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 52, 262);
			} else {
				EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 77, 262);
			}

			EscribirPalabraHorizontal(font, page, doc, estadoCivil, fontSize, 150, 262);
			EscribirPalabraHorizontal(font, page, doc, facturaNombre, fontSize, 20, 115);
			EscribirPalabraHorizontal(font, page, doc, nit, fontSize, 40, 103);
			EscribirPalabraHorizontal(font, page, doc, email, fontSize, 20, 55);

			// Services Definition

			if (servicioIndividual != "") {
				switch (servicioIndividual) {
				case "Cable Básico":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 318, 483);
					break;
				case "Tv HD":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 318, 466);
					break;				
				}

			}

			if (combo != "") {
				switch (combo) {
				case "C1D":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 296, 378);
					break;
				case "C2D":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 296, 370);
					break;
				case "C3D":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 296, 362);
					break;
				case "C4D":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 296, 354);
					break;
				case "C1H":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 362, 378);
					break;
				case "C2H":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 362, 370);
					break;
				case "C3H":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 362, 362);
					break;
				case "C4H":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 362, 354);
					break;
				}

			}

			if (servicioAdicional.toUpperCase().contains("Y")) {
				EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 365, 241);
			}

			if (cajaAdicional != "") {
				switch (cajaAdicional) {
				case "1 CAJA DIGITAL PAGO MENSUAL":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 283, 196);
					break;				
				case "1 CAJA HD PAGO MENSUAL":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 283, 179);
					break;				
				case "2 CAJAS DIGITAL PAGO MENSUAL":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 323, 196);
					break;				
				case "2 CAJAS HD PAGO MENSUAL":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 323, 179);
					break;				
				case "3 CAJAS DIGITAL PAGO MENSUAL":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 364, 196);
					break;				
				case "3 CAJAS HD PAGO MENSUAL":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 364, 179);
					break;				
				case "1 CAJA DIGITAL PAGO UNICO":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 404, 196);
					break;
				case "2 CAJAS DIGITAL PAGO UNICO":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 404, 196);
					break;
				case "3 CAJAS DIGITAL PAGO UNICO":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 404, 196);
					break;
				case "1 CAJA HD PAGO UNICO":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 404, 179);
					break;
				case "2 CAJAS HD PAGO UNICO":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 404, 179);
					break;
				case "3 CAJAS HD PAGO UNICO":
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 404, 179);
					break;
				}

			}

			if (premiumPack != "") {

				if (premiumPack.contains("PP1"))
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 318, 133);
				if (premiumPack.contains("PP2"))
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 318, 125);
				if (premiumPack.contains("PP3"))
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 318, 117);
				if (premiumPack.contains("PP4"))
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 318, 110);
				if (premiumPack.contains("PP5"))
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 318, 102);
				if (premiumPack.contains("PP6"))
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 318, 94);
				if (premiumPack.contains("PP7"))
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 318, 87);
				if (premiumPack.contains("PP8"))
					EscribirPalabraHorizontal(font, page, doc, "X", fontSize, 318, 79);
			}

			EscribirPalabraHorizontal(font, page, doc, observaciones, fontSize, 291, 68);

			page = doc.getPage(0);

			EscribirPalabraHorizontal(font, page, doc, nombre, fontSize, 475, 510);

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

	public ContratoHFC() {
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

	@Override
	public String toString() {
		return "ContratoHFC [archivoBase=" + archivoBase + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", edad=" + edad + ", dpi=" + dpi + ", dpiExtendido=" + dpiExtendido + ", direccionInstalacion="
				+ direccionInstalacion + ", telefonoCasa=" + telefonoCasa + ", telefonoCelular=" + telefonoCelular
				+ ", telefonoOficina=" + telefonoOficina + ", telefonoContacto=" + telefonoContacto + ", sexo=" + sexo
				+ ", estadoCivil=" + estadoCivil + ", facturaNombre=" + facturaNombre + ", nit=" + nit + ", email="
				+ email + ", servicioIndividual=" + servicioIndividual + ", combo=" + combo + ", servicioAdicionale="
				+ servicioAdicional + ", cajaAdicional=" + cajaAdicional + ", premiumPack=" + premiumPack
				+ ", observaciones=" + observaciones + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((archivoBase == null) ? 0 : archivoBase.hashCode());
		result = prime * result + ((cajaAdicional == null) ? 0 : cajaAdicional.hashCode());
		result = prime * result + ((combo == null) ? 0 : combo.hashCode());
		result = prime * result + ((direccionInstalacion == null) ? 0 : direccionInstalacion.hashCode());
		result = prime * result + ((dpi == null) ? 0 : dpi.hashCode());
		result = prime * result + ((dpiExtendido == null) ? 0 : dpiExtendido.hashCode());
		result = prime * result + ((edad == null) ? 0 : edad.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + ((facturaNombre == null) ? 0 : facturaNombre.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((nit == null) ? 0 : nit.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((premiumPack == null) ? 0 : premiumPack.hashCode());
		result = prime * result + ((servicioAdicional == null) ? 0 : servicioAdicional.hashCode());
		result = prime * result + ((servicioIndividual == null) ? 0 : servicioIndividual.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((telefonoCasa == null) ? 0 : telefonoCasa.hashCode());
		result = prime * result + ((telefonoCelular == null) ? 0 : telefonoCelular.hashCode());
		result = prime * result + ((telefonoContacto == null) ? 0 : telefonoContacto.hashCode());
		result = prime * result + ((telefonoOficina == null) ? 0 : telefonoOficina.hashCode());
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
		ContratoHFC other = (ContratoHFC) obj;
		if (archivoBase == null) {
			if (other.archivoBase != null)
				return false;
		} else if (!archivoBase.equals(other.archivoBase))
			return false;
		if (cajaAdicional == null) {
			if (other.cajaAdicional != null)
				return false;
		} else if (!cajaAdicional.equals(other.cajaAdicional))
			return false;
		if (combo == null) {
			if (other.combo != null)
				return false;
		} else if (!combo.equals(other.combo))
			return false;
		if (direccionInstalacion == null) {
			if (other.direccionInstalacion != null)
				return false;
		} else if (!direccionInstalacion.equals(other.direccionInstalacion))
			return false;
		if (dpi == null) {
			if (other.dpi != null)
				return false;
		} else if (!dpi.equals(other.dpi))
			return false;
		if (dpiExtendido == null) {
			if (other.dpiExtendido != null)
				return false;
		} else if (!dpiExtendido.equals(other.dpiExtendido))
			return false;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (estadoCivil == null) {
			if (other.estadoCivil != null)
				return false;
		} else if (!estadoCivil.equals(other.estadoCivil))
			return false;
		if (facturaNombre == null) {
			if (other.facturaNombre != null)
				return false;
		} else if (!facturaNombre.equals(other.facturaNombre))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (nit == null) {
			if (other.nit != null)
				return false;
		} else if (!nit.equals(other.nit))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (premiumPack == null) {
			if (other.premiumPack != null)
				return false;
		} else if (!premiumPack.equals(other.premiumPack))
			return false;
		if (servicioAdicional == null) {
			if (other.servicioAdicional != null)
				return false;
		} else if (!servicioAdicional.equals(other.servicioAdicional))
			return false;
		if (servicioIndividual == null) {
			if (other.servicioIndividual != null)
				return false;
		} else if (!servicioIndividual.equals(other.servicioIndividual))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (telefonoCasa == null) {
			if (other.telefonoCasa != null)
				return false;
		} else if (!telefonoCasa.equals(other.telefonoCasa))
			return false;
		if (telefonoCelular == null) {
			if (other.telefonoCelular != null)
				return false;
		} else if (!telefonoCelular.equals(other.telefonoCelular))
			return false;
		if (telefonoContacto == null) {
			if (other.telefonoContacto != null)
				return false;
		} else if (!telefonoContacto.equals(other.telefonoContacto))
			return false;
		if (telefonoOficina == null) {
			if (other.telefonoOficina != null)
				return false;
		} else if (!telefonoOficina.equals(other.telefonoOficina))
			return false;
		return true;
	}

}
