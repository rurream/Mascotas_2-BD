package cl.creative_it_spa.mascotas_2.POJOs;

import java.util.ArrayList;

/**
 * Created by Rodrigo on 13-06-2017.
 */

public class ListaMascotas {

    private String nombre_mascota;
    private int puntaje_mascota;
    private int id;
    private int foto_mascota;

    public ListaMascotas(String nombre_mascota, int puntaje_mascota, int foto_mascota, int id) {
        this.nombre_mascota = nombre_mascota;
        this.puntaje_mascota = puntaje_mascota;
        this.foto_mascota = foto_mascota;
        this.id = id;
    }



    public ListaMascotas() {

    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public int getPuntaje_mascota() {
        return puntaje_mascota;
    }

    public void setPuntaje_mascota(int puntaje_mascota) {
        this.puntaje_mascota = puntaje_mascota;
    }


    public int getFoto_mascota() {
        return foto_mascota;
    }

    public void setFoto_mascota(int foto_mascota) {
        this.foto_mascota = foto_mascota;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

