package com.example;

public class Desarrollador extends Empleado {
    // Atributos específicos del desarrollador
    private String lenguajePrincipal;
    private int proyectosCompletados;
    private String nivelSenioridad; // Junior, Mid, Senior
    private boolean tieneCertificaciones;

    // Constructor
    public Desarrollador(String nombre, String apellido, String cedula,
                        double salarioBase, int añosExperiencia, String departamento,
                        String lenguajePrincipal, int proyectosCompletados,
                        String nivelSenioridad, boolean tieneCertificaciones) {
        super(nombre, apellido, cedula, salarioBase, añosExperiencia, departamento);
        this.lenguajePrincipal = lenguajePrincipal;
        this.proyectosCompletados = proyectosCompletados;
        this.nivelSenioridad = nivelSenioridad;
        this.tieneCertificaciones = tieneCertificaciones;
    }

    // Getters específicos
    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public int getProyectosCompletados() {
        return proyectosCompletados;
    }

    public String getNivelSenioridad() {
        return nivelSenioridad;
    }

    public boolean isTieneCertificaciones() {
        return tieneCertificaciones;
    }

    // Setters específicos
    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public void setProyectosCompletados(int proyectosCompletados) {
        if (proyectosCompletados >= 0) {
            this.proyectosCompletados = proyectosCompletados;
        }
    }

    public void setNivelSenioridad(String nivelSenioridad) {
        this.nivelSenioridad = nivelSenioridad;
    }

    public void setTieneCertificaciones(boolean tieneCertificaciones) {
        this.tieneCertificaciones = tieneCertificaciones;
    }

    // Sobrescritura del método calcularSalarioTotal
    @Override
    public double calcularSalarioTotal() {
        double salarioConExperiencia = super.calcularSalarioTotal();

        // Bono por nivel de senioridad
        double bonoSenioridad = 0;
        switch (nivelSenioridad.toLowerCase()) {
            case "junior":
                bonoSenioridad = salarioBase * 0.10; // 10%
                break;
            case "mid":
                bonoSenioridad = salarioBase * 0.25; // 25%
                break;
            case "senior":
                bonoSenioridad = salarioBase * 0.40; // 40%
                break;
        }

        // Bono por proyectos completados (2% por proyecto)
        double bonoProyectos = salarioBase * (proyectosCompletados * 0.02);

        // Bono por certificaciones
        double bonoCertificaciones = tieneCertificaciones ? salarioBase * 0.15 : 0;

        return salarioConExperiencia + bonoSenioridad + bonoProyectos + bonoCertificaciones;
    }

    @Override
    public double calcularBonoAnual() {
        double bonoBase = super.calcularBonoAnual();

        // Bono adicional por alta productividad
        if (proyectosCompletados >= 10) {
            bonoBase += salarioBase * 0.5; // 50% adicional
        } else if (proyectosCompletados >= 5) {
            bonoBase += salarioBase * 0.25; // 25% adicional
        }

        return bonoBase;
    }

    // Métodos específicos del desarrollador
    public void completarProyecto() {
        proyectosCompletados++;
        System.out.println(obtenerNombreCompleto() + " ha completado un nuevo proyecto.");
        System.out.println("Total de proyectos: " + proyectosCompletados);
    }

    public void actualizarCertificaciones(boolean nuevasCertificaciones) {
        this.tieneCertificaciones = nuevasCertificaciones;
        String estado = nuevasCertificaciones ? "obtenido" : "perdido";
        System.out.println(obtenerNombreCompleto() + " ha " + estado + " certificaciones.");
    }

    public double calcularProductividad() {
        // Proyectos por año de experiencia
        return añosExperiencia > 0 ? (double) proyectosCompletados / añosExperiencia : 0;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("=== INFORMACIÓN ESPECÍFICA DEL DESARROLLADOR ===");
        System.out.println("Lenguaje principal: " + lenguajePrincipal);
        System.out.println("Nivel de senioridad: " + nivelSenioridad);
        System.out.println("Proyectos completados: " + proyectosCompletados);
        System.out.println("Tiene certificaciones: " + (tieneCertificaciones ? "Sí" : "No"));
        System.out.println("Productividad: " + String.format("%.2f", calcularProductividad()) + " proyectos/año");
    }

    @Override
    public boolean esElegibleParaPromocion() {
        // Criterios específicos para desarrolladores
        return super.esElegibleParaPromocion() && 
               proyectosCompletados >= 5 && 
               tieneCertificaciones;
    }
}