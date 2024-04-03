import java.util.ArrayList;
import java.util.Scanner;

class Project {
  String name;
  int deadline;
  int completionTime;

  public Project(String name, int deadline, int completionTime) {
    this.name = name;
    this.deadline = deadline;
    this.completionTime = completionTime;
  }

  public String getStatus() {
    if (completionTime < deadline) {
      return "Early";
    } else if (completionTime > deadline) {
      return "Late";
    } else {
      return "On Time";
    }
  }
}

public class ProjectCompletion {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Project> projects = new ArrayList<>();

    int numProjects;
    System.out.println("Enter the number of projects: ");
    numProjects = scanner.nextInt();

    for (int i = 0; i < numProjects; i++) {
      System.out.println("Enter project " + (i + 1) + " details:");
      System.out.print("Project name: ");
      String name = scanner.next();
      System.out.print("Deadline (days): ");
      int deadline = scanner.nextInt();
      System.out.print("Completion time (days): ");
      int completionTime = scanner.nextInt();
      projects.add(new Project(name, deadline, completionTime));
    }

    int onTime = 0, late = 0, early = 0;
    double totalTime = 0;
    for (Project project : projects) {
      totalTime += project.completionTime;
      switch (project.getStatus()) {
        case "On Time":
          onTime++;
          break;
        case "Late":
          late++;
          break;
        case "Early":
          early++;
          break;
      }
    }

    double averageTime = totalTime / projects.size();

    System.out.println("\nProject Completion Statistics:");
    System.out.println("On Time: " + onTime);
    System.out.println("Late: " + late);
    System.out.println("Early: " + early);
    System.out.printf("Average Completion Time: %.2f days\n", averageTime);
  }
}
