package com.betrybe.agrix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betrybe.agrix.exeptions.FertilizersNotFoundExeption;
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

  public List<Fertilizers> getAllFertilizers() {
    return fertilizersRepositories.findAll();
  }

  public Fertilizers getFertilizersById(Long id) {
    Optional<Fertilizers> fertilizer = fertilizersRepositories.findById(id);
    if (fertilizer.isEmpty()) {
      throw new FertilizersNotFoundExeption();
    }
    return fertilizer.get();
  }


}
