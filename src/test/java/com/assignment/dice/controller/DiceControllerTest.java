package com.assignment.dice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void diceSimulationTest() throws Exception {
        mockMvc.perform(get("/roll/default")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void diceSimulationWithQueryParam() throws Exception{
        mockMvc.perform(get("/roll/dynamic")
                .param("diceNo","3")
                .param("slides","5")
                .param("rotations","7")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void diceSimulationWithQueryParamFailed() throws Exception{
        mockMvc.perform(get("/roll/dynamic")
                .param("diceNo","0")
                .param("slides","3")
                .param("rotations","0")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}
