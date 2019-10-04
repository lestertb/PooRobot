package com.example.amendez.robotvendedor;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    /** Speech to text**/
    private static final int REQUEST_CODE = 1234;
    Button startButton;
    /** Text to speech**/
    TextToSpeech t1;

    Shirt shirt = new Shirt(1000,"camisa",10, "Robot","StoreTEC","playera");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set language
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                Locale locSpanish = new Locale("spa", "CR");
                t1.setLanguage(locSpanish);
            }
        });

        startButton = (Button) findViewById(R.id.buttton1);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isConnected()){
                    commands(0);
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Por favor, conectarse a Internet", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            ArrayList<String> matches_text =
                    data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String text = matches_text.get(0);
            int command = engine(text);
            commands(command);
        }
    }

    /**
     *
     * @param text
     * @return
     */
    private int engine(String text){
        if(text.contains("comprar") && text.contains("camisa")){
            return 1;
        }else if (text.contains("salir")){
            return 100;
        }else if(text.contains("si") || text.contains("Si") || text.contains("sí") && text.contains("comprar")){
            return 2;
        }
        return -1;
    }

    private void commands(int command){
        switch (command){
            case 0:     //saludar
                leerTexto("Hola! ¿En qué le puedo ayudar?"); //Text to speech
                while (t1.isSpeaking()){

                }
                grabarText();   //Speech to text
                break;
            case 1:     //comprar camisa
                leerTexto("Tengo" + shirt.getCant() + "camisas"  + "de tipo: " + shirt.getType() +
                        "¿Desea comprar una camisa?");

                while (t1.isSpeaking()){

                }

                grabarText();  //Speech to text -> Respuesta del cliente

                break;
            case 2:
                leerTexto("Prueba de compra");

            case 100:
                leerTexto("Adios!");
                while (t1.isSpeaking()){

                }
                finish();
                default:
                    //Text to speech -> No he logrado entenderle, por favor, me puede explicar de nuevo
                    //Speech to text -> Respuesta del cliente
        }
    }

    /**
     *
     * @param texto
     */
    private void leerTexto(String texto){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            t1.speak(texto, TextToSpeech.QUEUE_FLUSH,null, null);
        }else {
            t1.speak(texto, TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    /**
     *
     */
    private void grabarText(){
        if(isConnected()){
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "es-ES");
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    /**
     To Check if the net is available and conected
     * @return true if the net is available and conected
     * and false in other case
     */
    public boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo net = cm.getActiveNetworkInfo();
        if (net!= null && net.isAvailable() && net.isConnected()){
            return true;
        }   else {
            return false;
        }
    }
}
