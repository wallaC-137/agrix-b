package com.betrybe.agrix.services;

import com.betrybe.agrix.exception.CropNotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.repositories.CropRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Crop service.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;

  /**
   * Instantiates a new Farm service.
   *
   * @param cropRepository the crop repository
   */
  @Autowired
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }


  /**
   * Gets all crop.
   *
   * @return the all crop
   */
  public List<Crop> getAllCrop() {

    return cropRepository.findAll();
  }

  /**
   * Gets crop by id.
   *
   * @param id the id
   * @return the crop by id
   */
  public Crop getCropById(Long id) {
    Optional<Crop> crop = cropRepository.findById(id);
    if (crop.isEmpty()) {
      throw new CropNotFoundException();
    }

    return crop.get();
  }

  /**
   * Gets crops by date between.
   *
   * @param start the start
   * @param end   the end
   * @return the crops by date between
   */
  public List<Crop> getCropsByDateBetween(LocalDate start, LocalDate end) {
    Optional<List<Crop>> crop = cropRepository.findByHarvestDateBetween(start, end);

    if (crop.isEmpty()) {
      throw new CropNotFoundException();
    }

    return crop.get();
  }
}
