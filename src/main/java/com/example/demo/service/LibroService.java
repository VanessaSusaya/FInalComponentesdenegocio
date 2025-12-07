package com.example.demo.service;

import com.example.demo.entity.Libro;
import com.example.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Libro crear(Libro l) {
        if (l.getEjemplaresDisponibles() == null) {
            l.setEjemplaresDisponibles(
                    l.getTotalEjemplares() == null ? 1 : l.getTotalEjemplares()
            );
        }
        return libroRepository.save(l);
    }


    public Libro actualizar(Long id, Libro datos) {
        Libro l = libroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Libro no encontrado"));
        l.setTitulo(datos.getTitulo());
        l.setAutor(datos.getAutor());
        l.setAnio(datos.getAnio());
        l.setCategoria(datos.getCategoria());
        l.setTotalEjemplares(datos.getTotalEjemplares());
        l.setEjemplaresDisponibles(datos.getEjemplaresDisponibles());
        return libroRepository.save(l);
    }

    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }

    public Optional<Libro> buscarPorId(Long id) {
        return libroRepository.findById(id);
    }

    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }
}
