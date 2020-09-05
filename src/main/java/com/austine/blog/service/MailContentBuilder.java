//package com.austine.blog.service;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//
//@Service
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class MailContentBuilder {
//
//    private TemplateEngine templateEngine;
//
//
//    String build(String message){
//        Context context = new Context();
//        context.setVariable("message", message);
//        return templateEngine.process("mailTemplate", context);
//    }
//}
