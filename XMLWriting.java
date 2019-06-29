import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class XMLWriting {
    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("/home/dolev/Desktop/java-dataProjects/XMLparser/staff.xml");
        Element root = document.getDocumentElement();

        Collection<stuff> company = new ArrayList<stuff>();
        company.add(new stuff("Dolev","Saliman","Dol","100000"));

        for (stuff stuff: company) {
            // server elements
            Element newServer = document.createElement("stuff");
            newServer.setAttribute("id", "10006");
            System.out.println("sadsdasd");
            Element name = document.createElement("firstname");
            name.appendChild(document.createTextNode(stuff.getFirstName()));
            newServer.appendChild(name);

            Element lastname = document.createElement("lastname");
            lastname.appendChild(document.createTextNode(stuff.getLastName()));
            newServer.appendChild(lastname);

            Element nickname = document.createElement("nickname");
            nickname.appendChild(document.createTextNode(stuff.getnickname()));
            newServer.appendChild(nickname);

            Element salary = document.createElement("salary");
            salary.appendChild(document.createTextNode(stuff.getLastName()));
            newServer.appendChild(salary);

            root.appendChild(newServer);
        }

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("server.xml");
        transformer.transform(source, result);
    }

    public static class stuff {
        private String salary , nickname , lastname,firstname;
        public stuff(String first,String Last ,String nick,String sala){
            this.firstname = first; this.lastname = Last; this.nickname = nick; this.salary = sala;
        }
        public String getFirstName() { return this.firstname;}
        public String getLastName() { return this.lastname;}
        public String getnickname() { return this.nickname;}
        public String getsalary() { return this.salary;}
    }
}