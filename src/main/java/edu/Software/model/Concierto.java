package edu.Software.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import edu.Software.exceptions.*;
import edu.Software.helpers.*;

public class Concierto {
  private String ubicacion;
  private LocalDate fechaHora;
  private int boletosVendidos;
  private int capacidadLugar;
  private List<Cancion> canciones;
  private List<Banda> bandas;
  public static List<Concierto> conciertos = new ArrayList<>();

  // CONSTRUCTOR POR DEFECTO
  public Concierto() {
    this.ubicacion = "";
    this.fechaHora = LocalDate.now();
    this.boletosVendidos = 0;
    this.capacidadLugar = 0;
    this.canciones = null;
    this.bandas = null;

  }

  // CONSTRUCTOR PARAMETRIZADO
  public Concierto(String ubicacion, LocalDate fechaHora, int boletosVendidos, int capacidadLugar,
      List<Cancion> canciones, List<Banda> bandas) {
    this.ubicacion = ubicacion;
    this.fechaHora = fechaHora;
    this.boletosVendidos = boletosVendidos;
    this.capacidadLugar = capacidadLugar;
    this.canciones = canciones;
    this.bandas = bandas;

  }

  // CREAR CONCIERTOS
  public static void CrearConcierto() throws ConciertoSinCancionesException, ConciertoSinBandaException {
    System.out.println("CREAR UN CONCIERTO");
    do {
      String ubicacion = Keyboard.readString("Ubicación, (Intro terminar): ");
      if (ubicacion.equals("")) {
        break;
      }
      LocalDate fechaHora = Keyboard.readDate("Fecha y Hora del Concierto (AAAA-MM-DD): ");

    //   if (conciertos.stream()
    //       .anyMatch(concierto -> fechaHora.equals(concierto.fechaHora) && ubicacion.equals(concierto.ubicacion))) {
    //     System.out
    //         .println("a hay un concierto programado para la fecha y ubicación ingresadas.\n Intentelo nuevamente");
    //     continue;
    //   }
      int boletosVendidos = Keyboard.readInt("Boletos vendidos: ");
      int capacidadLugar = Keyboard.readInt("Capacidad del lugar: ");

      // INICIALIZAR LA LISTA DE CANCIONES
      List<Cancion> canciones = new ArrayList<>();
      // VERIFICACIÓN INICIAL
      if (Cancion.canciones.isEmpty()) {
        throw new ConciertoSinCancionesException("No hay canciones para agregar al Concierto.");
      }
      do {
        MostrarCanciones2();
        int i = Keyboard.readInt("\nElija el número de la canción a agregar(-1 -Termina): ");

        if (i == -1) {
          break; // SALIR SI SE ELIGE -1
        }
        canciones.add(Cancion.canciones.get(i - 1));
      } while (true);

      // INICIALIZAR LA LISTA DE BANDAS
      List<Banda> bandas = new ArrayList<>();
      // VERIFICACIÓN INICIAL
      if (Banda.bandas.isEmpty()) {
        throw new ConciertoSinBandaException("No hay bandas para agregar al Concierto.");
      }
      do {
        MostrarBandas2();
        int i = Keyboard.readInt("\nElija el número de la banda a agregar (-1 -Termina): ");

        if (i == -1) {
          break; // SALIR SI SE ELIGE -1
        }

        bandas.add(Banda.bandas.get(i - 1));

      } while (true);

      conciertos
          .add(new Concierto(ubicacion, fechaHora, boletosVendidos, capacidadLugar, canciones, bandas));
      System.out.println("El concierto ha sido creado con éxito");
    } while (true);
  }

  // OBTENER LAS BANDAS
  public static void MostrarBandas2() {
    System.out.println("Bandas:");
    int index = 1;

    for (Banda b : Banda.bandas) {
      System.out.printf("%2d: %s - %s%n", index, b.getNombre(), b.getGeneroMusical());
      index++;
    }
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


  // REGISTRAR BOLETOS VENDIDOS
  public void registrarBoletosVendidos(String ubicacionConcierto, int boletosVendidosNuevos)
      throws CapacidadExcedidaException, ConciertoNoValidoException {

    if (this.ubicacion.equals(ubicacionConcierto)) {
      if ((boletosVendidos + boletosVendidosNuevos) <= capacidadLugar) {
        boletosVendidos += boletosVendidosNuevos;
        System.out.println(boletosVendidosNuevos + " boletos vendidos registrados correctamente.");
      } else {
        throw new CapacidadExcedidaException("No se pueden vender más boletos, capacidad del lugar superada.");
      }
    } else {
      throw new ConciertoNoValidoException("Los boletos no son para este concierto.");
    }
  }

  // MOSTRAR CONCIERTO
  public static void MostrarConcierto() {
    System.out.println("-".repeat(35));
    System.out.printf("%18s %n", "CONCIERTOS");
    System.out.println("-".repeat(35));
    System.out.printf("%-18s %-10s, %-10s, %-10s, %10s, %10s%n", "UBICACION", "FECHA", "BOLETOS VENDIDOS",
        "CAPACIDAD LUGAR", "CANCIONES", "BANDAS");
    System.out.println("-".repeat(35));
    for (Concierto c : Concierto.conciertos) {
      List<Cancion> canciones = c.getCanciones();
      // CREACIÓN DE CADENA PARA ALMACENAR LA REPRESENTACIÓN DE CANCIONES
      StringBuilder cancionesStr = new StringBuilder();
      // AGREGAR EL NOMBRE DE LA CANCIÓN A LA CADENA
      for (Cancion cancion : canciones) {
        cancionesStr.append(cancion.getNombre()).append(", ");
      }
      // MOSTRAR LAS BANDAS DEL CONCIERTO
      List<Banda> bandas = c.getBandas();
      // CREACIÓN DE CADENA PARA ALMACENAR LA REPRESENTACIÓN DE BANDAS
      StringBuilder bandaStr = new StringBuilder();
      // AGREGAR EL NOMBRE DE LA BANDA A LA CADENA
      for (Banda banda : bandas) {
        bandaStr.append(banda.getNombre()).append(", ");
      }
      System.out.printf("%-12s %-10s %-30s %-10s %-10s %-18s%n", c.getUbicacion(), c.getFechaHora(),
          c.getBoletosVendidos(), c.getCapacidadLugar(), cancionesStr.toString(), bandaStr.toString());
    }
  }

  // ACCESORES Y MUTADORES
  public LocalDate getFechaHora() {
    return fechaHora;
  }

  public void setFechaHora(LocalDate fechaHora) {
    this.fechaHora = fechaHora;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public List<Cancion> getCanciones() {
    return canciones;
  }

  public List<Banda> getBandas() {
    return bandas;
  }

  public void setCanciones(List<Cancion> canciones) {
    this.canciones = canciones;
  }

  public int getBoletosVendidos() {
    return boletosVendidos;
  }

  public void setBoletosVendidos(int boletosVendidos) {
    this.boletosVendidos = boletosVendidos;
  }

  public int getCapacidadLugar() {
    return capacidadLugar;
  }

  public void setCapacidadLugar(int capacidadLugar) {
    this.capacidadLugar = capacidadLugar;
  }
}

