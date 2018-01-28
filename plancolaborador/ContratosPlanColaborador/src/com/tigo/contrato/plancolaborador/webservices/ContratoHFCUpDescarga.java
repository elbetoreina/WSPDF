package com.tigo.contrato.plancolaborador.webservices;

import java.io.File;
import java.io.IOException;


import java.util.UUID;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.tigo.contrato.plancolaborador.model.ContratoHFCUp;
import com.tigo.contrato.plancolaborador.util.FileUtil;

@Path("/contratohfcup")
public class ContratoHFCUpDescarga {

	@GET
	@Produces("application/pdf")
	@Path("/descarga")
	public Response getFile(@Context ServletContext ctx, @QueryParam("nombre") String nombreCliente,
			@QueryParam("dpi") String dpi, @QueryParam("codcli") String codigoCliente,
			@QueryParam("dirinst") String direccionInstalacion, @QueryParam("telcon") String telefonoContacto,
			@QueryParam("sind") String servicioIndividual, @QueryParam("combo") String combo,
			@QueryParam("sadi") String servicioAdicional, @QueryParam("cadi") String cajaAdicional,
			@QueryParam("ppack") String premiumPack, @QueryParam("obs") String observaciones

	) {

		File file = new File(ctx.getRealPath("/pdf/Acuerdo_HFC_UP.pdf"));

		UUID uid = UUID.randomUUID();
		File tempFile = new File(ctx.getRealPath("/pdf/Acuerdo_HFC_UPTemp" + uid.toString() + ".pdf"));

		try {

			FileUtil.copyFileUsingChannel(file, tempFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ContratoHFCUp contrato = new ContratoHFCUp();

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

		if (codigoCliente != null) {
			contrato.setDpiExtendido(codigoCliente.replaceAll("\u00a0", " "));
			contrato.setDpiExtendido(contrato.getCodigoCliente().replaceAll("\uFFFd", ""));
		} else {
			contrato.setDpiExtendido("");
		}

		if (direccionInstalacion != null) {
			contrato.setDireccionInstalacion(direccionInstalacion.replaceAll("\u00a0", " "));
			contrato.setDireccionInstalacion(contrato.getDireccionInstalacion().replaceAll("\uFFFd", ""));
		} else {
			contrato.setDireccionInstalacion("");
		}

		if (telefonoContacto != null) {
			contrato.setTelefonoContacto(telefonoContacto.replaceAll("\u00a0", " "));
			contrato.setTelefonoContacto(contrato.getTelefonoContacto().replaceAll("\uFFFd", ""));
		} else {
			contrato.setTelefonoContacto("");
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

		File respuesta = contrato.escribirDatosMovilHorizontal();

		ResponseBuilder response = Response.ok((Object) respuesta);
		response.header("Content-Disposition", "attachment; filename=contrato-movil-plan-colaborador.pdf");
		return response.build();
	}

}
