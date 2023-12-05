package edu.Software.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Keyboard {

  /**
   * Utilidad basada en la clase Scanner para el ingreso básico validado de datos
   * por consola
   */

  // Atributos
  public static char ENTER = 13;
  public static Scanner sc = new Scanner(System.in).useDelimiter("[\n]+|[\r\n]+");

  // Metodos
  public static String readString(String mensaje) {
    System.out.print(mensaje);
    return sc.nextLine();
  }

  public static int readInt(int from, int to, String mensaje) {
    int value;
    do {
      value = readInt(mensaje);
      if (value < from || value > to) {
        System.out.print("Rango inválido. ");
      }
    } while (value < from || value > to);
    return value;
  }

  public static int readInt(int from, String mensaje) {
    int value;
    do {
      value = readInt(mensaje);
      if (value < from) {
        System.out.print("Rango inválido. ");
      }
    } while (value < from);
    return value;
  }

  public static int readInt(String mensaje, int to) {
    int value;
    do {
      value = readInt(mensaje);
      if (value > to) {
        System.out.print("Rango inválido. ");
      }
    } while (value > to);
    return value;
  }

  public static int readInt(String mensaje) {
    boolean ok;
    int value = Integer.MIN_VALUE;
    System.out.print(mensaje);

    do {
      try {
        ok = true;
        value = sc.nextInt();
      } catch (InputMismatchException e) {
        ok = false;
        System.out.print(">> Valor erróneo. " + mensaje);
      } finally {
        sc.nextLine();
      }
    } while (!ok);

    return value;
  }

  public static long readLong(long from, long to, String mensaje) {
    long value;
    do {
      value = readLong(mensaje);
      if (value < from || value > to) {
        System.out.print("Rango inválido. ");
      }
    } while (value < from || value > to);
    return value;
  }

  public static long readLong(long from, String mensaje) {
    long value;
    do {
      value = readLong(mensaje);
      if (value < from) {
        System.out.print("Rango inválido. ");
      }
    } while (value < from);
    return value;
  }

  public static long readLong(String mensaje, long to) {
    long value;
    do {
      value = readLong(mensaje);
      if (value > to) {
        System.out.print("Rango inválido. ");
      }
    } while (value > to);
    return value;
  }

  public static long readLong(String mensaje) {
    boolean ok;
    long value = Long.MIN_VALUE;
    System.out.print(mensaje);

    do {
      try {
        ok = true;
        value = sc.nextLong();
      } catch (InputMismatchException e) {
        ok = false;
        System.out.print(">> Valor erróneo. " + mensaje);
      } finally {
        sc.nextLine();
      }
    } while (!ok);

    return value;
  }

  public static double readDouble(double from, double to, String mensaje) {
    double value;
    do {
      value = readDouble(mensaje);
      if (value < from || value > to) {
        System.out.print("Rango inválido. ");
      }
    } while (value < from || value > to);
    return value;
  }

  public static double readDouble(double from, String mensaje) {
    double value;
    do {
      value = readDouble(mensaje);
      if (value < from) {
        System.out.print("Rango inválido. ");
      }
    } while (value < from);
    return value;
  }

  public static double readDouble(String mensaje, double to) {
    double value;
    do {
      value = readDouble(mensaje);
      if (value > to) {
        System.out.print("Rango inválido. ");
      }
    } while (value > to);
    return value;
  }

  public static double readDouble(String mensaje) {
    boolean ok;
    double value = Double.NaN;
    System.out.print(mensaje);

    do {
      try {
        ok = true;
        value = sc.nextDouble();
      } catch (InputMismatchException e) {
        ok = false;
        System.out.print(">> Valor erróneo. " + mensaje);
      } finally {
        sc.nextLine();
      }
    } while (!ok);

    return value;
  }

  public static boolean readBoolean(String message, String msgError) {
    msgError = msgError + "\n" + message;
    boolean ok;
    boolean value = false;
    System.out.print(message);

    do {
      try {
        String str = " " + sc.nextLine().toLowerCase().trim() + " ";
        if (str.trim().length() == 0) {
          ok = false;
        } else if (" si s true t ".contains(str)) {
          value = true;
        } else if (" no n false  f ".contains(str)) {
          value = false;
        } else {
          throw new InputMismatchException();
        }
        ok = true;
      } catch (Exception e) {
        ok = false;
        System.out.println(msgError);
      }
    } while (!ok);
    return value;
  }

  public static boolean readBoolean(String message) {
    return readBoolean(message, "Se esperaba [si|no|true|false|s|n|t|f]");
  }

  /**
   * Retorna el primer caracter de una cadena.
   * 
   * @param message La petición de entrada que se hace al usuario
   * @return El primer caracter de la cadena ingresada
   */
  public static char readChar(String message) {
    char c = ENTER;
    System.out.print(message);

    String aux = sc.nextLine();
    if (aux.length() > 0) {
      c = aux.charAt(0);
    }

    return c;
  }

  public static LocalDate readDate(LocalDate from, LocalDate to, String mensaje) {
    LocalDate value;
    do {
      value = readDate(mensaje);
      if (value.isBefore(from) || value.isAfter(to)) {
        System.out.print("Rango de fecha inválido. ");
      }
    } while (value.isBefore(from) || value.isAfter(to));
    return value;
  }

  public static LocalDate readDate(LocalDate from, String mensaje) {
    LocalDate value;
    do {
      value = readDate(mensaje);
      if (value.isBefore(from)) {
        System.out.print("Rango de fecha inválido. ");
      }
    } while (value.isBefore(from));
    return value;
  }

  public static LocalDate readDate(String mensaje, LocalDate to) {
    LocalDate value;
    do {
      value = readDate(mensaje);
      if (value.isAfter(to)) {
        System.out.print("Rango de fecha inválido. ");
      }
    } while (value.isAfter(to));
    return value;
  }

  /**
   * Permite leer una fecha en cualquier formato válido. Si ingresa "hoy" se
   * asigna la fecha actual
   * 
   * @param mensaje La petición de la fecha o la fecha y la hora
   * @return Un objeto de tipo Calendar con la hora ingresada
   */
  public static LocalDate readDate(String mensaje) {
    boolean ok;
    LocalDate date = LocalDate.now();
    System.out.print(mensaje);

    do {
      try {
        ok = true;
        String strDate = sc.next();
        if (!strDate.toLowerCase().equals("hoy")) {
          date = LocalDate.parse(strDate);
        }
      } catch (DateTimeParseException dtps) {
        ok = false;
        System.out.print(">> Fecha errónea. " + mensaje);
      } finally {
        sc.nextLine();
      }
    } while (!ok);

    return date;
  }

  /**
   * Leer cualquier tipo de enumeración como un String
   * Ver
   * https://www.tabnine.com/code/java/methods/java.lang.Enum/getDeclaringClass
   * Ejemplo: TipoBanio t = Keyboard.readEnum(TipoBanio.class, "Tipo de baño: ");
   * 
   * @param <T>     El tipo de enumeración que se retorna
   * @param c       El tipo de enumeración que se lee. Si es nulo no se hace la
   *                lectura
   * @param mensaje La petición para la enumeración
   * @return Retorna el tipo correspondiente al string ingresado o nulo si no se
   *         ingresa un string
   */
  public static <T extends Enum<T>> T readEnum(Class<T> c, String mensaje) {
    boolean ok;
    System.out.print(mensaje);

    if (c != null) {
      do {
        ok = true;
        try {
          String type = sc.nextLine().trim().toUpperCase();
          return type.length() > 0 ? Enum.valueOf(c, type) : null;
        } catch (IllegalArgumentException ex) {
          ok = false;
          System.out.printf(">> %s no incluye el valor dado. %s", c.getSimpleName(), mensaje);
        }
      } while (!ok);
    }

    return null;
  }

}