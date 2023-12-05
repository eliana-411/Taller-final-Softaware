package edu.prog2;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import edu.prog2.controllers.*;
import edu.prog2.helpers.UtilFiles;
import edu.prog2.model.*;

public class AppFileTests {
    public static void main(String[] args) throws Exception {
        boolean existe = UtilFiles.fileExists("./pom.xml");
        System.out.println("¿Existe pom.xml? = " + existe);

        existe = UtilFiles.fileExists("./src/main/java/edu/prog2/helpers/Keyboard.java");
        System.out.println("¿Existe Keyboard.java? = " + existe);

        existe = UtilFiles.fileExists("./src/main/java/edu/prog2/helpers/");
        System.out.println("¿Existe helpers? = " + existe);

        existe = UtilFiles.pathExists("./target/classes/edu/other");
        System.out.println("¿Existe other? = " + existe);

        existe = UtilFiles.pathExists("./src/main/java/edu/prog2/helpers/");
        System.out.println("¿Existe helpers? = " + existe);

        existe = UtilFiles.pathExists("./src/main/java/edu/prog2/model/Cliente.java");
        System.out.println("¿Existe Cliente.java? = " + existe);

        try {
            UtilFiles.createFolderIfNotExist("./data/prueba1");
            System.out.println("Carpeta \"./data/prueba1\" lista para ser usada");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            UtilFiles.createFolderIfNotExist("./data/prueba1/pdfs");
            System.out.println("Carpeta \"./data/prueba1/pdfs\" lista para ser usada");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            UtilFiles.createFolderIfNotExist("./data/prueba1/textos");
            System.out.println("Carpeta \"./data/prueba1/textos\" lista para ser usada");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            UtilFiles.createFolderIfNotExist("./data/prueba2");
            System.out.println("Carpeta \"./data/prueba2\" lista para ser usada");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            UtilFiles.createFolderIfNotExist("./data/prueba2/docs");
            System.out.println("Carpeta \"./data/prueba2/docs\" lista para ser usada");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            UtilFiles.createFolderIfNotExist("./data/prueba2/docs/nuevos");
            System.out.println("Carpeta \"./data/prueba2/docs/nuevos\" lista para ser usada");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            UtilFiles.createFolderIfNotExist("./data/prueba2/docs/viejos");
            System.out.println("Carpeta \"./data/prueba2/docs/viejos\" lista para ser usada");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            UtilFiles.createFolderIfNotExist("./data/prueba2/videos");
            System.out.println("Carpeta \"./data/prueba2/videos\" lista para ser usada");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(
                UtilFiles.getPath("./src/main/java/edu/prog2/controllers/CtrlVentas.java"));
        System.out.println(UtilFiles.getPath("./src/main/java/edu/prog2/controllers/"));

        try {
            UtilFiles.initPath("./data/varios/prueba.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ArrayList<String> jugadores = new ArrayList<>();
            jugadores.add("Diego Armando Maradona");
            jugadores.add("Lionel Messi");
            jugadores.add("Cristiano Ronaldo");
            jugadores.add("Johan Cruyff");
            jugadores.add("Franz Beckenbauer");
            UtilFiles.writeText(jugadores, "./data/jugadores.txt");

            CtrlClientes clientes = new CtrlClientes();
            clientes.add(new Cliente("C01", "Jorge Pérez", "8880001"));
            clientes.add(new Cliente("C02", "Lucas García", "80002"));
            clientes.add(new Cliente("C03", "Andrea Pérez", "8880003"));
            UtilFiles.writeText(clientes.getList(), "./data/clientes.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            CtrlProductos productos = new CtrlProductos();
            productos.add(new Producto("Salsa de Tomate Fruco", 4000, 8, LocalDate.of(2022, 06, 15)));
            productos.add(new Producto("Café Luker", 4500, 3, LocalDate.of(2022, 04, 22)));
            productos.add(new Producto("Libra Arroz Diana", 2800, 20, LocalDate.of(2022, 05, 30)));
            UtilFiles.writeText(productos.getList(), "./data/productos.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String filePath = "./src/main/java/edu/prog2/model/Cliente.java";
            String texto = UtilFiles.readText(filePath);
            System.out.println(texto);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            CtrlClientes clientes = new CtrlClientes();
            clientes.add(new Cliente("C01", "Jorge Pérez", "8880001"));
            clientes.add(new Cliente("C02", "Lucas García", "80002"));
            clientes.add(new Cliente("C03", "Andrea Pérez", "8880003"));
            UtilFiles.writeCSV(clientes.getList(), "./data/clientes.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
