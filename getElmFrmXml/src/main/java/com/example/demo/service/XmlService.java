package com.example.demo.service;





import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

@Service
public class XmlService {

    public String getInputXML() {
        try {
            ClassPathResource resource = new ClassPathResource("C:\\Users\\ashut\\OneDrive\\Desktop\\xML\\getElmFrmXml\\src\\main\\resources\\templates\\input.xml");
            InputStream inputStream = resource.getInputStream();
            byte[] bytes = inputStream.readAllBytes();
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOutputXML() {
        try {
            ClassPathResource resource = new ClassPathResource("C:\\Users\\ashut\\OneDrive\\Desktop\\xML\\getElmFrmXml\\src\\main\\resources\\templates\\output.xml");
            InputStream inputStream = resource.getInputStream();
            byte[] bytes = inputStream.readAllBytes();
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean compareOrderNo(String inputParameter) {
        String inputXML = getInputXML();
        if (inputXML != null) {
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new InputSource(new StringReader(inputXML)));
                String orderNo = document.getDocumentElement().getAttribute("OrderNo");
                return inputParameter.equals(orderNo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

