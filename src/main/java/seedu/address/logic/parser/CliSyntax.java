package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    public static final Prefix PREFIX_SECTION_TYPE = new Prefix("~");
    public static final Prefix PREFIX_TITLE = new Prefix("t/");
    public static final Prefix PREFIX_SUBHEADER = new Prefix("s/");
    public static final Prefix PREFIX_TAGS = new Prefix("#");
    public static final Prefix PREFIX_DURATION = new Prefix("d/");

}
