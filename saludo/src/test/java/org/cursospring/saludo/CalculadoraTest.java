package org.cursospring.saludo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculadoraTest {

    @Test
    void calculadoraSumarTest(){
        assertEquals(7, Calculadora.sumar(4L,3L));
    }
    
    @Test
    void calculadoraRestarTest() {
        assertEquals(1, Calculadora.restar(4L, 3L));
    }

}
