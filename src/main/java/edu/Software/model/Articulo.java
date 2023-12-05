package edu.Software.model;

import java.util.List;
import java.util.ArrayList;
import edu.Software.helpers.*;

public class Articulo {
  private String nombre;
  private double costo;
  private String descripcion;
  public static List<Articulo> articulos = new ArrayList<>();

  // CONSTRUCTOR POR DEFECTO
  public Articulo() {
    this.nombre = "";
    this.costo = 0.0;
    this.descripcion = "";
  }

  // CONSTRUCTOR PARAMETRIZADO
  public Articulo(String nombre, double costo, String descripcion) {
    this.nombre = nombre;
    this.costo = costo;
    this.descripcion = descripcion;
  }

  // CREAR ARTÍCULOS
  public static void CrearArticulo() {
    System.out.println("CREAR UN ARTÍCULO");
    do {
      String nombre = Keyboard.readString("Nombre (Intro terminar): ");
      if (nombre.equals("")) {
        break;
      }

      // if (articulos.stream().anyMatch(articulo -> nombre.equals(articulo.nombre))) {
      //   System.out.println("El Artículo ya existe, intente de nuevo.\n");
      //   continue;
      // }

      Double costo = Keyboard.readDouble("Costo: ");
      String descripcion = Keyboard.readString("Descripción: ");

      articulos.add(new Articulo(nombre, costo, descripcion));
      System.out.println("Artículo creado con éxito.");
    } while (true);
  }

  // MOSTRAR ARTÍCULOS
  public static void MostrarArticulos() {
    System.out.println("-".repeat(5));
    System.out.printf("%20s %n", "ARTICULOS");
    System.out.println("-".repeat(50));
    System.out.printf("%-15s %-10s %-10s %n", "NOMBRE", "COSTO",
        "DESCRIPCION");
    System.out.println("-".repeat(50));
    for (Articulo a : Articulo.articulos) {
      System.out.printf("%-15s %-10s %-10s %n", a.getNombre(), a.getCosto(), a.getDescripcion());
    }
  }

  // ACCESORES Y MUTADORES
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getCosto() {
    return costo;
  }

  public void setCosto(double costo) {
    this.costo = costo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}

