package com.inutilapp.viewfinder.service;


import com.inutilapp.viewfinder.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 3000)
    public void sendMessageWebSocket() {

        String msg = "hola desde servidor !! ..";

        template.convertAndSend("/topic/greetings", new Greeting(msg));

        System.out.println(msg);

    }



}
