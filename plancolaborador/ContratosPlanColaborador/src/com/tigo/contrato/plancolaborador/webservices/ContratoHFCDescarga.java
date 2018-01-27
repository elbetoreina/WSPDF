package com.tigo.contrato.plancolaborador.webservices;

import java.io.File;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


import com.tigo.contrato.plancolaborador.model.ContratoHFC;
import com.tigo.contrato.plancolaborador.util.FileUtil;

@Path("/contratohfc")
public class ContratoHFCDescarga {

	@GET
	@Produces("application/pdf")
	@Path("/descarga")
	public Response getFile(@Context ServletContext ctx, @QueryParam("nombre") String nombreCliente,
			@QueryParam("fechaNac") String fechaNacimiento, @QueryParam("edad") String edad,
			@QueryParam("dpi") String dpi, @QueryParam("dpiext") String dpiExtendido,
			@QueryParam("dirinst") String direccionInstalacion, @QueryParam("tel") String telefonoCasa,
			@QueryParam("cel") String telefonoCelular, @QueryParam("telof") String telefonoOficina,
			@QueryParam("telcon") String telefonoContacto, @QueryParam("sexo") String sexo,
			@QueryParam("estciv") String estadoCivil, @QueryParam("facnom") String facturaNombre,
			@QueryParam("nit") String nit, @QueryParam("email") String email,
			@QueryParam("sind") String servicioIndividual, @QueryParam("combo") String combo,
			@QueryParam("sadi") String servicioAdicional, @QueryParam("cadi") String cajaAdicional,
			@QueryParam("ppack") String premiumPack, @QueryParam("obs") String observaciones

	) {

		File file = new File(ctx.getRealPath("/pdf/Acuerdo_HFC.pdf"));

		UUID uid = UUID.randomUUID();
		File tempFile = new File(ctx.getRealPath("/pdf/Acuerdo_HFCTemp" + uid.toString() + ".pdf"));

		try {

			FileUtil.copyFileUsingChannel(file, tempFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ContratoHFC contrato = new ContratoHFC();

		contrato.setArchivoBase(tempFile);

		if (nombreCliente != null) {
			contrato.setNombre(nombreCliente.replaceAll("\u00a0", " "));
			contrato.setNombre(contrato.getNombre().replaceAll("\uFFFd", ""));
		} else {
			contrato.setNombre("");
		}

		if (dpi != null) {
			contrato.setDpi(dpi.replaceAll("\u00a0", " "));
			contrato.setDpi(contrato.getDpi().replaceAll("\uFFFd", ""));
		} else {
			contrato.setDpi("");
		}

		if (dpiExtendido != null) {
			contrato.setDpiExtendido(dpiExtendido.replaceAll("\u00a0", " "));
			contrato.setDpiExtendido(contrato.getDpiExtendido().replaceAll("\uFFFd", ""));
		} else {
			contrato.setDpiExtendido("");
		}

		if (direccionInstalacion != null) {
			contrato.setDireccionInstalacion(direccionInstalacion.replaceAll("\u00a0", " "));
			contrato.setDireccionInstalacion(contrato.getDireccionInstalacion().replaceAll("\uFFFd", ""));
		} else {
			contrato.setDireccionInstalacion("");
		}

		if (telefonoCasa != null) {
			contrato.setTelefonoCasa(telefonoCasa.replaceAll("\u00a0", " "));
			contrato.setTelefonoCasa(contrato.getTelefonoCasa().replaceAll("\uFFFd", ""));
		} else {
			contrato.setTelefonoCasa("");
		}

		if (telefonoCelular != null) {
			contrato.setTelefonoCelular(telefonoCelular.replaceAll("\u00a0", " "));
			contrato.setTelefonoCelular(contrato.getTelefonoCelular().replaceAll("\uFFFd", ""));
		} else {
			contrato.setTelefonoCelular("");
		}

		if (telefonoOficina != null) {
			contrato.setTelefonoOficina(telefonoOficina.replaceAll("\u00a0", " "));
			contrato.setTelefonoOficina(contrato.getTelefonoOficina().replaceAll("\uFFFd", ""));
		} else {
			contrato.setTelefonoOficina("");
		}

		if (telefonoContacto != null) {
			contrato.setTelefonoContacto(telefonoContacto.replaceAll("\u00a0", " "));
			contrato.setTelefonoContacto(contrato.getTelefonoContacto().replaceAll("\uFFFd", ""));
		} else {
			contrato.setTelefonoContacto("");
		}

		if (sexo != null) {
			contrato.setSexo(sexo.replaceAll("\u00a0", " "));
			contrato.setSexo(contrato.getSexo().replaceAll("\uFFFd", ""));
		} else {
			contrato.setSexo("");
		}

		if (estadoCivil != null) {
			contrato.setEstadoCivil(estadoCivil.replaceAll("\u00a0", " "));
			contrato.setEstadoCivil(contrato.getEstadoCivil().replaceAll("\uFFFd", ""));
		} else {
			contrato.setEstadoCivil("");
		}

		if (nombreCliente != null) {
			contrato.setFacturaNombre(nombreCliente.replaceAll("\u00a0", " "));
			contrato.setFacturaNombre(contrato.getFacturaNombre().replaceAll("\uFFFd", ""));
		} else {
			contrato.setFacturaNombre("");
		}

		if (nit != null) {
			contrato.setNit(nit.replaceAll("\u00a0", " "));
			contrato.setNit(contrato.getNit().replaceAll("\uFFFd", ""));
		} else {
			contrato.setNit("");
		}

		if (email != null) {
			contrato.setEmail(email.replaceAll("\u00a0", " "));
			contrato.setEmail(contrato.getEmail().replaceAll("\uFFFd", ""));
		} else {
			contrato.setEmail("");
		}

		if (servicioIndividual != null) {
			contrato.setServicioIndividual(servicioIndividual.replaceAll("\u00a0", " "));
			contrato.setServicioIndividual(contrato.getServicioIndividual().replaceAll("\uFFFd", ""));
		} else {
			contrato.setServicioIndividual("");
		}

		if (combo != null) {
			contrato.setCombo(combo.replaceAll("\u00a0", " "));
			contrato.setCombo(contrato.getCombo().replaceAll("\uFFFd", ""));
		} else {
			contrato.setCombo("");
		}

		if (servicioAdicional != null) {
			contrato.setServicioAdicionale(servicioAdicional.replaceAll("\u00a0", " "));
			contrato.setServicioAdicionale(contrato.getServicioAdicionale().replaceAll("\uFFFd", ""));
		} else {
			contrato.setServicioAdicionale("");
		}

		if (cajaAdicional != null) {
			contrato.setCajaAdicional(cajaAdicional.replaceAll("\u00a0", " "));
			contrato.setCajaAdicional(contrato.getCajaAdicional().replaceAll("\uFFFd", ""));
		} else {
			contrato.setCajaAdicional("");
		}

		if (premiumPack != null) {
			contrato.setPremiumPack(premiumPack.replaceAll("\u00a0", " "));
			contrato.setPremiumPack(contrato.getPremiumPack().replaceAll("\uFFFd", ""));
		} else {
			contrato.setPremiumPack("");
		}

		if (observaciones != null) {
			contrato.setObservaciones(observaciones.replaceAll("\u00a0", " "));
			contrato.setObservaciones(contrato.getObservaciones().replaceAll("\uFFFd", ""));
		} else {
			contrato.setObservaciones("");
		}

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if (fechaNacimiento != null) {
				contrato.setFechaNacimiento(df.parse(fechaNacimiento));
			} else {
				contrato.setFechaNacimiento(df.parse("01/01/1900"));
			}

		} catch (ParseException e) {
			e.printStackTrace(); // test
		}

		if (edad != null) {
			contrato.setEdad(Integer.parseInt(edad));
		} else {
			contrato.setEdad(0);
		}

		

		File respuesta = contrato.escribirDatosMovilHorizontal();

	

		ResponseBuilder response = Response.ok((Object) respuesta);
		response.header("Content-Disposition", "attachment; filename=contrato-movil-plan-colaborador.pdf");
		return response.build();
	}

}
