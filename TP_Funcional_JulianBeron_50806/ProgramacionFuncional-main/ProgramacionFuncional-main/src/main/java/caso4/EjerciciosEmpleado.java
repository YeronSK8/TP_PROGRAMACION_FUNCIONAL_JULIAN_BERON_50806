package caso4;

import java.util.*;
import java.util.stream.Collectors;

public class EjerciciosEmpleado {

    public static void main(String[] args) {
        // Datos de prueba
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Ana López", "Ventas", 2500.00, 28),
                new Empleado("Carlos Ruiz", "IT", 3500.00, 35),
                new Empleado("María García", "IT", 3200.00, 30),
                new Empleado("Juan Pérez", "Recursos Humanos", 2800.00, 42),
                new Empleado("Laura Fernández", "Ventas", 2300.00, 26),
                new Empleado("Pedro Martínez", "IT", 4000.00, 38),
                new Empleado("Sofía Ramírez", "Marketing", 2700.00, 29),
                new Empleado("Diego Torres", "Ventas", 1800.00, 24),
                new Empleado("Valeria Castro", "Marketing", 2900.00, 31),
                new Empleado("Roberto Silva", "Recursos Humanos", 2200.00, 45),
                new Empleado("Camila Morales", "IT", 3800.00, 27),
                new Empleado("Andrés Vega", "Ventas", 2100.00, 23)
        );

        System.out.println("=== CASO PRÁCTICO 4: EMPLEADOS ===\n");

        // 1. Obtener la lista de empleados cuyo salario sea mayor a 2000, ordenados por salario descendente
        System.out.println("1. Empleados con salario mayor a 2000 (ordenados por salario descendente):");
        List<Empleado> empleadosBienPagados = empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .collect(Collectors.toList());
        empleadosBienPagados.forEach(e ->
                System.out.printf("  - %s: $%.2f (%s)%n", e.getNombre(), e.getSalario(), e.getDepartamento())
        );

        // 2. Calcular el salario promedio general
        System.out.println("\n2. Salario promedio general:");
        double salarioPromedio = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);
        System.out.printf("  $%.2f%n", salarioPromedio);

        // 3. Agrupar los empleados por departamento y calcular la suma de salarios de cada uno
        System.out.println("\n3. Suma de salarios por departamento:");
        Map<String, Double> salariosPorDepartamento = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));
        salariosPorDepartamento.forEach((departamento, suma) ->
                System.out.printf("  %s: $%.2f%n", departamento, suma)
        );

        // 4. Obtener los nombres de los 2 empleados más jóvenes
        System.out.println("\n4. Los 2 empleados más jóvenes:");
        List<String> dosMasJovenes = empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .collect(Collectors.toList());
        dosMasJovenes.forEach(nombre -> System.out.println("  - " + nombre));

        System.out.println("\n=== CONCLUSIONES ===");
        System.out.println("✓ Operaciones de filtro, ordenamiento y límite aplicadas");
        System.out.println("✓ Promedios y sumatorias calculadas con collectors");
        System.out.println("✓ groupingBy con downstream collectors (summingDouble) practicado");
    }
}
