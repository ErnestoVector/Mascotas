package ml.ernestovector.mascotas.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ml.ernestovector.mascotas.R;
import ml.ernestovector.mascotas.pojo.Mascota;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>{

//Atributos-----------------------------------------------------------------------------------------
    ArrayList<Mascota> mascotas;    //Lista de Mascotas
    Activity activity;

//Constructor---------------------------------------------------------------------------------------

    public PerfilAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

//Le damos vida al CardView-------------------------------------------------------------------------
    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflamos el layout y lo pasamos al viewholder para obtener los views
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_profile, parent, false);

        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerfilViewHolder holder, int position) {
        //Asocia cada elemento de la lista a cada view
        final Mascota mascota = mascotas.get(position);
        holder.ivImagenMascota2.setImageResource(mascota.getFoto());
        holder.tvRatingMascota2.setText(mascota.getRate());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    //---Subclase de ViewHolder-------------------------------------------------------------------------
    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        //Atributos
        private ImageView ivImagenMascota2;
        private TextView tvRatingMascota2;

        public PerfilViewHolder(View itemView){
            super(itemView);
            ivImagenMascota2 = (ImageView)   itemView.findViewById(R.id.ivImagenMascota2);
            tvRatingMascota2 = (TextView)    itemView.findViewById(R.id.tvRatingMascota2);
        }

    }
}
