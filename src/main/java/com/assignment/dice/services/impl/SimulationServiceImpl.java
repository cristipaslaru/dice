package com.assignment.dice.services.impl;

import com.assignment.dice.dao.SimulationRepository;
import com.assignment.dice.dtos.DistributionDTO;
import com.assignment.dice.dtos.SimulationDTO;
import com.assignment.dice.entity.Simulation;
import com.assignment.dice.services.SimulationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SimulationServiceImpl implements SimulationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimulationServiceImpl.class);

    @Autowired
    private SimulationRepository simulationRepository;

    @Override
    public Simulation saveSimulation(Integer noOfRolls, Integer noOfDices, Integer noOfSlides){
        Simulation simulation = new Simulation();
        simulation.setSimulationNo(getSimulationNo());
        simulation.setNoOfRolls(noOfRolls);
        simulation.setNoOfDices(noOfDices);
        simulation.setNoOfSlides(noOfSlides);
        return simulationRepository.save(simulation);
    }

    @Override
    public Set<SimulationDTO> getSimulationDetails(){
        return simulationRepository.getSimulation();
    }

    @Override
    public Set<DistributionDTO> getRelativeDistribution(Integer noOfDices, Integer noOfSlides){
        LOGGER.debug("getRelativeDistribution method called with: no of dices {}, no of slides {}",noOfDices,noOfSlides);
        return simulationRepository.getRelativeDistribution(noOfDices, noOfSlides);
    }

    private Integer getSimulationNo(){
        return (int) simulationRepository.count()+1;
    }

}
