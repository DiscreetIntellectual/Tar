import org.junit.jupiter.api.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;


public class TarTest {

    String tar1 = "src/test/f1.txt src/test/f2.txt -out src/test/output.txt";
    String reverse1 = "-u src/test/output.txt";

    String tar2 = "src/test/f1.txt -out src/test/newOut.txt";
    String reverse2 = "-u src/test/newOut.txt";

    @Test
    void test1() {
        TarParse.main(tar1.split(" "));
        TarParse.main(reverse1.split(" "));
        try {
            assertEquals(Files.readAllLines(Paths.get("src/test/f1.txt")),
                    Files.readAllLines(Paths.get("src/test/safezone/f1.txt")));
            assertEquals(Files.readAllLines(Paths.get("src/test/f2.txt")),
                    Files.readAllLines(Paths.get("src/test/safezone/f2.txt")));
        }
        catch (Exception e) {
            throw new IllegalArgumentException("I think something's wrong with your files...");
        }
    }

    @Test
    void test2() {
        TarParse.main(tar2.split(" "));
        TarParse.main(reverse2.split(" "));
        try {
            assertEquals(Files.readAllLines(Paths.get("src/test/f1.txt")),
                    Files.readAllLines(Paths.get("src/test/safezone/f1.txt")));
        }
        catch (Exception e) {
            throw new IllegalArgumentException("I think something's wrong with your files...");
        }
    }
}
