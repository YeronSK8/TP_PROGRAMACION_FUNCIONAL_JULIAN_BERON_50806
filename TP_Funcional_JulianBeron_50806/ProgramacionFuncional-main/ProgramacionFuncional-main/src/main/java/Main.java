import caso1.EjerciciosAlumno;
import caso2.EjerciciosProducto;
import caso3.EjerciciosLibro;
import caso4.EjerciciosEmpleado;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║   TRABAJO PRÁCTICO - PROGRAMACIÓN FUNCIONAL EN JAVA      ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");

        // Caso 1: Alumnos
        EjerciciosAlumno.main(args);
        System.out.println("\n" + "=".repeat(60) + "\n");

        // Caso 2: Productos
        EjerciciosProducto.main(args);
        System.out.println("\n" + "=".repeat(60) + "\n");

        // Caso 3: Libros
        EjerciciosLibro.main(args);
        System.out.println("\n" + "=".repeat(60) + "\n");

        // Caso 4: Empleados
        EjerciciosEmpleado.main(args);
        System.out.println("\n" + "=".repeat(60));

        System.out.println("\n╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║          TODOS LOS EJERCICIOS COMPLETADOS ✓              ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
    }
}

