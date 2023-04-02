package com.alura;

import java.util.ArrayList;

import com.alura.model.Curso;


public class LambdasStream {

    public static void main(String[] args) {

        Curso curso1 = new Curso("Geometria", 30);
        Curso curso2 = new Curso("Fisica", 10);
        Curso curso3 = new Curso("Quimica", 20);
        Curso curso4 = new Curso("Historia", 50);

        ArrayList<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(curso3);
        System.out.println(curso4);
        System.out.println(cursos);

























        /*String curso1 = "Geometria";
        String curso2 = "Fisica";
        String curso3 = "Quimica";
        String curso4 = "Historia";

        ArrayList<String> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);*/

       /* System.out.println(cursos);

        Collections.sort(cursos);

        System.out.println(cursos);

        Collections.sort(cursos, Collections.reverseOrder());

        System.out.println(cursos);*/

        /*cursos.sort(Comparator.reverseOrder());
        System.out.println(cursos);

        cursos.sort(Comparator.naturalOrder());
        System.out.println(cursos);*/

        // stream a partir de Java 8

        // List<String> cursosList  = cursos.stream().sorted().collect(Collectors.toList());
        // System.out.println(cursosList);
    }
}
