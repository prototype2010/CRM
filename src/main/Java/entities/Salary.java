package entities;

import java.sql.Date;

/**
 * Created by Boris on 11.05.2016.
 */
public class Salary {
    private int id;
    private int employeeId;
    private Date date;
    private int bonus;
    private int penalty;
    private int sum;
    private boolean status;

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", date=" + date +
                ", bonus=" + bonus +
                ", penalty=" + penalty +
                ", sum=" + sum +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salary salary = (Salary) o;

        if (bonus != salary.bonus) return false;
        if (employeeId != salary.employeeId) return false;
        if (id != salary.id) return false;
        if (penalty != salary.penalty) return false;
        if (status != salary.status) return false;
        if (sum != salary.sum) return false;
        if (date != null ? !date.equals(salary.date) : salary.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + employeeId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + bonus;
        result = 31 * result + penalty;
        result = 31 * result + sum;
        result = 31 * result + (status ? 1 : 0);
        return result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
