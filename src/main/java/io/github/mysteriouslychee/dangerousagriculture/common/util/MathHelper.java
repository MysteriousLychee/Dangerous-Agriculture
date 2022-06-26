package io.github.mysteriouslychee.dangerousagriculture.common.util;

import java.util.Random;

public class MathHelper {

    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }
    
    public static double getRandomDouble(int min, int max) {
    	Random random = new Random();
    	return random.doubles(min, max).findFirst().getAsDouble();
    }
}
