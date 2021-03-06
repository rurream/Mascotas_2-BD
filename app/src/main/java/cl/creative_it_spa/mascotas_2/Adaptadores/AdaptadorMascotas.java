package cl.creative_it_spa.mascotas_2.Adaptadores;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cl.creative_it_spa.mascotas_2.Fragments.FDetalleMascotas;
import cl.creative_it_spa.mascotas_2.ModeloBDMascotas.AuxiliarBD;
import cl.creative_it_spa.mascotas_2.ModeloBDMascotas.ConstructorBDMascotas;
import cl.creative_it_spa.mascotas_2.POJOs.ListaMascotas;
import cl.creative_it_spa.mascotas_2.POJOs.MascotasTopFive;
import cl.creative_it_spa.mascotas_2.R;

/**
 * Created by Rodrigo on 13-06-2017.
 */

public class AdaptadorMascotas extends RecyclerView.Adapter<AdaptadorMascotas.MascotasViewHolder>{

    ArrayList<ListaMascotas> mascotas;
    Activity activity;
    Integer idMascotaSeleccionada=1;

    public AdaptadorMascotas(ArrayList<ListaMascotas> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotasViewHolder holder_de_mascotas, final int position) {
        final ListaMascotas mascota= mascotas.get(position);
        holder_de_mascotas.img_foto_mascota.setImageResource(mascota.getFoto_mascota());
        holder_de_mascotas.tv_nombre_mascota.setText(mascota.getNombre_mascota());
        holder_de_mascotas.tv_puntos_mascota.setText("" + mascota.getPuntaje_mascota());

        if(idMascotaSeleccionada==mascota.getId()){
            holder_de_mascotas.cvMascotas.setBackgroundColor(activity.getResources().getColor(R.color.colorSeleccion));
        }else{
            holder_de_mascotas.cvMascotas.setBackgroundColor(activity.getResources().getColor(R.color.colorBlanco));
        }

        holder_de_mascotas.img_hueso_blanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.playSoundEffect(android.view.SoundEffectConstants.CLICK);

                Integer idMascotaLike=mascota.getId();
                ConstructorBDMascotas constructorBDMascotas=new ConstructorBDMascotas(activity);

                Integer puntajenuevo=mascota.getPuntaje_mascota() + 1;
                constructorBDMascotas.actualizarLike(idMascotaLike, puntajenuevo);

                Integer puntaje_actual=constructorBDMascotas.obtenerLikes(idMascotaLike);
                holder_de_mascotas.tv_puntos_mascota.setText(String.valueOf(puntaje_actual));
                mascotas.get(position).setPuntaje_mascota(puntaje_actual);

                MascotasTopFive mascotasTopFive=new MascotasTopFive();
                ArrayList<ListaMascotas> listaMascotasTop5;
                listaMascotasTop5=mascotasTopFive.mascotas_top(mascotas);
                constructorBDMascotas.actualizarMascotasTop5(listaMascotasTop5);
            }
        });

        holder_de_mascotas.img_foto_mascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.playSoundEffect(android.view.SoundEffectConstants.CLICK);

                idMascotaSeleccionada=mascota.getId();

                FDetalleMascotas fragmento= new FDetalleMascotas(idMascotaSeleccionada);
                FragmentTransaction transaccion= ((FragmentActivity) v.getContext()).getSupportFragmentManager().beginTransaction();
                transaccion.replace(R.id.ly_mascota_seleccionada, fragmento);
                transaccion.addToBackStack(null);
                transaccion.commit();

                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }





    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

        ImageView img_foto_mascota, img_hueso_color;
        TextView tv_nombre_mascota;
        TextView tv_puntos_mascota;
        ImageButton img_hueso_blanco;
        CardView cvMascotas;

        public MascotasViewHolder(View itemView) {
            super(itemView);

            img_foto_mascota=(ImageView) itemView.findViewById(R.id.img_foto_mascota);
            tv_nombre_mascota=(TextView) itemView.findViewById(R.id.tv_nombre_mascota);
            tv_puntos_mascota=(TextView) itemView.findViewById(R.id.tv_puntos_mascota);
            img_hueso_blanco=(ImageButton) itemView.findViewById(R.id.img_hueso_blanco);
            img_hueso_color=(ImageView) itemView.findViewById(R.id.img_hueso_color);

            cvMascotas=(CardView) itemView.findViewById(R.id.cvMascotas);
        }
    }
}
