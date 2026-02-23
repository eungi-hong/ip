package bee;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;

    TaskList() {
        this.list = new ArrayList<>();
    }

    public void addTodo(Todo todo) {
        list.add(todo);
    }

    public void addDeadline(Deadline deadline) {
        list.add(deadline);
    }

    public void addEvent(Event event) {
        list.add(event);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < list.size(); i++) {
            str.append(i + 1 + ". " + list.get(i).toString() + "\n");
        }
        return str.toString();
    }

    public String toStringConditional(String word) {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).name.contains(word)) {
                str.append(i + 1 + ". " + list.get(i).toString() + "\n");
            }
        }
        return str.toString();
    }

    public Task lastTask() {
        return list.get(list.size() - 1);
    }

    public void doTask(Integer ind) {
        assert 1 <= ind && ind <= getLength() : "index should be within range";
        Task task = list.get(ind - 1);
        task.doTask();
    }

    public void undoTask(Integer ind) {
        assert 1 <= ind && ind <= getLength() : "index should be within range";
        list.get(ind - 1).undoTask();
    }

    public void deleteTask(Integer ind) {
        assert 1 <= ind && ind <= getLength() : "index should be within range";
        Task task = list.remove(ind - 1);
    }

    public String toStore() {
        StringBuilder tasks = new StringBuilder();
        for (int i = 0; i < this.getLength(); i++) {
            tasks.append(list.get(i).toStore() + "\n");
        }
        return tasks.toString();
    }

    public Integer getLength() {
        return list.size();
    }

    public Task getTask(Integer ind) {
        assert 1 <= ind && ind <= getLength() : "index should be within range";
        return list.get(ind - 1);
    }

}
