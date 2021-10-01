package com.assignment.dice.dtos;

public class RollDice {

    private Integer sum;
    private Integer total;

    public RollDice(Integer sum, Integer total) {
        this.sum = sum;
        this.total = total;
    }

    public Integer getSum() {
        return sum;
    }

    public Integer getTotal() {
        return total;
    }
}
