package seedu.address.model.entry;

import java.util.Set;

import seedu.address.model.tag.Tag;


public interface Taggable {
    Set<Tag> getTags();
}
