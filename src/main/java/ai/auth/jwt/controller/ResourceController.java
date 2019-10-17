package ai.auth.jwt.controller;

import ai.auth.jwt.domain.MetroPolitanCity;
import ai.auth.jwt.domain.User;
import ai.auth.jwt.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by suman.das on 11/28/18.
 */
@RestController
@RequestMapping("/jwttest")
public class ResourceController {

    @Autowired
    private GenericService userService;

    @Autowired
    private TokenStore tokenStore;

    @RequestMapping(value ="/all/cities")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<MetroPolitanCity> getUser(){
        return userService.findAllRandomCities();
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('STANDARD_USER')")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }

    @RequestMapping(value="/delete/{cityName}", method=RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('SUPER_USER')")
    public Boolean removeCity(@PathParam("cityName") String cityName){
        return userService.removeCity(cityName);
    }

}
