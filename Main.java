import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
    public static void main(String[] args) {
        clearConsole();
        Scanner scanner = new Scanner(System.in);

        List<Worker> workers = new ArrayList<>();

        int currentCommand = 0;

        while (currentCommand != 4) {
          System.out.println("Выберите нужную команду: ");
          System.out.println("1. Добавить сотрудника");
          System.out.println("2. Добавить сотрудника без данных");
          System.out.println("3. Вывод сотрудников оперделенным стажем");
          System.out.println("4. Завершить программу");


          try {
              int n = scanner.nextInt();
              scanner.nextLine(); // очистка буфера
              currentCommand = n;
          } catch (Exception e) {
            scanner.nextLine(); // очистка буфера
            continue;
          }

          clearConsole();

          if (currentCommand == 1) {
            System.out.print("Введите фамилию и инициалы: ");
            String fullName = scanner.nextLine();

            System.out.print("Введите должность: ");
            String position = scanner.nextLine();

            System.out.print("Введите зарплату: ");
            double salary = scanner.nextDouble();

            System.out.print("Введите год поступления: ");
            int hireYear = scanner.nextInt();
            scanner.nextLine(); 
    

            Worker worker = new Worker(fullName, position, salary, hireYear);
            workers.add(worker);

            clearConsole();

            System.out.println("Добавлен новый сотрудник: ");
            System.out.println(worker);

            System.out.println("___________________________________");
            currentCommand = 0;

          }else if (currentCommand == 2) { 
            Worker worker = new Worker();
            workers.add(worker);

            clearConsole();

            System.out.println("Добавлен новый сотрудник: ");
            System.out.println(worker);

            System.out.println("___________________________________");
            currentCommand = 0;
          }
          else if (currentCommand == 3) {
            System.out.println("Введите минимальный стаж (в годах) для поиска: ");

            int minExperience = scanner.nextInt();


            boolean found = false;
            System.out.println("Работники со стажем более " + minExperience + " лет:");
            for (Worker w : workers) {
                if (w.getExperience() >= minExperience) {
                    System.out.println(w.getFullName() + " (стаж: " + w.getExperience() + " лет)");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Таких работников нет.");
            }
            System.out.println("___________________________________");
            currentCommand = 0;
          }
        }

        scanner.close();
    }
    
}