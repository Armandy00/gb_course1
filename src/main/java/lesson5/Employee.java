package lesson5;

public class Employee {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private int pay;
    public int old;

    public Employee(String fio, String position, String email, String phone, int pay, int old) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.pay = pay;
        this.old = old;
    }

    public void PrintToPanel() {
        System.out.println(String.format(" ФИО: - %s \n Должность: - %s \n Элект. почта: - %s \n Телефон: - %s \n Зарплата: - %s \n Возраст: - %s",
                this.fio, this.position, this.email, this.phone, this.pay, this.old));

    }
}
