package com.olmo.numero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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
    Button botonSalir;
    EditText numero;
    TextView solucion;
    TextView textoContador;
    TextView victoria;

    int min=1;
    int max=1000;
    int r;
    int n=-1;
    int contador = 0;
    int restante;

    Context context;
    CharSequence text;
    int duration;
    Toast toast;




    AlertDialog.Builder alerta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dialogo normal
        alerta = new AlertDialog.Builder(this);
        alerta.setTitle("BLOC DE NOTAS");
        alerta.setMessage("Vamos a probar cómo se guardan notas en una base de datos con SQLite");
        alerta.setPositiveButton("OK",null);





        botonComprobar = (Button) findViewById(R.id.buttonComprobar);
        botonComprobar.setOnClickListener(this);
        botonSalir = (Button) findViewById(R.id.buttonSalir);
        botonSalir.setOnClickListener(this);
        botonMostrar = (Button) findViewById(R.id.buttonGenerarNumero);
        botonMostrar.setOnClickListener(this);

        numero  = (EditText) findViewById(R.id.numero);
        solucion  = (TextView) findViewById(R.id.solucion);
        textoContador  = (TextView) findViewById(R.id.contador);
        victoria  = (TextView) findViewById(R.id.victoria);



        context = getApplicationContext();
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
                if(numero.getText().toString().equals("") || numero.getText().toString().equals(null)) {
                    text = "Introduce un número entre 1 y 1000";
                    toast = Toast.makeText(context, text, duration);
                    toast.show();
                    } else {
                    n = Integer.parseInt(numero.getText().toString());
                    if (n > 0 && n < 1001) {
                        if (checkNumber(n)) {
                            solucion.setText("La solucion es: " + r);
                            alerta.setTitle("¡VICTORIA!");
                            alerta.setMessage("¡Número correcto!");
                            victoria.setText("¡Victoria!");
                        } else {

                            contador++;
                            restante = 5-contador;
                            alerta.setTitle("Número Incorrecto :( ");
                            alerta.setMessage("Prueba otra vez, te quedan " + restante  + "intnetos");
                            textoContador.setText("Llevas: " + contador + " intentos");
                            if(contador>=5){
                                alerta.setTitle("DERROTA");
                                alerta.setMessage("Se te acabaron los intentos :( " + "La solucion era: " + r);
                                solucion.setText("La solucion era: " + r);
                                victoria.setText("DERROTA, Alcanzaste el número máximo de intentos :(");
                            }

                        }
                    }
                    }


                alerta.create();
                alerta.show();


                break;
            case R.id.buttonGenerarNumero:
                r =(int)(Math.random()*(max-min+1)+min);
                victoria.setText("");
                solucion.setText("");
                textoContador.setText("");
                contador=0;
                text = String.valueOf(r);
                duration = Toast.LENGTH_SHORT;
                toast = Toast.makeText(context, text, duration);
                toast.show();
                break;
            case R.id.buttonSalir:
                finish();
                break;

        }

    }
}