package com.example;

public class Main {
    public static void main(String[] args) {
        Profesor prof1 = new Profesor("Laura Méndez", "1001001001", 3500000, 30, true);
        Profesor prof2 = new Profesor("Pedro Salazar", "2002002002", 2800000);
        Profesor prof3 = new Profesor();
        Profesor prof4 = new Profesor("Ana Ruiz", "3003003003");

        System.out.println("=== Profesores ===");
        prof1.mostrarInformacion();
        System.out.println();
        prof2.mostrarInformacion();
        System.out.println();
        prof3.mostrarInformacion();
        System.out.println();
        prof4.mostrarInformacion();
        System.out.println();

        System.out.println("=== Salario Anual ===");
        System.out.println("Salario base anual: " + prof1.calcularSalarioAnual());
        System.out.println("Salario con bono de 2M: " + prof1.calcularSalarioAnual(2000000));
        System.out.println("Salario para 6 meses: " + prof1.calcularSalarioAnual(6));
        System.out.println();

        System.out.println("=== Carga Horaria ===");
        System.out.println("Evaluación sin límite: " + prof1.evaluarCargaHoraria());
        System.out.println("Evaluación con límite 25: " + prof1.evaluarCargaHoraria(25));
        System.out.println();

        System.out.println("=== Horas Anuales ===");
        System.out.println("Horas anuales: " + prof1.calcularHorasAnuales());
        System.out.println();

        System.out.println("=== Asignación de Curso ===");
        Curso cursoJava = new Curso("Programación en Java");
        prof1.asignarCurso(cursoJava);
        cursoJava.mostrarInformacionCurso();
        System.out.println();

        System.out.println("=== Modificación de Horas ===");
        prof1.asignarHorasSemanales(38);
        prof1.mostrarInformacion();
    }
}
