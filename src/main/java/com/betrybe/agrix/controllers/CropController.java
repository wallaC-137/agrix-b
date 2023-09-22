package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.services.CropService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Crop controller.
 */
@RestController
@RequestMapping(value = "/crops")
public class CropController {

  private final CropService cropService;


  /**
   * Instantiates a new Crop controller.
   *
   * @param cropService the crop service
   */
  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Gets all crop.
   *
   * @return the all crop
   */
  @GetMapping()
  public ResponseEntity<List<CropDto>> getAllCrop() {
    List<Crop> crops = cropService.getAllCrop();

    List<CropDto> cropDtos = crops.stream()
        .map((crop) -> new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(),
            crop.getFarmId().getId(), crop.getPlantedDate(), crop.getHarvestDate()))
        .collect(Collectors.toList());

    return ResponseEntity.ok(cropDtos);
  }

  /**
   * Gets crop by id.
   *
   * @param id the id
   * @return the crop by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<CropDto> getCropById(@PathVariable Long id) {
    Crop crop = cropService.getCropById(id);

    CropDto cropDto = new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(),
        crop.getFarmId().getId(), crop.getPlantedDate(), crop.getHarvestDate());

    return ResponseEntity.ok(cropDto);
  }


  /**
   * Gets crops by harvest date.
   *
   * @param startDate the start date
   * @param endDate   the end date
   * @return the crops by harvest date
   */
  @GetMapping("/search")
  public ResponseEntity<List<CropDto>> getCropsByHarvestDate(
      @RequestParam("start") LocalDate startDate,
      @RequestParam("end") LocalDate endDate) {

    List<Crop> crops = cropService.getCropsByDateBetween(startDate, endDate);

    List<CropDto> cropDtos = crops.stream()
        .map((crop) -> new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(),
            crop.getFarmId().getId(), crop.getPlantedDate(), crop.getHarvestDate()))
        .collect(Collectors.toList());

    return ResponseEntity.ok(cropDtos);
  }

}
