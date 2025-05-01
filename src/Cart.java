import java.util.*;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem menuItem) {
        for (CartItem cartItem : items) {
            if (cartItem.getItem().getName().equals(menuItem.getName())) {
                cartItem.increaseQuantity(1);
                return;
            }
        }
        items.add(new CartItem(menuItem, 1));
    }

    public void printCart() {
        System.out.println("[ Orders ]");
        for (CartItem item : items) {
            item.print();
        }
        System.out.printf("\n[ Total ]\nW %.1f\n", getTotalPrice());
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}
