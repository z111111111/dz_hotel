package com.hotel.hotel.repositories;

import com.hotel.hotel.models.AdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddServiceRepository extends JpaRepository<AdditionalService, Integer> {
}
