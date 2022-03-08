package org.cursospring.companyservice.feignclients;

import java.util.List;

import org.cursospring.companyservice.model.Truck;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name= "truck-service", url = "http://localhost:8002/truck")
//@RequestMapping("/car")
public interface  TruckFeignClient {
    
    @PostMapping()
    Truck save(@RequestBody Truck truck);

    @GetMapping("/bycompany/{companyId}")
    List<Truck> getTrucks(@PathVariable("companyId") int companyId);
}
