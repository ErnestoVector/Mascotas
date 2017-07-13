package ml.ernestovector.mascotas.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ml.ernestovector.mascotas.R;
import ml.ernestovector.mascotas.adapter.MascotaAdaptador;
import ml.ernestovector.mascotas.adapter.PerfilAdaptador;
import ml.ernestovector.mascotas.pojo.Mascota;

public class PerfilFragment extends Fragment {

//Atributos-----------------------------------------------------------------------------------------
    ArrayList<Mascota> mascotas;
    private RecyclerView rvPerfil;
    public PerfilAdaptador adaptador;

//Constructor---------------------------------------------------------------------------------------
    public PerfilFragment() {
        // Required empty public constructor
    }

//Metodo onCreateView-------------------------------------------------------------------------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        //Iniciando el RecyclerView
        rvPerfil = (RecyclerView) v.findViewById(R.id.rvPerfil);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvPerfil.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdaptador();

        //Retormanos el view inflado
        return v;
    }

    //Correr el adaptador
    public void inicializarAdaptador(){
        adaptador = new PerfilAdaptador(mascotas, getActivity());
        rvPerfil.setAdapter(adaptador);
    }

    //Crear los objetos en la lista mascotas
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perro3, "5"));
        mascotas.add(new Mascota(R.drawable.perro2, "3"));
        mascotas.add(new Mascota(R.drawable.perro1, "4"));
        mascotas.add(new Mascota(R.drawable.perro1, "2"));
        mascotas.add(new Mascota(R.drawable.perro2, "5"));
        mascotas.add(new Mascota(R.drawable.perro3, "5"));
        mascotas.add(new Mascota(R.drawable.perro2, "3"));
        mascotas.add(new Mascota(R.drawable.perro3, "4"));
        mascotas.add(new Mascota(R.drawable.perro1, "4"));

    }

}
