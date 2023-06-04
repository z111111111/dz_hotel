package com.hotel.hotel.services;

import com.hotel.hotel.models.AdditionalService;
import com.hotel.hotel.models.Room;
import com.hotel.hotel.repositories.AddServiceRepository;
import com.hotel.hotel.repositories.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public void saveRoom(Room room){
        roomRepository.save(room);
    }

    public void deleteRoom(Integer id){
        roomRepository.deleteById(id);
    }

    public Room getRoomById(Integer id){
        return roomRepository.findById(id).get();
    }
}
