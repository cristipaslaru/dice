package com.assignment.dice.services.impl;

import com.assignment.dice.dtos.RollDice;
import com.assignment.dice.services.RollDiceService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class RollDiceServiceImpl implements RollDiceService {

    @Override
    public List<RollDice> getSumPerRotations(Integer diceNo, Integer slideNo, Integer rotations) {
        Map<Integer, Long> result = IntStream.range(0, rotations).boxed()
                .map(sum -> getDicesSum(diceNo, slideNo))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<RollDice> results = new ArrayList<>();
        result.forEach((k, v) -> results.add(new RollDice(k, v.intValue())));
        return results;
    }

    private Integer getDicesSum(Integer diceNo, Integer slideNo) {
        return IntStream.range(0, diceNo).map(diceRes -> returnDice(slideNo)).sum();
    }

    private int returnDice(Integer slideNo) {
        return (int) (Math.random() * slideNo + 1);
    }


}
