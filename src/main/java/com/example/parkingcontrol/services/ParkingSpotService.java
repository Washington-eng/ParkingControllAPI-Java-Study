package com.example.parkingcontrol.services;

import com.example.parkingcontrol.models.ParkingSpot;
import com.example.parkingcontrol.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {
    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpot save(ParkingSpot parkingSpot){
        return parkingSpotRepository.save(parkingSpot);
    }

    public List<ParkingSpot> findAll(){
        return parkingSpotRepository.findAll();
    }

    public boolean existsByLicensePlateCar(String licensePlateCar){
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber){ return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);}
    public boolean existsByApartmentAndBlock(String apartment, String block){ return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);}
    public Optional<ParkingSpot> findById(UUID id){
        return parkingSpotRepository.findById(id);
    }

    public void deleteParkingSpot(ParkingSpot parkingSpot){
        parkingSpotRepository.delete(parkingSpot);
    }
}
