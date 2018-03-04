package cz.muni.fi.pb138.jaro2018.task1;

import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * ***********************************************************************
 * Take this skeleton code and implement the missing bodies of
 * <code>averageSalaryAtPosition</code> and <code>addNote</code> methods.
 * Everything else should be left untouched.
 *
 * After completion, the <code>main</code> method should work correctly. It
 * reads (parses) the given file (company.xml if you run it directly from the
 * Netbeans project) and processes it using your methods.
 *
 */
public class Main {

    /**
     * W3C object model representation of a XML document. Note: We use the
     * interface(!) not its implementation
     */
    private final Document doc;

    /**
     * Task 1, part A: Complete this method. You are likely to consult the Java
     * Core API documentation for org.w3c.dom package when working on this task.
     * You can also use the XPath sub-API (javax.xml.xpath) to evaluate XPath
     * expressions from within Java methods.
     *
     * Hint for those not experienced in Java: you can use double
     * Double.parseDouble (String s) to convert the text node inside the salary
     * element to a double value. You can write any other (private) method you
     * need.
     *
     * You can suppose that the input document is always valid, i.e. its
     * structure fulfills the criteria specified in the comments inside the
     * document company.xml.
     *
     * Increase the salary for a person identified by its pid
     *
     * @param pidToIncrease identifier of the person whom the salary should be
     * increased.
     * @param percent percentual increase, eg. 10 means the new salary will be
     * 110 % of the current one.
     *
     * @return the person element where the salary has been increased by the
     * method. If such a person does not exist, the method returns null.
     */
    public Element increaseSalary(String pidToIncrease, double percent) {
        // complete the method
        // you can create also other (private) methods if needed

        return null;
    }

    /**
     * Task 1, part B: Complete this method. You are likely to consult the Java
     * Core API documentation for org.w3c.dom package when working on this task.
     *
     * You can also use the XPath sub-API (javax.xml.xpath) to evaluate XPath
     * expressions from within Java methods.
     *
     * You can suppose that the input document is always valid, i.e. its
     * structure fulfills the criteria specified in the comments inside the
     * document company.xml.
     *
     * @return average salary of all heads of division in the company as double.
     */
    public double getHeadAverageSalary() {
        // complete the method
        // you can create also other (private) methods if needed
        return -1;
    }

    /**
     * Task 1, part C: Complete this method. The method adds a new note to an
     * existing person identified by its person ID (pid) and returns this person
     * element. If such a person does not exist, the method does nothing and
     * returns null.
     *
     * @param pid of the person to add the note to this person. pid must not be
     * null nor empty (the method does not check it)
     * @param note the note to be added to the person with the given pid
     * @return the Element person with the given pid and new note added
     */
    public Element addNote(String pid, String note) {
        // complete the method
        // you can create also other (private) methods if needed
        return null;    }

    /**
     * **********************************************************************
     */
    /**
     * Create a new instance of this class and read the content of the XML file
     * under the given URL.
     */
    public static Main newInstance(URI uri) throws SAXException,
            ParserConfigurationException, IOException {
        return new Main(uri);
    }

    /**
     * Create a new instance of this class and read the content of the given XML
     * file.
     */
    public static Main newInstance(File file)
            throws SAXException, ParserConfigurationException, IOException {
        return newInstance(file.toURI());
    }

    /**
     * Constructor creating a new instance of Uloha1 class reading from the file
     * at the given URI
     */
    private Main(URI uri) throws SAXException, ParserConfigurationException,
            IOException {
        // Vytvorime instanci tovarni tridy
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Pomoci tovarni tridy ziskame instanci DocumentBuilderu
        DocumentBuilder builder = factory.newDocumentBuilder();
        // DocumentBuilder pouzijeme pro zpracovani XML dokumentu
        // a ziskame model dokumentu ve formatu W3C DOM
        doc = builder.parse(uri.toString());
    }

    public void serializetoXML(URI output)
            throws IOException, TransformerConfigurationException, TransformerException {
        // Vytvorime instanci tovarni tridy
        TransformerFactory factory = TransformerFactory.newInstance();
        // Pomoci tovarni tridy ziskame instanci tzv. kopirovaciho transformeru
        Transformer transformer = factory.newTransformer();
        // Vstupem transformace bude dokument v pameti
        DOMSource source = new DOMSource(doc);
        // Vystupem transformace bude vystupni soubor
        StreamResult result = new StreamResult(output.toString());
        // Provedeme transformaci
        transformer.transform(source, result);
    }

    public void serializetoXML(File output) throws IOException,
            TransformerException {
        serializetoXML(output.toURI());
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException, XPathExpressionException {

        System.out.println("Running demo...");
        if (args.length < 1) {
            System.err.println("Input file name is missing.");
            return;
        } else if (args.length < 2) {
            System.err.println("Output file name is missing.");
            return;
        }

        File input = new File(args[0]);
        File output = new File(args[1]);

        Main task1 = newInstance(input);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        double percent = 20;
        System.out.println("\nTask 1.B Average salaries of heads: " + task1.getHeadAverageSalary());
        task1.increaseSalary("1", percent);
        System.out.println("\nTask 1.A Salary of person pid=1 increased by " + percent + "%");
        System.out.println("\nTask 1.B Average salaries of heads is now: " + task1.getHeadAverageSalary());
        System.out.println("\nTask 1.C Person with pid=1 is now:");
        trans.transform(new DOMSource(task1.addNote("1", "New note to person 1")), new StreamResult(System.out));
        task1.serializetoXML(output);
        System.out.println("\nDemo finished, see the above output to check whether it is correct.");
    }

    /**
     * Help method for testing purposes.
     */
    Document getDocument() {
        return doc;
    }

}
