package org.cursospring.companyservice.controller;

import java.util.List;
import java.util.Map;

import org.cursospring.companyservice.entity.Company;
import org.cursospring.companyservice.model.Van;
import org.cursospring.companyservice.model.Truck;
import org.cursospring.companyservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    
    @GetMapping
    public ResponseEntity<List<Company>> getAll(){
        List<Company> companies = companyService.getAll();
        if(companies.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable("id") int id) {
        Company company = companyService.getUserById(id);
        if (company == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(company);
    }

    @PostMapping()
    public ResponseEntity<Company> save(@RequestBody Company company) {
        Company companyNew = companyService.save(company);
        return ResponseEntity.ok(companyNew);
    }

    @GetMapping("/trucks/{companyId}")
    public ResponseEntity<List<Truck>> getTrucks(@PathVariable("companyId") int companyId) {
        Company company = companyService.getUserById(companyId);
        if(company == null)
            return ResponseEntity.notFound().build();
        List<Truck> trucks = companyService.getTrucks(companyId);
        return ResponseEntity.ok(trucks);
    }

    @GetMapping("/vans/{companyId}")
    public ResponseEntity<List<Van>> getVans(@PathVariable("companyId") int companyId) {
        Company company = companyService.getUserById(companyId);
        if (company == null)
            return ResponseEntity.notFound().build();
        List<Van> vans = companyService.getVans(companyId);
        return ResponseEntity.ok(vans);
    }
    
    @PostMapping("/savetruck/{companyId}")
    public ResponseEntity<Truck> saveTruck(@PathVariable("companyId") int companyId, @RequestBody Truck truck) {
        if (companyService.getUserById(companyId) == null)
            return ResponseEntity.notFound().build();
        Truck truckNew = companyService.saveTruck(companyId, truck);
        return ResponseEntity.ok(truckNew);
    }

    @PostMapping("/savevan/{companyId}")
    public ResponseEntity<Van> saveVan(@PathVariable("companyId") int companyId, @RequestBody Van van) {
        if (companyService.getUserById(companyId) == null)
            return ResponseEntity.notFound().build();
        Van vanNew = companyService.saveVan(companyId, van);
        return ResponseEntity.ok(vanNew);
    }

    @GetMapping("/getall/{companyId}")
    public  ResponseEntity<Map<String, Object>> getAllVehicules(@PathVariable("companyId") int companyId){
        Map<String, Object> result = companyService.getCompanyAndVehicules(companyId);
        return ResponseEntity.ok(result);
    }
}

