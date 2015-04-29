package by.gsu.epamlab.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {
    private static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd");
    private final String login;
    private final String name;
    private final Date date;
    private final int mark;

    public Result(String login, String name, Date date, String mark) {
        this.login = login;
        this.name = name;
        this.date = date;
        this.mark = markToInt(mark);
    }

    public Result(String login, String name, Date date, int mark) {
        this.login = login;
        this.name = name;
        this.date = date;
        this.mark = mark;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public int getMark() {
        return mark;
    }

    public int markToInt(String mark) {
        return (int)(Double.parseDouble(mark) * 10);
    }

    private String markToString(int mark) {
        return String.valueOf((double)mark / 10);
    }

    public static Date parseData(String data) throws ParseException {
        return DATE_FORMAT.parse(data);
    }

    @Override
    public String toString() {
        return login + ';' + name + ';' + DATE_FORMAT.format(date) + ";" + markToString(mark);
    }
}
