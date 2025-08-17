package ru.netology.tasks;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        EpicTask epic = new EpicTask(55, subtasks);

        MeetingTask meeting = new MeetingTask(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Протестировать программу");
        String[] subtasks = {"тест", "проверка", "баг-репорт"};
        EpicTask epic = new EpicTask(2, subtasks);
        MeetingTask meeting = new MeetingTask(3, "Обсуждение тестирования", "тесты", "Сегодня");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("тест");
        Task[] expected = {simpleTask,epic, meeting};
        assertArrayEquals(expected, result);

        Task[] result2 = todos.search("баг");
        Task[] expected2 = {epic};
        assertArrayEquals(expected2, result2);

        Task[] result3 = todos.search("работа");
        Task[] expected3 = {};
        assertArrayEquals(expected3, result3);
    }
}
