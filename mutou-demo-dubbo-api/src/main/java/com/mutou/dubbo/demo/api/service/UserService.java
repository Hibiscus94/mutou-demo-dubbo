package com.mutou.dubbo.demo.api.service;

import com.mutou.dubbo.demo.api.dto.business.UserDTO;
import com.mutou.dubbo.demo.api.dto.common.Request;
import com.mutou.dubbo.demo.api.dto.common.Result;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.dubbo.demo.api.service <br>
 * jdk 8
 *
 * @author mutou <br>
 * @version 1.0.0
 * @date 2019-03-23 <br>
 */
@Path("/user")
public interface UserService {
    @Path("/")
    @POST
    @Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
    Long addUser(@FormParam("name") String name, @FormParam("age") Integer age, @FormParam("sex") String sex);

    @Path("/{id:\\d+}")
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
    @Consumes({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
    Result<UserDTO> getUser(@PathParam("id") Long id);
}
