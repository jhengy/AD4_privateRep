package seedu.address.ui;

import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.ui.JumpToListRequestEvent;
import seedu.address.commons.events.ui.PersonPanelSelectionChangedEvent;
import seedu.address.model.person.Person;

/**
 * Panel containing the list of persons.
 */
public class PersonListPanel extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    // note that the ListVie<Person> is tied to ObservableList<Person>, which comes from Model
    // ListCell is the class that encapsulates each cell displayed in the listview.
    // ListCell `listens' to any change from listView(when ObservableList changes), and calls its update() method
    @FXML
    private ListView<Person> personListView;

    public PersonListPanel(ObservableList<Person> personList) {
        super(FXML); // this loads the layout from FXML file to the FXML control element ListView
        setConnections(personList); // this connects personList from filteredPerson of ModelManager to a particular Person card
        registerAsAnEventHandler(this);
    }
    // set connections between PersonListPanel: ListView<Person> and PersonListViewCell
    // this method sets the connection between filteredList in model to FXML component
    // personsListView in this class
    private void setConnections(ObservableList<Person> personList) {
        // personListView.setOrientation(Orientation.HORIZONTAL); // we can set the orientation of te listview
        personListView.setItems(personList);
        personListView.setCellFactory(listView -> new PersonListViewCell());
        setEventHandlerForSelectionChangeEvent();
    }

    private void setEventHandlerForSelectionChangeEvent() {
        personListView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        logger.fine("Selection in person list panel changed to : '" + newValue + "'");
                        raise(new PersonPanelSelectionChangedEvent(newValue));
                    }
                });
    }

    /**
     * Scrolls to the {@code PersonCard} at the {@code index} and selects it.
     */
    private void scrollTo(int index) {
        Platform.runLater(() -> {
            personListView.scrollTo(index);
            personListView.getSelectionModel().clearAndSelect(index);
        });
    }

    @Subscribe
    private void handleJumpToListRequestEvent(JumpToListRequestEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
        scrollTo(event.targetIndex);
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class PersonListViewCell extends ListCell<Person> {
        // this class gives the interaction between Model and PersonListPannel!!
        @Override
        // this will be called automatically, to sync between model FilteredList/ versionedAddress Book
        // - at the start of initialization
        // - whenever the predicate of FilteredPersonlist under model manager is set to true
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                // this line connects each person in filteredList under model to create a newPersonCard
                // whenever a person in filteredPerson List is refreshed, a new PersonCard is created
                setGraphic(new PersonCard(person, getIndex() + 1).getRoot());

            }
        }
    }

}
