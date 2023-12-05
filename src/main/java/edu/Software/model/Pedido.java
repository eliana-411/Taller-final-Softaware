package edu.Software.model;

import java.util.List;
import java.util.ArrayList;
import edu.Software.helpers.*;

public class Pedido {
  private String idPedido;
  private String direccionEnvio;
  private String estadoPedido;
  private List<Articulo> articulos;
  private List<Album> albumes;
  private List<Fanatico> fanaticos;
  public static List<Pedido> pedidos = new ArrayList<>();

  // CONSTRUCTOR POR DEFECTO
  public Pedido() {
    this.idPedido = "";
    this.direccionEnvio = "";
    this.estadoPedido = "";
    this.articulos = null;
    this.albumes = null;
    this.fanaticos = null;
  }

  // CONSTRUCTOR PARAMETRIZADO
  public Pedido(String idPedido, String direccionEnvio, String estadoPedido, List<Articulo> articulos,
      List<Album> albumes, List<Fanatico> fanaticos) {
    this.idPedido = idPedido;
    this.direccionEnvio = direccionEnvio;
    this.estadoPedido = estadoPedido;
    this.articulos = articulos;
    this.albumes = albumes;
    this.fanaticos = fanaticos;
  }

  // CREAR PEDIDO
  public static void CrearPedido() {
    System.out.println("CREAR UN PEDIDO");
    do {
      String idPedido = Keyboard.readString("ID del pedido (Intro terminar): ");
      if (idPedido.equals("")) {
        break;
      }

    //   if (pedidos.stream().anyMatch(pedido -> idPedido.equals(pedido.idPedido))) {
    //     System.out.println("El pedido ya existe, intente de nuevo.\n");
    //     continue;
    //   }

      String direccionEnvio = Keyboard.readString("Dirección del Envío: ");
      String estadoPedido = Keyboard.readString("Estado del pedido: ");

      // INICIALIZAR LA LISTA DE ARTICULOS
      List<Articulo> articulos = new ArrayList<>();
      do {
        MostrarArticulos2();
        int i = Keyboard.readInt("\nElija el número del artículo a agregar(-1 -Termina): ");

        if (i == -1) {
          break; // SALIR SI SE ELIGE -1
        }
        articulos.add(Articulo.articulos.get(i - 1));

      } while (true);

      // INICIALIZAR LA LISTA DE ALBUMES
      List<Album> albumes = new ArrayList<>();
      do {
        MostrarAlbumes2();
        int i = Keyboard.readInt("\nElija el número del album a agregar(-1 -Termina): ");

        if (i == -1) {
          break; // SALIR SI SE ELIGE -1
        }
        albumes.add(Album.albumes.get(i - 1));

      } while (true);

      // INICIALIZAR LA LISTA DE FANÁTICOS
      List<Fanatico> fanaticos = new ArrayList<>();
      do {
        MostrarFanaticos2();
        int i = Keyboard.readInt("\nElija el número del fanático a agregar(-1 -Termina): ");

        if (i == -1) {
          break; // SALIR SI SE ELIGE -1
        }
        fanaticos.add(Fanatico.fanaticos.get(i - 1));

      } while (true);

      pedidos.add(new Pedido(idPedido, direccionEnvio, estadoPedido, articulos, albumes, fanaticos));
    } while (true);
  }

  // OBTENER LOS FANÁTICOS
  public static void MostrarFanaticos2() {
    System.out.println("Fanáticos:");
    int index = 1;

    for (Fanatico f : Fanatico.fanaticos) {
      System.out.printf("%2d: %s - %s%n", index, f.getNombre(), f.getEmail());
      index++;
    }
  }

  // OBTENER LAS CANCIONES
  public static void MostrarArticulos2() {
    System.out.println("Artículo:");
    int index = 1;

    for (Articulo a : Articulo.articulos) {
      System.out.printf("%2d: %s - %s%n", index, a.getNombre(), a.getCosto());
      index++;
    }
  }

  // OBTENER LAS CANCIONES
  public static void MostrarAlbumes2() {
    System.out.println("Titulo:");
    int index = 1;

    for (Album a : Album.albumes) {
      System.out.printf("%2d: %s%n", index, a.getTitulo());
      index++;
    }
  }

  // MOSTRAR PEDIDOS
  public static Pedido MostrarPedido() {
    System.out.println("Pedido:");
    int index = 1;

    for (Pedido p : Pedido.pedidos) {
      System.out.printf("%2d: %s - %s%n", index, p.getArticulos(), p.getEstadoPedido());
      index++;
    }

    int choice = Keyboard.readInt(1, index - 1, "Elija el número de un pedido entre 1 y " + (index - 1) + ": ");
    return Pedido.pedidos.get(choice - 1);
  }

  // MOSTRAR PEDIDOS
  public static void MostrarPedido2() {
    System.out.println("-".repeat(100));
    System.out.printf("%50s %n", "PEDIDOS");
    System.out.println("-".repeat(100));
    System.out.printf("%-7s %-12s %-10s %-23s %-20s %-18s%n", "ID", "DIRECCIÓN", "ESTADO", "ARTÍCULOS", "ALBUMES", "FANÁTICOS");
    System.out.println("-".repeat(100));
    for (Pedido p : Pedido.pedidos) {
      // OBTENER LA LISTA DE ARTICULOS
      List<Articulo> articulos = p.getArticulos();
      // CREACION DE CADENA PARA ALMACENAR LA REPRESENTACIÓN DE ARTÍCLOS
      StringBuilder articulosStr = new StringBuilder();
      // AGREGAR EL NOMBRE DEL ARTÍCULO A LA CADENA
      for (Articulo articulo : articulos) {
        articulosStr.append(articulo.getNombre()).append(", ");
      }

      // OBTENER LA LISTA DE ALBUMES
      List<Album> albumes = p.getAlbumes();
      // CREACION DE CADENA PARA ALMACENAR LA REPRESENTACIÓN DE ALBUMES
      StringBuilder albumesStr = new StringBuilder();
      // AGREGAR EL TITULO DEL ALBUM A LA CADENA
      for (Album album : albumes) {
        albumesStr.append(album.getTitulo()).append(", ");
      }

      // OBTENER LA LISTA DE FANATICOS
      List<Fanatico> fanaticos = p.getFanaticos();
      // CREACION DE CADENA PARA ALMACENAR LA REPRESENTACIÓN DE FANATICOS
      StringBuilder fanaticosStr = new StringBuilder();
      // AGREGAR EL NOMBRE DEL FANATICO A LA CADENA
      for (Fanatico fanatico : fanaticos) {
        fanaticosStr.append(fanatico.getNombre()).append(", ");
      }
      System.out.printf("%-7s %-12s %-10s %-23s %-20s %-18s%n", p.getIdPedido(), p.getDireccionEnvio(),
          p.getEstadoPedido(), articulosStr.toString(), albumesStr.toString(), fanaticosStr.toString());
    }
  }

  // REGISTRAR INFORMACIÓN DE ENVÍO
  public static void RegistrarInformacionEnvio() {
    do {
      // MOSTRAR PEDIDOS DISPONIBLES
      MostrarPedido2();

      // OBTENER EL NÚMERO DEL PEDIDO QUE EL USUARIO DESEA REGISTRAR
      int numeroPedido = Keyboard.readInt("Elija el número del pedido para Registrar Envio (Intro para cancelar): ");
      if (numeroPedido <= 0 || numeroPedido > pedidos.size()) {
        System.out.println("Número de pedido inválido. Intente de nuevo.\n");
        continue;
      }

      // OBTENER EL PEDIDO CORRESPONDIENTE AL NÚMERO INGRESADO
      Pedido pedido = pedidos.get(numeroPedido - 1);

      // VALIDAR QUE EL PEDIDO ESTA EN "ENVIADO" ANTES DE PERMITIR LA ACTUALIZACIÓN
      if (!pedido.getEstadoPedido().equalsIgnoreCase("enviado")) {
        System.out
            .println("No se puede registrar la información de envío para un pedido que no está en estado 'enviado'.");
        System.out.println("Intenta con otro pedido.\n");
        continue;
      }

      // MOSTRAR INFORMACIÓN ANTES DE LA ACTUALIZACIÓN
      System.out.println("\nDatos actuales del pedido\n");
      System.out.println("ID pedido: " + pedido.getIdPedido());
      System.out.println("Artículos: " + pedido.getArticulos());
      System.out.println("Dirección de envío actual: " + pedido.getDireccionEnvio());
      System.out.println("Estado del pedido: " + pedido.getEstadoPedido());

      // SOLICITAR LA NUEVA DIRECCIÓN DE ENVIO AL USUARIO
      String nuevaDireccionEnvio = Keyboard.readString("Nueva dirección de envío (Intro para mantener la actual): ");
      pedido.setDireccionEnvio(nuevaDireccionEnvio.length() > 0 ? nuevaDireccionEnvio : pedido.getDireccionEnvio());

      // MOSTRAR LA INFORMACIÓN DESPUES DE LA ACTUALIZACIÓN
      System.out.println("\nInformación de envío registrada\n");
      System.out.println("ID pedido: " + pedido.getIdPedido());
      System.out.println("Artículos: " + pedido.getArticulos());
      System.out.println("Nueva dirección de envío: " + pedido.getDireccionEnvio());
      System.out.println("Estado del pedido: " + pedido.getEstadoPedido());

      // SALIR DEL BUCLE DESPUÉS DE REGISTRAR LA INFORMACIÓN DE ENVÍO CON ÉXISTO
      break;

    } while (true);
  }

  // ACTUALIZAR EL ESTADO DE LOS PEDIDOS (PENDIENTE, ENVIADO, ENTREGADO)
  public static void ActualizarEstadoPedido() {
    // ELECCIÓN DEL PEDIDO A ACTUALIZAR
    Pedido p = Pedido.MostrarPedido();
    // DATOS ACTUALES DEL PEDIDO
    System.out.println("\nDatos actuales del pedido\n");
    System.out.println("ID pedido: " + p.getIdPedido());
    System.out.println("Artículos: " + p.getArticulos());
    System.out.println("Dirección de envio: " + p.getDireccionEnvio());
    System.out.println("Estado del pedido: " + p.getEstadoPedido());

    // PEDIR NUEVOS DATOS
    System.out.println("\nActualizar el estado del pedido: \n");

    String estadoPedido = Keyboard.readString("Estado del pedido (Pendiente, enviado, entregado): ");
    p.setEstadoPedido(estadoPedido.length() > 0 ? estadoPedido : p.getEstadoPedido());

    // NUEVO ESTADO DEL PEDIDO
    System.out.println("\nNuevo estado del pedido\n");
    System.out.println("Estado del pedido: " + p.getEstadoPedido());

  }

  // ACCESORES Y MUTADORES
  public String getIdPedido() {
    return this.idPedido;
  }

  public void seIdPedido(String idPedido) {
    this.idPedido = idPedido;
  }

  public List<Articulo> getArticulos() {
    return articulos;
  }

  public List<Album> getAlbumes() {
    return albumes;
  }

  public List<Fanatico> getFanaticos() {
    return fanaticos;
  }

  public void setArticulos(List<Articulo> articulos) {
    this.articulos = articulos;
  }

  public String getDireccionEnvio() {
    return direccionEnvio;
  }

  public void setDireccionEnvio(String direccionEnvio) {
    this.direccionEnvio = direccionEnvio;
  }

  public String getEstadoPedido() {
    return estadoPedido;
  }

  public void setEstadoPedido(String estadoPedido) {
    this.estadoPedido = estadoPedido;
  }
}

