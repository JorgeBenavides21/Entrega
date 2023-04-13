package com.example.votacion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Eleccion extends AppCompatActivity {

    Button btn2,btn3;
    EditText et2,et3,et4,et5,et6;
    TextView tv3,tv4,tv5,tv6,tv7,tv8,tv10;

    int numero;
    int numero1 = 0;
    int numero2= 0;
    int numero3 = 0;
    int contador = 0;
    int perdedor=0;

    String nombre;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion);


        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3final);

        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);

        tv3 = findViewById(R.id.tv10);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        tv8 = findViewById(R.id.tv8);
        tv10 = findViewById(R.id.tv10);


        String estudiantes = getIntent().getStringExtra("dato");
        numero = Integer.parseInt(estudiantes);

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                nombre=et2.getText().toString();

                tv5.setVisibility(View.VISIBLE);
                tv6.setVisibility(View.VISIBLE);
                tv7.setVisibility(View.VISIBLE);
                tv8.setVisibility(View.VISIBLE);
                tv10.setVisibility(View.VISIBLE);

                et3.setVisibility(View.VISIBLE);
                et4.setVisibility(View.VISIBLE);
                et5.setVisibility(View.VISIBLE);
                et6.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn2.setEnabled(false);

            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                    if(et3.getText().length() != 0 && et4.getText().length() != 0 && et5.getText().length() != 0 && et6.getText().length() != 0){

                        double nota1, nota2,nota3, nota4;
                        nota1 = Double.parseDouble(et3.getText().toString());
                        nota2 = Double.parseDouble(et4.getText().toString());
                        nota3 = Double.parseDouble(et5.getText().toString());
                        nota4 = Double.parseDouble(et6.getText().toString());

                        if(nota1>=0 && nota1<=5 && nota2>=0 && nota2<=5  && nota3>=0 && nota3<=5 && nota4>=0 && nota4<=5 ){


                            Operaciones op = new Operaciones();
                            double notaFinal = op.promedio(nota1,nota2,nota3,nota4);
                            Toast.makeText(Eleccion.this, "El estudiante " + nombre + " obtuvo un promedio de: " + notaFinal, Toast.LENGTH_SHORT).show();
                            contador+=1;

                            if(notaFinal<3){
                                perdedor+=1;
                            }

                            tv5.setVisibility(View.INVISIBLE);
                            tv6.setVisibility(View.INVISIBLE);
                            tv7.setVisibility(View.INVISIBLE);
                            tv8.setVisibility(View.INVISIBLE);
                            tv10.setVisibility(View.INVISIBLE);
                            et3.setVisibility(View.INVISIBLE);
                            et4.setVisibility(View.INVISIBLE);
                            et5.setVisibility(View.INVISIBLE);
                            et6.setVisibility(View.INVISIBLE);
                            btn3.setVisibility(View.INVISIBLE);
                            et2.setText("");
                            et3.setText("");
                            et4.setText("");
                            et5.setText("");
                            et6.setText("");
                            btn2.setEnabled(true);

                            if(contador == numero){

                                Toast.makeText(Eleccion.this, "El numero de estudiantes que perdieron son " + perdedor, Toast.LENGTH_SHORT).show();
                                et2.setText("");
                                et3.setText("");
                                et4.setText("");
                                et5.setText("");
                                et6.setText("");
                                btn2.setEnabled(false);
                                et2.setEnabled(false);
                            }
                        } else{
                            et3.setText("");
                            et4.setText("");
                            et5.setText("");
                            et6.setText("");
                            Toast.makeText(Eleccion.this, "LAS NOTAS DEBEN ESTAR ENTRE O Y 5", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        });
    }
}
