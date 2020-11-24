package com.olmo.numero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button botonComprobar;
    Button botonMostrar;
    EditText numero;
    TextView solucion;

    int min=0;
    int max=1000;
    int r;
    int n;

    Context context;
    CharSequence text;
    int duration;
    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonComprobar = (Button) findViewById(R.id.buttonComprobar);
        botonMostrar = (Button) findViewById(R.id.buttonMostrarSolucion);
        numero  = (EditText) findViewById(R.id.numero);
        solucion  = (TextView) findViewById(R.id.solucion);
        r =(int)Math.random()*(max-min+1)+min;
        System.out.println(r);

        context = getApplicationContext();
        text = "Número incorrecto";
        duration = Toast.LENGTH_SHORT;



    }



    public Boolean checkNumber(int n){
        if(n==r){
            return true;
        }else
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonComprobar:
                n= Integer.parseInt(numero.getText().toString());
               if(checkNumber(n)){
                   solucion.setText("La solucion es: " + r);
                   text = "¡Número Correcto!";
               }else{
                   text = "Número incorrecto";
               }

                toast = Toast.makeText(context, text, duration);
                toast.show();

                break;
            case R.id.buttonMostrarSolucion:
                solucion.setText("La solucion era: " + r);

        }

    }
}