package com.hotel.hotel.repositories;

import com.hotel.hotel.models.Order;
import com.hotel.hotel.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
