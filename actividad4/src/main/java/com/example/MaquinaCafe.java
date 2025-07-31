package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MaquinaCafe {
    private String tipoCafe;
    private double temperatura;
    private int tamañoVaso;
    private BigDecimal precio;
    private int nivelIntensidad;
    private LocalDate fechaTostado;

    public MaquinaCafe() {
        this("Americano", 65.0, 200, new BigDecimal("2500"), 5, LocalDate.of(2022, 1, 1));
    }

    public MaquinaCafe(String tipoCafe, double temperatura, int tamañoVaso, BigDecimal precio, int nivelIntensidad, LocalDate fechaTostado) {
        setTipoCafe(tipoCafe);
        setTemperatura(temperatura);
        setTamañoVaso(tamañoVaso);
        setPrecio(precio);
        setNivelIntensidad(nivelIntensidad);
        setFechaTostado(fechaTostado);
    }

    public void setTipoCafe(String tipoCafe) {
        if (tipoCafe != null && !tipoCafe.isBlank()) {
            this.tipoCafe = tipoCafe;
        }
    }

    public void setTemperatura(double temperatura) {
        if (temperatura >= 30 && temperatura <= 100) {
            this.temperatura = temperatura;
        }
    }

    public void setTamañoVaso(int tamañoVaso) {
        if (tamañoVaso > 0) {
            this.tamañoVaso = tamañoVaso;
        }
    }

    public void setPrecio(BigDecimal precio) {
        if (precio != null && precio.compareTo(BigDecimal.ZERO) > 0 && precio.compareTo(new BigDecimal("10000")) <= 0) {
            this.precio = precio;
        }
    }

    public void setNivelIntensidad(int nivelIntensidad) {
        if (nivelIntensidad >= 1 && nivelIntensidad <= 10) {
            this.nivelIntensidad = nivelIntensidad;
        }
    }

    public void setFechaTostado(LocalDate fechaTostado) {
        if (fechaTostado != null && !fechaTostado.isAfter(LocalDate.now()) && fechaTostado.isAfter(LocalDate.of(2009, 12, 31))) {
            this.fechaTostado = fechaTostado;
        }
    }

    @Override
    public String toString() {
        return String.format("MaquinaCafe[tipo=%s, temp=%.1f°C, vaso=%dml, precio=%s, intensidad=%d, fecha=%s]",
            tipoCafe, temperatura, tamañoVaso, precio, nivelIntensidad, fechaTostado);
    }
}
