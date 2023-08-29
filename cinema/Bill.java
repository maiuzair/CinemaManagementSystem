package cinema;

public class Bill {
    int cost;

    public Bill() {
        this.cost = 0;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Bill{" + "cost=" + cost + '}';
    }
    
    
    
}
