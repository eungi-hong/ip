package bee;

public class Todo extends Task {
    /**
     * Represents a task. It has name, and status representing whether it has been completed.
     * @param name
     * @param isDone
     */
    Todo(String name, boolean isDone) {
        super(name, isDone);
    }

    /**
     * @return task in a string form suitable for users to view.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * @return task in a string form suitable for storage in the local disk.
     */
    public String toStore() {
        return "T / " + super.toStore();
    }
}