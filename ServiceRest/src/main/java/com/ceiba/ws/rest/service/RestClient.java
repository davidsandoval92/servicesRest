package com.ceiba.ws.rest.service;

import com.ceiba.ws.rest.vo.VOUsuario;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestClient {

	public static void main(String[] args) {
		String urlService = "http://localhost:8080/ServiceRest/services/ceiba/validarusuario";
		System.out.println("######## UrlService invocada: ["+urlService+"]");
		VOUsuario vo = new VOUsuario();
		vo.setUsuario("Apolo");
		vo.setPassword("Lima");
		vo.setUserValido(false);

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(urlService);
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, vo);
		vo = response.getEntity(VOUsuario.class);
		System.out.println("######## Response: [Usuario: " + vo.getUsuario() + "]");
		System.out.println("######## Response: [User is valid: " + vo.isUserValido() + "]");

	}

}
