package com.eoi.springBootDemo.controllers;


import com.eoi.springBootDemo.sockets.ChatMessage;
import com.eoi.springBootDemo.sockets.Greeting;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

@Log4j2
@Controller
public class ChatController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(ChatMessage message) throws Exception {
        log.info("MENSAJE RECIBIDO" + message);
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }


    @GetMapping("/chat")
    public String chat(ChatMessage message) throws Exception {
        return "chat";
    }





}
