package com.semana7.swagger.service.impl;

import com.semana7.swagger.entity.Autor;
import com.semana7.swagger.repository.AutorRepository;
import com.semana7.swagger.request.AutorRequest;
import com.semana7.swagger.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor
@Service
public class AutorServiceImpl implements AutorService {

//    private final AutorRepository autorRepository;
//
//    public AutorServiceImpl(AutorRepository autorRepository){
//        this.autorRepository = autorRepository;
//    }
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public Autor crearAutor(AutorRequest autor) {
        Autor entity = new Autor();
        entity.setTipoDoc(autor.getTipoDoc());
        entity.setNumDoc(autor.getNumDoc());
        entity.setNombres(autor.getNombres());
        entity.setApellidos(autor.getApellidos());
        entity.setEmail(autor.getEmail());
        entity.setEstado(1);
        entity.setUserCreate("Sonny");
        entity.setDateCreate(getTimestamp());


        return autorRepository.save(entity);
    }

    @Override
    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    @Override
    public Autor obtenerUno(Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()){
            return autor.get();
        }
        return  null;
    }

    @Override
    public Autor actualizar(Long id, Autor autor) {
        boolean exists = autorRepository.existsById(id);
        if(exists){
            Optional<Autor> entity = autorRepository.findById(id);
            Autor autor1 = entity.get();
            autor1.setNombres(autor.getNombres());
            autor1.setApellidos(autor.getApellidos());
            return autorRepository.save(autor1);
        }
        return null;
    }

    @Override
    public Autor eliminar(Long id) {
        boolean exists = autorRepository.existsById(id);
        if(exists){
            Optional<Autor> entity = autorRepository.findById(id);
            Autor autor1 = entity.get();
            autor1.setEstado(0);
            return autorRepository.save(autor1);
        }
        return null;
    }

    private Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTime);
        return  timestamp;
    }
}
