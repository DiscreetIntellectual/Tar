import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.*;

public class TarCombine {

    public void combine(ArrayList<String> fileNames, String mainFile) {
        try {
            BufferedWriter result = new BufferedWriter(new FileWriter(mainFile));
            for (String name: fileNames) {
                List<String> all = Files.readAllLines(Paths.get(name));
                result.write("***" + name + "***" + Integer.toString(all.size()) + "***\n");
                for (String unit: all)
                    result.write(unit + "\n");
            }
            result.close();
        }
        catch (Exception e) {
            throw new IllegalArgumentException("I think something is wrong with your files...");
        }
    }

}
