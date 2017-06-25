package cl.creative_it_spa.mascotas_2.ModeloBDMascotas;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import cl.creative_it_spa.mascotas_2.POJOs.ListMascotDetalle;
import cl.creative_it_spa.mascotas_2.POJOs.ListaMascotas;

/**
 * Created by Rodrigo on 21-06-2017.
 * se supone que si la BD existe la abre, si no la crea (onCreate)
 */

public class AuxiliarBD extends SQLiteOpenHelper {

    private Context context;

    public AuxiliarBD(Context context) {
        super(context, ConstantesBD.nombre_BD, null, ConstantesBD.version_BD);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas="CREATE TABLE " + ConstantesBD.TablaMascotas + " (" +
                ConstantesBD.TablaMascotas_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBD.TablaMascotas_Nombre + " TEXT, " +
                ConstantesBD.TablaMascotas_Puntos + " INTEGER, " +
                ConstantesBD.TablaMascotas_FotoPrincipal + " INTEGER)";

        String queryCrearTablaFotosChicas="CREATE TABLE " + ConstantesBD.TablaFotosChicas + " (" +
                ConstantesBD.TablaFotosChicas_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TablaFotosChicas_Id_Mascota + " INTEGER, " +
                ConstantesBD.TablaFotosChicas_Foto + " INTEGER, " +
                ConstantesBD.TablaFotosChicas_Puntaje + " INTEGER, " +
                "FOREIGN KEY ("+ ConstantesBD.TablaFotosChicas_Id_Mascota + ") REFERENCES " +
                ConstantesBD.TablaMascotas +" ("+ ConstantesBD.TablaMascotas_Id +"))";

        String queryCrearTablaMascotaPorDefecto="CREATE TABLE " + ConstantesBD.TablaMascotaPorDefecto + " (" +
                ConstantesBD.TablaMascotaPorDefecto_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TablaMascotaPorDefecto_Foto + " INTEGER, " +
                ConstantesBD.TablaMascotaPorDefecto_Puntaje + " INTEGER)";

        String queryCrearTablaMascotasTop5="CREATE TABLE " + ConstantesBD.TablaMascotasTop5 + " (" +
                ConstantesBD.TablaMascotasTop5_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBD.TablaMascotasTop5_Nombre + " TEXT, " +
                ConstantesBD.TablaMascotasTop5_Puntos + " INTEGER, " +
                ConstantesBD.TablaMascotasTop5_FotoPrincipal + " INTEGER)";

        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaFotosChicas);
        db.execSQL(queryCrearTablaMascotaPorDefecto);
        db.execSQL(queryCrearTablaMascotasTop5);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TablaMascotas);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TablaFotosChicas);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TablaMascotaPorDefecto);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TablaMascotasTop5_FotoPrincipal);
        onCreate(db);

    }


    //********************************SELECT********************************************

    public ArrayList<ListaMascotas> obtenerMascotasFull(){
        ArrayList<ListaMascotas> mascotas= new ArrayList<ListaMascotas>();
        String q_mascotasFull="SELECT * FROM " + ConstantesBD.TablaMascotas;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros = db.rawQuery(q_mascotasFull, null);

        while (registros.moveToNext()){
            ListaMascotas objetoTemporal= new ListaMascotas();
            objetoTemporal.setNombre_mascota(registros.getString(1));
            objetoTemporal.setPuntaje_mascota(registros.getInt(2));
            objetoTemporal.setFoto_mascota(registros.getInt(3));
            objetoTemporal.setId(registros.getInt(0));

            mascotas.add(objetoTemporal);
        }

        if(registros != null && !registros.isClosed()){
            registros.close();
        }
        db.close();

        return mascotas;
    }



    public  ArrayList<ListMascotDetalle> obtenerDetalleMascotaSeleccionada(int id_mascota){
        ArrayList<ListMascotDetalle> mascotaSeleccionada= new ArrayList<ListMascotDetalle>();
        String qDetalleMascotas="SELECT " +
                ConstantesBD.TablaFotosChicas_Foto + ", " +
                ConstantesBD.TablaFotosChicas_Puntaje + ", " +
                ConstantesBD.TablaMascotas_FotoPrincipal  + ", " +
                ConstantesBD.TablaMascotas_Nombre
                + " FROM " + ConstantesBD.TablaFotosChicas +
                " INNER JOIN " + ConstantesBD.TablaMascotas + " ON " +
                ConstantesBD.TablaFotosChicas + "." + ConstantesBD.TablaFotosChicas_Id_Mascota +
                " = " + ConstantesBD.TablaMascotas + "." + ConstantesBD.TablaMascotas_Id +
                " WHERE " +
                ConstantesBD.TablaFotosChicas + "." + ConstantesBD.TablaFotosChicas_Id_Mascota + " = " + id_mascota;

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros = db.rawQuery(qDetalleMascotas, null);

        while (registros.moveToNext()){
            ListMascotDetalle objetoTemporal= new ListMascotDetalle();
            objetoTemporal.setPuntaje_masc_detalle(registros.getInt(1));
            objetoTemporal.setFoto_mascota_mini_1(registros.getInt(0));
            objetoTemporal.setFoto_principal(registros.getInt(2));
            objetoTemporal.setNombre_mascota(registros.getString(3));

            mascotaSeleccionada.add(objetoTemporal);
        }

        if(registros != null && !registros.isClosed()){
            registros.close();
        }
        db.close();

        return mascotaSeleccionada;
    }


    public ArrayList<ListMascotDetalle> obtenerDetalleMascotaPorDefecto(){
        ArrayList<ListMascotDetalle> mascota_por_defecto= new ArrayList<ListMascotDetalle>();
        String q_mascotaDefecto="SELECT * FROM " + ConstantesBD.TablaMascotaPorDefecto;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros = db.rawQuery(q_mascotaDefecto, null);

        while (registros.moveToNext()){
            ListMascotDetalle objetoTemporal= new ListMascotDetalle();
            objetoTemporal.setPuntaje_masc_detalle(registros.getInt(2));
            objetoTemporal.setFoto_mascota_mini_1(registros.getInt(1));

            mascota_por_defecto.add(objetoTemporal);
        }

        if(registros != null && !registros.isClosed()){
            registros.close();
        }
        db.close();
        return mascota_por_defecto;
    }


    public int obtenerLikes(int id_mascotaLikeada){
        Integer puntaje=0;

        String q_likes_mascota="SELECT " + ConstantesBD.TablaMascotas_Puntos +
                " FROM " + ConstantesBD.TablaMascotas + " WHERE " +
                ConstantesBD.TablaMascotas_Id + " = " + id_mascotaLikeada;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros = db.rawQuery(q_likes_mascota, null);

        if(registros.moveToNext()){
            puntaje=registros.getInt(0);
        }
        db.close();
        return puntaje;
    }



    public ArrayList<ListaMascotas> obtenerMascotasTop5(){
        ArrayList<ListaMascotas> mascotasTop5= new ArrayList<ListaMascotas>();
        String q_mascotasFull="SELECT " + ConstantesBD.TablaMascotasTop5_Nombre + ", " +
                ConstantesBD.TablaMascotasTop5_Puntos + ", " +
                ConstantesBD.TablaMascotasTop5_FotoPrincipal +
                " FROM " + ConstantesBD.TablaMascotasTop5 +
                " ORDER BY " + ConstantesBD.TablaMascotasTop5_Puntos +
                " DESC";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros = db.rawQuery(q_mascotasFull, null);

        while (registros.moveToNext()){
            ListaMascotas objetoTemporal= new ListaMascotas();
            objetoTemporal.setNombre_mascota(registros.getString(0));
            objetoTemporal.setPuntaje_mascota(registros.getInt(1));
            objetoTemporal.setFoto_mascota(registros.getInt(2));

            mascotasTop5.add(objetoTemporal);
        }

        if(registros != null && !registros.isClosed()){
            registros.close();
        }
        db.close();

        return mascotasTop5;
    }








    //***************************INSERT************************************************
    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBD.TablaMascotas, null, contentValues);
        db.close();
    }


    public void insertarFotoChicaMascotas(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBD.TablaFotosChicas, null, contentValues);
        db.close();
    }


    public void insertarMascotaPorDefecto(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBD.TablaMascotaPorDefecto, null, contentValues);

        db.close();
    }



    public void insertarMascotasTop5(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBD.TablaMascotasTop5, null, contentValues);
        db.close();
    }



    //***************************UPDATE************************************************

    public void actualizarLikes(ContentValues contentValues, int id_mascotaLikeada){
        SQLiteDatabase db=this.getWritableDatabase();
        db.update(ConstantesBD.TablaMascotas, contentValues, ConstantesBD.TablaMascotas_Id + " = " + id_mascotaLikeada, null);
        db.close();
    }

    public void actualizarMascotasTop5(ContentValues contentValues, int id_mascota){
        SQLiteDatabase db=this.getWritableDatabase();
        db.update(ConstantesBD.TablaMascotasTop5, contentValues, ConstantesBD.TablaMascotasTop5_Id + " = " + id_mascota, null);
        db.close();
    }
}
