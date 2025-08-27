package com.example;

public class Gerente extends Empleado {
    // Atributos específicos del gerente
    private int equipoACargoTamaño;
    private double presupuestoAnual;
    private int metasCumplidas;
    private int metasTotales;
    private String tipoGerencia; // Operacional, Estratégica, Técnica

    // Constructor
    public Gerente(String nombre, String apellido, String cedula,
                  double salarioBase, int añosExperiencia, String departamento,
                  int equipoACargoTamaño, double presupuestoAnual, 
                  int metasCumplidas, int metasTotales, String tipoGerencia) {
        super(nombre, apellido, cedula, salarioBase, añosExperiencia, departamento);
        this.equipoACargoTamaño = equipoACargoTamaño;
        this.presupuestoAnual = presupuestoAnual;
        this.metasCumplidas = metasCumplidas;
        this.metasTotales = metasTotales;
        this.tipoGerencia = tipoGerencia;
    }

    // Getters específicos
    public int getEquipoACargoTamaño() {
        return equipoACargoTamaño;
    }

    public double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public int getMetasCumplidas() {
        return metasCumplidas;
    }

    public int getMetasTotales() {
        return metasTotales;
    }

    public String getTipoGerencia() {
        return tipoGerencia;
    }

    // Setters específicos
    public void setEquipoACargoTamaño(int equipoACargoTamaño) {
        if (equipoACargoTamaño >= 0) {
            this.equipoACargoTamaño = equipoACargoTamaño;
        }
    }

    public void setPresupuestoAnual(double presupuestoAnual) {
        if (presupuestoAnual >= 0) {
            this.presupuestoAnual = presupuestoAnual;
        }
    }

    public void setMetasCumplidas(int metasCumplidas) {
        if (metasCumplidas >= 0 && metasCumplidas <= metasTotales) {
            this.metasCumplidas = metasCumplidas;
        }
    }

    public void setMetasTotales(int metasTotales) {
        if (metasTotales >= 0) {
            this.metasTotales = metasTotales;
            // Ajustar metas cumplidas si es necesario
            if (metasCumplidas > metasTotales) {
                metasCumplidas = metasTotales;
            }
        }
    }

    public void setTipoGerencia(String tipoGerencia) {
        this.tipoGerencia = tipoGerencia;
    }

    // Sobrescritura del método calcularSalarioTotal
    @Override
    public double calcularSalarioTotal() {
        double salarioConExperiencia = super.calcularSalarioTotal();

        // Bono por tamaño del equipo (2% por cada persona)
        double bonoEquipo = salarioBase * (equipoACargoTamaño * 0.02);

        // Bono por tipo de gerencia
        double bonoTipo = 0;
        switch (tipoGerencia.toLowerCase()) {
            case "operacional":
                bonoTipo = salarioBase * 0.20; // 20%
                break;
            case "estratégica":
                bonoTipo = salarioBase * 0.35; // 35%
                break;
            case "técnica":
                bonoTipo = salarioBase * 0.25; // 25%
                break;
        }

        // Bono por cumplimiento de metas
        double porcentajeMetas = metasTotales > 0 ? (double) metasCumplidas / metasTotales : 0;
        double bonoMetas = salarioBase * (porcentajeMetas * 0.30); // Hasta 30%

        return salarioConExperiencia + bonoEquipo + bonoTipo + bonoMetas;
    }

    @Override
    public double calcularBonoAnual() {
        double bonoBase = super.calcularBonoAnual();

        // Bono adicional por gestión exitosa
        double porcentajeMetas = metasTotales > 0 ? (double) metasCumplidas / metasTotales : 0;
        if (porcentajeMetas >= 0.9) { // 90% o más de metas cumplidas
            bonoBase += salarioBase * 1.0; // 100% adicional
        } else if (porcentajeMetas >= 0.7) { // 70% o más
            bonoBase += salarioBase * 0.5; // 50% adicional
        }

        return bonoBase;
    }

    // Métodos específicos del gerente
    public void cumplirMeta() {
        if (metasCumplidas < metasTotales) {
            metasCumplidas++;
            System.out.println(obtenerNombreCompleto() + " ha cumplido una nueva meta.");
            System.out.println("Progreso: " + metasCumplidas + "/" + metasTotales + " metas");
        } else {
            System.out.println("Todas las metas ya han sido cumplidas.");
        }
    }

    public void agregarMiembroEquipo() {
        equipoACargoTamaño++;
        System.out.println("Nuevo miembro agregado al equipo de " + obtenerNombreCompleto());
        System.out.println("Tamaño actual del equipo: " + equipoACargoTamaño + " personas");
    }

    public double calcularPorcentajeMetas() {
        return metasTotales > 0 ? (double) metasCumplidas / metasTotales * 100 : 0;
    }

    public double calcularPresupuestoPorPersona() {
        return equipoACargoTamaño > 0 ? presupuestoAnual / equipoACargoTamaño : 0;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("=== INFORMACIÓN ESPECÍFICA DEL GERENTE ===");
        System.out.println("Tipo de gerencia: " + tipoGerencia);
        System.out.println("Tamaño del equipo: " + equipoACargoTamaño + " personas");
        System.out.println("Presupuesto anual: $" + String.format("%.2f", presupuestoAnual));
        System.out.println("Metas cumplidas: " + metasCumplidas + "/" + metasTotales);
        System.out.println("Porcentaje de cumplimiento: " + String.format("%.1f", calcularPorcentajeMetas()) + "%");
        System.out.println("Presupuesto por persona: $" + String.format("%.2f", calcularPresupuestoPorPersona()));
    }

    @Override
    public boolean esElegibleParaPromocion() {
        // Criterios específicos para gerentes
        return super.esElegibleParaPromocion() && 
               calcularPorcentajeMetas() >= 80.0 && 
               equipoACargoTamaño >= 5;
    }
}
