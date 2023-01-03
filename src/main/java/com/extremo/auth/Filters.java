package com.extremo.auth;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.reactive.server.ServerRequestFilter;

import com.extremo.json.User;

public class Filters {

	private final Client client = ClientBuilder.newBuilder().build();
	private final String url = "http://localhost:8090/users";

	@ServerRequestFilter(preMatching = true,nonBlocking = true)
	public Response getLogin(ContainerRequestContext context) {
		String auth = context.getHeaders().getFirst("Authentication");
		if ("true".equals(auth)) {
			
			// This list simulate business rule.
			List<User> users = client.target(url).request().get(new GenericType<List<User>>() {
			});

			return Response.status(Status.OK).entity(users).build();
			
		}
		return null;
	}

}
