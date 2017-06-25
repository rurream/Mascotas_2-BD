package cl.creative_it_spa.mascotas_2.ModeloBDMascotas;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import cl.creative_it_spa.mascotas_2.POJOs.ListMascotDetalle;
import cl.creative_it_spa.mascotas_2.POJOs.ListaMascotas;
import cl.creative_it_spa.mascotas_2.R;

/**
 * Created by Rodrigo on 21-06-2017.
 * Clase del Modelo, también llamada INTERACTOR
 */

public class ConstructorBDMascotas {

    private Context context;

    public ConstructorBDMascotas(Context context) {
        this.context = context;
    }


    //****************************Recuperar Datos*******************************************

    public ArrayList<ListaMascotas> obtenerDatos(){

        AuxiliarBD auxdb=new AuxiliarBD(context);
        ArrayList<ListaMascotas> arraySondeo= new ArrayList<ListaMascotas>();
        arraySondeo=auxdb.obtenerMascotasFull();
        if(arraySondeo.size()==0){
            insertarMascotas(auxdb);
            insertarFotosChicasMascotas(auxdb);
            insertarMascotaPorDefecto(auxdb);
            insertarMascotasTop5(auxdb);
            return auxdb.obtenerMascotasFull();
        }else{
            return arraySondeo;
        }
    }

    public ArrayList<ListMascotDetalle> obtenerDatosDetalle(int id_mascotaSeleccionada){
        AuxiliarBD auxdb=new AuxiliarBD(context);
        ArrayList<ListMascotDetalle> datosDetalle= new ArrayList<ListMascotDetalle>();
        datosDetalle=auxdb.obtenerDetalleMascotaSeleccionada(id_mascotaSeleccionada);
        return datosDetalle;
    }

    public ArrayList<ListMascotDetalle> obtenerDatosMascotaPorDefecto(){
        AuxiliarBD auxdb=new AuxiliarBD(context);
        ArrayList<ListMascotDetalle> datosDetalleMascotaPorDefecto= new ArrayList<ListMascotDetalle>();
        datosDetalleMascotaPorDefecto=auxdb.obtenerDetalleMascotaPorDefecto();
        return datosDetalleMascotaPorDefecto;
    }


    public int obtenerLikes(int id_mascotaLikeada){
        AuxiliarBD auxdb=new AuxiliarBD(context);
        return auxdb.obtenerLikes(id_mascotaLikeada);
    }


    public ArrayList<ListaMascotas> obtenerDatosMascotasTop5(){
        AuxiliarBD auxdb=new AuxiliarBD(context);
        return auxdb.obtenerMascotasTop5();
    }


    //****************************Insertar Datos*******************************************

    public void insertarMascotas(AuxiliarBD db){
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotas_Nombre, "Cheef");
        contentValues.put(ConstantesBD.TablaMascotas_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotas_FotoPrincipal, R.drawable.m1);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotas_Nombre, "Niña");
        contentValues.put(ConstantesBD.TablaMascotas_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotas_FotoPrincipal, R.drawable.m2);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotas_Nombre, "Twins");
        contentValues.put(ConstantesBD.TablaMascotas_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotas_FotoPrincipal, R.drawable.m3);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotas_Nombre, "Pancho Malo");
        contentValues.put(ConstantesBD.TablaMascotas_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotas_FotoPrincipal, R.drawable.m4);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotas_Nombre, "Math");
        contentValues.put(ConstantesBD.TablaMascotas_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotas_FotoPrincipal, R.drawable.m5);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotas_Nombre, "Loquillo");
        contentValues.put(ConstantesBD.TablaMascotas_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotas_FotoPrincipal, R.drawable.m6);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotas_Nombre, "Paco");
        contentValues.put(ConstantesBD.TablaMascotas_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotas_FotoPrincipal, R.drawable.m7);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotas_Nombre, "Cachupin");
        contentValues.put(ConstantesBD.TablaMascotas_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotas_FotoPrincipal, R.drawable.m8);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotas_Nombre, "Dentin");
        contentValues.put(ConstantesBD.TablaMascotas_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotas_FotoPrincipal, R.drawable.m9);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotas_Nombre, "Lucky");
        contentValues.put(ConstantesBD.TablaMascotas_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotas_FotoPrincipal, R.drawable.m10);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotas_Nombre, "Epidemia");
        contentValues.put(ConstantesBD.TablaMascotas_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotas_FotoPrincipal, R.drawable.m11);
        db.insertarMascotas(contentValues);

    }

    public void insertarFotosChicasMascotas(AuxiliarBD db){
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m1_1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 1);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m1_2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 4);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m1_3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 0);
        db.insertarFotoChicaMascotas(contentValues);

        //************************************************************

        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m2_1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 3);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m2_2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 1);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m2_3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 2);
        db.insertarFotoChicaMascotas(contentValues);

        //************************************************************

        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m3_1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 0);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m3_2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 3);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m3_3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 1);
        db.insertarFotoChicaMascotas(contentValues);

        //************************************************************

        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 4);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m4_1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 1);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 4);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m4_2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 3);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 4);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m4_3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 3);
        db.insertarFotoChicaMascotas(contentValues);

        //************************************************************

        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 5);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m5_1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 5);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 5);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m5_2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 1);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 5);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m5_3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 3);
        db.insertarFotoChicaMascotas(contentValues);

        //************************************************************

        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 6);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m6_1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 2);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 6);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m6_2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 3);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 6);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m6_3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 1);
        db.insertarFotoChicaMascotas(contentValues);

        //************************************************************

        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 7);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m7_1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 0);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 7);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m7_2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 1);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 7);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m7_3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 3);
        db.insertarFotoChicaMascotas(contentValues);

        //************************************************************

        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 8);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m8_1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 1);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 8);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m8_2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 1);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 8);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m8_3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 3);
        db.insertarFotoChicaMascotas(contentValues);

        //************************************************************

        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 9);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m9_1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 3);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 9);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m9_2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 1);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 9);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m9_3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 4);
        db.insertarFotoChicaMascotas(contentValues);

        //************************************************************

        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 10);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m10_1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 0);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 10);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m10_2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 2);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 10);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m10_3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 1);
        db.insertarFotoChicaMascotas(contentValues);

        //************************************************************

        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 11);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m11_1);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 1);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 11);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m11_2);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 3);
        db.insertarFotoChicaMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaFotosChicas_Id_Mascota, 11);
        contentValues.put(ConstantesBD.TablaFotosChicas_Foto, R.drawable.m11_3);
        contentValues.put(ConstantesBD.TablaFotosChicas_Puntaje, 2);
        db.insertarFotoChicaMascotas(contentValues);
    }


    public void insertarMascotaPorDefecto(AuxiliarBD db){

        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotaPorDefecto_Foto, R.drawable.default_dog);
        contentValues.put(ConstantesBD.TablaMascotaPorDefecto_Puntaje, 0);
        db.insertarMascotaPorDefecto(contentValues);
    }

    public void insertarMascotasTop5(AuxiliarBD db){
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotasTop5_Nombre, "Cheef");
        contentValues.put(ConstantesBD.TablaMascotasTop5_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotasTop5_FotoPrincipal, R.drawable.m1);
        db.insertarMascotasTop5(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotasTop5_Nombre, "Niña");
        contentValues.put(ConstantesBD.TablaMascotasTop5_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotasTop5_FotoPrincipal, R.drawable.m2);
        db.insertarMascotasTop5(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotasTop5_Nombre, "Twins");
        contentValues.put(ConstantesBD.TablaMascotasTop5_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotasTop5_FotoPrincipal, R.drawable.m3);
        db.insertarMascotasTop5(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotasTop5_Nombre, "Pancho Malo");
        contentValues.put(ConstantesBD.TablaMascotasTop5_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotasTop5_FotoPrincipal, R.drawable.m4);
        db.insertarMascotasTop5(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotasTop5_Nombre, "Math");
        contentValues.put(ConstantesBD.TablaMascotasTop5_Puntos, 0);
        contentValues.put(ConstantesBD.TablaMascotasTop5_FotoPrincipal, R.drawable.m5);
        db.insertarMascotasTop5(contentValues);
    }







    //****************************ACTUALIZAR Datos*******************************************

    public void actualizarLike(int id_mascotaLikeada, int puntos){
        AuxiliarBD auxdb=new AuxiliarBD(context);
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TablaMascotas_Puntos, puntos);
        auxdb.actualizarLikes(contentValues, id_mascotaLikeada);
    }

    public void actualizarMascotasTop5(ArrayList<ListaMascotas> listaMascotasTop5){
        AuxiliarBD auxdb=new AuxiliarBD(context);
        ContentValues contentValues;
        ListaMascotas listaTemp;

        for (Integer i=0; i<listaMascotasTop5.size(); i++){
            contentValues=new ContentValues();
            listaTemp=listaMascotasTop5.get(i);
            contentValues.put(ConstantesBD.TablaMascotasTop5_Nombre, listaTemp.getNombre_mascota());
            contentValues.put(ConstantesBD.TablaMascotasTop5_Puntos, listaTemp.getPuntaje_mascota());
            contentValues.put(ConstantesBD.TablaMascotasTop5_FotoPrincipal, listaTemp.getFoto_mascota());
            auxdb.actualizarMascotasTop5(contentValues, i+1);
        }
    }
}
