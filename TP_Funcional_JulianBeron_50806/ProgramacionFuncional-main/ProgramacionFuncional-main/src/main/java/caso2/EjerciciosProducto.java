package caso2;

import java.util.*;
import java.util.stream.Collectors;

public class EjerciciosProducto {

    public static void main(String[] args) {
        // Datos de prueba
        List<Producto> productos = Arrays.asList(
                new Producto("Laptop", "Electrónica", 1200.00, 15),
                new Producto("Mouse", "Electrónica", 25.00, 50),
                new Producto("Teclado", "Electrónica", 80.00, 30),
                new Producto("Monitor", "Electrónica", 350.00, 20),
                new Producto("Silla Gamer", "Muebles", 450.00, 10),
                new Producto("Escritorio", "Muebles", 200.00, 8),
                new Producto("Auriculares", "Electrónica", 150.00, 25),
                new Producto("Cámara Web", "Electrónica", 90.00, 18),
                new Producto("Lámpara LED", "Iluminación", 45.00, 40),
                new Producto("Estante", "Muebles", 120.00, 12)
        );

        System.out.println("=== CASO PRÁCTICO 2: PRODUCTOS ===\n");

        // 1. Listar los productos con precio mayor a 100, ordenados por precio descendente
        System.out.println("1. Productos con precio mayor a 100 (ordenados por precio descendente):");
        List<Producto> productosCostosos = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toList());
        productosCostosos.forEach(p ->
            System.out.printf("  - %s: $%.2f%n", p.getNombre(), p.getPrecio())
        );

        // 2. Agrupar productos por categoría y calcular el stock total
        System.out.println("\n2. Stock total por categoría:");
        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)
                ));
        stockPorCategoria.forEach((categoria, stock) ->
                System.out.printf("  %s: %d unidades%n", categoria, stock)
        );

        // 3. Generar un String separando con ";" cada producto que contenga nombre y precio
        System.out.println("\n3. String con nombre y precio separados por ';':");
        String productosString = productos.stream()
                .map(p -> p.getNombre() + ": $" + String.format("%.2f", p.getPrecio()))
                .collect(Collectors.joining("; "));
        System.out.println(productosString);

        // 4. Calcular el precio promedio general y por categoría
        System.out.println("\n4. Precio promedio:");

        // Promedio general
        double promedioGeneral = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);
        System.out.printf("  Promedio general: $%.2f%n", promedioGeneral);

        // Promedio por categoría
        System.out.println("  Promedio por categoría:");
        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));
        promedioPorCategoria.forEach((categoria, promedio) ->
                System.out.printf("    %s: $%.2f%n", categoria, promedio)
        );

        System.out.println("\n=== CONCLUSIONES ===");
        System.out.println("✓ Programación funcional aplicada en contexto real");
        System.out.println("✓ Reportes y estadísticas generadas con Streams");
        System.out.println("✓ Lambdas, collectors y manipulación funcional consolidados");
    }
}

