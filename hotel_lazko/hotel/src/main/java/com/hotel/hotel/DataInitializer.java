package com.hotel.hotel;

import com.hotel.hotel.models.AdditionalService;
import com.hotel.hotel.models.Order;
import com.hotel.hotel.models.Room;
import com.hotel.hotel.repositories.AddServiceRepository;
import com.hotel.hotel.repositories.OrderRepository;
import com.hotel.hotel.repositories.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final AddServiceRepository additionalServiceRepository;

    public DataInitializer(RoomRepository roomRepository, AddServiceRepository additionalServiceRepository) {
        this.roomRepository = roomRepository;
        this.additionalServiceRepository = additionalServiceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Выполните операции добавления записей в базу данных здесь
        // Например:

        // Создание заказа
        AdditionalService service1 = new AdditionalService();
        service1.setName("Дополнительная услуга 1");
        // Добавление дополнительных услуг к заказу
        service1.setCost_value(100L);
        AdditionalService service2 = new AdditionalService();
        service2.setName("Дополнительная услуга 2");
        service2.setCost_value(200L);

        // Сохранение заказа в репозитории
        additionalServiceRepository.save(service1);
        additionalServiceRepository.save(service2);

        Room room1 = new Room();
        room1.setNum(1);
        room1.setFloor(1);
        room1.setCost_per_night(100);

        Room room2 = new Room();
        room1.setNum(2);
        room1.setFloor(1);
        room1.setCost_per_night(150);

        Room room3 = new Room();
        room1.setNum(3);
        room1.setFloor(1);
        room1.setCost_per_night(200);

        roomRepository.save(room1);
        roomRepository.save(room2);
        roomRepository.save(room3);

    }
}