package com.mindflow.servlet3.demo.util;

import java.util.Random;

/**
 * @author Ricky Fung
 */
public abstract class RandomUtils {

    public static int genRandom() {
        Random random = new Random();
        return random.nextInt();
    }

    public static int genRandom(long seed) {
        Random random = new Random(seed);
        return random.nextInt();
    }
}
