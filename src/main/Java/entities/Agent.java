package entities;

/**
 * Created by Boris on 11.05.2016.
 */
public class Agent {
    private int id;
    private String name;
    private boolean status;
    private String info;
    private int sales;
    private int sum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agent agent = (Agent) o;

        if (id != agent.id) return false;
        if (sales != agent.sales) return false;
        if (status != agent.status) return false;
        if (sum != agent.sum) return false;
        if (info != null ? !info.equals(agent.info) : agent.info != null) return false;
        if (name != null ? !name.equals(agent.name) : agent.name != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", info='" + info + '\'' +
                ", sales=" + sales +
                ", sum=" + sum +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + sales;
        result = 31 * result + sum;
        return result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
