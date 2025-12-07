package com.example.demo.repository;

import com.example.demo.entity.ERole;
import com.example.demo.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(ERole nombre);
}
