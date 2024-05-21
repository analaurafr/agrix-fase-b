package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.repository.FarmRepository;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;

  /**
   * Instantiates a new Farm service.
   *
   * @param farmRepository the farm repository
   */
  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * Find by id farm.
   *
   * @param farmId the id
   * @return the farm
   * @throws FarmNotFoundException the farm not found exception
   */
  public Farm findFarmById(Long farmId) throws FarmNotFoundException {
    return farmRepository.findById(farmId).orElseThrow(FarmNotFoundException::new);
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<Farm> findAllFarms() {
    return farmRepository.findAll();
  }

  /**
   * Create farm.
   *
   * @param farm the farm
   * @return the farm
   */
  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }
}
