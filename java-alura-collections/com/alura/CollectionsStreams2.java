package com.alura;

import com.alura.model.Curso;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsStreams2 {
    public static void main(String[] args) {
        int tiempo = 0;

        Curso curso1 = new Curso("Historia", 30);
        Curso curso2 = new Curso("Algebra", 10);
        Curso curso3 = new Curso("Aritmetica", 20);
        Curso curso4 = new Curso("Geometria", 50);
        Curso curso5 = new Curso("Fisica", 60);
        Curso curso6 = new Curso("Quimica", 80);
        Curso curso7 = new Curso("Quimica", 70);
        Curso curso8 = new Curso("Fisica", 40);

        ArrayList<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        cursos.add(curso5);
        cursos.add(curso6);
        cursos.add(curso7);
        cursos.add(curso8);

        List<Curso> cursoList = cursos.stream().filter(curso -> !curso.getNombre().equalsIgnoreCase("Ruby"))
                .sorted(Comparator.comparingInt(Curso::getTiempo)).collect(Collectors.toList());
        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).average().getAsDouble());
        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).max().getAsInt());
        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).min().getAsInt());

        Map<String, List<Curso>> groupCurso = cursos.stream().collect(Collectors.groupingBy(Curso::getNombre));

        //groupCurso.forEach((key, value) -> System.out.println(key + " - " + value.size()));

        System.out.println(cursos.parallelStream().mapToInt(Curso::getTiempo).sum());


    }
}
