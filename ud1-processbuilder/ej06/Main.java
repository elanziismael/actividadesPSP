public class Main {

    public static void main(String[] args) {

        try {
        ProcessBuilder pb = new ProcessBuilder("bash","-lc","printenv MI_VAR").inheritIO();
        pb.environment().put("MI_VAR","UD1");

        Process proceso = pb.start();

        proceso.waitFor();

        } catch (Exception ex) {
            System.err.println(ex);
        }
        
    }
    
}
