package mx.edu.utez.ejemplo.service;

import mx.edu.utez.ejemplo.model.Login;

import java.util.List;

public interface LoginService {
 List<Login> findAll();

 void save(Login login);
}
