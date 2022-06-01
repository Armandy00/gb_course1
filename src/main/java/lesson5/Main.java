package lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] employeessArray = new Employee[5];
        employeessArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employeessArray[1] = new Employee("Smirnov Ivan", "Tester", "ismirnov@mailbox.com", "892312313", 25000, 40);
        employeessArray[2] = new Employee("Smirnov Vlad", "Painter", "vsmirnov@mailbox.com", "892312314", 24000, 45);
        employeessArray[3] = new Employee("Toptov Kostya", "Programmer", "ktoptov@mailbox.com", "892312315", 35000, 47);
        employeessArray[4] = new Employee("Maslov Serega", "Teacher", "smaslov@mailbox.com", "892312316", 25000, 25);

        for (Employee employee : employeessArray) {
            if (employee.old > 40) {
                System.out.println("----------------------------------------------");
                employee.PrintToPanel();
            }
        }

    }
}
