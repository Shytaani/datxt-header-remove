import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class HeaderRemover {
    
    public static void main(String[] args) {
        
        final String BASE_PATH = "data";

        Path target = Path.of(BASE_PATH, "test.dat");
        
        List<String> lines = null;
        
        try {
            lines = Files.lines(target).collect(Collectors.toList());
            lines.remove(0);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try (
            FileWriter fw = new FileWriter(Path.of(BASE_PATH, "test_no_header_java.csv").toFile());
            BufferedWriter bw = new BufferedWriter(fw);
        ) {
            fw.write(String.join("\n", lines));
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
