package com.snape.shivichuhome.simpletexttovoice;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech texttoSpeech;
    EditText txt;
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt=(EditText)findViewById(R.id.editText);
        click=(Button)findViewById(R.id.button);

        texttoSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR)
                {
                    texttoSpeech.setLanguage(Locale.US);
                }
            }
        });

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toSpeak=txt.getText().toString();
                Toast.makeText(getApplicationContext(),toSpeak,Toast.LENGTH_SHORT).show();
                texttoSpeech.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);

            }
        });


    }


    protected void onPause() {
        if(texttoSpeech!=null) {
            texttoSpeech.stop();
            texttoSpeech.shutdown();
        }
        super.onPause();
    }

}

