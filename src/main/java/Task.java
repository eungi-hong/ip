public abstract class Task {
    protected final String name;
    protected boolean done = false;
    protected char type;

    Task(String name) {
        this.type = 'T';
        this.name = name;
    }

    @Override
    public String toString() {
        return  (done ? "[X] " : "[ ] ") + name;
    }

    public void doTask() {
        this.done = true;
    }

    public void undoTask() {
        this.done = false;
    }
}
