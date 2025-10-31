package caso3;

import java.util.*;
import java.util.stream.Collectors;

public class EjerciciosLibro {

    public static void main(String[] args) {
        // Datos de prueba
        List<Libro> libros = Arrays.asList(
                new Libro("Cien años de soledad", "Gabriel García Márquez", 417, 29.99),
                new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 863, 35.50),
                new Libro("El principito", "Antoine de Saint-Exupéry", 96, 12.99),
                new Libro("1984", "George Orwell", 328, 24.99),
                new Libro("Rayuela", "Julio Cortázar", 600, 32.00),
                new Libro("Ficciones", "Jorge Luis Borges", 174, 18.50),
                new Libro("El túnel", "Ernesto Sabato", 158, 15.99),
                new Libro("Crónica de una muerte anunciada", "Gabriel García Márquez", 120, 19.99),
                new Libro("La casa de los espíritus", "Isabel Allende", 433, 28.00),
                new Libro("Pedro Páramo", "Juan Rulfo", 124, 16.50)
        );

        System.out.println("=== CASO PRÁCTICO 3: LIBROS ===\n");

        // 1. Listar los títulos de los libros con más de 300 páginas, ordenados alfabéticamente
        System.out.println("1. Títulos de libros con más de 300 páginas (ordenados alfabéticamente):");
        List<String> titulosLargos = libros.stream()
                .filter(libro -> libro.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .collect(Collectors.toList());
        titulosLargos.forEach(titulo -> System.out.println("  - " + titulo));

        // 2. Calcular el promedio de páginas de todos los libros
        System.out.println("\n2. Promedio de páginas de todos los libros:");
        double promedioPaginas = libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0.0);
        System.out.printf("  %.2f páginas%n", promedioPaginas);

        // 3. Agrupar los libros por autor y contar cuántos libros tiene cada uno
        System.out.println("\n3. Cantidad de libros por autor:");
        Map<String, Long> librosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting()
                ));
        librosPorAutor.forEach((autor, cantidad) ->
                System.out.printf("  %s: %d libro(s)%n", autor, cantidad)
        );

        // 4. Obtener el libro más caro de la lista
        System.out.println("\n4. Libro más caro:");
        Optional<Libro> libroMasCaro = libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio));
        libroMasCaro.ifPresent(libro ->
                System.out.printf("  %s - $%.2f%n", libro.getTitulo(), libro.getPrecio())
        );

        System.out.println("\n=== CONCLUSIONES ===");
        System.out.println("✓ Operaciones filter, map, sorted y collect practicadas");
        System.out.println("✓ Promedios y máximos manejados con Streams");
        System.out.println("✓ Agrupación con groupingBy() y counting() entendida");
    }
}

