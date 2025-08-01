package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private int cantidadLibros;
    private boolean publica;
    private BigDecimal presupuestoAnual;
    private LocalDate fechaFundacion;
    private List<String> secciones;

    public Biblioteca() {
        this("Biblioteca Florez", 1000, true, new BigDecimal("1000000"), LocalDate.of(2000, 1, 1), List.of("General"));
    }

    public Biblioteca(String nombre, int cantidadLibros, boolean publica, BigDecimal presupuestoAnual, LocalDate fechaFundacion, List<String> secciones) {
        setNombre(nombre);
        setCantidadLibros(cantidadLibros);
        setPublica(publica);
        setPresupuestoAnual(presupuestoAnual);
        setFechaFundacion(fechaFundacion);
        setSecciones(secciones);
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre;
        }
    }

    public void setCantidadLibros(int cantidadLibros) {
        if (cantidadLibros >= 0) {
            this.cantidadLibros = cantidadLibros;
        }
    }

    public void setPublica(boolean publica) {
        this.publica = publica;
    }

    public void setPresupuestoAnual(BigDecimal presupuestoAnual) {
        if (presupuestoAnual != null && presupuestoAnual.compareTo(BigDecimal.ZERO) >= 0) {
            this.presupuestoAnual = presupuestoAnual;
        }
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        if (fechaFundacion != null && !fechaFundacion.isAfter(LocalDate.now())) {
            this.fechaFundacion = fechaFundacion;
        }
    }

    public void setSecciones(List<String> secciones) {
        if (secciones != null && !secciones.isEmpty()) {
            this.secciones = secciones;
        }
    }

    @Override
    public String toString() {
        return String.format("Biblioteca[nombre=%s, libros=%d, pública=%b, presupuesto=%s, fundación=%s, secciones=%s]",
            nombre, cantidadLibros, publica, presupuestoAnual, fechaFundacion, secciones);
    }
}
