package modelo;

import java.io.Serializable;
import java.util.Date;

public class Entrada implements Serializable {

    String patente;
    String estado;
    String comentario;
    Date fecha;


@exclude
    private String id;
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public Entrada(String patente, String estado, String comentario, Date fecha) {
        this.patente = patente;
        this.estado = estado;
        this.comentario = comentario;
        this.fecha = fecha;
    }
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}
