package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DURATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SECTION_TYPE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SUBHEADER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAGS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.entry.MajorEntry;

public class AddEntryCommand extends Command{
    public static final String COMMAND_WORD = "addEntry";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an entry to the resuMaker "
            + "Parameters: "
            + PREFIX_SECTION_TYPE + "SECTION TYPE "
            + "[" + PREFIX_TAGS + "TAG]..."
            + PREFIX_TITLE + "TITLE "
            + PREFIX_SUBHEADER + "SUBHEADER"
            + PREFIX_DURATION + "DURATION\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_SECTION_TYPE + "Experience "
            + PREFIX_TAG + "Java "
            + PREFIX_TITLE + "The Source Enterprise "
            + PREFIX_SUBHEADER + "Java Programmer intern "
            + PREFIX_DURATION + "May 2010 - Aug 2010 ";

    public static final String MESSAGE_SUCCESS = "New Entry added for ResuMaker: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This entry already exists in the resuMaker";

    private final MajorEntry toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddEntryCommand(MajorEntry entry) {
        requireNonNull(entry); // if the object is null throw nullpointer exception, else return the object
        toAdd = entry;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);
        // interaction with model to be completed at later stage
        /*if (model.hasEntry(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.addPerson(toAdd);
        model.commitAddressBook(); */
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddEntryCommand // instanceof handles nulls
                && toAdd.equals(((AddEntryCommand) other).toAdd));
    }
}
