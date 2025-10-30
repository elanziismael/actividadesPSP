import java.io.File;
import java.io.IOException;



public class Main {
    public static void main(String[] args)throws IOException, InterruptedException {

        try{

            ProcessBuilder pb = new ProcessBuilder("cat", "/etc/passwd").inheritIO();
            pb.redirectOutput(new File("salida.txt"));
            pb.redirectError(new File("error.txt"));

            try{
                Process p = pb.start();
                p.waitFor();
                System.out.println("Finalizado");
            }
                
                      
        }catch(Exception ex){
            System.err.println(ex);
        }

    }
}
digo de salida: " + codigo