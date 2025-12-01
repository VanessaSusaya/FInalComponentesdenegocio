package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
