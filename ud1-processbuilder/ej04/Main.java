import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        
        try {
            new ProcessBuilder("bash","-lc","top -b -n1").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        

    }
    
}
