package com.example;

public class Profesor {
    private String nombre;
    private String numeroIdentificacion;
    private double salarioMensual;
    private int horasSemanales;
    private boolean esTiempoCompleto;

    
    public Profesor(String nombre, String numeroIdentificacion, double salarioMensual, int horasSemanales, boolean esTiempoCompleto) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        setSalarioMensual(salarioMensual);
        setHorasSemanales(horasSemanales);
        this.esTiempoCompleto = esTiempoCompleto;
    }

    public Profesor(String nombre, String numeroIdentificacion, double salarioMensual) {
        this(nombre, numeroIdentificacion, salarioMensual, 20, false);
    }

    public Profesor() {
        this("Sin nombre", "Sin identificación", 0.0, 0, false);
    }

    public Profesor(String nombre, String numeroIdentificacion) {
        this(nombre, numeroIdentificacion, 0.0, 10, false);
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Identificación: " + numeroIdentificacion);
        System.out.println("Salario Mensual: " + salarioMensual);
        System.out.println("Horas Semanales: " + horasSemanales);
        System.out.println("¿Tiempo Completo?: " + (esTiempoCompleto ? "Sí" : "No"));
    }

    public double calcularSalarioAnual() {
        return salarioMensual * 12;
    }

    public double calcularSalarioAnual(double bonoAnual) {
        return (salarioMensual * 12) + bonoAnual;
    }

    public double calcularSalarioAnual(int meses) {
        return salarioMensual * meses;
    }

    public void asignarHorasSemanales(int horas) {
        if (horas > 40) {
            System.out.println("Error: No se pueden asignar más de 40 horas.");
        } else {
            this.horasSemanales = horas;
        }
    }

    public String evaluarCargaHoraria() {
        return (horasSemanales <= 20) ? "Carga normal" : "Carga alta";
    }

    public String evaluarCargaHoraria(int limiteHoras) {
        return (horasSemanales <= limiteHoras) ? "Carga normal" : "Carga alta";
    }

    public void asignarCurso(Curso curso) {
        curso.asignarProfesor(this); 
    }

    public int calcularHorasAnuales() {
        return horasSemanales * 40;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        if (salarioMensual < 0) {
            System.out.println("Error: El salario no puede ser negativo.");
        } else {
            this.salarioMensual = salarioMensual;
        }
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        if (horasSemanales > 40) {
            System.out.println("Error: No se pueden asignar más de 40 horas.");
        } else {
            this.horasSemanales = horasSemanales;
        }
    }

    public boolean isEsTiempoCompleto() {
        return esTiempoCompleto;
    }

    public void setEsTiempoCompleto(boolean esTiempoCompleto) {
        this.esTiempoCompleto = esTiempoCompleto;
    }
}

