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

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

//---Atributos--------------------------------------------------------------------------------------
    ArrayList<Mascota> mascotas;    //Lista de Mascotas
    Activity activity;

//---Constructor------------------------------------------------------------------------------------
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

//Le damos vida al CardView
    //Inflamos el layout
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        //asociamos el recycler_card con el main activity
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card, parent, false);

        return new MascotaViewHolder(v);
    }

//Asociamos cada elemento de la lista a cada view con el metodo onBindViewHolder
    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.ivImagenMascota.setImageResource(mascota.getFoto());
        holder.ibGrayBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "clic en el hueso gris", Toast.LENGTH_SHORT).show();
            }
        });
        holder.tvNombreMascota.setText(mascota.getNombre());
        holder.tvRatingMascota.setText(mascota.getRate());

    }

//Cantidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

//---Subclase de ViewHolder-------------------------------------------------------------------------
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        //Atributos
        private ImageView ivImagenMascota;
        private ImageButton ibGrayBone;
        private TextView tvNombreMascota;
        private TextView tvRatingMascota;

        public MascotaViewHolder(View itemView){
            super(itemView);
            ivImagenMascota = (ImageView)   itemView.findViewById(R.id.ivImagenMascota);
            ibGrayBone      = (ImageButton) itemView.findViewById(R.id.ibGrayBone);
            tvNombreMascota = (TextView)    itemView.findViewById(R.id.tvNombreMascota);
            tvRatingMascota = (TextView)    itemView.findViewById(R.id.tvRatingMascota);
        }

    }

}
