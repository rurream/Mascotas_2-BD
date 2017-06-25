package cl.creative_it_spa.mascotas_2.Presentadores;

import android.content.Context;

import java.util.ArrayList;

import cl.creative_it_spa.mascotas_2.InterfazPresentador.IMarcadorPresentador;
import cl.creative_it_spa.mascotas_2.InterfazView.IMarcadorView;
import cl.creative_it_spa.mascotas_2.ModeloBDMascotas.ConstructorBDMascotas;
import cl.creative_it_spa.mascotas_2.POJOs.ListaMascotas;

/**
 * Created by Rodrigo on 21-06-2017.
 */

public class MarcadorPresentador implements IMarcadorPresentador{

    private IMarcadorView iFListaMascotasView;
    private Context contexto;
    private ConstructorBDMascotas constructorBDMascotas;
    private ArrayList<ListaMascotas> mascotasBDTop5;

    public MarcadorPresentador(IMarcadorView iFListaMascotasView, Context contexto) {
        this.iFListaMascotasView = iFListaMascotasView;
        this.contexto = contexto;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorBDMascotas=new ConstructorBDMascotas(contexto);
        mascotasBDTop5=constructorBDMascotas.obtenerDatosMascotasTop5();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iFListaMascotasView.inicializarAdaptadorRV(iFListaMascotasView.crearAdaptador(mascotasBDTop5));
        iFListaMascotasView.generarLinearLayoutVertical();
    }
}
