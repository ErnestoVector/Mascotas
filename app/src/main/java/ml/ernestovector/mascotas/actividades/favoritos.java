package ml.ernestovector.mascotas.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import ml.ernestovector.mascotas.pojo.Mascota;
import ml.ernestovector.mascotas.adapter.MascotaAdaptador;
import ml.ernestovector.mascotas.R;

public class favoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotafavoritos;
    private RecyclerView listaFavoritos;
    public MascotaAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        //Obtenemos el llamado al intent (a partir del icono de la AppBar)
        Intent i = getIntent();

        //Iniciando el RecyclerView
        listaFavoritos = (RecyclerView) findViewById(R.id.rvFavoritos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaFavoritos.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    //Correr el adaptador
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotafavoritos, this);
        listaFavoritos.setAdapter(adaptador);
    }

    //Crear los objetos en la lista mascotas
    public void inicializarListaMascotas(){
        mascotafavoritos = new ArrayList<Mascota>();

        mascotafavoritos.add(new Mascota(R.drawable.perro3,   "Gastón",   "5"));
        mascotafavoritos.add(new Mascota(R.drawable.perro2,   "Puppy",    "3"));
        mascotafavoritos.add(new Mascota(R.drawable.perro1,   "Kraken",   "4"));
        mascotafavoritos.add(new Mascota(R.drawable.hamster3, "Canela",   "2"));
        mascotafavoritos.add(new Mascota(R.drawable.hamster1, "Travieso", "5"));

    }
}
