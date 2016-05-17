package entities;

import java.sql.Date;

/**
 * Created by Boris on 11.05.2016.
 */
public class Sale {
    private int id;
    private int employeeName;
    private int agentName;
    private Date saleDate;
    private String comment;
    private boolean status;
    private int sum;

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", employeeName=" + employeeName +
                ", agentName=" + agentName +
                ", saleDate=" + saleDate +
                ", comment='" + comment + '\'' +
                ", status=" + status +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        if (agentName != sale.agentName) return false;
        if (employeeName != sale.employeeName) return false;
        if (id != sale.id) return false;
        if (status != sale.status) return false;
        if (sum != sale.sum) return false;
        if (comment != null ? !comment.equals(sale.comment) : sale.comment != null) return false;
        if (saleDate != null ? !saleDate.equals(sale.saleDate) : sale.saleDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + employeeName;
        result = 31 * result + agentName;
        result = 31 * result + (saleDate != null ? saleDate.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + sum;
        return result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(int employeeName) {
        this.employeeName = employeeName;
    }

    public int getAgentName() {
        return agentName;
    }

    public void setAgentName(int agentName) {
        this.agentName = agentName;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
