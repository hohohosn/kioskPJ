public class CartItem {
    private MenuItem item;
    private int quantity;

    public CartItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }

    public void print() {
        System.out.printf("%s | W %.1f | 수량: %d | 합계: W %.1f\n",
                item.getName(), item.getPrice(), quantity, getTotalPrice());
    }
}
