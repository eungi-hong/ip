package bee;

public abstract class Task {
    protected final String name;
    protected boolean isDone;

    /**
     * Represents a task, implemented by subclasses like Todo, Deadline, Event
     * @param name
     * @param isDone
     */
    Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    /**
     * @return task in a string form suitable for users to view.
     */
    @Override
    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + name;
    }

    /**
     * @return task in a string form suitable for storage in the local disk.
     */
    public String toStore() {
        return (isDone ? 1 : 0) + " / " + name;
    }

    /**
     * Mark the task as done.
     */
    public void doTask() {
        isDone = true;
    }

    /**
     * Mark the task as not done.
     */
    public void undoTask() { isDone = false; }

    /**
     * @return true if the name of the task contains the given word, false otherwise.
     */
    public boolean containsWord(String word) {
        return name.contains(word);
    }
}
