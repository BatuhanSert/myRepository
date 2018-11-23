import com.lexicalscope.jewel.cli.Option;

public interface CLIOptions {

    @Option(shortName = "l", longName = "locale", description = "The locale. [defaults to en-US]", defaultValue = "en_US")
    String getLocale();

    @Option(shortName = "r", longName = "reverse", description = "Reverse the result of comparisons", defaultValue = "false")
    String isReverse();

    @Option(shortName = "i", longName = "ignore-case", description = "Fold lower case to upper case characters using supplied locale", defaultValue = "false")
    String isIgnoreCase();

    @Option(shortName = "o", longName = "output", description = "Write results to FILE instead of standard output", defaultToNull = true)
    String getOutput();

    @Option(shortName = "f", longName = "input", description = "Input file that contains lines to be sorted")
    String getInput();
}
