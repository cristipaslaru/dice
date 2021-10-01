package com.assignment.dice.services;

import com.assignment.dice.dtos.RollDice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RollDiceServiceTest {

    @Autowired
    private RollDiceService rollDiceService;

    @Test
    public void validateRotationNo(){
        List<RollDice> results = rollDiceService.getSumPerRotations(3, 6, 100);
        Integer sum = results.stream().map(RollDice::getTotal).reduce(Integer::sum).orElse(null);
        Assert.assertEquals(Integer.valueOf(100),sum);

        long count = results.stream().map(RollDice::getSum).filter(val -> val < 19).filter(val -> val > 2).count();
        Assert.assertEquals(results.stream().map(RollDice::getSum).count(),count);
    }
}
