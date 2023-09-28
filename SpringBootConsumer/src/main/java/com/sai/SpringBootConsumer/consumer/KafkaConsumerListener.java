package com.sai.SpringBootConsumer.consumer;

import com.sai.SpringBootConsumer.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerListener {

    private int co1=1;
    private  int co2=2;
    private  int co3=3;



    @KafkaListener(topics = "topicjavaobj", groupId = "stg")
    public void listenToJavaObj(Person person){
        System.out.println(person);
    }
//
//
//    @KafkaListener(topics = "topicProgrammaticallyCreated",groupId = "stg")
//    public void consume1(String message){
//        log.info("Consumer1 {} listening to message  :  {}",co1++, message);
//    }
//
//
//
//    @KafkaListener(topics = "topicProgrammaticallyCreated",groupId = "stg")
//    public void consume2(String message){
//        log.info("Consumer2 {} listening to message  :  {}",co2++, message);
//    }



//    @KafkaListener(topics = "topicProgrammaticallyCreated",groupId = "stg")
//    public void consume3(String message){
//        log.info("Consumer3  {} listening to message  :  {}",co3++, message);
//    }

}
