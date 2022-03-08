package org.cursospring.saludo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "saludo")
public class SaludoControlador {

    private final AtomicLong contador = new AtomicLong();
    private static final String template = "Hola %s !";
    
    @GetMapping
    public Saludo saludo(@RequestParam(value="nombre", defaultValue = "Mundo") String nombre){
        return new Saludo(String.format(template, nombre), contador.incrementAndGet());
    }
}
