package com.ceiba.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ceiba.ws.rest.vo.VOUsuario;

@Path("/ceiba")
public class ServiceLoginJR {

	@POST
	@Path("/validarusuario")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public VOUsuario validarUsuario(VOUsuario user) {
		user.setUserValido(false);
		if (user.getUsuario().equals("david") && user.getPassword().equals("Delta")) {
			user.setUserValido(true);
		}
		return user;
	}

}
