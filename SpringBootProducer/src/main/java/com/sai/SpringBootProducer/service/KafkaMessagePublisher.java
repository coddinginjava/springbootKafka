package com.sai.SpringBootProducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String,Object> template;


    public void sendMessage(String message){
        // by doing  template.send("topicCreatedOnFlow", like this in the below the topic is created on the fly
        // once the message is received from the controller
        CompletableFuture<SendResult<String, Object>> future = template.send("topicCreatedOnFlow", message);
        future.whenComplete((result,ex)->{
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });
    }
}



// topic can be created using the cli of the kafka
// sh bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic NewTopic --partitions 3 --replication-factor 1



// or can be created using the spring boot configuration in the config file
// also need to enter the topic  name in the template
//    CompletableFuture<SendResult<String, Object>> future = template.send("topicProgrammaticallyCreated", message);