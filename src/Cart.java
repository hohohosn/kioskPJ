import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(MenuItem menuItem) {
        for (CartItem item : items) {
            if (item.getMenuItem().equals(menuItem)) {
                item.increaseQuantity();
                return;
            }
        }
        items.add(new CartItem(menuItem));
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }

        System.out.println("[ Orders ]");
        for (CartItem item : items) {
            System.out.printf("%s | W %.1f | 수량: %d\n",
                    item.getMenuItem().getName(),
                    item.getMenuItem().getPrice(),
                    item.getQuantity());
        }

        System.out.println("\n[ Total ]");
        System.out.printf("W %d\n", calculateTotalPrice());
    }

    public int calculateTotalPrice() {
        int sum = 0;
        for (CartItem item : items) {
            sum += item.getTotalPrice();
        }
        return sum;
    }

    public void clearCart() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
