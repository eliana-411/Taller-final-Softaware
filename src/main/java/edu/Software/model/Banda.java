package edu.Software.model;

import java.util.List;
import java.util.ArrayList;
import edu.Software.exceptions.*;
import edu.Software.helpers.*;

public class Banda implements IBanda {
  private String nombre;
  private String generoMusical;
  private String historia;
  private List<Artista> miembros;
  public static List<Banda> bandas = new ArrayList<>();

  // CONSTRUCTOR POR DEFECTO
  public Banda() {
    this.nombre = "";
    this.generoMusical = "";
    this.historia = "";
    this.miembros = new ArrayList<>();
  }

  // CONSTRUCTOR PARAMETRIZADO
  public Banda(String nombre, String generoMusical, String historia, List<Artista> miembros) {
    this.nombre = nombre;
    this.generoMusical = generoMusical;
    this.historia = historia;
    this.miembros = miembros;
  }

  // REGISTRAR UNA NUEVA BANDA
  public static void CrearBandas() throws BandaSinArtistaException {
    System.out.println("CREAR UNA BANDA");
    do {
      String nombre = Keyboard.readString("Nombre (Intro terminar): ");
      if (nombre.equals("")) {
        break;
      }

      // if (bandas.stream().anyMatch(banda -> nombre.equals(banda.nombre))) {
      //   System.out.println("La banda ya existe, intente de nuevo.\n");
      //   continue;
      // }

      String generoMusical = Keyboard.readString("Genero Musical: ");
      String historia = Keyboard.readString("Historia: ");

      // INICIALIZAR LA LISTA DE MIEMBROS
      List<Artista> miembros = new ArrayList<>();
      // VERIFICACIÓN INICIAL
      if (Artista.artistas.isEmpty()) {
        throw new BandaSinArtistaException("No hay artistas para agregar a la Banda.");
      }

      do {
        MostrarArtista2();
        int i = Keyboard.readInt("\nElija el número del artista a agregar(-1 -Termina): ");

        if (i == -1) {
          break; // SALIR SI ELIGE -1
        }

        miembros.add(Artista.artistas.get(i - 1));

      } while (true);

      Banda nuevaBanda = new Banda(nombre, generoMusical, historia, miembros);

      // AGREGAR NUEVA BANDA A LA LISTA DE BANDAS
      bandas.add(nuevaBanda);

    } while (true);
  }

  public static void MostrarArtista2() {
    System.out.println("Artista:");
    int index = 1;

    for (Artista a : Artista.artistas) {
      System.out.printf("%2d: %s - %s%n", index, a.getNombre(), a.getInstrumento());
      index++;
    }
  }

  // ACTUALIZAR INROMACIÓN DE LA BANDA
  public void ActualizarInfoBanda() throws BandaNoEncontradaException {
    // ELECCIÓN DE LA BANDA A ACTUALIZAR
    Banda b = Banda.MostrarBanda();
    // DATOS ACTUALES DE LA BANDA
    System.out.println("\nDatos actuales de la banda\n");
    System.out.println("Nombre: " + b.getNombre());
    System.out.println("Género musical: " + b.getGeneroMusical());
    System.out.println("Historia: " + b.getHistoria());
    System.out.println("Miembros: " + b.getMiembros());

    // PEDIR NUEVOS DATOS
    System.out.println("\nNuevos datos de la banda: \n");

    String nombre = Keyboard.readString("Nombre: ");
    b.setNombre(nombre.length() > 0 ? nombre : b.getNombre());

    String generoMusical = Keyboard.readString("Género Musical: ");
    b.setGeneroMusical(generoMusical.length() > 0 ? generoMusical : b.getGeneroMusical());

    String historia = Keyboard.readString("Historia: ");
    b.setHistoria(historia.length() > 0 ? historia : b.getHistoria());

    System.out.println("Miembros:");

    for (Banda bd : Banda.bandas) {
      for (Artista a : bd.getMiembros())
        System.out.printf("%s%n", a.getNombre());
    }

    // DATOS NUEVOS
    System.out.println("\nDatos nuevos de la banda\n");
    System.out.println("Nombre: " + b.getNombre());
    System.out.println("Género musical: " + b.getGeneroMusical());
    System.out.println("Historia: " + b.getHistoria());
    System.out.println("Miembros: " + b.getMiembros());

  }

  // MOSTRAR BANDA
  public static Banda MostrarBanda() throws BandaNoEncontradaException {
    System.out.println("Banda:");
    int index = 1;

    for (Banda b : Banda.bandas) {
      System.out.printf("%2d: %s - %s%n", index, b.getNombre(),
          b.getGeneroMusical());
      index++;
    }

    int choice = Keyboard.readInt(1, index - 1, "Elija el número de una banda entre 1 y " + (index - 1) + ": ");
    return Banda.bandas.get(choice - 1);
  };

  // MOSTRAR BANDAS
  public static void MostrarBanda2() {
    System.out.println("-".repeat(100));
    System.out.printf("%50s %n", "BANDAS");
    System.out.println("-".repeat(100));
    System.out.printf("%-12s %-10s %-30s %-18s%n", "NOMBRE", "GENERO", "HISTORIA", "MIEMBROS");
    System.out.println("-".repeat(100));
    for (Banda b : Banda.bandas) {
      // OBTIENE LA LISTA DE ARTISTAS DE LA BANDA
      List<Artista> miembros = b.getMiembros();
      // CREACIÓN DE CADENA PARA ALMACENAR LA REPRESENTACIÓN DE MIEMBROS
      StringBuilder miembrosStr = new StringBuilder();
      // AGREGA CADA MIEMBRO A LA CADENA
      for (Artista artista : miembros) {
        miembrosStr.append(artista.getNombre()).append(", ");
      }
      System.out.printf("%-12s %-10s %-30s %-18s%n", b.getNombre(), b.getGeneroMusical(), b.getHistoria(),
          miembrosStr.toString());
    }
  }

  // BUSCAR UNA BANDA POR NOMBRE
  public static Banda buscarBandaPorNombre(List<Banda> bandas, String nombre) {
    for (Banda banda : bandas) {
      if (banda.getNombre().equalsIgnoreCase(nombre)) {
        return banda; // SI ENCUENTRA LA BANDA, LA RETORNA
      }
    }
    return null; // SI NO ENCUENTRA LA BANDA CON ESE NOMBRE RETORNA NULL
  }

  // ACCESORES Y MUTADORES
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getGeneroMusical() {
    return generoMusical;
  }

  public void setGeneroMusical(String generoMusical) {
    this.generoMusical = generoMusical;
  }

  public String getHistoria() {
    return historia;
  }

  public void setHistoria(String historia) {
    this.historia = historia;
  }

  @Override
  public List<Artista> getMiembros() {
    return miembros;
  }

  @Override
  public void setMiembros(List<Artista> miembros) {
    this.miembros = miembros;
  }

  public List<Banda> getBandas() {
    return bandas;
  }

  public void setBandas(List<Banda> bandas) {
    this.bandas = bandas;
  }
}

