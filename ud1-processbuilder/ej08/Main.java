import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args)throws IOException, InterruptedException {

        try{

            ProcessBuilder pb = new ProcessBuilder("lssleep 10").inheritIO();
            Process p = pb.start();
            boolean terminado = p.waitFor(2, TimeUnit.SECONDS);
            if(!terminado){
                System.out.println("Tarda demasiado");
            }else{
                System.out.println("finalizado correctamente");
            }
                
                      
        }catch(Exception ex){
            System.err.println(ex);
        }

    }
}
