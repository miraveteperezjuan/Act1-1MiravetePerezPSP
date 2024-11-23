import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LanzadorTriangulo1 {

    //El constructor vario se utiliza para crear objetos de la clase triangulo
    public LanzadorTriangulo1() {
    }

    public static void main(String[] args) {
        //Scanner para pedir el número de lados que tendrá nuestro triangulo
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número entero: ");

        if (scanner.hasNextInt()) {
            int num1 = scanner.nextInt();

            //El classpath es como una lista de lugares donde Java buscará las clases necesarias para ejecutar el programa.
            String classpath = System.getProperty("java.class.path");

            //Usa ProcessBuilder para crear un comando que ejecute el programa Triangulo
            //Con el String.valueOf se pasa el número de lados que va a tener el triangulo
            // cp y classpath llama al intérprete de Java. Es el comando que ejecuta cualquier programa escrito en Java.
            ProcessBuilder proceso = new ProcessBuilder(new String[]{"java", "-cp", classpath, "Triangulo", String.valueOf(num1)});

            //El archivo de SALIDA será dirigido a un nuevo archivo llamado triangulo
            proceso.redirectOutput(new File("triangulo.txt"));

            //En el caso de dar algún error se creará un archivo donde se pondrá el motivo del error.
            proceso.redirectError(new File("errores.txt"));

            //Intenta ejecutar el proceso, si no saca el error de salida.
            try {
                proceso.start();
                System.out.println("El proceso ha sido lanzado con éxito");
                System.out.println("Examina los archivos salida.txt y errores.txt");
            } catch (IOException e) {
                System.out.println("Error en la salida" + e.getMessage());
            }
            //Tienes que introducir un número valido para que funcione el programa.
        } else {
            System.out.println("Error. Debes de introducir un número entero válido");
        }

        //Se cierra el scanner
        scanner.close();
    }
}
