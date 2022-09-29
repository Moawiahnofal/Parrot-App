package assigmnet5_000875260;

/**
 * Assignemt5 solution for Parrot class.
 *
 * @Author Moawiah Nofal
 */
public class Parrot {
    private boolean tamed = false;
    private boolean alive = true;
    private boolean flying = true;
    private double amountOfSeeds = 0.1;
    private String name = "Parrot Julius";
    private int numberOfHearts = 3;  // parrot health

    private double chanceOfTaming;    // *** percentage chance of taming


    public String getTamedtText() {
        String tameds;
        if (tamed == true) {
            tameds = "Tamed";
            return tameds;
        } else {
            tameds = "Untamed";
            return tameds;
        }
    }

    public Boolean getTamed() {
        return tamed;
    }

    public void setTamed(boolean tamed) {
        this.tamed = tamed;

    }


    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getAliveText() {
        String aliveCheck;
        if (alive == false) {
            aliveCheck = "DEAD";
        } else {
            aliveCheck = "ALIVE";
        }
        return aliveCheck;
    }


    // Getter and setter method
    public boolean getAlive() {
        return alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getAmountOfSeeds() {
        return amountOfSeeds;
    }

    public void setAmountOfSeeds(double amountOfSeeds) {
        this.amountOfSeeds = amountOfSeeds;
    }

    public int getNumberOfHearts() {
        return numberOfHearts;
    }

    public void setNumberOfHearts(int numberOfHearts) {
        this.numberOfHearts = numberOfHearts;
    }

    public String getFlying() {
        String state = "";
        if (flying) {
            state = "Flying";
        } else if (flying == false) {
            state = "Staying";
        }
        return state;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    public void isAlive(String kindOfFood) {  // Check alive or dead
        if (kindOfFood.equals("cookie")) {
            alive = false;
        } else if (kindOfFood.equals("seed"))
            alive = true;
    }

    public void feed(int numSeeds) {
        if (numSeeds >= 0 && numSeeds <= 3) {
            this.numberOfHearts = +numSeeds;
            this.amountOfSeeds = +numSeeds;
        }
    }

    public void hitParrot() {
        this.tamed = false;
        if (this.numberOfHearts > 0) {
            this.numberOfHearts--;
        }
        if (numberOfHearts == 0) {
            this.alive = false;
        }
    }

    public void setChanceOfTaming(double chance) {
        chance = (double) amountOfSeeds * 20;
        chanceOfTaming = chance;
    }

    public double getChanceOfTaming() {
        return chanceOfTaming;
    }

    @Override
    public String toString() {
        return getTamedtText() + " " +
                getAliveText() + " " + getName() + ":" + " " + getAmountOfSeeds()
                + "Kg seeds," + " " + getNumberOfHearts() +
                " Hearts," + " " + getFlying();
    }
}



