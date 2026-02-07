import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;

    TaskList(ArrayList<Task> list) {
        this.list = list;
    }

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
            str.append(list.get(i).toString());
        }
        return str.toString();
    }

    public Task lastTask() {
        return list.get(list.size() - 1);
    }

    public void doTask(Integer ind) {
        Task task = list.get(ind - 1);
        task.doTask();
    }

    public void undoTask(Integer ind) {
        Task task = list.get(ind - 1);
        task.undoTask();
    }

    public void deleteTask(Integer ind) {
        Task task = list.remove(ind - 1);
        System.out.println(task);
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
        return list.get(ind - 1);
    }
}
