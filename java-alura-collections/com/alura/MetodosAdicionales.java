package com.alura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MetodosAdicionales {
    public static void main(String[] args) {

        Curso curso1 = new Curso("PHP", 30);
        Curso curso2 = new Curso("Ruby", 10);
        Curso curso3 = new Curso("Java", 20);
        Curso curso4 = new Curso("JavaScript", 50);

        ArrayList<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);


        // Utilazando CompareTo
        /*System.out.println(cursos);

        Collections.sort(cursos, Collections.reverseOrder());

        System.out.println(cursos);*/

        System.out.println(cursos);

       // cursos.sort(Comparator.comparing(Curso::getNombre)); Con Comparator

       // Collections.sort(cursos, Comparator.comparing(Curso::getNombre).reversed()); // Con Collection

        //System.out.println(cursos);

        //stream me retorna una lista nueva
       // List<Curso> cursoList = cursos.stream().sorted(Comparator.comparingInt(Curso::getTiempo)).collect(Collectors.toList());

        // con lambdas filter
        List<Curso> cursoList = cursos.stream().filter(curso -> !curso.getNombre().equalsIgnoreCase("Ruby")).sorted(Comparator.comparingInt(Curso::getTiempo)).collect(Collectors.toList());
        System.out.println(cursoList);

    }

    public static class Curso {

        private String nombre;
        private int tiempo;

        public Curso(String nombre, int tiempo) {
            this.nombre = nombre;
            this.tiempo = tiempo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getTiempo() {
            return tiempo;
        }

        public void setTiempo(int tiempo) {
            this.tiempo = tiempo;
        }

        @Override
        public String toString() {
           return this.nombre;
        }




    }
}
