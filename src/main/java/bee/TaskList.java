package bee;

import java.util.ArrayList;
import java.time.LocalDate;

import bee.Exception.UnknownCommandException;

public class TaskList {
    private ArrayList<Task> list;

    // EFFECTS: constructs an empty TaskList
    TaskList() {
        this.list = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    // EFFECTS: constructs a TaskList with the given list of tasks
    public void addTodo(Todo todo) {
        list.add(todo);
    }

    // EFFECTS: adds a deadline to the TaskList
    public void addDeadline(Deadline deadline) {
        list.add(deadline);
    }

    // EFFECTS: adds an event to the TaskList
    public void addEvent(Event event) {
        list.add(event);
    }

    // EFFECTS: returns a string representation of the TaskList for users to view
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            str.append(i + 1 + ". " + list.get(i).toString() + "\n");
        }
        return str.toString();
    }

    // EFFECTS: returns a string representation of the TaskList for users to view, but only includes tasks whose name contains the given word
    public String toStringConditional(String word) {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).containsWord(word)) {
                str.append(i + 1 + ". " + list.get(i).toString() + "\n");
            }
        }
        return str.toString();
    }

    // EFFECTS: returns the last task in the TaskList
    public Task lastTask() {
        return list.get(list.size() - 1);
    }

    // EFFECTS: marks the task at the given index as done
    public void doTask(Integer ind) {
        assert 1 <= ind && ind <= getLength() : "index should be within range";
        Task task = list.get(ind - 1);
        task.doTask();
    }

    // EFFECTS: marks the task at the given index as not done
    public void undoTask(Integer ind) {
        assert 1 <= ind && ind <= getLength() : "index should be within range";
        list.get(ind - 1).undoTask();
    }

    // EFFECTS: deletes the task at the given index from the TaskList
    public void deleteTask(Integer ind) {
        assert 1 <= ind && ind <= getLength() : "index should be within range";
        Task task = list.remove(ind - 1);
    }

    // EFFECTS: returns a string representation of the TaskList for storage in the local disk
    public String toStore() {
        StringBuilder tasks = new StringBuilder();
        for (int i = 0; i < this.getLength(); i++) {
            tasks.append(list.get(i).toStore() + "\n");
        }
        return tasks.toString();
    }

    // EFFECTS: returns the number of tasks in the TaskList
    public Integer getLength() {
        return list.size();
    }

    // EFFECTS: returns the task at the given index in the TaskList
    public Task getTask(Integer ind) {
        assert 1 <= ind && ind <= getLength() : "index should be within range";
        return list.get(ind - 1);
    }

    // EFFECTS: postpones the deadline of the task at the given index to a later date. If the task is not a deadline, throws an UnknownCommandException
    public void postpone(Integer ind, LocalDate by) throws UnknownCommandException {
        if (!(list.get(ind - 1) instanceof Deadline)) {
            throw new UnknownCommandException();
        }
        Deadline d = (Deadline) list.get(ind - 1);
        d.postpone(by);
    }

    // EFFECTS: postpones the duration of the task at the given index to a later date. If the task is not an event, throws an UnknownCommandException
    public void postpone(Integer ind, LocalDate from, LocalDate to) throws UnknownCommandException {
        if (!(list.get(ind - 1) instanceof Event)) {
            throw new UnknownCommandException();
        }
        Event e = (Event) list.get(ind - 1);
        e.postpone(from, to);
    }
}
