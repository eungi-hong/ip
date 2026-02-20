package Bee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate from;
    protected LocalDate to;
    /**
     * Represents an event with timeframe. It has name, starting time, ending time, and status representing whether it has been completed.
     * @param name
     * @param by
     * @param isDone
     */
    public Event(String name, LocalDate from, LocalDate to, boolean isDone) {
        super(name, isDone);
        this.from = from;
        this.to = to;
    }

    /**
     * @return the task in a string form suitable for users to view.
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return "[E]" + super.toString() + " (from: " + from.format(formatter) + " to: " + to.format(formatter) + ")";
    }

    /**
     * @return event in a string form suitable for storage in the local disk.
     */
    public String toStore() {
        return "E / " + super.toStore() + " / " + this.from + " / " + this.to;
    }
}
