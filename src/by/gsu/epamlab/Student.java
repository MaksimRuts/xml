package by.gsu.epamlab;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String login;
    private List<Test> results;

    public Student(String login) {
        this.login = login;
        results = new ArrayList<Test>();
    }

    public String getLogin() {
        return login;
    }

    public List<Test> getResults() {
        return results;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Test test : results) {
            builder.append(login)
                    .append(";")
                    .append(test)
                    .append("\r\n");
        }
        return builder.toString();
    }
}
