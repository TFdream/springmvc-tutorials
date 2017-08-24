package com.mindflow.servlet3.demo.util;

import java.util.Random;

/**
 * @author Ricky Fung
 */
public abstract class RandomUtils {

    public static int genRandom(int bound) {
        return (int) (Math.random() * bound);
    }

    public static int getRandom(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}
