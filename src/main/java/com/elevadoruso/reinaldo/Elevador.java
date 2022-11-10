package com.elevadoruso.reinaldo;


import java.io.Serializable;

public class Elevador implements Serializable {
    private Integer andar;
    private Character elevador;
    private Character turno;

    public Elevador() {
    }

    public Elevador(int andar, Character elevador, Character turno) {
        this.andar = andar;
        this.elevador = elevador;
        this.turno = turno;
    }

    public int getAndar() {
        return andar;
    }

    public Character getElevador() {
        return elevador;
    }

    public Character getTurno() {
        return turno;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public void setElevador(Character elevador) {
        this.elevador = elevador;
    }

    public void setTurno(Character turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Elevador{" +
                "andar=" + andar +
                ", elevador=" + elevador +
                ", turno=" + turno +
                '}';
    }
}