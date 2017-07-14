package ml.ernestovector.mascotas.javamail;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Quota;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarMail extends AsyncTask<Void, Void, Void> {

//Atributos-----------------------------------------------------------------------------------------
    private Context context;
    private Session session;

    //Informacion para enviar el email
    private String email;
    private String subject;
    private String message;

    //Dialogo de progreso para el envío del correo
    private ProgressDialog progressDialog;

//Constructor---------------------------------------------------------------------------------------
    public EnviarMail(Context context, String email, String subject, String message){
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

//Metodos-------------------------------------------------------------------------------------------
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Muestra el dialogo de progreso cuando se envia el correo
        progressDialog = ProgressDialog.show(context,"Enviando mensaje","Espera un momento...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Termina el dialogo de progreso
        progressDialog.dismiss();
        //Muestra un mensaje de exito (correo enviado)
        Toast.makeText(context, "Mensaje Enviado",Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        //Creando Propiedades
        Properties props = new Properties();

        //configurando propiedades para Gmail
        //Si no usas Gmail, deberás cambiar las siguientes lineas de codigo
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //Creando una nueva sesion
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Autenticando el password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(ConfigCorreo.EMAIL, ConfigCorreo.PASSWORD);
                    }
                });

        try {
            //Creando objeto MimeMessage
            MimeMessage mm = new MimeMessage(session);

            //Configuramos la direccion de envio
            mm.setFrom(new InternetAddress(ConfigCorreo.EMAIL));
            //Añadimos receptor
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            //Añadimos Asunto
            mm.setSubject(subject);
            //Añadimos el mensaje
            mm.setText(message);

            //Enviamos el correo
            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
