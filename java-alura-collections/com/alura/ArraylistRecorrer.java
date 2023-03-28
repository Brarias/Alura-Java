package com.alura;

import java.util.ArrayList;

public class ArraylistRecorrer {
    public static void main(String[] args) {
        String variable1 = "Clase 1";
        String variable2 = "Clase 2";
        String variable3 = "Clase 3";
        String variable4 = "Clase 4";

        ArrayList<String> listaString = new ArrayList<>();
        listaString.add(variable1);
        listaString.add(variable2);
        listaString.add(variable3);
        listaString.add(variable4);

        System.out.println(listaString);


        //FORMAS DE RECORRER ARRAYLISTS

        // con un for comun
        /*for(int i = 0; i < listaString.size(); i++){
            System.out.println(listaString.get(i));
        }*/

        // con un foreach
        /*for(String clase : listaString){
            System.out.println(clase);
        }*/

        // con lambdas, a partir de Java 8

        listaString.forEach(clase ->{
            System.out.println("con lambdas: " + clase);
        });
    }
}
