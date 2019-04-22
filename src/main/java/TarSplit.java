import java.io.*;
import java.nio.file.*;
import java.util.List;

public class TarSplit {

    public void split(String sourcePath) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(sourcePath));
            String name;
            BufferedWriter output = new BufferedWriter(new FileWriter("src/test/safezone/safefile.txt"));
            int count = 0;
            for (String line: allLines) {
                if (count == 0) {
                    output.close();
                    String[] schism = line.split("\\*\\*\\*");
                    name = schism[1];
                    int length = Integer.parseInt(schism[2]);
                    new File(name).createNewFile();
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
