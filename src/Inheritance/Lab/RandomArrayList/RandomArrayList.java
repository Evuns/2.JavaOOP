package Inheritance.Lab.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> {

    private static final Random RANDOM;

    static{
        RANDOM = new Random();
    }

    public Object getRandomElement(){
        int index = RANDOM.nextInt(super.size());
        return super.remove(index);
    }
}
