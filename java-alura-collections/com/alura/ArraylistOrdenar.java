package com.alura;

import java.util.ArrayList;

public class ArraylistOrdenar {

    public static void main(String[] args) {

        MetodosAdicionales.Curso curso1 = new MetodosAdicionales.Curso("Geometria", 30);
        MetodosAdicionales.Curso curso2 = new MetodosAdicionales.Curso("Fisica", 10);
        MetodosAdicionales.Curso curso3 = new MetodosAdicionales.Curso("Quimica", 20);
        MetodosAdicionales.Curso curso4 = new MetodosAdicionales.Curso("Historia", 50);

        ArrayList<MetodosAdicionales.Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(curso3);
        System.out.println(curso4);

























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
        //System.out.println(cursosList);
    }
}
