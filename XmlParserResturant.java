import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XmlParserResturant{

    public static void main(String[]args){
        try {
        File Xmlfile = new File("/home/dolev/Desktop/java-dataProjects/XMLparser/resturant.xml");
        DocumentBuilderFactory fdb  = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = fdb.newDocumentBuilder();
        Document doc = db.parse(Xmlfile);
        System.out.println(doc.getDocumentElement().getNodeName());

        System.out.println("--------------------------");
        
        NodeList l = doc.getElementsByTagName("first_dish");
        System.out.println("First dish");
        System.out.println("--------------------------");
        for(int j = 0 ; j < l.getLength();j++){
            Node nNode = l.item(j);
            Element e = (Element) nNode;
            for(int i = 0 ; i<e.getElementsByTagName("dish").getLength() ; i++){
                System.out.println(e.getElementsByTagName("dish").item(i).getAttributes().item(0).getTextContent());
                System.out.println(e.getElementsByTagName("price").item(i).getTextContent());
        
            }
        }
        System.out.println("--------------------------");
        NodeList list2 = doc.getElementsByTagName("main_dish");
        System.out.println("Main dish");
        System.out.println("--------------------------");
        for(int i = 0 ; i<list2.getLength() ; i++){
                Node nNode = list2.item(i);
                Element e = (Element)nNode;            
                for(int j = 0 ; j < e.getElementsByTagName("dish").getLength();j++){
                    System.out.println(e.getElementsByTagName("dish").item(j).getAttributes().item(0).getTextContent());
                    System.out.println(e.getElementsByTagName("price").item(j).getTextContent());
                    
                }
        }
        System.out.println("--------------------------");
        System.out.println("Desserts");
        System.out.println("--------------------------");
        NodeList list3 = doc.getElementsByTagName("desserts");
        for(int i = 0 ; i<list3.getLength() ; i++){
            Node nNode = list3.item(i);
            Element e = (Element)nNode;            
            for(int j = 0 ; j < e.getElementsByTagName("dish").getLength();j++){
                System.out.println(e.getElementsByTagName("dish").item(j).getAttributes().item(0).getTextContent());
                System.out.println(e.getElementsByTagName("price").item(j).getTextContent());
                
            }
    }


    } catch (Exception e) {
       e.printStackTrace();
    }
    }
}