package org.cursospring.companyservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cursospring.companyservice.entity.Company;
import org.cursospring.companyservice.feignclients.VanFeignClient;
import org.cursospring.companyservice.feignclients.TruckFeignClient;
import org.cursospring.companyservice.model.Van;
import org.cursospring.companyservice.model.Truck;
import org.cursospring.companyservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CompanyService {
    
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TruckFeignClient truckFeignClient;

    @Autowired
    VanFeignClient vanFeignClient;

    public List<Company> getAll(){
        return companyRepository.findAll();
    }

    public Company getUserById(int id){
        return companyRepository.findById(id).orElse(null);
    }

    public Company save(Company company){
        Company companyNew = companyRepository.save(company);
        return companyNew;
    }

    public List<Truck> getTrucks(int companyId){
        List<Truck> trucks = restTemplate.getForObject("http://localhost:8002/truck/bycompany/" + companyId, List.class);
        return trucks;
    }

    public List<Van> getVans(int companyId) {
        List<Van> vans = restTemplate.getForObject("http://localhost:8003/van/bycompany/" + companyId, List.class);
        return vans;
    }

    public Truck saveTruck(int companyId, Truck truck ){
        truck.setCompanyId(companyId);
        Truck truckNew = truckFeignClient.save(truck);
        return truckNew;
    }

    public Van saveVan(int companyId, Van van) {
        van.setCompanyId(companyId);
        Van vanNew = vanFeignClient.save(van);
        return vanNew;
    }

    public Map<String, Object> getCompanyAndVehicules(int companyId){

        Map<String, Object> result = new HashMap<>();
        Company company = companyRepository.findById(companyId).orElse(null);
        if(company == null){
            result.put("Mensaje", "no existe la compañia");
            return result;
        }
        result.put("Company", company);

        try {
            List<Truck> trucks = truckFeignClient.getTrucks(companyId);
            if (trucks.isEmpty())
                result.put("Trucks", "esa compañia no tiene camiones");
            else
                result.put("Trucks", trucks);            
        } catch (Exception e) {
            //TODO: handle exception
        }    
        try {
            List<Van> vans = vanFeignClient.getVans(companyId);
            if (vans.isEmpty())
                result.put("vans", "ese compañia no tiene vans");
            else
                result.put("vans", vans);
        } catch (Exception e) {
            //TODO: handle exception
        }
        return result;

    }
}
