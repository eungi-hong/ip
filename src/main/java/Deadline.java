import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDateTime by;

    public Deadline(String name, LocalDateTime by, boolean isDone) {
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
