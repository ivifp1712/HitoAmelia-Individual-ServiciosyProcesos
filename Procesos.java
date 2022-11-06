
import java.io.File;

public class Procesos {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "Principal", "Pepe", "Juan", "Luis");

        pb.redirectOutput(new File("examen1.txt"));
        pb.redirectError(new File("error1.txt"));
        try {
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProcessBuilder pb2= new ProcessBuilder("java", "Principal", "Rosa", "Miguel", "Pedro");
        pb2.redirectOutput(new File("examen2.txt"));
        pb2.redirectError(new File("error2.txt"));
        try {
            Process p2 = pb2.start();
            p2.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
