package controller;

import java.io.*;
import java.sql.Statement;
import java.util.Scanner;

public class GestorFicherosConjuntos {

    public void lecturaEscritura(String path){
        Scanner scanner = new Scanner(System.in);
        File file = new File(path);
        FileWriter fileWriter = null;

        System.out.println("Por favor, introduce el mensaje que quieres guardar.");
        String mensaje = scanner.nextLine();
        //este es el contenido del examen

        try {
            //
            fileWriter = new FileWriter(file,false);
            for (int i = 0; i < mensaje.length(); i++) {
                char letra = mensaje.charAt(i);
                //fileWriter.write(letra+"\n");
                int codigo = (int)letra;
                // System.out.println("codigo = " + codigo);
                //fileWriter.write("123");
                fileWriter.write(String.valueOf(codigo*5)+"\n");
            }
        } catch (IOException e) {
            System.out.println("Error en los permisos");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Fallo en el cerrado");
            }
        }
    }

    public void descifrado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, introduce la ruta del fichero que quieres descrifrar.");
        String path = scanner.nextLine();

        File file = new File(path);
        FileReader fileReader = null;

        try {
            // Hace la lectura en formato de bytes y por lo tanto no es comprensible
            fileReader = new FileReader(file);
            // Necesitamos un objeto bufferedreader para leer el contenido en formato carácter
            BufferedReader lector = new BufferedReader(fileReader);

            String linea;
            StringBuilder mensajeDescifrado = new StringBuilder();

            while ((linea = lector.readLine()) !=null) {
                int codigo = Integer.parseInt(linea);
                int descifrado = codigo/5;
                char letra = (char) (descifrado);
                mensajeDescifrado.append(letra);
            }  System.out.println(mensajeDescifrado);
            lector.close();
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero.");
        } finally {
            try {
                fileReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Fallo en el cerrado.");
            }
        }

    }
}
