package com.assignment.dice.controllers;

import com.assignment.dice.dtos.RollDice;
import com.assignment.dice.services.RollDiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class DiceController {

    @Autowired
    private RollDiceService rollDiceService;

    @GetMapping(value = "roll/default")
    public ResponseEntity<List<RollDice>> diceSimulation() {
        List<RollDice> results = rollDiceService.getSumPerRotations(3, 6, 100);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping(value = "roll/dynamic")
    public ResponseEntity<List<RollDice>> diceSimulationWithQueryParam(@RequestParam @Min(1) Integer diceNo,
                                                                       @RequestParam @Min(4) Integer slides,
                                                                       @RequestParam @Min(1) Integer rotations) {
        List<RollDice> results = rollDiceService.getSumPerRotations(diceNo, slides, rotations);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }


}
