package com.extremo.json;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/users")
public class UserResource {

	private Set<User> users = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

	public UserResource() {
		users.add(new User("admin"));
	}

	@GET
	public Set<User> list() {
		return users;
	}

}
