package com.autocar.autocar.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autocar.autocar.models.entity.carro;

public interface carroRepository extends JpaRepository<carro, Integer>{
    
}
