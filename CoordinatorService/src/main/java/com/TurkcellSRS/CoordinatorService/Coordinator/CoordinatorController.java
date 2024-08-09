package com.TurkcellSRS.CoordinatorService.Coordinator;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/coordinator")
@RequiredArgsConstructor
public class CoordinatorController {

    private final CoordinatorService coordinatorService;

    @RequestMapping("/2pc")
    public boolean performTwoPhaseCommit() {
        return coordinatorService.performTwoPhaseCommit();
    }
}
