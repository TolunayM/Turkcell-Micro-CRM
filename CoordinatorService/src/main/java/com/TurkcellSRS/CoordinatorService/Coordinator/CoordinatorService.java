package com.TurkcellSRS.CoordinatorService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoordinatorService {


    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String PREPARE_TOPIC = "prepare-topic";
    private static final String COMMIT_TOPIC = "commit-topic";
    private static final String ROLLBACK_TOPIC = "rollback-topic";

    public boolean performTwoPhaseCommit(Long orderId, Long cartId) {
        boolean prepareOrder = sendPrepareMessage("OrderService", orderId);
        boolean prepareCart = sendPrepareMessage("CartService", cartId);

        if (prepareOrder && prepareCart) {
            sendCommitMessage("OrderService", orderId);
            sendCommitMessage("CartService", cartId);
            return true;
        } else {
            sendRollbackMessage("OrderService", orderId);
            sendRollbackMessage("CartService", cartId);
            return false;
        }
    }

    private boolean sendPrepareMessage(String service, Long id) {
        kafkaTemplate.send(PREPARE_TOPIC, service + ":" + id);
        // Implement logic to wait for response and return true if successful
        return true;
    }

    private void sendCommitMessage(String service, Long id) {
        kafkaTemplate.send(COMMIT_TOPIC, service + ":" + id);
    }

    private void sendRollbackMessage(String service, Long id) {
        kafkaTemplate.send(ROLLBACK_TOPIC, service + ":" + id);
    }

    @KafkaListener(topics = "prepare-response-topic", groupId = "coordinator-group")
    public void listenPrepareResponse(String message) {
        // Implement logic to handle prepare responses
    }
}