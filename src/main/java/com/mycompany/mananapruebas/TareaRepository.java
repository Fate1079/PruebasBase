/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.mananapruebas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANDRES FELIPE
 */
public class TareaRepository {

    public void agregarTarea(String nombre) throws SQLException {
        String query = "INSERT INTO tareas (nombre) VALUES (?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.executeUpdate();
        }
    }

    public List<Tarea> obtenerTareas() throws SQLException {
        List<Tarea> lista = new ArrayList<>();
        String query = "SELECT FROM tareas";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                lista.add(new Tarea(rs.getInt("id"), rs.getString("nombre"), rs.getBoolean("completada")));
            }
        }
        return lista;
    }

    public void completarTarea(int id) throws SQLException {
        String query = "UPDATE tareas SET completada = TRUE WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
