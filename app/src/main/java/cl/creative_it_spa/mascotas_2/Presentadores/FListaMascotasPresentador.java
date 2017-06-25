package cl.creative_it_spa.mascotas_2.Presentadores;

import android.content.Context;

import java.util.ArrayList;

import cl.creative_it_spa.mascotas_2.InterfazPresentador.IFListaMascotasPresentador;
import cl.creative_it_spa.mascotas_2.InterfazView.IFListaMascotasView;
import cl.creative_it_spa.mascotas_2.ModeloBDMascotas.ConstructorBDMascotas;
import cl.creative_it_spa.mascotas_2.POJOs.ListaMascotas;

/**
 * Created by Rodrigo on 21-06-2017.
 */

public class FListaMascotasPresentador implements IFListaMascotasPresentador {

    private IFListaMascotasView iFListaMascotasView;
    private Context contexto;
    private ConstructorBDMascotas constructorBDMascotas;
    private ArrayList<ListaMascotas> mascotasBD;

    public FListaMascotasPresentador(IFListaMascotasView ifListaMascotasView, Context contexto) {
        this.iFListaMascotasView = ifListaMascotasView;
        this.contexto = contexto;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorBDMascotas=new ConstructorBDMascotas(contexto);
        mascotasBD=constructorBDMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iFListaMascotasView.inicializarAdaptadorRV(iFListaMascotasView.crearAdaptador(mascotasBD));
        iFListaMascotasView.generarLinearLayoutVertical();
    }
}
