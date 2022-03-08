package org.cursospring.saludo;

/**
 * Clase saludo
 * @author Marcelo
 * @version 1.0
 */
public class Saludo {

    private String mensaje;
    private Long id;

    public Saludo() {
    }

    public Saludo(String mensaje, Long id) {
        this.mensaje = mensaje;
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Saludo [id=" + id + ", mensaje=" + mensaje + "]";
    }

}
