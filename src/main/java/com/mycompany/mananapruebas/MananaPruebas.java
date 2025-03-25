/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mananapruebas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ANDRES FELIPE
 */
public class MananaPruebas {

     public static void main(String[] args) {
        TareaService tareaService = new TareaService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📋 Menú:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Ver tareas");
            System.out.println("3. Completar tarea");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de la tarea: ");
                        String nombre = scanner.nextLine();
                        tareaService.agregarTarea(nombre);
                        break;
                    case 2:
                        List<Tarea> tareas = tareaService.obtenerTareas();
                        if (tareas.isEmpty()) {
                            System.out.println("No hay tareas pendientes.");
                        } else {
                            tareas.forEach(System.out::println);
                        }
                        break;
                    case 3:
                        System.out.print("Número de tarea a completar: ");
                        int id = scanner.nextInt();
                        tareaService.completarTarea(id);
                        break;
                    case 4:
                        System.out.println("¡Hasta luego!");
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
