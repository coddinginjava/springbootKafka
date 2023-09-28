package com.sai.SpringBootProducer.controller;

import com.sai.SpringBootProducer.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
@RequestMapping("/producer-app")
public class Controller {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;


    @GetMapping("/produce/{message}")
    public ResponseEntity<?> sendToKafka(@PathVariable String message) {
        try {
            for (int i = 0; i < 10000; i++)
                kafkaMessagePublisher.sendMessage(message + i);
            return ResponseEntity.ok("message Send to kafka successfully !!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
