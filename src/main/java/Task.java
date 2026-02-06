public abstract class Task {
    protected final String name;
    protected boolean isDone;

    Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return  (isDone ? "[X] " : "[ ] ") + name;
    }

    public String toStore() {
        return (isDone ? 1 : 0) + " / " + name;
    }

    public void doTask() {
        this.isDone = true;
    }

    public void undoTask() {
        this.isDone = false;
    }
}
