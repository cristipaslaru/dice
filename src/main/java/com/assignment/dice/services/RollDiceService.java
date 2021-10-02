package com.assignment.dice.services;

import com.assignment.dice.dtos.RollDiceDTO;
import com.assignment.dice.entity.RollDice;

import java.util.List;

public interface RollDiceService {
    List<RollDiceDTO> getSumPerSimulations(Integer noOfDices, Integer noOfSlides, Integer noOfRolls);
}
