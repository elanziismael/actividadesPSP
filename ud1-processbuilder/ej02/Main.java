import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("bash", "-lc", "ls -l");

        try {
            Process proceso = pb.start();
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(proceso.getInputStream())
            );

            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            int codigoSalida = proceso.waitFor();
            
            if (codigoSalida == 0) {
                System.out.println("Resultado: Éxito");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error de E/S al ejecutar el proceso: " + e.getMessage());
        }
    }
    
}
