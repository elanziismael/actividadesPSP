import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            int codigoSalida = new ProcessBuilder("echo", "hola").inheritIO().start().waitFor();

            if (codigoSalida == 0) {
                System.out.println("Resultado: Éxito");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar el proceso: " + e.getMessage());
        }
    }
    
}
