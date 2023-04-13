package com.example.votacion;
import android.view.View;
import android.widget.Toast;


public class Operaciones {
    double promedio;
    int contador = 0;

    public double promedio(double n1, double n2, double n3, double n4){

        n1 = n1 * 0.20;
        n2 = n2 * 0.30;
        n3 = n3 * 0.15;
        n4 = n4 * 0.35;

        promedio= (n1 + n2 + n3 + n4);

        if(promedio<3){
            contador +=1;
        }

        return promedio;
    }

}
