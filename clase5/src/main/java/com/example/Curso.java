package com.example;

public class Curso {
    private String nombreCurso;
    private Profesor profesorAsignado;

    public Curso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void asignarProfesor(Profesor profesor) {
        this.profesorAsignado = profesor;
        System.out.println("Profesor " + profesor.getNombre() + " asignado al curso " + nombreCurso + ".");
    }

    public void mostrarInformacionCurso() {
        System.out.println("Curso: " + nombreCurso);
        if (profesorAsignado != null) {
            System.out.println("Profesor Asignado: " + profesorAsignado.getNombre());
        } else {
            System.out.println("No hay profesor asignado.");
        }
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Profesor getProfesorAsignado() {
        return profesorAsignado;
    }
}
