package seedu.address.model.entry;

import java.util.Objects;
import java.util.Set;
import seedu.address.model.tag.Tag;

/**
 * Represents a generic entry in the ResuMaker.
 */
public class Entry implements Taggable {
    private String sectionType;
    private Set<Tag> tags;
    private ListDescription description;

    public Entry(String sectionType, Set<Tag> tags) {
        this.sectionType = sectionType;
        this.description = new ListDescription();
        this.tags = tags;
    }

    public String getSectionType() {
        return sectionType;
    }

    public ListDescription getDescription() {
        return description;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    /**
     * Returns true if both entries of the same section type and
     * have at least one field the same out the remaining fields
     * This defines a weaker notion of equality between two entries.
     */
    public boolean isSameEntry(Entry other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof MajorEntry)) {
            return false;
        }

        MajorEntry otherMajorEntry = (MajorEntry) other;
        return otherMajorEntry != null
                && otherMajorEntry.getSectionType().equals(getSectionType())
                && (otherMajorEntry.getDescription().equals(getDescription())
                    || otherMajorEntry.getTags().equals(getTags()));
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof MajorEntry)) {
            return false;
        }

        MajorEntry otherMajorEntry = (MajorEntry) other;
        return otherMajorEntry.getSectionType().equals(getSectionType())
                && otherMajorEntry.getTags().equals(getTags())
                && otherMajorEntry.getDescription().equals(getDescription());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(sectionType, tags, description);
    }

    @Override
    // note: Description is omitted
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getSectionType())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }


}
