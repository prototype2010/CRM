package entities;

/**
 * Created by Boris on 14.05.2016.
 */
public class AbstractRank extends Rank {
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "AbstractRank{" +
                "bonus=" + bonus +
                '}';
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
