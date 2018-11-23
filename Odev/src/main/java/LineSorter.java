import com.lexicalscope.jewel.cli.CliFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class LineSorter {
    public static void sort(CLIOptions options) throws IOException,NullPointerException {
        System.out.println("options.getInput():" + options.getInput());
        System.out.println("options.getLocale():" + options.getLocale());
        System.out.println("options.getOutput():" + options.getOutput());
        System.out.println("options.isIgnoreCase():" + options.isIgnoreCase());
        System.out.println("options.isReverse():" + options.isReverse());
        File input = new File(options.getInput());
        Path path = Paths.get(input.getAbsolutePath());
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        lines.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ("true".equalsIgnoreCase(options.isReverse())) {
                    // ters sırala
                    if ("true".equalsIgnoreCase(options.isIgnoreCase())) {
                        //küçük büyüğe bakmadan karşılaştır
                        return o2.compareToIgnoreCase(o1);
                    } else {
                        return o2.compareTo(o1);
                    }
                } else {
                    // normal sırala
                    if ("true".equalsIgnoreCase(options.isIgnoreCase())) {
                        return o1.compareToIgnoreCase(o2);
                    } else {
                        return o1.compareTo(o2);
                    }
                }
            }
        });

        if (options.getOutput() == null) {
            System.out.println("After Sorting:");
            for (String counter : lines) {
                System.out.println(counter);
            }
        } else {
            File out = new File(options.getOutput());
            Files.write(Paths.get(out.getAbsolutePath()), lines, StandardCharsets.UTF_8);
            System.out.println("sort result written to :" + out.getAbsolutePath());
        }
    }

    public static void main(String[] args) throws IOException,NullPointerException {
        CLIOptions options = CliFactory.parseArguments(CLIOptions.class, args);
        LineSorter.sort(options);
    }
}
