package caso1;

import java.util.*;
import java.util.stream.Collectors;

public class EjerciciosAlumno {

    public static void main(String[] args) {
        // Datos de prueba
        List<Alumno> alumnos = Arrays.asList(
                new Alumno("Juan", 8.5, "3A"),
                new Alumno("María", 9.0, "3B"),
                new Alumno("Pedro", 5.5, "3A"),
                new Alumno("Ana", 7.5, "3B"),
                new Alumno("Luis", 6.0, "3A"),
                new Alumno("Sofía", 9.5, "3B"),
                new Alumno("Carlos", 7.0, "3A"),
                new Alumno("Laura", 8.0, "3C"),
                new Alumno("Diego", 4.5, "3C"),
                new Alumno("Valeria", 10.0, "3C")
        );

        System.out.println("=== CASO PRÁCTICO 1: ALUMNOS ===\n");

        // 1. Obtener los nombres de los alumnos aprobados (nota ≥ 7) en mayúsculas y ordenados
        System.out.println("1. Nombres de alumnos aprobados (nota ≥ 7) en mayúsculas y ordenados:");
        List<String> aprobados = alumnos.stream()
                .filter(alumno -> alumno.getNota() >= 7)
                .map(alumno -> alumno.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        aprobados.forEach(System.out::println);

        // 2. Calcular el promedio general de notas
        System.out.println("\n2. Promedio general de notas:");
        double promedioGeneral = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0.0);
        System.out.printf("%.2f%n", promedioGeneral);

        // 3. Agrupar alumnos por curso usando Collectors.groupingBy()
        System.out.println("\n3. Alumnos agrupados por curso:");
        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));
        alumnosPorCurso.forEach((curso, listaAlumnos) -> {
            System.out.println("Curso " + curso + ":");
            listaAlumnos.forEach(alumno ->
                System.out.println("  - " + alumno.getNombre() + " (nota: " + alumno.getNota() + ")")
            );
        });

        // 4. Obtener los 3 mejores promedios
        System.out.println("\n4. Los 3 mejores promedios (notas):");
        List<Double> tresMejoresPromedios = alumnos.stream()
                .map(Alumno::getNota)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        tresMejoresPromedios.forEach(nota -> System.out.printf("%.2f%n", nota));

        System.out.println("\n=== CONCLUSIONES ===");
        System.out.println("✓ Pipeline de Streams aplicado correctamente");
        System.out.println("✓ Operaciones de mapeo, filtrado, reducción y agrupación utilizadas");
        System.out.println("✓ Código declarativo más claro que el enfoque imperativo");
    }
}

