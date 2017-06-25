package cl.creative_it_spa.mascotas_2.InterfazView;

import java.util.ArrayList;

import cl.creative_it_spa.mascotas_2.Adaptadores.AdaptMascotaSeleccionada;
import cl.creative_it_spa.mascotas_2.POJOs.ListMascotDetalle;
import cl.creative_it_spa.mascotas_2.POJOs.ListaMascotas;

/**
 * Created by Rodrigo on 21-06-2017.
 */

public interface IFDetalleMascotasView {

    public void generarGridLayoutVertical();


    public AdaptMascotaSeleccionada crearAdaptador(ArrayList<ListMascotDetalle> mascotasdetalle,
                                                   ArrayList<ListMascotDetalle> mascota_detalle_defecto);

    public void inicializarAdaptadorRV(AdaptMascotaSeleccionada adaptador);
}
