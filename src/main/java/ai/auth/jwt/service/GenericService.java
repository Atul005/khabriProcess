package ai.auth.jwt.service;

import ai.auth.jwt.domain.MetroPolitanCity;
import ai.auth.jwt.domain.User;

import java.util.List;

/**
 * Created by suman.das on 11/28/18.
 */
public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();

    List<MetroPolitanCity> findAllRandomCities();

    Boolean removeCity(String cityName);
}
