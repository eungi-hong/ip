package Bee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDate by;

    public Deadline(String name, LocalDate by, boolean isDone) {
        super(name, isDone);
        this.by = by;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return "[D]" + super.toString() + " (by: " + by.format(formatter) + ")";
    }

    public String toStore() {
        return "D / " + super.toStore() + " / " + this.by;
    }
}
