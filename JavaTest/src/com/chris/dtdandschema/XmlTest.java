package com.chris.dtdandschema;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * Created by Chris on 2017/11/17.
 */
public class XmlTest {

    @Test
    public void testXmlDom4J(){
        //1.获取解析器
        SAXReader reader = new SAXReader();
        Document document;
        try {
            document = reader.read("src/com/chris/dtdandschema/web_schema.xml");
            Element elem = document.getRootElement();
            System.out.println(elem.getName());
            String version = elem.attributeValue("version");
            System.out.println(version);

            List<Element> elements = elem.elements();
            for(Element element:elements){
//                System.out.println(element.getName());
                if("servlet".equals(element.getName())){
                    Element elementName =  element.element("servlet-name");
                    Element elementClass =  element.element("servlet-class");
                    System.out.println(elementName.getText()+"..."+elementClass.getText());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
