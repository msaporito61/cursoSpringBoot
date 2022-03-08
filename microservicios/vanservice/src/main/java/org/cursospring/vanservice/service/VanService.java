package org.cursospring.vanservice.service;

import java.util.List;

import org.cursospring.vanservice.entity.Van;
import org.cursospring.vanservice.repository.VanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VanService {
    
    @Autowired
    VanRepository vanRepository;

    public List<Van> getAll(){
        return vanRepository.findAll();
    }

    public Van getVanById(int id){
        return vanRepository.findById(id).orElse(null);
    }

    public Van save(Van van){
        Van vanNew = vanRepository.save(van);
        return vanNew;
    }

    public List<Van> byCompanyId(int companyId) {
        return vanRepository.findByCompanyId(companyId);
    }
}
