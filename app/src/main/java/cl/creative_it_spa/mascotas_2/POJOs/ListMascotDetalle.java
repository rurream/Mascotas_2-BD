package cl.creative_it_spa.mascotas_2.POJOs;

/**
 * Created by Rodrigo on 18-06-2017.
 */

public class ListMascotDetalle {

    int puntaje_masc_detalle;
    int foto_mascota_mini_1;
    int id_foto, id_mascota, foto_principal;
    String nombre_mascota;

    public ListMascotDetalle(int puntaje_masc_detalle, int foto_mascota_mini_1) {
        this.puntaje_masc_detalle=puntaje_masc_detalle;
        this.foto_mascota_mini_1 = foto_mascota_mini_1;
    }

    public ListMascotDetalle(int puntaje_masc_detalle, int foto_mascota_mini_1,
                             int id_foto, int id_mascota, int foto_principal, String nombre_mascota) {
        this.puntaje_masc_detalle=puntaje_masc_detalle;
        this.foto_mascota_mini_1 = foto_mascota_mini_1;
        this.id_foto=id_foto;
        this.id_mascota=id_mascota;
        this.foto_principal=foto_principal;
        this.nombre_mascota=nombre_mascota;
    }

    public ListMascotDetalle() {

    }

    public int getPuntaje_masc_detalle() {
        return puntaje_masc_detalle;
    }

    public void setPuntaje_masc_detalle(int puntaje_masc_detalle) {
        this.puntaje_masc_detalle = puntaje_masc_detalle;
    }

    public int getFoto_mascota_mini_1() {
        return foto_mascota_mini_1;
    }

    public void setFoto_mascota_mini_1(int foto_mascota_mini_1) {
        this.foto_mascota_mini_1 = foto_mascota_mini_1;
    }

    public int getId_foto() {
        return id_foto;
    }

    public void setId_foto(int id_foto) {
        this.id_foto = id_foto;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public int getFoto_principal() {
        return foto_principal;
    }

    public void setFoto_principal(int foto_principal) {
        this.foto_principal = foto_principal;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }
}
