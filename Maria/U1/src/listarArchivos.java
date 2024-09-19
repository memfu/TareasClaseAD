import java.io.File;
import java.io.IOException;

// Aclaracion: Archivo puede ser directorio o fichero
// Metodo recursivo
public class listarArchivos {
    public static void listadoArchivos(File directorio){
        String saltoDeLinea = "\n";
        // Comprueba que el directorio existe y es un directorio
        if(directorio.exists() && directorio.isDirectory()) {
            // Hace un listado de los archivos dentro del directorio
            File[] archivos = directorio.listFiles();
            // Comprueba que el directorio no este vacio
            if(archivos != null) {
                // Recorre cada archivo
                for (File archivo : archivos) {
                    // Comprueba si el archivo es un directorio, en caso positivo le pasa el metodo de forma recursiva
                    if(archivo.isDirectory()) {
                        // Se imprime el directorio antes de explorar su contenido.
                        System.out.println("Directorio: " + archivo.getName());
                        listadoArchivos(archivo);
                    } else {
                        System.out.println("Fichero: " + archivo.getName());
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        String saltoDeLinea = System.lineSeparator();
        /*
    Parte 1: Listar el nombre de todos los ficheros ubicados en un directorio
    (en clase hemos puesto como ejemplo un directorio creado en el paquete resources)
    */
        // Mi directorio elegido
        // Ejemplo de primer constructor
        File directorioMaria = new File ("/Users/maria/Desktop/UNIR DAM");
        File [] listaArchivos = directorioMaria.listFiles();
        for (File archivo : listaArchivos) {
            System.out.println(archivo);
        }
        System.out.println(saltoDeLinea);
    /*
    Parte 2: Crear una subcarpeta en el directorio llamado directorio y crear en ella un fichero
     Obtener todos los nombres de los ficheros del directorio llamado directorio y el subdirectorio creado
    */
        // Comprueba si hay derechos de escritura en el directorio
        if (directorioMaria.canWrite()) {
            System.out.println("El directorio tiene permisos de escritura.");
            // Ejemplo de segundo constructor
            File nuevoDirectorio = new File("/Users/maria/Desktop/UNIR DAM", "nuevoDirectorio");
            // Ejemplo de tercer constructor
            File nuevoFichero = new File(nuevoDirectorio, "ejemplo.md");
            try {
                // Crea el nuevo directorio
                if (!nuevoDirectorio.exists()) {
                    nuevoDirectorio.mkdir();
                    System.out.println("El subdirectorio se ha creado correctamente.");
                } else {
                    System.out.println("El subdirectorio no se ha podido crear, porque ya existe.");
                }
                // Crea el nuevo fichero
                if (!nuevoFichero.exists()) {
                    nuevoFichero.createNewFile();
                    System.out.println("El fichero se ha creado correctamente." + saltoDeLinea);
                    // Tiene que estar aqui dentro para que que aparezcan los nuevos cambios
                    File [] listaArchivosSub = nuevoDirectorio.listFiles();
                    System.out.println("Nombres de los ficheros dentro del directorio: ");
                    for (File archivo : listaArchivos) {
                        System.out.println(archivo);
                    }
                    System.out.println(saltoDeLinea);
                    System.out.println("Nombres de los ficheros dentro del subdirectorio: ");
                    for (File archivoSub : listaArchivosSub) {
                        System.out.println(archivoSub);
                    }
                    System.out.println(saltoDeLinea);
                } else {
                    System.out.println("El fichero no se ha podido crear, porque ya existe.");
                    System.out.println(saltoDeLinea);
                }
            } catch (IOException e) {
                System.out.println("Fallo en la creación del fichero.");
            }

        } else {
            System.out.println("No tiene permiso de escritura.");
        }

        /*
    Parte 3: Listar el nombre de todos los ficheros y directorios de una ruta concreta,
    como por ejemplo C:/Users
    Para la parte 3 tenéis que utilizar el concepto de recursividad.
    Investigad a que se refiere ese término y en la clase del jueves lo trataremos,
    así como la resolución del ejercicio.
    */
        File directorioAD = new File ("/Users/maria/Desktop/UNIR DAM/01-AD");
        // Llamo al metodo con mi directorio como argumento
        listadoArchivos(directorioAD);
    }


}
