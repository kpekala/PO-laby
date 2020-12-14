package agh.cs.lab6;

public class Philosopher extends Thread {
    protected String id;
    protected Fork lf, rf;
    protected int meals = 0;

    public Philosopher(String id, Fork lf, Fork rf) {
        this.id = id;
        this.lf = lf;
        this.rf = rf;
    }

    public void dine() throws InterruptedException{
        lf.lockInterruptibly();
        lf.use();
        sleep(1);
        System.out.println(id + " podnosi lf");
        rf.lockInterruptibly();
        rf.use();
        sleep(1);
        System.out.println(id + " podnosi rf");
        sleep(10);
        meals++;

        lf.unlock();
        rf.unlock();
    }

    @Override
    public void run(){
        try {
            while (true){
                dine();
                sleep(10);
            }
        }catch (InterruptedException e){ }
        System.out.println(id + " zjadł " + meals + " razy");

    }
}
