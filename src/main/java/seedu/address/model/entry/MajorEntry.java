package seedu.address.model.entry;

import java.util.Objects;
import java.util.Set;
import seedu.address.model.tag.Tag;

/**
 * class encapsulating entries under education, experience or project section
 */
public class MajorEntry extends Entry {
    private String title;
    private String subHeader;
    private String duration;

    public MajorEntry(String sectionType, String subHeader, String title, String duration, Set<Tag> tags) {
        super(sectionType, tags);
        this.duration = duration;
        this.title = title;
        this.subHeader = subHeader;
    }

    public String getTitle() {
        return title;
    }

    // precond: for v1.1, input for subheader is compulsory
    public String getSubHeader() {
        return subHeader;
    }

    public String getDuration() {
        return duration;
    }


    /**
     * Returns true if both entries of the same section type and name and
     * have at least one field the same out the remaining fields
     * This defines a weaker notion of equality between two entries.
     */
    @Override
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
                && otherMajorEntry.getTitle().equals(getTitle())
                && (otherMajorEntry.getSubHeader().equals(getSubHeader()) || otherMajorEntry.getDuration().equals(getDuration())
                        || otherMajorEntry.getDescription().equals(getDescription())
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
                && otherMajorEntry.getDescription().equals(getDescription())
                && otherMajorEntry.getSubHeader().equals(getSubHeader())
                && otherMajorEntry.getDuration().equals(getDuration())
                && otherMajorEntry.getTitle().equals(getTitle());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(getSectionType(),getTags(), getDescription(), title, subHeader, duration);
    }

    @Override
    // note: Description is omitted
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getSectionType())
                .append(" title: ")
                .append(getTitle())
                .append(" subheader: ")
                .append(getSubHeader())
                .append(" duration: ")
                .append(getDuration())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
