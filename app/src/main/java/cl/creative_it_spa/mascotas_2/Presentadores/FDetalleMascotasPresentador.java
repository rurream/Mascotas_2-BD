package cl.creative_it_spa.mascotas_2.Presentadores;

import android.content.Context;

import java.util.ArrayList;

import cl.creative_it_spa.mascotas_2.InterfazPresentador.IFDetalleMascotasPresentador;
import cl.creative_it_spa.mascotas_2.InterfazView.IFDetalleMascotasView;
import cl.creative_it_spa.mascotas_2.ModeloBDMascotas.ConstructorBDMascotas;
import cl.creative_it_spa.mascotas_2.POJOs.ListMascotDetalle;
import cl.creative_it_spa.mascotas_2.POJOs.ListaMascotas;

/**
 * Created by Rodrigo on 21-06-2017.
 */

public class FDetalleMascotasPresentador implements IFDetalleMascotasPresentador {

    private IFDetalleMascotasView ifDetalleMascotasView;
    private Context contexto;
    private ConstructorBDMascotas constructorBDMascotas;
    private ArrayList<ListMascotDetalle> mascotaBDPorDefecto;
    private ArrayList<ListMascotDetalle> mascotasBDDetalle;
    private int id_mascotaSeleccionada;

    public FDetalleMascotasPresentador(IFDetalleMascotasView ifDetalleMascotasView, Context contexto, int id_mascotaSeleccionada) {
        this.ifDetalleMascotasView = ifDetalleMascotasView;
        this.contexto = contexto;
        this.id_mascotaSeleccionada=id_mascotaSeleccionada;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorBDMascotas=new ConstructorBDMascotas(contexto);
        mascotasBDDetalle=constructorBDMascotas.obtenerDatosDetalle(id_mascotaSeleccionada);
        mascotaBDPorDefecto=constructorBDMascotas.obtenerDatosMascotaPorDefecto();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        ifDetalleMascotasView.inicializarAdaptadorRV(ifDetalleMascotasView.crearAdaptador(mascotasBDDetalle, mascotaBDPorDefecto));
        ifDetalleMascotasView.generarGridLayoutVertical();
    }
}
