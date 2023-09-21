package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Crop;

/**
 * The type Crop dto.
 */
public record CropDto(Long id, String name, Double plantedArea, Long farmId) {

  /**
   * To crop.
   *
   * @return the crop
   */
  public Crop toCrop() {

    return new Crop(id, name, plantedArea, null);
  }
}
