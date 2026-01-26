public class Task {
    protected final String name;
    protected boolean done;

    Task(String name) {
        this.name = name;
        this.done = false;
    }

    @Override
    public String toString() {
        return (this.done ? "[X] " : "[ ] ") + name;
    }

    public void doTask() {
        this.done = true;
    }

    public void undoTask() {
        this.done = false;
    }
}
