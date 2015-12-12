package com.example.ezequielbrrt.hilos;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    final Handler mhandler = new Handler();
    protected void miHilo(){
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mhandler.post(ejecutarAccion);
            }

        };
        t.start();
    }

    final Runnable ejecutarAccion = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(MainActivity.this, "Hola soy un hilo", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonuno = (Button) findViewById(R.id.Boton1);

        botonuno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pulsando", Toast.LENGTH_SHORT).show();
                miHilo();
            }
        });

    }
}
