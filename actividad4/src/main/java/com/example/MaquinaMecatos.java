package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MaquinaMecatos {
    private String nombreProducto;
    private int cantidadDisponible;
    private BigDecimal precioUnitario;
    private boolean refrigerado;
    private LocalDate fechaCaducidad;
    private List<String> ingredientes;

    public MaquinaMecatos() {
        this("Chocolatina", 20, new BigDecimal("1500"), false, LocalDate.now().plusMonths(6), List.of("Cacao", "Azúcar"));
    }

    public MaquinaMecatos(String nombreProducto, int cantidadDisponible, BigDecimal precioUnitario, boolean refrigerado, LocalDate fechaCaducidad, List<String> ingredientes) {
        setNombreProducto(nombreProducto);
        setCantidadDisponible(cantidadDisponible);
        setPrecioUnitario(precioUnitario);
        setRefrigerado(refrigerado);
        setFechaCaducidad(fechaCaducidad);
        setIngredientes(ingredientes);
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        if (nombreProducto == null || nombreProducto.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.nombreProducto = nombreProducto.trim();
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        if (cantidadDisponible < 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }
        this.cantidadDisponible = cantidadDisponible;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        if (precioUnitario == null || precioUnitario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Precio inválido");
        }
        this.precioUnitario = precioUnitario;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        if (fechaCaducidad.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Caducado");
        }
        this.fechaCaducidad = fechaCaducidad;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        if (ingredientes == null || ingredientes.isEmpty()) {
            throw new IllegalArgumentException("Debe tener al menos un ingrediente");
        }
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return String.format(
            "MaquinaMecatos[producto=%s, cantidad=%d, precio=%s, refrigerado=%b, vence=%s, ingredientes=%s]",
            nombreProducto, cantidadDisponible, precioUnitario, refrigerado, fechaCaducidad, ingredientes
        );
    }
}
