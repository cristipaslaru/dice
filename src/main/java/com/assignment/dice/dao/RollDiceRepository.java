package com.assignment.dice.dao;

import com.assignment.dice.entity.RollDice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RollDiceRepository extends CrudRepository<RollDice,Integer> {
}
