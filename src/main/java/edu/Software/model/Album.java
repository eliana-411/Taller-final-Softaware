package edu.Software.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import edu.Software.exceptions.*;
import edu.Software.helpers.*;

public class Album {
  private String titulo;
  private LocalDate fechaLanzamiento;
  private String criticas;
  private String reseñas;
  private int ventas;
  private int sencillosDestacados;
  private double costo;
  private List<Cancion> canciones;
  public static List<Album> albumes = new ArrayList<>();

  public Album() {
    this.titulo = "";
    this.fechaLanzamiento = LocalDate.now();
    this.criticas = "";
    this.reseñas = "";
    this.ventas = 0;
    this.sencillosDestacados = 0;
    this.costo = 0.0; 
    this.canciones = null;
  }

  // CCONSTRUCTOR PARAMETRIZADO
  // LANZAR NUEVO ÁLBUM
  public Album(String titulo, LocalDate fechaLanzamiento, String criticas, String reseñas, int ventas,
      int sencillosDestacados, double costo, List<Cancion> canciones) {
    this.titulo = titulo;
    this.fechaLanzamiento = fechaLanzamiento;
    this.criticas = criticas;
    this.reseñas = reseñas;
    this.ventas = ventas;
    this.sencillosDestacados = sencillosDestacados;
    this.costo = costo;
    this.canciones = canciones;
  }

  // CREAR ÁLBUM
  public static void CrearAlbum() throws AlbumVacioException {
    System.out.println("CREAR UN ÁLBUM");
    do {
      String titulo = Keyboard.readString("Título (Intro terminar): ");
      if (titulo.equals("")) {
        break;
      }
      // if (albumes.stream().anyMatch(album -> titulo.equals(album.titulo))) {
      //   System.out.println("El Álbum ya existe, intente de nuevo.\n");
      //   continue;
      // }
      LocalDate fechaLanzamiento = Keyboard.readDate("Fecha Lanzamiento (AAAA-MM-DD): ");
      String criticas = Keyboard.readString("Críticas: ");
      String reseñas = Keyboard.readString("Reseñas: ");
      int ventas = Keyboard.readInt("Ventas: ");
      int sencillosDestacados = Keyboard.readInt("Sencillos destacados: ");
      double costo = Keyboard.readDouble("Costo: ");
      // INICIALIZAR LA LISTA DE CANCIONES
      List<Cancion> canciones = new ArrayList<>();
      // VERIFICACIÓN INICIAL
      if (Cancion.canciones.isEmpty()) {
        throw new AlbumVacioException("No hay canciones para agregar al Álbum.");
      }
      do {
        MostrarCanciones2();
        int i = Keyboard.readInt("\nElija el número de la canción a agregar(-1 -Termina): ");

        if (i == -1) {
          break; // SALIR SI ELIGE -1
        }

        canciones.add(Cancion.canciones.get(i - 1));

      } while (true);
      Album nuevoAlbum = new Album(titulo, fechaLanzamiento, criticas, reseñas, ventas, sencillosDestacados, costo, canciones);

      // AGREGAR ALBUM A LA LISTA DE ALBUMES
      albumes.add(nuevoAlbum);

    } while (true);
  }

  // OBTENER LAS CANCIONES
  public static void MostrarCanciones2() {
    System.out.println("Canción:");
    int index = 1;

    for (Cancion c : Cancion.canciones) {
      System.out.printf("%2d: %s - %s%n", index, c.getNombre(), c.getDuracion());
      index++;
    }
  }

  // MOSTRAR ÁLBUM
  public static void MostrarAlbum() {
    System.out.println("-".repeat(130));
    System.out.printf("%50s %n", "ALBUMES");
    System.out.println("-".repeat(130));
    System.out.printf("%-18s %-20s %-20s %-26s %-10s %-15s %-12s %-15s%n", "TITULO", "FECHALANZAMIENTO", "CRITICAS",
        "RESEÑAS",
        "VENTAS", "DESTACDADOS", "COSTO", "CANCIONES");
    System.out.println("-".repeat(130));
    for (Album a : Album.albumes) {
      // OBTENER LA LISTA DE CANCIONES DEL ALBUM
      List<Cancion> canciones = a.getCanciones();
      // CREACIÓN DE CADENA PARA ALMACENAR LA REPRESENTACIÓN DE CANCIONES
      StringBuilder cancionesStr = new StringBuilder();
      // AGREGAR EL NOMBRE DE LA CANCIÓN A LA CADENA
      for (Cancion cancion : canciones) {
        cancionesStr.append(cancion.getNombre()).append(", ");
      }
      System.out.printf("%-20s %-15s %-25s %-25s %-10d %-15d %-12.2f %-15s%n", a.getTitulo(), a.getFechaLanzamiento(),
          a.getCriticas(), a.getReseñas(), a.getVentas(), a.getSencillosDestacados(), a.getCosto(), cancionesStr.toString());
    }
  }

  // ACCESORES Y MUTADORES
  public String getTitulo() {
    return titulo;
  }

  public LocalDate getFechaLanzamiento() {
    return fechaLanzamiento;
  }

  public List<Cancion> getCanciones() {
    return canciones;
  }

  public String getCriticas() {
    return criticas;
  }

  public String getReseñas() {
    return reseñas;
  }

  public int getVentas() {
    return ventas;
  }

  public int getSencillosDestacados() {
    return sencillosDestacados;
  }
  public double getCosto() {
    return costo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

   public void setCosto(double costo) {
    this.costo = costo;
  }

  public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
    this.fechaLanzamiento = fechaLanzamiento;
  }

  public void setCanciones(List<Cancion> canciones) {
    this.canciones = canciones;
  }

  public void setCriticas(String criticas) {
    this.criticas = criticas;
  }

  public void setReseñas(String reseñas) {
    this.reseñas = reseñas;
  }

  public void setVentas(int ventas) {
    this.ventas = ventas;
  }

  public void setSencillosDestacados(int sencillosDestacados) {
    this.sencillosDestacados = sencillosDestacados;
  }

}

