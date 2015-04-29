import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.parser.ResultsParser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class Runner {

    public static final String SRC_RESULTS_XML = "src/results.xml";

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            ResultsParser parser = new ResultsParser();
            reader.setContentHandler(parser);
            reader.parse(SRC_RESULTS_XML);
            for (Result result : parser.getResults()) {
                System.out.println(result);
            }
        } catch (SAXException e) {
            System.err.println("File parsing error");
        } catch (IOException e) {
            System.err.println("File isn't found");
        }
    }
}
