package com.example;

public class Empleado {
    // Atributos protegidos para acceso desde clases hijas
    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected double salarioBase;
    protected int añosExperiencia;
    protected String departamento;

    // Constructor
    public Empleado(String nombre, String apellido, String cedula,
            double salarioBase, int añosExperiencia, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.salarioBase = salarioBase;
        this.añosExperiencia = añosExperiencia;
        this.departamento = departamento;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public String getDepartamento() {
        return departamento;
    }

    // Setters con validaciones
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public void setApellido(String apellido) {
        if (apellido != null && !apellido.trim().isEmpty()) {
            this.apellido = apellido;
        }
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase >= 0) {
            this.salarioBase = salarioBase;
        }
    }

    public void setAñosExperiencia(int añosExperiencia) {
        if (añosExperiencia >= 0) {
            this.añosExperiencia = añosExperiencia;
        }
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // Métodos de negocio
    public double calcularSalarioTotal() {
        // Salario base + bono por experiencia (5% por año)
        double bonoExperiencia = salarioBase * (añosExperiencia * 0.05);
        return salarioBase + bonoExperiencia;
    }

    public double calcularBonoAnual() {
        // Bono anual equivalente a un mes de salario
        return calcularSalarioTotal();
    }

    public String obtenerNombreCompleto() {
        return nombre + " " + apellido;
    }

    public void mostrarInformacion() {
        System.out.println("=== INFORMACIÓN DEL EMPLEADO ===");
        System.out.println("Nombre: " + obtenerNombreCompleto());
        System.out.println("Cédula: " + cedula);
        System.out.println("Departamento: " + departamento);
        System.out.println("Años de experiencia: " + añosExperiencia);
        System.out.println("Salario base: $" + String.format("%.2f", salarioBase));
        System.out.println("Salario total: $" + String.format("%.2f", calcularSalarioTotal()));
        System.out.println("Bono anual: $" + String.format("%.2f", calcularBonoAnual()));
    }

    public boolean esElegibleParaPromocion() {
        // Criterio básico: más de 3 años de experiencia
        return añosExperiencia >= 3;
    }
}