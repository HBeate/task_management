package at.bha;

import java.util.List;
import java.util.Scanner;

public class TaskGUI {
    private Scanner scanner;
    private TaskDAO taskDAO;

    public TaskGUI() {
        this.scanner = new Scanner(System.in);
        this.taskDAO = new TaskDAO();
    }

    public void scanInput() {
        System.out.println("Welcome... Please choose: \n a-add \n d-delete \n e-edit \n p-print \n x-exit");

        while (true) {
            //           System.out.println("Bitte wählen sie...");
            String input = this.scanner.nextLine();
            switch (input) {
                case "a":
                    addTask();
                    break;
                case "d":
                    System.out.println("Choose the id of the task you would like to delete.");
                    deleteTask();
                    break;
                case "e":
                    System.out.println("I still have to figure out how to do this");
                    editTask();
                    break;
                case "p":
                    printAllTasks();
                    break;
                case "x":
                    System.out.println("Exit");
exitTask();
                    break;
                default:
                    System.out.println("Not a valid input");
            }
        }
    }

    public void addTask() {
        System.out.println("Enter the task you want to add.");
        String input = this.scanner.nextLine();
        TaskVO task = new TaskVO(0, input);
        this.taskDAO.insertTask(task);
        printAllTasks();
    }

    public void deleteTask() {
        System.out.println("Enter the ID of the task you would like to delete.");
        String inputId = this.scanner.nextLine();
        int id = Integer.valueOf(inputId);
        TaskVO task = new TaskVO(id, "");
        taskDAO.deleteTask(task);
        printAllTasks();

    }

    public void printAllTasks() {
        List<TaskVO> tasks = this.taskDAO.getAllTasks();
        System.out.println("Printout of your tasks:");
        for (TaskVO task : tasks) {
            System.out.println("ID: " + task.getId() + " Name: " + task.getName());
        }

    }
    public void editTask(){
        System.out.println("Enter the ID of the task you would like to edit.");
        String inputId = scanner.nextLine();
        int id = Integer.valueOf(inputId);
        System.out.println("Enter the name you would like to edit.");
        String input = scanner.nextLine();
        TaskVO taskVO = new TaskVO(id, input);
        taskDAO.editTask(taskVO);
        printAllTasks();
    }
    public void exitTask(){
        System.exit(0);
    }
}
