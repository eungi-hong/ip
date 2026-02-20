package Bee;  // same package as the class being tested

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void toStore_completedTask_success() {
        Todo todo = new Todo("completed task", true);
        assertEquals(todo.toStore(), "T / 1 / completed task");
    }

    @Test
    public void toStore_uncompletedTask_success() {
        Todo todo = new Todo("uncompleted task", false);
        assertEquals(todo.toStore(), "T / 0 / uncompleted task");
    }
}
