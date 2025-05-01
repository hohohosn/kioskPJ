import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Burger 메뉴
        Menu burgers = new Menu("Burgers");
        burgers.addItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // 음료

        // 디저트

        List<Menu> menus = new ArrayList<>();
        menus.add(burgers);

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
