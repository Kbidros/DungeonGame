package com.kristian.demo.test;

import com.kristian.demo.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player = new Player(
            5,
            5,
            5,
            50,
            2,
            5
    );

    @Test
    public void reducePlayerHealth() {
        player.takeDamage(5);
        System.out.println(player.getHealth());


        assertEquals(45, player.getHealth());
    }

    @Test
    public void reducePlayerLevel(){
        player.setLevel(player.getLevel() -1);

        assertEquals(1, player.getLevel());

    }

    @Test
    public void checkStartingHealth() {

        System.out.println(player.getHealth());
        assertEquals(50, player.getHealth());


    }


}