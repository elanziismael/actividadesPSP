import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args)throws IOException, InterruptedException {

        try{

            File tmp = File.createTempFile("pipe", "txt");

            ProcessBuilder pb1 = new ProcessBuilder("bash", "-lc", "echo 'hola mundo'");
            pb1.redirectOutput(tmp);
            Process proceso1 = pb1.start();
            int codigoP1 = proceso1.waitFor();

            ProcessBuilder pb2 = new ProcessBuilder("bash", "-lc", "wc -w");
            pb2.redirectInput(tmp);
            Process proceso2 = pb2.start();
            String salida = new String(proceso2.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            proceso2.waitFor();

            System.out.println(salida);

            Files.deleteIfExists(tmp.toPath());

        }catch(IOException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();

        }


    }
}
