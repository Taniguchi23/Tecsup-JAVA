package com.semana7.swagger.service;

import com.semana7.swagger.entity.Autor;
import com.semana7.swagger.request.AutorRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AutorService {
    Autor crearAutor(AutorRequest autor);
    List<Autor> obtenerTodos();
    Autor obtenerUno(Long id);
    Autor actualizar(Long id, Autor autor);
    Autor eliminar(Long id);
}
