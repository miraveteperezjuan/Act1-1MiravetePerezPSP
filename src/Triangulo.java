import java.time.LocalDateTime;

public class Triangulo {

    //El constructor vario se utiliza para crear objetos de la clase triangulo
    public Triangulo() {
    }

    public static void main(String[] args) {

        //LocalDateTime.now(): Captura la fecha y hora actual y el string.valueOf la imprime en consola en formato texto.
        System.out.println("Fecha y hora de inicio: " + String.valueOf(LocalDateTime.now()));

        //args: Es una lista que contiene los argumentos pasados al programa.
        if (args.length == 0) {
            System.out.println("Se requiere un argumento");
        } else {
            //Integer.parseInt(...): Convierte ese argumento de texto a número entero.
            int filas = Integer.parseInt(args[0]);
            //dibujo del triángulo invertido
            for(int i = filas; i >= 1; --i) {
                for(int n = 1; n <= i; ++n) {
                    System.out.print(n);
                }

                System.out.println();
            }

            System.out.println("Fecha y hora de finalización: " + String.valueOf(LocalDateTime.now()));
        }
    }
}