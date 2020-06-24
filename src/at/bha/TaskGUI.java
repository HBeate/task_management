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

    public void scanInputTask() {
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
                    break;
                case "e":
                    System.out.println("I still have to figure out how to do this");
                    break;
                case "p":
                    printAllTasks();
                    break;
                case "x":
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Not a valid input");
            }
        }
    }

    public void addTask() {
        System.out.println("Enter the task you want to add.");
    }

    public void deleteTask() {

    }

    public void printAllTasks(){
        List<TaskVO> tasks= this.taskDAO.getAllTasks();
        System.out.println("Print out of your tasks");
        for (TaskVO task:tasks) {
            System.out.println("ID: " + task.getId() + " Name: " + task.getName());
        }

    }
}
