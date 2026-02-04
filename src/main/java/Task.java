public abstract class Task {
    protected final String name;
    protected boolean isDone = false;

    Task(String name) {
        this.name = name;
    }

    Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return  (isDone ? "[X] " : "[ ] ") + name;
    }

    public void doTask() {
        this.isDone = true;
    }

    public void undoTask() {
        this.isDone = false;
    }
}
