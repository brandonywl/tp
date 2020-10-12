package seedu.duke.data.exception;

import seedu.duke.data.timetable.Event;

/**
 * Signals the different type of possible exceptions.
 */
public class SystemException extends Exception {
    /** Types of exception. */
    public enum ExceptionType {
        EXCEPTION_WRONG_PREFIX("Type of prefix not recognized!"),
        EXCEPTION_MISSING_DESCRIPTION("Missing description!"),
        EXCEPTION_MISSING_TITLE_PREFIX("Missing title prefix!"),
        EXCEPTION_MISSING_TITLE("Missing title!"),
        EXCEPTION_DUPLICATE_NOTE("This note already exists in the notebook!"),
        EXCEPTION_MISSING_NOTE("This note does not exists in the notebook!"),
        EXCEPTION_MISSING_TIMING("This event does not have a timing specified!"),
        EXCEPTION_MISSING_RECURRING_END_TIME("Please specify until when do you want "
                + "this event to repeat."),
        EXCEPTION_EARLY_REMINDER("Please limit your reminders to at most 1 week earlier."),
        EXCEPTION_WRONG_TIMING("Your input has a wrong format for the date time input. "
                + "Please follow the yyyy-MM-dd HH:mm format with the \"-\" and \":\" in 24-Hour Clock format"),
        EXCEPTION_MISSING_TIMING_PREFIX("Please include the timing prefix."),
        EXCEPTION_WRONG_LIST_TIMING_FORMAT("Your input list timing query has a wrong format. "
                + "Try YYYY-MM"),
        EXCEPTION_WRONG_REMINDER_FORMAT("Your input has a wrong format for the time before reminder. "
                + "Please follow [NumberOfUnits-Units] format where NumberOfUnits > 0 and units = "
                + Event.REMINDER_DAY + " or " + Event.REMINDER_WEEK + "."),
        EXCEPTION_SEARCH_DATE_OUT_OF_RANGE("Your query is out of range for our system."),
        EXCEPTION_MISSING_RECURRING_TYPE("Please indicate whether you would like to have the event "
                + "repeat daily, weekly, monthly or yearly"),
        EXCEPTION_WRONG_RECURRING_TYPE("There are only the following recurring types: "
                + "daily, weekly, monthly or yearly"),
        EXCEPTION_INDEX_OUT_OF_RANGE("The index you specified is out of range. Please specify "
                + "the index that is indicated when you print the event list"),
        EXCEPTION_WRONG_TIME_UNIT("That time unit is not accepted!"),
        EXCEPTION_MISSING_TAG_PREFIX("Missing tag prefix!"),
        EXCEPTION_MISSING_TAG("Missing tag name!"),
        EXCEPTION_MISSING_INDEX_PREFIX("Missing index prefix!"),
        EXCEPTION_MISSING_INDEX("Missing index!"),
        EXCEPTION_MISSING_PIN("Missing pin!"),
        EXCEPTION_MISSING_KEYWORD("No search query input. Please enter a keyword for search results."),
        EXCEPTION_INVALID_INDEX_FORMAT("Invalid index format!"),
        EXCEPTION_INVALID_INDEX_VALUE("Invalid index value!"),
        EXCEPTION_FILE_CREATION_ERROR("Unable to create a file!"),
        EXCEPTION_INVALID_END_INPUT("Input /end on a new line!");

        /** The exception message. */
        private final String exceptionMessage;

        /**
         * Constructor of an ExceptionType.
         *
         * @param exceptionMessage The exception message.
         */
        ExceptionType(String exceptionMessage) {
            this.exceptionMessage = exceptionMessage;
        }

        /**
         * Overrides the parent toString method.
         *
         * @return The exception message.
         */
        @Override
        public String toString() {
            return exceptionMessage;
        }
    }

    public SystemException(ExceptionType exceptionType) {
        super(exceptionType.toString());
    }
}
