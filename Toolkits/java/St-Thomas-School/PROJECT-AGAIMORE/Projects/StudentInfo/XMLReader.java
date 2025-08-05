package Projects.StudentInfo;


/**
 * Write a description of class XMLReader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import Projects.StudentInfo.Student;

public class XMLReader {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        try {
            File inputFile = new File("students.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    int age = Integer.parseInt(eElement.getElementsByTagName("age").item(0).getTextContent());
                    String department = eElement.getElementsByTagName("department").item(0).getTextContent();

                    students.add(new Student(name, age, department));
                }
            }

            // Display student details
            for (Student student : students) {
                System.out.println(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
