import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.Option;
import java.util.ArrayList;
import java.util.Arrays;

public class TarParse {

    @Argument(usage = "List of files to combine")
    private ArrayList<String> files;

    @Option(name = "-out", usage = "Output file")
    private String outFile;

    @Option(name = "-u", usage = "File to split")
    private String fileToSplit;

    private void parse(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        }
        catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("Expected command: [file1.txt file2.txt ... -out output.txt] " +
                    "or [-u filename.txt]");
            parser.printUsage(System.err);
            return;
        }

        if (files == null)
            new TarSplit().split(fileToSplit);
        else
            new TarCombine().combine(files, outFile);
    }

    public static void main(String[] args) {
        new TarParse().parse(args);
    }

}
