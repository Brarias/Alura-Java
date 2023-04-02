package com.alura;

import com.alura.model.Aula;
import com.alura.model.Curso;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DifLinkedArray {

   public static final List<List<Integer>> listas = new ArrayList<List<Integer>>(){
        {
            add(new LinkedList<>());
            add(new ArrayList<>());
        }
    };

    public static void main(String[] args) {
        for (List<Integer> lista:listas){
            final String nombreImplementacion = lista.getClass().getSimpleName();

            // Métodos a comparar entre LinkedList y ArrayList


            // add
            long inicio = System.currentTimeMillis();
            for(int i = 0; i < 100000; i++){
                lista.add((i));
            }
            long fin = System.currentTimeMillis();
            long duracion = fin - inicio;
            System.out.println(nombreImplementacion + " add: " + duracion);


            // get
            inicio = System.currentTimeMillis();
            for(int i = 0; i < 100000; i++){
                lista.get((i));
            }
            fin = System.currentTimeMillis();
            duracion = fin - inicio;
            System.out.println(nombreImplementacion + " get: " + duracion);

            // remove
            inicio = System.currentTimeMillis();
            for(int i = 99999; i >= 0; i--){
                lista.remove((i));
            }
            fin = System.currentTimeMillis();
            duracion = fin - inicio;
            System.out.println(nombreImplementacion + " remove: " + duracion);


            // LinkedList es más efectivo en adicionar elementos en cualquier indice

            // ArrayList
        }
    }

}
