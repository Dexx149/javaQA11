package ru.netology.tasks;

public class EpicTask extends Task {
    String[] subtasks = new String[0];

    public EpicTask(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String s : subtasks) {
            if (s.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
