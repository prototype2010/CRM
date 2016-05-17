package entities;

/**
 * Created by Boris on 14.05.2016.
 */
public class AbstractEmployee extends Employee {
    @Override
    public String toString() {
        return "AbstractEmployee{" +
                "bonus=" + bonus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AbstractEmployee that = (AbstractEmployee) o;

        if (Double.compare(that.bonus, bonus) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(bonus);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double getBonus() {

        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    private double bonus;
}
