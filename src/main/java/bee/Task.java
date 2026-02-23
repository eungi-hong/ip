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

    @Override
    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + name;
    }

    public String toStore() {
        return (isDone ? 1 : 0) + " / " + name;
    }

    public void doTask() {
        isDone = true;
    }

    public void undoTask() { isDone = false; }

    public boolean containsWord(String word) {
        return name.contains(word);
    }
}
