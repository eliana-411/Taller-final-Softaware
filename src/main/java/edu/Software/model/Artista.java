package edu.Software.model;

import java.util.ArrayList;
import java.util.List;
import edu.Software.helpers.*;

public class Artista {
  private String identificacion;
  private String nombre;
  private String instrumento;
  private String experiencia;
  public static List<Artista> artistas = new ArrayList<>();

  // CONSTRUCTOR POR DEFECTO
  public Artista() {
    this.identificacion = "";
    this.nombre = "";
    this.instrumento = "";
    this.experiencia = "";
  }

  // CONSTRUCTOR PARAMETRIZADO
  public Artista(String identificacion, String nombre, String instrumento, String experiencia) {
    this.identificacion = identificacion;
    this.nombre = nombre;
    this.instrumento = instrumento;
    this.experiencia = experiencia;
  }

  // CREAR ARTISTA
  public static void CrearArtista() {
    System.out.println("CREAR UN ARTISTA");
    do {
      String identificacion = Keyboard.readString("ID (Intro terminar): ");
      if (identificacion.equals("")) {
        break;
      }

      // if (artistas.stream().anyMatch(artista -> identificacion.equals(artista.identificacion))) {
      //   System.out.println("El Artista ya existe, intente de nuevo.\n");
      //   continue;
      // }

      String nombre = Keyboard.readString("Nombre: ");
      String instrumento = Keyboard.readString("Instrumento: ");
      String experiencia = Keyboard.readString("Experiencia: ");

      artistas.add(new Artista(identificacion, nombre, instrumento, experiencia));
    } while (true);
  }

  // MOSTRAR ARTISTA
  public static void MostrarArtista() {
    System.out.println("-".repeat(70));
    System.out.printf("%30s %n", "ARTISTAS");
    System.out.println("-".repeat(70));
    System.out.printf("%-7s %-20s %-20s %-8s %n", "ID", "NOMBRE", "INSTRUMENTO", "EXPERIENCIA");
    System.out.println("-".repeat(70));
    for (Artista a : Artista.artistas) {
      System.out.printf("%-7s %-20s %-20s %-8s %n", a.getIdentificacion(), a.getNombre(), a.getInstrumento(),
          a.getExperiencia());
    }
  }

  // ACCESORES Y MUTADORES

  public List<Artista> getArtistas() {
    return artistas;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getInstrumento() {
    return instrumento;
  }

  public void setInstrumento(String instrumento) {
    this.instrumento = instrumento;
  }

  public String getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(String experiencia) {
    this.experiencia = experiencia;
  }

}

