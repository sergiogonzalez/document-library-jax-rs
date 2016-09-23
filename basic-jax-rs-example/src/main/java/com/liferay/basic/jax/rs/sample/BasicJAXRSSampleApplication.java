/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.basic.jax.rs.sample;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;

import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@ApplicationPath("/greetings")
@Component(immediate = true, service = Application.class)
public class BasicJAXRSSampleApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (Validator.isNotNull(drink)) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}

}