package com.example;

public class SistemaEmpleados {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE EMPLEADOS ===");
        System.out.println();

        // Crear empleados de diferentes tipos
        Empleado empleadoGeneral = new Empleado(
            "Ana", "García", "12345678", 3000000, 2, "Recursos Humanos"
        );

        Desarrollador desarrollador = new Desarrollador(
            "Carlos", "Rodríguez", "87654321", 4500000, 4, "Tecnología",
            "Java", 8, "Mid", true
        );

        Gerente gerente = new Gerente(
            "María", "López", "11223344", 8000000, 7, "Operaciones",
            12, 500000000, 7, 10, "Estratégica"
        );

        // Mostrar información inicial
        System.out.println("\n=== INFORMACIÓN INICIAL DE EMPLEADOS ===");
        empleadoGeneral.mostrarInformacion();
        System.out.println();

        desarrollador.mostrarInformacion();
        System.out.println();

        gerente.mostrarInformacion();
        System.out.println();

        // Demostrar funcionalidades específicas
        System.out.println("=== DEMOSTRANDO FUNCIONALIDADES ESPECÍFICAS ===");

        // Desarrollador completa proyectos
        desarrollador.completarProyecto();
        desarrollador.completarProyecto();
        System.out.println("Nueva productividad: " + 
                          String.format("%.2f", desarrollador.calcularProductividad()) + 
                          " proyectos/año\n");

        // Gerente cumple metas
        gerente.cumplirMeta();
        gerente.cumplirMeta();
        gerente.agregarMiembroEquipo();
        System.out.println();

        // Verificar elegibilidad para promoción
        System.out.println("=== ELEGIBILIDAD PARA PROMOCIÓN ===");
        System.out.println(empleadoGeneral.obtenerNombreCompleto() + 
                          " elegible: " + empleadoGeneral.esElegibleParaPromocion());
        System.out.println(desarrollador.obtenerNombreCompleto() + 
                          " elegible: " + desarrollador.esElegibleParaPromocion());
        System.out.println(gerente.obtenerNombreCompleto() + 
                          " elegible: " + gerente.esElegibleParaPromocion());
        System.out.println();

        // Demostrar polimorfismo
        System.out.println("=== DEMOSTRACIÓN DE POLIMORFISMO ===");
        Empleado[] empleados = {empleadoGeneral, desarrollador, gerente};

        double totalSalarios = 0;
        double totalBonos = 0;

        for (Empleado emp : empleados) {
            System.out.println("Procesando: " + emp.obtenerNombreCompleto());
            System.out.println("Salario total: $" + String.format("%.2f", emp.calcularSalarioTotal()));
            System.out.println("Bono anual: $" + String.format("%.2f", emp.calcularBonoAnual()));

            totalSalarios += emp.calcularSalarioTotal();
            totalBonos += emp.calcularBonoAnual();
            System.out.println();
        }

        System.out.println("=== RESUMEN FINANCIERO ===");
        System.out.println("Total salarios mensuales: $" + String.format("%.2f", totalSalarios));
        System.out.println("Total bonos anuales: $" + String.format("%.2f", totalBonos));
        System.out.println("Costo anual total: $" + String.format("%.2f", (totalSalarios * 12) + totalBonos));

        // Demostrar uso de setters
        System.out.println("\n=== ACTUALIZANDO INFORMACIÓN ===");
        desarrollador.setSalarioBase(5000000);
        desarrollador.setNivelSenioridad("Senior");
        System.out.println("Nuevo salario del desarrollador: $" + 
                          String.format("%.2f", desarrollador.calcularSalarioTotal()));

        gerente.setPresupuestoAnual(600000000);
        System.out.println("Nuevo presupuesto por persona: $" + 
                          String.format("%.2f", gerente.calcularPresupuestoPorPersona()));
    }
}