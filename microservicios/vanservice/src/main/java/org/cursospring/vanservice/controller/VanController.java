package org.cursospring.vanservice.controller;

import java.util.List;

import org.cursospring.vanservice.entity.Van;
import org.cursospring.vanservice.service.VanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/van")
public class VanController {

    @Autowired
    VanService VanService;
    
    @GetMapping
    public ResponseEntity<List<Van>> getAll(){
        List<Van> Vans = VanService.getAll();
        if(Vans.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(Vans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Van> getById(@PathVariable("id") int id) {
        Van Van = VanService.getVanById(id);
        if (Van == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(Van);
    }

    @PostMapping()
    public ResponseEntity<Van> save(@RequestBody Van Van) {
        Van VanNew = VanService.save(Van);
        return ResponseEntity.ok(VanNew);
    }

    @GetMapping("/bycompany/{companyId}")
    public ResponseEntity<List<Van>> getByCompanyId(@PathVariable("companyId") int companyId) {
        List<Van> Vans = VanService.byCompanyId(companyId);
        if (Vans.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(Vans);
    }

}
