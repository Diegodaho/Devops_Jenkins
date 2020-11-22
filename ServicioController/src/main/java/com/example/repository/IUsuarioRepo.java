package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
	
	Usuario findByNick(String nick);

}
