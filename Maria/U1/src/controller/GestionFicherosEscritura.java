package controller;

import java.io.*;
import java.util.Scanner;

public class GestionFicherosEscritura {

    public void escribirFichero(String path) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nombre del fichero que quiere guardar.");
        String nombreFichero = scanner.next();
        File fichero = new File(path+nombreFichero+".txt");


    }
}
