package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Client;
import com.hotel.hotel.repositories.ClientRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public List<Client> getClientByFirstName(String firstName){
        return clientRepository.findByFirstName(firstName);
    }

    public void saveClient(Client client){
        clientRepository.save(client);
    }

    public void deleteClient(Integer id){
        clientRepository.deleteById(id);
    }

    public Client getClientById(Integer id){
        return clientRepository.findById(id).get();
    }
}
