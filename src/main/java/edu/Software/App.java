package edu.Software;

import java.util.Scanner;
import edu.Software.model.*;
import edu.Software.exceptions.*;

public class App {

    static Scanner in = new Scanner(System.in, "UTF-8").useDelimiter("[\n]+|[\r\n]+");

    public static void main(String[] args) throws Exception {
        System.out.println("-".repeat(90));
        System.out.printf("%50s%n", "ROCK & CODE");
        System.out.println("-".repeat(90));

        do {

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    Artista.CrearArtista();
                    break;
                case 2:
                    try {
                        Banda.CrearBandas();
                    } catch (BandaSinArtistaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    Cancion.CrearCanciones();
                    break;
                case 4:
                    try {
                        Album.CrearAlbum();
                    } catch (AlbumVacioException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    Fanatico.CrearFanatico();
                    break;
                case 6:
                    try {
                        Concierto.CrearConcierto();
                    } catch (ConciertoSinCancionesException e) {
                        System.out.println(e.getMessage());
                    } catch (ConciertoSinBandaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    Articulo.CrearArticulo();
                    break;
                case 8:
                    Pedido.CrearPedido();
                    break;
                case 9:
                    new Banda().ActualizarInfoBanda();
                    break;
                case 10:
                    Pedido.ActualizarEstadoPedido();
                    break;
                case 11:
                    //System.out.println("Mostrar Fanaticos concierto");
                    Fanatico.MostrarFanaticosPorConcierto();
                    break;
                case 12:
                    Banda.MostrarBanda2();
                    break;
                case 13:
                    Pedido.MostrarPedido2();
                    break;
                case 14:
                    Artista.MostrarArtista();
                    break;
                case 15:
                    Articulo.MostrarArticulos();
                    break;
                case 16:
                    Cancion.MostrarCanciones();
                    break;
                case 17:
                    Album.MostrarAlbum();
                    break;
                case 18:
                    Concierto.MostrarConcierto();
                    break;
                case 19:
                    Fanatico.MostrarFanaticos();
                    break;
                case 20:
                    Pedido.RegistrarInformacionEnvio();// FALTA IMPLEMENTAR !!!!!!
                    break;
                case 99:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (true);

    }

    private static int leerOpcion() {
        String opciones = "\nMenú de opciones:\n"
                + " 1 - Crear artistas                                 11 - Mostrar fanáticos del concierto \n"
                + " 2 - Crear banda                                    12 - Mostrar banda                   \n"
                + " 3 - Crear canciones                                13 - Mostrar pedido                  \n"
                + " 4 - Crear álbum                                    14 - Mostrar artista                 \n"
                + " 5 - Crear fanáticos                                15 - Mostrar artículos               \n"
                + " 6 - Crear conciertos                               16 - Mostrar canciones               \n"
                + " 7 - Crear artículos                                17 - Mostrar álbum                   \n"
                + " 8 - Crear pedidos                                  18 - Mostrar concierto               \n"
                + " 9 - Actualizar información de la banda             19 - Mostrar fanáticos               \n"
                + "10 - Actualizar estado del pedido                   20 - Registrar información de envío  \n"
                + "\nElija una opción (99 para salir) > ";

        System.out.print(opciones);
        int opcion = in.nextInt();
        System.out.println();
        return opcion;
    }
}
