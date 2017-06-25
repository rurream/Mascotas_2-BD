package cl.creative_it_spa.mascotas_2.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.pkmmte.view.CircularImageView;

import java.util.ArrayList;

import cl.creative_it_spa.mascotas_2.Adaptadores.AdaptMascotaSeleccionada;
import cl.creative_it_spa.mascotas_2.InterfazView.IFDetalleMascotasView;
import cl.creative_it_spa.mascotas_2.POJOs.ListMascotDetalle;
import cl.creative_it_spa.mascotas_2.Presentadores.FDetalleMascotasPresentador;
import cl.creative_it_spa.mascotas_2.InterfazPresentador.IFDetalleMascotasPresentador;
import cl.creative_it_spa.mascotas_2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FDetalleMascotas extends android.support.v4.app.Fragment implements IFDetalleMascotasView {


    private int id_mascota_seleccionada;
    TextView tv_mascota_seleccionada;
    CircularImageView img_mascota_seleccionada;
    RecyclerView rvMascotaSeleccionada;
    IFDetalleMascotasPresentador presentadorDatos;


    public FDetalleMascotas(int id_mascota_seleccionada) {

        this.id_mascota_seleccionada=id_mascota_seleccionada;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_fdetalle_mascotas, container, false);

        rvMascotaSeleccionada=(RecyclerView) v.findViewById(R.id.rvMascotaSeleccionada);

        tv_mascota_seleccionada=(TextView) v.findViewById(R.id.tv_nombre_mascota_seleccionada);
        img_mascota_seleccionada=(CircularImageView) v.findViewById(R.id.img_mascota_seleccionada3);


        if(id_mascota_seleccionada!=-1){

            presentadorDatos=new FDetalleMascotasPresentador(this, getContext(), id_mascota_seleccionada);
        }
        else{
            FDetalleMascotas fragmento= new FDetalleMascotas(1);
            FragmentTransaction transaccion= ((FragmentActivity) v.getContext()).getSupportFragmentManager().beginTransaction();
            transaccion.replace(R.id.ly_mascota_seleccionada, fragmento);
            transaccion.addToBackStack(null);
            transaccion.commit();
        }
        return v;
    }



    @Override
    public void generarGridLayoutVertical() {
        GridLayoutManager llm=new GridLayoutManager(getActivity(), 3);
        llm.setOrientation(GridLayoutManager.VERTICAL);
        rvMascotaSeleccionada.setLayoutManager(llm);
    }

    @Override
    public AdaptMascotaSeleccionada crearAdaptador(ArrayList<ListMascotDetalle> mascot_detalle,
                                                   ArrayList<ListMascotDetalle> mascot_detalle_defecto) {

        if(id_mascota_seleccionada!=-1){

            ListMascotDetalle mascotaSeleccionada=mascot_detalle.get(0);
            tv_mascota_seleccionada.setText(mascotaSeleccionada.getNombre_mascota());
            img_mascota_seleccionada.setImageResource(mascotaSeleccionada.getFoto_principal());

            Integer numero_fotos_detalle_faltantes= 9-mascot_detalle.size();

            for (Integer i=numero_fotos_detalle_faltantes; i>0;i--){
                mascot_detalle.add(new ListMascotDetalle(mascot_detalle_defecto.get(0).getPuntaje_masc_detalle(),
                        mascot_detalle_defecto.get(0).getFoto_mascota_mini_1()));
            }
        }
        AdaptMascotaSeleccionada adaptador=new AdaptMascotaSeleccionada(mascot_detalle, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(AdaptMascotaSeleccionada adaptador) {
        rvMascotaSeleccionada.setAdapter(adaptador);
    }
}
