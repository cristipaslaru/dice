package com.assignment.dice.services;

import com.assignment.dice.dtos.RollDiceDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RollDiceDTOServiceTest {

    @Autowired
    private RollDiceService rollDiceService;

    @Test
    public void validateRotationNo(){
        List<RollDiceDTO> results = rollDiceService.getSumPerSimulations(3, 6, 100);
        Integer sum = results.stream().map(RollDiceDTO::getOccurrenceNo).reduce(Integer::sum).orElse(null);
        Assert.assertEquals(Integer.valueOf(100),sum);

        long count = results.stream().map(RollDiceDTO::getSumOfDices).filter(val -> val < 19).filter(val -> val > 2).count();
        Assert.assertEquals(results.stream().map(RollDiceDTO::getSumOfDices).count(),count);
    }

}
