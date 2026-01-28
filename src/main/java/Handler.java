public class Handler {
    public static void handle(String input) throws BeeException {
            if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                TaskList.listAllTasks();
            }
            else if (input.startsWith("mark")) {
                Integer ind = Integer.parseInt(input.split(" ")[1]);
                if (ind > TaskList.getLength()) {
                    throw new IndexException();
                }
                System.out.println("Nice! I've marked this task as done:");
                TaskList.doTask(ind);
            }
            else if (input.startsWith("unmark")) {
                Integer ind = Integer.parseInt(input.split(" ")[1]);
                if (ind > TaskList.getLength()) {
                    throw new IndexException();
                }
                System.out.println("OK, I've marked this task as not done yet:");
                TaskList.undoTask(ind);
            }

            // add tasks
            else if (input.startsWith("todo")) {
                String[] taskInfo = input.split("\s+", 2);
                if (taskInfo.length == 1) {
                    throw new EmptyTaskException();
                }
                System.out.println("Got it. I've added this task:");
                TaskList.addTodo(taskInfo[1]);
                System.out.println("Now you have " + TaskList.getLength() + " tasks in the list.");
            }
            else if (input.startsWith("deadline")) {
                String[] taskInfo = input.split("\s+", 2);
                if (taskInfo.length == 1) {
                    throw new EmptyTaskException();
                }
                taskInfo = taskInfo[1].split(" /by ");
                if (taskInfo.length == 1) {
                    throw new NoDeadlineException();
                }
                System.out.println("Got it. I've added this task:");
                TaskList.addDeadline(taskInfo[0], taskInfo[1]);
                System.out.println("Now you have " + TaskList.getLength() + " tasks in the list.");
            }
            else if (input.startsWith("event")) {
                String[] taskInfo = input.split("\s+", 2);
                if (taskInfo.length == 1) {
                    throw new EmptyTaskException();
                }
                taskInfo = taskInfo[1].split(" /from ");
                if (taskInfo.length == 1) {
                    throw new NoTimeFrameException();
                }
                String name = taskInfo[0];
                String timeframe = taskInfo[1];

                String[] timeInfo = timeframe.split(" /to ");
                if (timeInfo.length == 1) {
                    throw new NoTimeFrameException();
                }
                String from = timeInfo[0];
                String to = timeInfo[1];

                System.out.println("Got it. I've added this task:");
                TaskList.addEvent(name, from, to);
                System.out.println("Now you have " + TaskList.getLength() + " tasks in the list.");
            }
            else if (input.startsWith("delete")) {
                Integer ind = Integer.parseInt(input.split(" ")[1]);
                if (ind > TaskList.getLength()) {
                    throw new IndexException();
                }
                System.out.println("Noted. I've removed this task:");
                TaskList.deleteTask(ind);
                System.out.println("Now you have " + TaskList.getLength() + " tasks in the list.");
            }
            else {
                throw new UnknownCommandException();
            }
    }
}
