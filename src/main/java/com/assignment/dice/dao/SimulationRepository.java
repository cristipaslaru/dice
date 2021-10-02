package com.assignment.dice.dao;

import com.assignment.dice.dtos.DistributionDTO;
import com.assignment.dice.dtos.SimulationDTO;
import com.assignment.dice.entity.Simulation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SimulationRepository extends CrudRepository<Simulation, Integer> {

    @Query("SELECT new com.assignment.dice.dtos.SimulationDTO(s.noOfDices, s.noOfSlides, sum(s.noOfRolls) as rolls, count(*) as simulationNo) FROM Simulation s group by s.noOfDices, s.noOfSlides")
    Set<SimulationDTO> getSimulation();

    @Query("SELECT new com.assignment.dice.dtos.DistributionDTO(r.sumOfDices, sum(s.noOfRolls) as noOfRolls, sum(r.occurrenceNo) as occurrenceNo) " +
            "FROM Simulation s left join RollDice r on s.id=r.simulation.id where s.noOfDices=?1 and s.noOfSlides=?2 group by r.sumOfDices")
    Set<DistributionDTO> getRelativeDistribution(Integer noOfDices, Integer noOfSlides);
}
