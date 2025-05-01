import java.util.*;

public class Menu {
    private String name;
    private List<MenuItem> items;

    public Menu(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void printMenuItems() {
        for (int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);
            System.out.printf("%d. %s | W %.1f | %s\n", i + 1, item.getName(), item.getPrice(), item.getDescription());
        }
        System.out.println("0. 뒤로가기");
    }
}
