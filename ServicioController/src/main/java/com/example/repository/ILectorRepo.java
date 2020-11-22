package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.entity.Lector;

@Repository
public interface ILectorRepo extends JpaRepository<Lector, Integer> {

}
