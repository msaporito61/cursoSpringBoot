package org.cursospring.truckservice.service;

import java.util.List;

import org.cursospring.truckservice.entity.Truck;
import org.cursospring.truckservice.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TruckService {
    
    @Autowired
    TruckRepository truckRepository;

    public List<Truck> getAll(){
        return truckRepository.findAll();
    }

    public Truck getTruckById(int id){
        return truckRepository.findById(id).orElse(null);
    }

    public Truck save(Truck truck){
        Truck truckNew = truckRepository.save(truck);
        return truckNew;
    }

    public List<Truck> byCompanyId(int companyId) {
        return truckRepository.findByCompanyId(companyId);
    }
}
