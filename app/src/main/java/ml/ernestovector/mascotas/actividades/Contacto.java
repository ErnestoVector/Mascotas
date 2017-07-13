package ml.ernestovector.mascotas.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import ml.ernestovector.mascotas.R;

public class Contacto extends AppCompatActivity {

    private EditText etNombre;
    private EditText etCorreo;
    private EditText etMensaje;
    private Button bEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        //Conectamos los componentes de la actividad al codigo
        etNombre  = (EditText) findViewById(R.id.etNombre);
        etCorreo  = (EditText) findViewById(R.id.etCorreo);
        etMensaje = (EditText) findViewById(R.id.etMensaje);
        bEnviar   = (Button)   findViewById(R.id.bEnviar);

        //Crear un bundle que envie el contenido de los EditText
        //a un nuevo correo con la clase javaMail
    }
}
