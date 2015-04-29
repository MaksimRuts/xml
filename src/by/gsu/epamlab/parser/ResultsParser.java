package by.gsu.epamlab.parser;

import by.gsu.epamlab.beans.Result;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultsParser extends DefaultHandler {


    private static enum FieldsKind {
        NAME, DATE, MARK, TEST, LOGIN, STUDENT;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    private List<Result> results;
    private String login;
    private String currentStartTag;

    public ResultsParser() {
        results = new ArrayList<Result>();
        login = "";
        currentStartTag = "";
    }

    public List<Result> getResults() {
        return results;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentStartTag = localName;
        if (FieldsKind.TEST.toString().equals(currentStartTag)) {
            Date date = null;
            try {
                date = Result.parseData(attributes.getValue(FieldsKind.DATE.ordinal()));
            } catch (ParseException e) {
                date = new Date(0);
            } finally {
                results.add(new Result(login,
                        attributes.getValue(FieldsKind.NAME.ordinal()),
                        date,
                        attributes.getValue(FieldsKind.MARK.ordinal())));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (FieldsKind.STUDENT.toString().equals(localName)) {
            login = "";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (FieldsKind.LOGIN.toString().equals(currentStartTag)) {
            login = String.valueOf(ch, start, length);
        }
        currentStartTag = "";
    }
}
