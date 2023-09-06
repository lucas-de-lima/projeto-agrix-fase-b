package com.betrybe.agrix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betrybe.agrix.models.entities.Fertilizers;
import com.betrybe.agrix.models.repositories.FertilizersRepositories;

@Service
public class FertilizerService {
  private FertilizersRepositories fertilizersRepositories;

  @Autowired
  public FertilizerService(FertilizersRepositories fertilizersRepositories) {
    this.fertilizersRepositories = fertilizersRepositories;
  }

  public Fertilizers insertFertilizer(Fertilizers fertilizer) {
    return fertilizersRepositories.save(fertilizer);
  }

}
