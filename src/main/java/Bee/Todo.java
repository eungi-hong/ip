package Bee;

public class Todo extends Task {
    Todo(String name, boolean isDone) {
        super(name, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public String toStore() {
        return "T / " + super.toStore();
    }
}