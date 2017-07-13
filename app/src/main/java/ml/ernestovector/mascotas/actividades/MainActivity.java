package ml.ernestovector.mascotas.actividades;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import ml.ernestovector.mascotas.pojo.Mascota;
import ml.ernestovector.mascotas.adapter.MascotaAdaptador;
import ml.ernestovector.mascotas.R;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Agregamos el FAB para futuras funcionalidades
        agregarFAB();

        //Iniciando el RecyclerView
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    //Correr el adaptador
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
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

//Inicializando el menu en la MainActivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//Inicializamos los botones del menu (se les asignan tareas a cada uno
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Identificamos el icono del menu seleccionado
        //Se repetira este caso por cada boton en el menu
        //en nuestro caso hay 2 botones (favoritos y opciones)
        switch(item.getItemId()){
            case R.id.iFavoritos:
                //Iniciamos el intent
                Intent i = new Intent(MainActivity.this, favoritos.class);
                startActivity(i);
                return true;

            case R.id.mContacto:
                //Añadimos un Toast para visualizar el toque a contactos
                Toast.makeText(getBaseContext(),getResources().getString(R.string.mContacto), Toast.LENGTH_SHORT).show();

                //Iniciamos el intent a la actividad Contactos
                Intent iContacto = new Intent(MainActivity.this, Contacto.class);
                startActivity(iContacto);
                return true;

            case R.id.mAcerca_de:
                //Añadimos un Toast para visualizar el toque a Acerca de
                Toast.makeText(getBaseContext(),getResources().getString(R.string.mAcercaDe), Toast.LENGTH_SHORT).show();
                Intent iAcercaDe = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(iAcercaDe);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

//Le da funcion al FAB de la camara
    public void agregarFAB(){
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.fabCamara);
        //Le damos una accion para realizar
        //Mientras tanto, un Toast
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"FAB Camara", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
