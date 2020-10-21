package seedu.duke.command;

import seedu.duke.data.notebook.Note;
import seedu.duke.ui.Formatter;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static seedu.duke.util.PrefixSyntax.PREFIX_DELIMITER;
import static seedu.duke.util.PrefixSyntax.PREFIX_INDEX;
import static seedu.duke.util.PrefixSyntax.PREFIX_TITLE;

/**
 * Un-archives a Note from the Notebook.
 */
public class UnarchiveNoteCommand extends Command {

    public static final String COMMAND_WORD = "unarchive-n";

    public static final String COMMAND_USAGE = COMMAND_WORD + ": Un-archives a note. Parameters: "
            + "[" + PREFIX_DELIMITER + PREFIX_TITLE + " TITLE] "
            + "[" + PREFIX_DELIMITER + PREFIX_INDEX + " INDEX]";

    public static final String UNARCHIVE_NOTE_MESSAGE = "The following note has been unarchived: ";
    public static final String COMMAND_UNSUCCESSFUL_MESSAGE = "This note does not exist in the notebook! ";

    private int index;
    private String title = "";

    /**
     * Constructs a UnarchiveNoteCommand to un-archive a Note.
     *
     * @param index of the item to be un-archived.
     */
    public UnarchiveNoteCommand(int index) {
        this.index = index;
    }

    /**
     * Constructs a UnarchiveNoteCommand to un-archive a Note.
     *
     * @param title of the item to be deleted.
     */
    public UnarchiveNoteCommand(String title) {
        this.title = title;
    }

    @Override
    public String execute() {
        String unarchivedTitle;
        Note unarchivedNote;
        ArrayList<Note> unarchivedNotesList;

        unarchivedNotesList = notebook.archiveNotes();

        try {
            // If there is no title, un-archive note by index. Else un-archive by title.
            if (title.isBlank()) {
                unarchivedNote = unarchivedNotesList.get(index);
                unarchivedTitle = unarchivedNote.getTitle();

                unarchivedNote.toggleIsArchived();

                return Formatter.formatString(UNARCHIVE_NOTE_MESSAGE + unarchivedTitle);

            } else {
                unarchivedNotesList = (ArrayList<Note>) unarchivedNotesList.stream()
                        .filter((s) -> s.getTitle().equalsIgnoreCase(title))
                        .collect(Collectors.toList());

                for (Note note : unarchivedNotesList) {
                    note.toggleIsArchived();
                    return Formatter.formatString(UNARCHIVE_NOTE_MESSAGE + title);
                }
            }

            return Formatter.formatString(COMMAND_UNSUCCESSFUL_MESSAGE);

        } catch (IndexOutOfBoundsException exception) {
            return Formatter.formatString(COMMAND_UNSUCCESSFUL_MESSAGE);
        }
    }
}
