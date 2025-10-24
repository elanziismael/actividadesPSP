import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        ProcessBuilder pb = new ProcessBuilder("pwd").directory(new File("/tmp"));
        Process proceso = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
        
        String linea;
        while ((linea = reader.readLine()) != null) {
            System.out.println(linea);  
        }

        while ((linea = errorReader.readLine()) != null) {
            System.err.println(linea);  
        }
        
        int codigoSalida = proceso.waitFor();

        if(codigoSalida == 0){
            System.out.println("Resultado: Éxito");
        } else {
            System.out.println("Resultado: Error");
        }

        

    }
    
}
