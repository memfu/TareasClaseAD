import java.io.File;
import java.util.Arrays;

public class Entrada {

    public static void main(String[] args) {
        // FILE -> fichero logico -> fisico
        // fichero logico
        // File ficheroSinPuntero = new File("/Users/borja/Documents/GitHub/ClaseAD-UNIR/T1/Fichero/src/resources/directorio/ejemplo_fichero.md");
        File ficheroSinPuntero = new File("src/resources/directorio");
        File carpetaPersonal = new File("/home/david/Documentos");
        //System.out.println(ficheroSinPuntero.getName());
        //System.out.println(ficheroSinPuntero.getParent());
        //System.out.println(ficheroSinPuntero.length());
        //System.out.println(ficheroSinPuntero.exists());
        //System.out.println(ficheroSinPuntero.isDirectory());
        // File[] -> todos los FICHEROS que estan dentro del directorio
        //ficheroSinPuntero.listFiles();
        // String[] -> todas las rutas de los FICHEROS que estan dentro del directorio
        //ficheroSinPuntero.list();

        // 1 -> Obtener todos los nombre de los ficheros del directorio llamado directorio
        System.out.println("""
                
                ____EJERCICIO 1____""");
        listarContenido(ficheroSinPuntero);
        // 2 -> Crear una subcarpeta en el directorio llamado directorio y crear en ella un fichero
        System.out.println("""
                
                ____EJERCICIO 2____""");
        crearContenido(ficheroSinPuntero, "SUBCARPETA", "FICHERO");
        //   -> Obtener todos los nombre de los ficheros del directorio llamado directorio y el subdirectorio creado
        System.out.println("""
                
                ____EJERCICIO 3____""");
        contenidoRecursividad(ficheroSinPuntero);
        // 3 -> Listar el nombre de todos los ficheros del SISTEMA ( C:/User o /Users )
        System.out.println("""
                
                ____EJERCICIO 4____""");
        contenidoRecursividad(carpetaPersonal);

        // RECURSIVIDAD

        /*if (!ficheroSinPuntero.exists()) {
            try {
                ficheroSinPuntero.createNewFile();
            } catch (IOException e) {
                System.out.println("Fallo en la creacion del fichero");
            }
        }*/
    }

    public static void listarContenido(File uri) {
        if (uri.isDirectory()) {
            System.out.println(Arrays.toString(uri.list()));
        } else {
            System.out.println("No es un directorio");
        }
    }

    public static void crearContenido(File uri, String nombreCarpeta, String nombreFichero) {
        var contenido = uri.listFiles();
        var existe = false;
        for (File f : contenido) {
            if (f.isDirectory() && f.getName().equalsIgnoreCase(nombreCarpeta)) {
                System.out.println("La carpeta: " + nombreCarpeta + " ya existe.");
                existe = true;
            }
        }
        if (!existe) {
            var nuevaCarpeta = new File(uri, nombreCarpeta);
            nuevaCarpeta.mkdir();
            System.out.println("Se ha creado la carpeta " + nombreCarpeta);
            var nuevoFichero = new File(nuevaCarpeta.getPath(), nombreFichero);
            try {
                nuevoFichero.createNewFile();
            } catch (Exception e) {
                System.out.println("No se pudo crear el fichero " + nombreFichero + e.getMessage());
            }
        }
    }

    public static void contenidoRecursividad(File uri) {
        if (uri.isDirectory()) {
            System.out.println("CARPETA: " + uri.getPath() + "\n     |--------> " + Arrays.toString(uri.list()));
            for (File f : uri.listFiles()) {
                contenidoRecursividad(f);
            }
        }
    }
}
