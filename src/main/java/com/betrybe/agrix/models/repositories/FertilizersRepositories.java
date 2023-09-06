package com.betrybe.agrix.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betrybe.agrix.models.entities.Fertilizers;


public interface FertilizersRepositories extends JpaRepository<Fertilizers, Long> {}
