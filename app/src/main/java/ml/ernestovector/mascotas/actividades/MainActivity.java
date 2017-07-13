package ml.ernestovector.mascotas.actividades;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import ml.ernestovector.mascotas.adapter.PageAdapter;
import ml.ernestovector.mascotas.fragment.MascotaFragment;
import ml.ernestovector.mascotas.R;
import ml.ernestovector.mascotas.fragment.PerfilFragment;

public class MainActivity extends AppCompatActivity {

//Atributos-----------------------------------------------------------------------------------------
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

//Metodo on create----------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Agregamos el FAB para futuras funcionalidades
        agregarFAB();

        //Conectamos el codigo con los elementos de la actividad
        toolbar   = (Toolbar)   findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
        }


    }

//Inicializando el menu en la MainActivity----------------------------------------------------------
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

//Le damos vida a los fragments en el MainActivity--------------------------------------------------
    private ArrayList<Fragment> agregarFragments(){
        //Creamos una lista de Fragments
        ArrayList<Fragment> fragments = new ArrayList<>();

        //Inicializamos los fragments en la lista
        fragments.add(new MascotaFragment());
        fragments.add(new PerfilFragment());

        //regresamos la lista con los fragments
        return fragments;
    }

    private void setUpViewPager(){
        //Obtenemos el soporte y la lista de fragments en el view pager
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));

        //Agregamos los fragments al tabLayout
        tabLayout.setupWithViewPager(viewPager);

        //Agregamos los iconos a los Tabs
        tabLayout.getTabAt(0).setIcon(R.drawable.camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.star);

    }

//Le da funcion al FAB de la camara-----------------------------------------------------------------
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
