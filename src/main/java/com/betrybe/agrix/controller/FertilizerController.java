package com.betrybe.agrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.betrybe.agrix.controller.dto.FertilizerBodyDto;
import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.models.entities.Fertilizers;
import com.betrybe.agrix.services.FertilizerService;
import com.betrybe.agrix.util.ModelDtoConverter;

@RestController
public class FertilizerController {
  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping("/fertilizers")
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto insertFertilizer(@RequestBody FertilizerBodyDto fertilizerDto) {
    Fertilizers fertilizer = ModelDtoConverter.dtoToFertilizers(fertilizerDto);
    Fertilizers response = fertilizerService.insertFertilizer(fertilizer);
    return ModelDtoConverter.fertilizerToDto(response);
  }
}
