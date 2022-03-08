package org.cursospring.demorest.controller;

import java.util.List;


import org.cursospring.demorest.model.Persona;
import org.cursospring.demorest.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1.0")
public class PersonaController {
    
    @Autowired
    private PersonaRepository repository;

    @GetMapping("/personas")
    public List<Persona> allPersonas(){
        return repository.findAll();
    }

    @PostMapping("/persona")
    public Persona createPersona(@RequestBody Persona persona){
        return repository.save(persona);
    }

    @GetMapping("/persona/{name}")
    public List<Persona> findByName(@PathVariable("name") String name){
        return repository.findByName(name);
    }

    @DeleteMapping("/persona/{id}")
    public void deletePersona(@PathVariable("id") Long id){
        repository.deleteById(id);
    }

    @PutMapping("/persona/{id}")
    public Persona updatePersona(@RequestBody Persona nuevaPersona, @PathVariable Long id){
        return repository.findById(id)
                .map(persona -> {
                    persona.setName(nuevaPersona.getName());
                    persona.setUsername(nuevaPersona.getUsername());
                    return repository.save(persona);
                })
                .orElseGet(() -> {
                    nuevaPersona.setId(id);
                    return repository.save(nuevaPersona);
                });
    }
}
