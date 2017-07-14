package ml.ernestovector.mascotas.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ml.ernestovector.mascotas.R;
import ml.ernestovector.mascotas.javamail.EnviarMail;

public class Contacto extends AppCompatActivity implements View.OnClickListener{

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

        bEnviar.setOnClickListener(this);
    }

    private void enviarMail(){
        //Obtenemos el contexto del correo
        String subject  = etNombre.getText().toString().trim();
        String email    = etCorreo.getText().toString().trim();
        String message  = etMensaje.getText().toString().trim();

        //Creando un objeto de tipo EnviarMail
        EnviarMail em = new EnviarMail(this, email, subject, message);

        //Ejecutamos EnviarMail para que mande el correo
        em.execute();
    }

    @Override
    public void onClick(View v) {
        enviarMail();
    }
}
