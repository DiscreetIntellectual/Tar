import java.io.*;
import java.nio.file.*;
import java.util.List;

public class TarSplit {

    public void split(String sourcePath) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(sourcePath));
            String name;
            BufferedWriter output = null;
            int count = 0;
            for (String line: allLines) {
                if (count == 0) {
                    if (output != null) output.close();
                    String[] schism = line.split("\\*\\*\\*");
                    name = schism[1];
                    int length = Integer.parseInt(schism[2]);
                    output = new BufferedWriter(new FileWriter(name));
                    count = length;
                }
                else {
                    count--;
                    output.write(line + "\n");
                }
            }
            output.close();
        }
        catch (Exception e) {
            throw new IllegalArgumentException("I think something's wrong with your files...");
        }
    }

}
