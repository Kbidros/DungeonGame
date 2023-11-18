package com.kristian.demo.test;

import com.kristian.demo.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player = new Player(
            5,
            5,
            5,
            80,
            1,
            5,
            80
    );

    @Test
    public void testPlayerLoses() {
        player.takeDamageFromMonster(player.getMaxHP());

        assertFalse(player.playerIsAlive());
    }

    @Test
    public void increasePlayerLevel(){
        player.setLevel(player.getLevel() + 1);

        assertEquals(2, player.getLevel());
    }

    @Test
    public void checkActualDamage() {
        int expectedDamage = player.getBaseDamage() + (player.getStrength() + 10);
        int actualDamage = player.calculateAttackDamage();

        assertEquals(expectedDamage, actualDamage);
    }
}