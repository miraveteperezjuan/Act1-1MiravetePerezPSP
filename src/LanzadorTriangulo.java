import java.io.File;
import java.io.IOException;

public class LanzadorTriangulo {

    // Constructor de la clase LanzadorTriangulo
    public LanzadorTriangulo() {
    }

    public static void main(String[] args) {
        // Definimos un array con los lados de los triángulos que queremos procesar.
        int[] ladosTriangulos = {5, 7, 9};

        // Obtenemos el classpath del sistema para localizar las clases necesarias.
        String classpath = System.getProperty("java.class.path");

        // Iteramos por cada valor del array para procesarlo.
        for (int lado : ladosTriangulos) {
            // Creamos un comando para ejecutar el programa Triangulo con el lado actual.
            ProcessBuilder proceso = new ProcessBuilder("java", "-cp", classpath, "Triangulo", String.valueOf(lado));

            // Redirigimos la salida del programa Triangulo a un archivo específico.
            proceso.redirectOutput(new File("triangulo" + lado + ".txt"));

            // Redirigimos los errores a un archivo común para todos los procesos.
            proceso.redirectError(new File("errores.txt"));

            // Intentamos iniciar el proceso, si no lo recogemos la excepción que saldrá por errrores.
            try {
                proceso.start();
                System.out.println("El proceso del triángulo con lado " + lado + " ha sido lanzado.");
            } catch (IOException e) {
                System.err.println("Error al iniciar el proceso para el triángulo con lado " + lado + ": " + e.getMessage());
            }
        }
    }
}
