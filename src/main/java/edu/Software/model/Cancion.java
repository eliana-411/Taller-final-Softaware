package edu.Software.model;

import java.util.List;
import java.util.ArrayList;
import edu.Software.helpers.*;

public class Cancion {
  private String nombre;
  private String duracion;
  public static List<Cancion> canciones = new ArrayList<>();

  // CONSTRUCTOR POR DEFECTO
  public Cancion() {
    this.nombre = "";
    this.duracion = "";
  }

  // CONSTRUCTOR PARAMETRIZADO
  public Cancion(String nombre, String duracion) {
    this.nombre = nombre;
    this.duracion = duracion;
  }

  // CREAR CANCION
  public static void CrearCanciones() {
    System.out.println("CREAR UNA CANCIÓN");
    do {
      String nombre = Keyboard.readString("Nombre (Intro terminar): ");
      if (nombre.equals("")) {
        break;
      }

      // if (canciones.stream().anyMatch(cancion -> nombre.equals(cancion.nombre))) {
      //   System.out.println("La canción ya existe, intente de nuevo.\n");
      //   continue;
      // }

      String duracion = Keyboard.readString("Duración: ");

      canciones.add(new Cancion(nombre, duracion));
      System.out.println("Canción creada con éxito.");
    } while (true);
  }

  // MOSTRAR ARTISTA
  public static void MostrarCanciones() {
    System.out.println("-".repeat(35));
    System.out.printf("%18s %n", "CANCIONES");
    System.out.println("-".repeat(35));
    System.out.printf("%-18s %-10s %n", "NOMBRE", "DURACIÓN");
    System.out.println("-".repeat(35));
    for (Cancion c : Cancion.canciones) {
      System.out.printf("%-18s %-8s %n", c.getNombre(), c.getDuracion());
    }
  }

  // ACCESORES Y MUTADORES
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDuracion() {
    return duracion;
  }

  public void setDuracion(String duracion) {
    this.duracion = duracion;
  }
}

