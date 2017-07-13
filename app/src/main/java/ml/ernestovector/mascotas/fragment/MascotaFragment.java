package ml.ernestovector.mascotas.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ml.ernestovector.mascotas.R;
import ml.ernestovector.mascotas.adapter.MascotaAdaptador;
import ml.ernestovector.mascotas.pojo.Mascota;

public class MascotaFragment extends Fragment {

//Atributos-----------------------------------------------------------------------------------------
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

//Constructor---------------------------------------------------------------------------------------
    public MascotaFragment() {
        // Required empty public constructor
    }

//Metodo onCreateView-------------------------------------------------------------------------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascota, container, false);

        //Iniciando el RecyclerView
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        //Retornamos el view inflado
        return v;
    }

    //Correr el adaptador
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    //Crear los objetos en la lista mascotas
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perro3,   "Gastón",   "5"));
        mascotas.add(new Mascota(R.drawable.perro2,   "Puppy",    "3"));
        mascotas.add(new Mascota(R.drawable.perro1,   "Kraken",   "4"));
        mascotas.add(new Mascota(R.drawable.hamster3, "Canela",   "2"));
        mascotas.add(new Mascota(R.drawable.hamster2, "Nube",     "5"));
        mascotas.add(new Mascota(R.drawable.hamster1, "Travieso", "5"));
        mascotas.add(new Mascota(R.drawable.gato2,    "Blacky",   "3"));
        mascotas.add(new Mascota(R.drawable.gato1,    "Karen",    "4"));

    }

}
