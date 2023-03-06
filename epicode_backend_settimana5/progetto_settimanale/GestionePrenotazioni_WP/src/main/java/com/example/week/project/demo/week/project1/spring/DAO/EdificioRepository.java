package com.example.week.project.demo.week.project1.spring.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.week.project.demo.week.project1.spring.entities.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long>{

}
