package com.semana7.swagger.controller;

import com.semana7.swagger.entity.Autor;
import com.semana7.swagger.repository.AutorRepository;
import com.semana7.swagger.request.AutorRequest;
import com.semana7.swagger.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping()
    public List<Autor> listarAutores(){
        List<Autor> autores = autorService.obtenerTodos();
        return autores;
    }

    @GetMapping("/{id}")
    public Autor listarAutor(@PathVariable Long id){
        Autor autor = autorService.obtenerUno(id);
        return autor;
    }

    @PostMapping()
    public Autor crearAutor(@RequestBody AutorRequest autor){
        Autor autorUpdate = autorService.crearAutor(autor);
        return autorUpdate;
    }

    @PutMapping()
    public Autor actualizarAutor(@PathVariable Long id, @RequestBody Autor autor){
        Autor autorUpdate = autorService.actualizar(id, autor);
        return autorUpdate;
    }
    @PutMapping("/{id}")
    public Autor eliminarAutor(@PathVariable Long id){
        Autor autorUpdate = autorService.eliminar(id);
        return autorUpdate;
    }





}
