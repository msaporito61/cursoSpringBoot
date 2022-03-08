package org.cursospring.truckservice.controller;

import java.util.List;

import org.cursospring.truckservice.entity.Truck;
import org.cursospring.truckservice.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/truck")
public class TruckController {

    @Autowired
    TruckService truckService;
    
    @GetMapping
    public ResponseEntity<List<Truck>> getAll(){
        List<Truck> trucks = truckService.getAll();
        if(trucks.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(trucks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Truck> getById(@PathVariable("id") int id) {
        Truck truck = truckService.getTruckById(id);
        if (truck == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(truck);
    }

    @PostMapping()
    public ResponseEntity<Truck> save(@RequestBody Truck truck) {
        Truck truckNew = truckService.save(truck);
        return ResponseEntity.ok(truckNew);
    }

    @GetMapping("/bycompany/{companyId}")
    public ResponseEntity<List<Truck>> getByCompanyId(@PathVariable("companyId") int companyId) {
        List<Truck> trucks = truckService.byCompanyId(companyId);
        if (trucks.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(trucks);
    }

}
