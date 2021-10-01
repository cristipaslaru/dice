package com.assignment.dice.services;

import com.assignment.dice.dtos.RollDice;

import java.util.List;

public interface RollDiceService {
    List<RollDice> getSumPerRotations(Integer diceNo, Integer slideNo, Integer iteretions);
}
