package entities;

import java.sql.Date;

/**
 * Created by Boris on 11.05.2016.
 */
public class Expense {
    private int id;
    private Date expenseDate;
    private int sum;
    private String type;
    private boolean status;
    private String comment;

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", expenseDate=" + expenseDate +
                ", sum=" + sum +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        if (id != expense.id) return false;
        if (status != expense.status) return false;
        if (sum != expense.sum) return false;
        if (comment != null ? !comment.equals(expense.comment) : expense.comment != null) return false;
        if (expenseDate != null ? !expenseDate.equals(expense.expenseDate) : expense.expenseDate != null) return false;
        if (type != null ? !type.equals(expense.type) : expense.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (expenseDate != null ? expenseDate.hashCode() : 0);
        result = 31 * result + sum;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
