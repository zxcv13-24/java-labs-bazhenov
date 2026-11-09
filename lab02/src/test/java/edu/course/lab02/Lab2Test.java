package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Lab2Test {

    @Test
    void testBankAccountCreate() {
        BankAccount acc = new BankAccount(100);
        assertEquals(100, acc.getBalance());
    }

    @Test
    void testBankAccountNegativeStart() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-1));
    }

    @Test
    void testBankAccountDeposit() {
        BankAccount acc = new BankAccount(100);
        acc.deposit(50);
        assertEquals(150, acc.getBalance());
    }

    @Test
    void testBankAccountBadDeposit() {
        BankAccount acc = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> acc.deposit(0));
    }

    @Test
    void testBankAccountWithdraw() {
        BankAccount acc = new BankAccount(100);
        acc.withdraw(30);
        assertEquals(70, acc.getBalance());
    }

    @Test
    void testBankAccountWithdrawTooMuch() {
        BankAccount acc = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> acc.withdraw(150));
    }

    @Test
    void testTaskCreate() {
        ProjectTask task = new ProjectTask("1", "Test", 5);
        assertEquals("1", task.getId());
        assertEquals(TaskStatus.NEW, task.getStatus());
    }

    @Test
    void testTaskBadInput() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("", "Test", 5));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("1", "", 5));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("1", "Test", -5));
    }

    @Test
    void testTaskStatusChange() {
        ProjectTask task = new ProjectTask("1", "Test", 5);

        task.changeStatus(TaskStatus.DONE);
        assertEquals(TaskStatus.DONE, task.getStatus());
        assertTrue(task.isCompleted()); // Проверка на завершенность

        task.changeStatus(TaskStatus.IN_PROGRESS);
        assertFalse(task.isCompleted());
    }

    @Test
    void testTaskAddHours() {
        ProjectTask task = new ProjectTask("1", "Test", 5);
        task.increaseEstimatedHours(3);
        assertEquals(8, task.getEstimatedHours());
    }

    @Test
    void testTaskBadHours() {
        ProjectTask task = new ProjectTask("1", "Test", 5);
        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimatedHours(0));
        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimatedHours(-2));
    }

    @Test
    void testTaskIdValid() {
        TaskId id = new TaskId("ABC");
        assertEquals("ABC", id.value());
    }

    @Test
    void testTaskIdInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new TaskId(null));
        assertThrows(IllegalArgumentException.class, () -> new TaskId(""));
    }
}