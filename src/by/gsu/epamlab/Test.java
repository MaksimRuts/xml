package by.gsu.epamlab;

import java.util.Date;

public class Test {
    private final String name;
    private final Date date;
    private final String mark;

    public Test(String name, Date date, String mark) {
        this.name = name;
        this.date = date;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return name + ';' + date + ";" + mark;
    }
}
