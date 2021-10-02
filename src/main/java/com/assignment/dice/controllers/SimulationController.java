package com.assignment.dice.controllers;

import com.assignment.dice.dtos.DistributionDTO;
import com.assignment.dice.dtos.SimulationDTO;
import com.assignment.dice.services.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;


@RestController
@Validated
public class SimulationController {

    @Autowired
    private SimulationService simulationService;

    @GetMapping(value="simulation")
    public ResponseEntity<Set<SimulationDTO>> getSimulationDetails(){
        return new ResponseEntity<>(simulationService.getSimulationDetails(), HttpStatus.OK);
    }

    @GetMapping(value="simulation/distribution")
    public ResponseEntity<Set<DistributionDTO>> getRelativeDistribution(@RequestParam @Min(1) Integer noOfDices, @RequestParam @Min(4) @Max(6) Integer noOfSlides){
        return new ResponseEntity<>(simulationService.getRelativeDistribution(noOfDices, noOfSlides),HttpStatus.OK);
    }


}
