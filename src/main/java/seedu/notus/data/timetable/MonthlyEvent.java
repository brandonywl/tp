package seedu.notus.data.timetable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

//@@author brandonywl
/**
 * Subclass of RecurringEvent that re-occurs every month.
 */
public class MonthlyEvent extends RecurringEvent {
    private static final int TIME_STEP = 1;

    /**
     * Constructor of MonthlyEvent with a specified recurrence type and specified endRecurrence date.
     *
     * @param title Title of Event
     * @param dateTime DateTime of Event
     * @param isToRemind Whether the Event requires reminders.
     * @param endRecurrence When the Event should stop re-occurring.
     * @param reminderSchedule Reminder Schedule of when reminder should be provided for this event.
     */
    public MonthlyEvent(String title, LocalDateTime dateTime, boolean isToRemind, LocalDate endRecurrence,
                        HashMap<String, ArrayList<Integer>> reminderSchedule) {
        super(title, dateTime, isToRemind, endRecurrence, RecurringEvent.MONTHLY_RECURRENCE_TYPE,
                reminderSchedule);
    }

    /**
     * Constructor of MonthlyEvent with a specified recurrence type and default end time of recurrence (Year 3000).
     *
     * @param title Title of Event
     * @param dateTime DateTime of Event
     * @param isToRemind Whether the Event requires reminders.
     * @param reminderSchedule Reminder Schedule of when reminder should be provided for this event.
     */
    public MonthlyEvent(String title, LocalDateTime dateTime, boolean isToRemind,
                        HashMap<String, ArrayList<Integer>> reminderSchedule) {
        super(title, dateTime, isToRemind, RecurringEvent.MONTHLY_RECURRENCE_TYPE, reminderSchedule);
    }

    @Override
    public LocalDate timeStep(LocalDate date) {
        return date.plusMonths(TIME_STEP);
    }
}