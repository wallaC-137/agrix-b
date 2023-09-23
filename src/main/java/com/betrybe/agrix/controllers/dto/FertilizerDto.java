package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.CropFertilizer;
import java.util.Set;

/**
 * The type Fertilizer dto.
 */
public record FertilizerDto(Long id, String name, String brand, String composition) {

}
