package ai.auth.jwt.service.impl;

import ai.auth.jwt.domain.MetroPolitanCity;
import ai.auth.jwt.domain.User;
import ai.auth.jwt.repository.RandomCityRepository;
import ai.auth.jwt.repository.UserRepository;
import ai.auth.jwt.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suman.das on 11/28/18.
 */
@Service
public class GenericServiceImpl implements GenericService {

    private UserRepository userRepository;

    private RandomCityRepository randomCityRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public List<MetroPolitanCity> findAllRandomCities() {
        return (List<MetroPolitanCity>)randomCityRepository.findAll();
    }

    @Override
    public Boolean removeCity(String cityName) {
        if(null != cityName){
            throw new RuntimeException();
        }
        return false;
    }
}
