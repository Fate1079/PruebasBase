/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.mananapruebas;

/**
 *
 * @author ANDRES FELIPE
 */
public class Tarea {

   
    private int id;
    private String nombre;
    private boolean completada;

    public Tarea(int id, String nombre, boolean completada) {
        this.id = id;
        this.nombre = nombre;
        this.completada = completada;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public boolean estaCompletada() { return completada; }

    @Override
    public String toString() {
        return id + ". " + nombre + " - " + (completada ? "✅ Completada" : "❌ Pendiente");
    }
}

