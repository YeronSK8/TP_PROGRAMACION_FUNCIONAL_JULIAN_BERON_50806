# Trabajo Práctico - Programación Funcional en Java

## Estructura del Proyecto

El proyecto contiene 4 casos prácticos de programación funcional con Streams de Java:

### 📚 Caso 1: Alumnos
**Clase:** `Alumno(nombre, nota, curso)`

**Ejercicios implementados:**
1. Obtener nombres de alumnos aprobados (nota ≥ 7) en mayúsculas y ordenados
2. Calcular promedio general de notas
3. Agrupar alumnos por curso usando `Collectors.groupingBy()`
4. Obtener los 3 mejores promedios

**Ejecutar:** `java -cp build/classes/java/main caso1.EjerciciosAlumno`

---

### 🛒 Caso 2: Productos
**Clase:** `Producto(nombre, categoria, precio, stock)`

**Ejercicios implementados:**
1. Listar productos con precio > 100, ordenados descendentemente
2. Agrupar productos por categoría y calcular stock total
3. Generar String con ";" separando nombre y precio usando `map + collect(joining)`
4. Calcular precio promedio general y por categoría

**Ejecutar:** `java -cp build/classes/java/main caso2.EjerciciosProducto`

---

### 📖 Caso 3: Libros
**Clase:** `Libro(titulo, autor, paginas, precio)`

**Ejercicios implementados:**
1. Listar títulos de libros con más de 300 páginas, ordenados alfabéticamente
2. Calcular promedio de páginas
3. Agrupar libros por autor y contar cuántos tiene cada uno
4. Obtener el libro más caro

**Ejecutar:** `java -cp build/classes/java/main caso3.EjerciciosLibro`

---

### 💼 Caso 4: Empleados
**Clase:** `Empleado(nombre, departamento, salario, edad)`

**Ejercicios implementados:**
1. Lista de empleados con salario > 2000, ordenados descendentemente
2. Calcular salario promedio general
3. Agrupar empleados por departamento y sumar salarios
4. Obtener nombres de los 2 empleados más jóvenes

**Ejecutar:** `java -cp build/classes/java/main caso4.EjerciciosEmpleado`

---

## Cómo ejecutar

### Compilar el proyecto:
```bash
./gradlew build
```

### Ejecutar todos los casos prácticos:
```bash
./gradlew run
```

### Ejecutar un caso específico:
```bash
java -cp build/classes/java/main caso1.EjerciciosAlumno
java -cp build/classes/java/main caso2.EjerciciosProducto
java -cp build/classes/java/main caso3.EjerciciosLibro
java -cp build/classes/java/main caso4.EjerciciosEmpleado
```

## Conceptos aplicados

✅ **Streams API**: Pipeline de operaciones funcionales
✅ **Lambdas**: Expresiones lambda para operaciones concisas
✅ **Method References**: Referencias a métodos (`::`）
✅ **Collectors**: Agrupación, suma, promedio, conteo
✅ **Operaciones intermedias**: `filter`, `map`, `sorted`, `limit`
✅ **Operaciones terminales**: `collect`, `forEach`, `average`, `max`
✅ **Programación declarativa**: Código más claro y mantenible

## Estructura de archivos

```
src/main/java/
├── Main.java                          # Ejecuta todos los casos
├── caso1/
│   ├── Alumno.java                    # Clase modelo
│   └── EjerciciosAlumno.java          # Ejercicios resueltos
├── caso2/
│   ├── Producto.java                  # Clase modelo
│   └── EjerciciosProducto.java        # Ejercicios resueltos
├── caso3/
│   ├── Libro.java                     # Clase modelo
│   └── EjerciciosLibro.java           # Ejercicios resueltos
└── caso4/
    ├── Empleado.java                  # Clase modelo
    └── EjerciciosEmpleado.java        # Ejercicios resueltos
```

## Conclusiones

Cada caso práctico demuestra:
- Reemplazo de código imperativo por enfoque declarativo
- Uso efectivo de la API de Streams
- Operaciones de mapeo, filtrado, reducción y agrupación
- Generación de reportes y estadísticas de manera funcional

