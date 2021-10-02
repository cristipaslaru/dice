package com.assignment.dice.controllers;

import com.assignment.dice.dtos.RollDiceDTO;
import com.assignment.dice.services.RollDiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class DiceController {

    @Autowired
    private RollDiceService rollDiceService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DiceController.class);

    @GetMapping(value = "roll-dice")
    public ResponseEntity<List<RollDiceDTO>> getSumPerSimulations() {
        LOGGER.debug("roll-dice API called");
        List<RollDiceDTO> results = rollDiceService.getSumPerSimulations(3, 6, 100);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping(value = "roll-dice/dynamic")
    public ResponseEntity<List<RollDiceDTO>> getSumPerSimulationsWithQueryParam(@RequestParam @Min(1) Integer noOfDices,
                                                                          @RequestParam @Min(4) @Max(6) Integer noOfSlides,
                                                                          @RequestParam @Min(1) Integer noOfRolls) {
        LOGGER.debug("roll-dice/dynamic API called with: no of dices {}, no of slides {}, no of rolls {} ",noOfDices,noOfSlides,noOfRolls);
        List<RollDiceDTO> results = rollDiceService.getSumPerSimulations(noOfDices, noOfSlides, noOfRolls);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }


}
