package com.example.demo.controller;
import java.util.*;
import java.io.*;
import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import com.example.demo.service.XmlService;

@RestController
@RequestMapping("/resources")
public class XmlController {

	 @Autowired
    private  XmlService xmlService;
	 
//    @GetMapping("/{orderNo}")
//    public String getOutputXML(@PathVariable("orderNo") String orderNo) {
//        if (xmlService.compareOrderNo(orderNo)) {
//            return xmlService.getOutputXML();
//        } else {
//        	
//        	return "Not Matched";
////            return "<Order OrderNo=\"" + orderNo + "\"/>";
//        }
//    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	   @GetMapping("/{orderNo}")
	    public ResponseEntity<String> getOutputXML(@PathVariable("orderNo") String orderNo) {
//		   System.out.println(this.xmlService.getOutputXML());
	        if (this.xmlService.compareOrderNo(orderNo)) {
	        	System.out.println("ok");
	        	
//	            payload = dao.getXmlPayload(orderNo);
	        	    org.springframework.http.HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
	        	    
	        	    responseHeaders.setContentType(MediaType.TEXT_XML);
	        	    return new ResponseEntity<String>(this.xmlService.getOutputXML(),responseHeaders, HttpStatus.OK);
//	        	String xmlString =  System.IO.File.ReadAllText(xmlService.getOutputXML());
//	        	 Document doc = convertStringToDocument(xmlService.getOutputXML());
//	        	return xmlString;
//	        		return "jai ho";
//	        		return xmlService.getOutputXML();
	        } else {
	        	
	        	return new ResponseEntity<>("Not matched",HttpStatus.NOT_FOUND);
//	            return "<Order OrderNo=\"" + orderNo + "\"/>";
	        }
	    }
	    
//    
    
    
//    @GetMapping("/{orderNo}")
//    
//    public ResponseEntity<T>
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
//		
//		try {
//			return new ResponseEntity<>(this.employeeService.getEmployeeById(id), HttpStatus.OK);
//		}catch (Exception e) {
//			
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
		
//		if(this.employeeService.getEmployeeById(id)== null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		
//		return new ResponseEntity<>(this.employeeService.getEmployeeById(id), HttpStatus.OK);
//	}
}


//
//
//public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") Long id){
//	
//	if(this.employeeService.findById(id)== null) {
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
//	
//	return new ResponseEntity<>(this.employeeService.findById(id), HttpStatus.OK);
//}

