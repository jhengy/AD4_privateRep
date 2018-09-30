package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DURATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SECTION_TYPE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SUBHEADER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAGS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;

import java.util.Set;
import java.util.stream.Stream;
import seedu.address.logic.commands.AddEntryCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.entry.MajorEntry;
import seedu.address.model.tag.Tag;

public class AddEntryCommandParser implements Parser<AddEntryCommand>{
    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddEntryCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_SECTION_TYPE, PREFIX_TAGS, PREFIX_TITLE, PREFIX_SUBHEADER, PREFIX_DURATION);

        if (!arePrefixesPresent(argMultimap, PREFIX_SECTION_TYPE, PREFIX_TITLE, PREFIX_SUBHEADER, PREFIX_DURATION, PREFIX_TAGS)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddEntryCommand.MESSAGE_USAGE));
        }

        String sectionType = ParserUtil.parseString(argMultimap.getValue(PREFIX_SECTION_TYPE).get());
        String header = ParserUtil.parseString(argMultimap.getValue(PREFIX_TITLE).get());
        String subHeader = ParserUtil.parseString(argMultimap.getValue(PREFIX_SUBHEADER).get());
        String duration = ParserUtil.parseString(argMultimap.getValue(PREFIX_DURATION).get());
        Set<Tag> tagList = ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAGS));

        // v1.1 only allows addition of major entry, other types of entry addition to be released in future stages
        MajorEntry entry = new MajorEntry(sectionType, header, subHeader, duration, tagList);

        return new AddEntryCommand(entry);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
