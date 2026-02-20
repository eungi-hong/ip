package Bee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDate by;

    /**
     * Represents a task with deadline. It has name, deadline, and status representing whether it has been completed.
     * @param name
     * @param by
     * @param isDone
     */
    public Deadline(String name, LocalDate by, boolean isDone) {
        super(name, isDone);
        this.by = by;
    }

    /**
     * @return task in a string form suitable for users to view.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return "[D]" + super.toString() + " (by: " + by.format(formatter) + ")";
    }

    /**
     * @return task in a string form suitable for storage in the local disk.
     */
    public String toStore() {
        return "D / " + super.toStore() + " / " + this.by;
    }
}
