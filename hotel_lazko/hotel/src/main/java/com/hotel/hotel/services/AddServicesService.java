package com.hotel.hotel.services;

import com.hotel.hotel.models.AdditionalService;
import com.hotel.hotel.models.Client;
import com.hotel.hotel.repositories.AddServiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AddServicesService {
    @Autowired
    private AddServiceRepository addServiceRepository;

    public void saveAdditionalService(AdditionalService additionalService){
        addServiceRepository.save(additionalService);
    }

    public void deleteAdditionalService(Integer id){
        addServiceRepository.deleteById(id);
    }

    public AdditionalService getAdditionalServiceById(Integer id){
        return addServiceRepository.findById(id).get();
    }

}
