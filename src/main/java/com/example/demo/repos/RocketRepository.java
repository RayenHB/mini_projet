package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Rocket;

public interface RocketRepository extends JpaRepository<Rocket, Long> {

}
