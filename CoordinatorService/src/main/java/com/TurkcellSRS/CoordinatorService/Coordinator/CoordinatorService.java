package com.TurkcellSRS.CoordinatorService.Coordinator;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CoordinatorService {


    private final KafkaTemplate<String, String> kafkaTemplate;


    private static final String PREPARE_TOPIC = "prepare-topic";
    private static final String COMMIT_TOPIC = "commit-topic";
    private static final String PREPARE_CART_TOPIC = "prepare-cart-topic";
    private static final String COMMIT_CART_TOPIC = "commit-cart-topic";
    private static final String ROLLBACK_TOPIC = "rollback-topic";


    private final CountDownLatch prepareLatch = new CountDownLatch(2);
    private final CountDownLatch commitLatch = new CountDownLatch(2);


    public boolean performTwoPhaseCommit() {
        sendPrepareMessage("OrderService");
        sendPrepareCartMessage("CartService");

//        if (prepareOrder) {
//            sendCommitMessage("OrderService");
//            //sendCommitCartMessage("CartService");
//            return true;
//        } else {
//            sendRollbackMessage("OrderService");
//            sendRollbackMessage("CartService");
//            return false;
//        }
        return true;
    }

    private boolean sendPrepareMessage(String service) {
        kafkaTemplate.send(PREPARE_TOPIC, service + ":" + "preparing");
        // Implement logic to wait for response and return true if successful
        return true;
    }

    private void sendCommitMessage(String service) {
        kafkaTemplate.send(COMMIT_TOPIC, service + ":" + "committing");
    }

    private void sendRollbackMessage(String service) {
        kafkaTemplate.send(ROLLBACK_TOPIC, service + ":" + "rolling back");
    }

    @KafkaListener(topics = "prepare-response-topic", groupId = "coordinator-group")
    public void listenPrepareResponse(String message) {
        System.out.println(message);
        if(message.equals("OrderService:prepared")){
             sendCommitMessage("OrderService");
        }
        if(message.equals("CartService:prepared")){
            sendCommitCartMessage("CartService");
        }
    }

    @KafkaListener(topics = "commit-response-topic", groupId = "coordinator-group")
    public void listenCommitResponse(String message) {
        System.out.println(message);
        // Implement logic to handle prepare responses
    }

    private boolean sendPrepareCartMessage(String service) {
        kafkaTemplate.send(PREPARE_CART_TOPIC, service + ":" + "preparing");
        // Implement logic to wait for response and return true if successful
        return true;
    }

    private void sendCommitCartMessage(String service) {
        kafkaTemplate.send(COMMIT_CART_TOPIC, service + ":" + "committing");
    }


    public boolean performFalseTwoPhase(){


            boolean prepareOrder = sendPrepareMessage("OrderService");
            boolean prepareCart = sendPrepareMessage("CartService");
            try {
                if (prepareLatch.await(10, TimeUnit.SECONDS) && prepareOrder && prepareCart) {
                    sendCommitMessage("OrderService");
                    sendCommitMessage("CartService");
                    if (commitLatch.await(10, TimeUnit.SECONDS)) {
                        return true;
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            sendRollbackMessage("OrderService");
            sendRollbackMessage("CartService");
            return false;
        }

}