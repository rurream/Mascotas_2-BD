package cl.creative_it_spa.mascotas_2.ModeloBDMascotas;

/**
 * Created by Rodrigo on 21-06-2017.
 */

public class ConstantesBD {

    public static final String nombre_BD="mascotas";
    public static final int version_BD=1;

    public static final String TablaMascotas="mascota";
    public static final String TablaMascotas_Id="id_mascota";
    public static final String TablaMascotas_Nombre="nombre_mascota";
    public static final String TablaMascotas_Puntos="puntos_mascota";
    public static final String TablaMascotas_FotoPrincipal="foto_grande_mascota";

    public static final String TablaFotosChicas="foto_chica";
    public static final String TablaFotosChicas_Id="id_foto_chica";
    public static final String TablaFotosChicas_Id_Mascota="id_mascota";
    public static final String TablaFotosChicas_Foto="foto_chica";
    public static final String TablaFotosChicas_Puntaje="puntos_foto_chica";

    public static final String TablaMascotaPorDefecto="mascota_por_defecto";
    public static final String TablaMascotaPorDefecto_Id="id_mascota_por_defecto";
    public static final String TablaMascotaPorDefecto_Foto="foto_mascota_por_defecto";
    public static final String TablaMascotaPorDefecto_Puntaje="puntaje_mascota_por_defecto";

    public static final String TablaMascotasTop5="mascota_top_5";
    public static final String TablaMascotasTop5_Id="id_mascota_top_5";
    public static final String TablaMascotasTop5_Nombre="nombre_mascota_top_5";
    public static final String TablaMascotasTop5_Puntos="puntos_mascota_top_5";
    public static final String TablaMascotasTop5_FotoPrincipal="foto_grande_mascota_top_5";
}
