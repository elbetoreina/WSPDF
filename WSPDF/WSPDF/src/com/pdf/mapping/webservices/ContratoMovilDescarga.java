package com.pdf.mapping.webservices;

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

import com.pdf.mapping.model.Contrato;
import com.pdf.mapping.util.FileUtil;

@Path("/contratomovilnuevo")
public class ContratoMovilDescarga {

	@GET
	@Produces("application/pdf")
	@Path("/descarga")
	public Response getFile(@Context ServletContext ctx, @QueryParam("nombre") String nombreCliente,
			@QueryParam("plan") String planSeleccionado, @QueryParam("modelo") String modeloTelefono,
			@QueryParam("observaciones") String observaciones, @QueryParam("fechacre") String fechaCreacion,
			@QueryParam("cantidad") String cantidadLineas, @QueryParam("fechanac") String fechaNacimiento,
			@QueryParam("dir") String direccion, @QueryParam("dpi") String dpi, @QueryParam("nit") String nit,
			@QueryParam("email") String email, @QueryParam("tel") String telContacto) {

			
		File file = new File(ctx.getRealPath("/pdf/ContratoMovil.pdf"));
		
		UUID uid = UUID.randomUUID();
		File tempFile = new File(ctx.getRealPath("/pdf/ContratoMovilTemp" + uid.toString() + ".pdf"));

		try { 
			
			FileUtil.copyFileUsingChannel(file, tempFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Contrato contrato = new Contrato();

		contrato.setArchivoBase(tempFile);

		if (nombreCliente != null) {
			contrato.setNombreCliente(nombreCliente.replaceAll("\u00a0"," "));
			contrato.setNombreCliente(contrato.getNombreCliente().replaceAll("\uFFFd",""));
		} else {
			contrato.setNombreCliente("");
		}
		
		if (planSeleccionado != null) {
			contrato.setPlanSeleccionado(planSeleccionado.replaceAll("\u00a0"," "));
			contrato.setPlanSeleccionado(contrato.getPlanSeleccionado().replaceAll("\uFFFd",""));
		} else {
			contrato.setPlanSeleccionado("");
		}
		
		if (modeloTelefono != null) {
			contrato.setModeloTelefono(modeloTelefono.replaceAll("\u00a0"," "));
			contrato.setModeloTelefono(contrato.getModeloTelefono().replaceAll("\uFFFd",""));
		} else {
			contrato.setModeloTelefono("");
		}
		
		if (observaciones != null) {
			contrato.setObservaciones(observaciones.replaceAll("\u00a0"," "));
			contrato.setObservaciones(contrato.getObservaciones().replaceAll("\uFFFd",""));
		} else {
			contrato.setObservaciones("");
		}
		
		if (cantidadLineas != null) {
			contrato.setCantidadLineas(Integer.parseInt(cantidadLineas));
		} else {
			contrato.setCantidadLineas(-1);
		}
		
		if (direccion != null) {
			contrato.setDireccionResidencia(direccion.replaceAll("\u00a0"," "));
			contrato.setDireccionResidencia(contrato.getDireccionResidencia().replaceAll("\uFFFd",""));
		} else {
			contrato.setDireccionResidencia("");
		}
		
		if (dpi != null) {
			contrato.setDpi(dpi.replaceAll("\u00a0"," "));
			contrato.setDpi(contrato.getDpi().replaceAll("\uFFFd",""));
		} else {
			contrato.setDpi("");
		}
		
		if (nit != null) {
			contrato.setNit(nit.replaceAll("\u00a0"," "));
			contrato.setNit(contrato.getNit().replaceAll("\uFFFd",""));
		} else {
			contrato.setNit("");
		}
		
		if (email != null) {
			contrato.setEmail(email.replaceAll("\u00a0"," "));
			contrato.setEmail(contrato.getEmail().replaceAll("\uFFFd",""));
		} else {
			contrato.setEmail("");
		}
		
		if (telContacto != null) {
			contrato.setTelContacto(telContacto.replaceAll("\u00a0"," "));
			contrato.setTelContacto(contrato.getTelContacto().replaceAll("\uFFFd",""));
		} else {
			contrato.setTelContacto("");
		}

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if (fechaCreacion != null){
				contrato.setFechaCreacion(df.parse(fechaCreacion));				
			}
			else{
				contrato.setFechaCreacion(df.parse("01/01/1900"));
			}
			
			if (fechaNacimiento != null){
				contrato.setFechaNacimiento(df.parse(fechaNacimiento));			
			}
			else{
				contrato.setFechaNacimiento(df.parse("01/01/1900"));
			}
			
			

		} catch (ParseException e) {
			e.printStackTrace(); //test
		}

		File respuesta = contrato.escribirDatosMovilVertical(true);
		
		respuesta = contrato.escribirDatosMovilHorizontalFirmas();
		
		

		ResponseBuilder response = Response.ok((Object) respuesta);
		response.header("Content-Disposition", "attachment; filename=contrato-movil-plan-colaborador.pdf");
		return response.build();
	}

}