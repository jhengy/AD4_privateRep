package seedu.address.model.category;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Category in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidCategoryName(String)}
 */
public class Category {

    public static final String MESSAGE_CATE_CONSTRAINTS = "Category names should be alphanumeric";
    public static final String CATE_VALIDATION_REGEX = "\\p{Alnum}+";

    public final String cateName;

    /**
     * Constructs a {@code Category}.
     *
     * @param cateName A valid category name.
     */
    public Category(String cateName) {
        requireNonNull(cateName);
        checkArgument(isValidCategoryName(cateName), MESSAGE_CATE_CONSTRAINTS);
        this.cateName = cateName;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidCategoryName(String test) {
        return test.matches(CATE_VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Category // instanceof handles nulls
                && cateName.equals(((Category) other).cateName)); // state check
    }

    @Override
    public int hashCode() {
        return cateName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '{' + cateName + '}';
    }

}
