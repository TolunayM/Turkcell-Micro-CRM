package com.TurkcellSRS.CoordinatorService.Coordinator;


import com.TurkcellSRS.CoordinatorService.CoordinatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/coordinator")
@RequiredArgsConstructor
public class CoordinatorController {

    private final CoordinatorService coordinatorService;

    public boolean performTwoPhaseCommit(Long orderId, Long cartId) {
        return coordinatorService.performTwoPhaseCommit(orderId, cartId);
    }
}
