package seedu.address.model.entry;

import java.util.ArrayList;
import java.util.List;
import seedu.address.commons.core.index.Index;

/**
 *  Represents bullet points content for an entry.
 */
public class ListDescription {
    private List<String> descriptionList;

    public ListDescription() {
        this.descriptionList = new ArrayList<>();
    }

    public List<String> getDescriptionList() {
        return descriptionList;
    }

    public void addBullet() {

    }

    public void editBullet(Index index, String editedMsg) {

    }
}
