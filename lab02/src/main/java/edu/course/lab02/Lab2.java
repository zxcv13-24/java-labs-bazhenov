package edu.course.lab02;

public class Lab2{

}

class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        if (balance < 0) throw new IllegalArgumentException("Минус нельзя");
        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Только плюс");
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (amount < 0 || amount > this.balance) throw new IllegalArgumentException("Ошибка списания");
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}

enum TaskStatus {
    NEW, IN_PROGRESS, DONE
}

class ProjectTask {
    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(String id, String title, int estimatedHours) {
        if (id == null || id.isEmpty() || title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Пустые поля");
        }
        if (estimatedHours < 0) throw new IllegalArgumentException("Минус нельзя");

        this.id = id;
        this.title = title;
        this.estimatedHours = estimatedHours;
        this.status = TaskStatus.NEW;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public TaskStatus getStatus() { return status; }
    public int getEstimatedHours() { return estimatedHours; }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) throw new IllegalArgumentException("Статус null");
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return this.status == TaskStatus.DONE;
    }

    public void increaseEstimatedHours(int hours) {
        if (hours <= 0) throw new IllegalArgumentException("Только плюс");
        this.estimatedHours += hours;
    }
}

record TaskId(String value) {
    public TaskId {
        if (value == null || value.isEmpty()) throw new IllegalArgumentException("Пустой ID");
    }
}