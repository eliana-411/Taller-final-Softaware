package edu.Software.model;

import java.util.List;
import java.util.ArrayList;
import edu.Software.helpers.*;

public class Fanatico {
  private String nombre;
  private String email;
  private String ubicacion;
  private String redesSociales;
  private List<Concierto> conciertosAsistidos;
  public static List<Fanatico> fanaticos = new ArrayList<>();

  // CONSTRUCTOR POR DEFECTO
  public Fanatico() {
    this.nombre = "";
    this.email = "";
    this.ubicacion = "";
    this.redesSociales = "";
    this.conciertosAsistidos = null;
  }

  // CONSTRUCTOR PARAMETRIZADO
  public Fanatico(String nombre, String email, String ubicacion, String redesSociales,
      List<Concierto> conciertosAsistidos) {
    this.nombre = nombre;
    this.email = email;
    this.ubicacion = ubicacion;
    this.redesSociales = redesSociales;
    this.conciertosAsistidos = conciertosAsistidos;
  }

  // CREAR FANÁTICO
  public static void CrearFanatico() {
    System.out.println("CREAR UN FANÁTICO");
    do {
      String nombre = Keyboard.readString("Nombre del fanatico(Intro terminar): ");
      if (nombre.equals("")) {
        break;
      }

      // if (fanaticos.stream().anyMatch(fanatico -> nombre.equals(fanatico.nombre)))
      // {
      // System.out.println("El fanático ya existe, intenta de nuevo.\n");
      // continue;
      // }

      String email = Keyboard.readString("Email: ");
      String ubicacion = Keyboard.readString("Ubicación: ");
      String redesSociales = Keyboard.readString("Redes sociales: ");

      // INICIALIZAR LA LISTA DE CONCIERTOS
      List<Concierto> conciertosAsistidos = new ArrayList<>();
      do {
        MostrarConciertos2();
        int i = Keyboard.readInt("\nElija el número del concierto a agregar(-1 -Termina): ");

        if (i == -1) {
          break; // SALIR SI SE ELIGE -1
        }
        conciertosAsistidos.add(Concierto.conciertos.get(i - 1));
      } while (true);

      fanaticos.add(new Fanatico(nombre, email, ubicacion, redesSociales, conciertosAsistidos));
      System.out.println("Fanático creado con éxito.\n");

    } while (true);
  }

  // OBTENER CONCIERTOS
  public static void MostrarConciertos2() {
    System.out.println("Conciertos:");
    int index = 1;

    for (Concierto c : Concierto.conciertos) {
      System.out.printf("%2d: %s - %s%n", index, c.getUbicacion(), c.getFechaHora());
      index++;
    }
  }

  // MOSTRAR FANÁTICOS
  public static void MostrarFanaticos() {
    System.out.println("-".repeat(100));
    System.out.printf("%40s %n", "FANATICOS");
    System.out.println("-".repeat(100));
    System.out.printf("%-15s %-26s %-13s %-12s %-10s %n", "NOMBRE", "EMAIL", "UBICACIÓN", "REDES SOCIALES",
        "CONCIERTOS ASISTIDOS");
    System.out.println("-".repeat(100));
    for (Fanatico f : Fanatico.fanaticos) {
      List<Concierto> conciertosAsistidos = f.getConciertosAsistidos();
      // CREACIÓN DE CADENA PARA ALMACENAR LA REPRESENTACIÓN DE CONCIERTOS
      StringBuilder conciertosStr = new StringBuilder();
      // AGREGAR LA UBICACIÓN Y LA FECHA DEL CONCIERTO A LA CADENA
      for (Concierto concierto : conciertosAsistidos) {
        conciertosStr.append(concierto.getUbicacion()).append(", ").append(concierto.getFechaHora()).append(", ");
      }
      System.out.printf("%-15s %-26s %-13s %-12s %-10s %n", f.getNombre(), f.getEmail(), f.getUbicacion(),
          f.getRedesSociales(), conciertosStr);
    }
  }

  // MÉTODO PARA MOSTRAR FANÁTICOS QUE ASISTIERON A UN CONCIERTO ELEGIDO POR EL
  // USUARIO
  public static void MostrarFanaticosPorConcierto() {
    MostrarConciertos2();
    int indiceConcierto = Keyboard
        .readInt("\nElija el número del concierto para ver los fanáticos que asistieron (-1 para salir): ");

    if (indiceConcierto == -1) {
      return; // SALIR SI ELIGE -1
    }

    if (indiceConcierto >= 1 && indiceConcierto <= Concierto.conciertos.size()) {
      Concierto conciertoSeleccionado = Concierto.conciertos.get(indiceConcierto - 1);
      System.out.println();
      System.out.printf("Fanáticos que asistieron al concierto en %s el %s:%n",
          conciertoSeleccionado.getUbicacion(), conciertoSeleccionado.getFechaHora());

      for (Fanatico fanatico : fanaticos) {
        if (fanatico.getConciertosAsistidos().contains(conciertoSeleccionado)) {
          System.out.printf("- %s%n", fanatico.getNombre());
        }
      }
    } else {
      System.out.println("Índice de concierto no válido.");
    }
  }

  // ACCESORES Y MUTADORES
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public String getRedesSociales() {
    return redesSociales;
  }

  public void setRedesSociales(String redesSociales) {
    this.redesSociales = redesSociales;
  }

  public List<Concierto> getConciertosAsistidos() {
    return conciertosAsistidos;
  }

  public void setConciertosAsistidos(List<Concierto> conciertosAsistidos) {
    this.conciertosAsistidos = conciertosAsistidos;
  }
}
