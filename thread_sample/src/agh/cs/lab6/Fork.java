package agh.cs.lab6;

import java.util.concurrent.locks.ReentrantLock;

public class Fork extends ReentrantLock {
    private int numberOfUses = 0;

    public int getNumberOfUses(){
        return numberOfUses;
    }
    public void use(){
        numberOfUses++;
    }
}
