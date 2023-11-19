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

    // Testing if player can die
    @Test
    public void testPlayerLoses() {
        player.takeDamageFromMonster(player.getMaxHP());

        assertFalse(player.playerIsAlive());
    }

    // Testing if player can gain levels
    @Test
    public void increasePlayerLevel(){
        player.setLevel(player.getLevel() + 1);

        assertEquals(2, player.getLevel());
    }

    // Testing if player damage is actually the damage player is capable of doing
    @Test
    public void checkActualDamage() {
        int expectedDamage = player.getBaseDamage() + (player.getStrength() + 10);
        int actualDamage = player.calculateAttackDamage();

        assertEquals(expectedDamage, actualDamage);
    }
}