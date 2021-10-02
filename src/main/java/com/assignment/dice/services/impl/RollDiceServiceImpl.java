package com.assignment.dice.services.impl;

import com.assignment.dice.dao.RollDiceRepository;
import com.assignment.dice.dtos.RollDiceDTO;
import com.assignment.dice.entity.RollDice;
import com.assignment.dice.entity.Simulation;
import com.assignment.dice.services.RollDiceService;
import com.assignment.dice.services.SimulationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class RollDiceServiceImpl implements RollDiceService {

    private static final Logger logger = LoggerFactory.getLogger(RollDiceServiceImpl.class);

    @Autowired
    private RollDiceRepository rollDiceRepository;

    @Autowired
    private SimulationService simulationService;

    @Override
    public List<RollDiceDTO> getSumPerSimulations(Integer noOfDices, Integer noOfSlides, Integer noOfRolls) {
        logger.debug("getSumPerSimulations method called with: no of dices {}, no of slides {}, no of rolls {} ",noOfDices,noOfSlides,noOfRolls);
        Map<Integer, Long> result = IntStream.range(0, noOfRolls).boxed()
                .map(sum -> getDicesSum(noOfDices, noOfSlides))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<RollDiceDTO> results = new ArrayList<>();
        result.forEach((k, v) -> results.add(new RollDiceDTO(k, v.intValue())));
        saveSimulation(noOfRolls, noOfDices, noOfSlides,results);
        return results;
    }

    private void saveSimulation(Integer noOfRolls,Integer noOfDices, Integer noOfSlides, List<RollDiceDTO> results) {
        Simulation simulation = simulationService.saveSimulation(noOfRolls, noOfDices,noOfSlides);
        logger.debug("Simulation saved {} ",simulation.toString());
        rollDiceRepository.saveAll(results.stream().map(dto->new RollDice(dto.getSumOfDices(),dto.getOccurrenceNo(),simulation)).collect(Collectors.toSet()));
    }

    private Integer getDicesSum(Integer noOfDices, Integer noOfSlides) {
        return IntStream.range(0, noOfDices).map(diceRes -> returnDice(noOfSlides)).sum();
    }

    private int returnDice(Integer noOfSlides) {
        return (int) (Math.random() * noOfSlides + 1);
    }


}
