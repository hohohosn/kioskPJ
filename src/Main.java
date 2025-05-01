import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Burger 메뉴
        Menu burgers = new Menu("Burgers");
        burgers.addItem(new MenuItem("Shack Burger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("Smoke Shack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("Cheese Burger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("Ham burger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // 음료
        Menu shake = new Menu("Shake");
        shake.addItem(new MenuItem("Milk Shake", 4.9, "우유와 카라멜이 들어간 쉐이크"));
        shake.addItem(new MenuItem("Chocolate Shake", 5.9, "초콜릿 칩이 들어간 쉐이크"));
        shake.addItem(new MenuItem("Butter Shake", 5.9, "버터의 고소한 맛을 살린 쉐이크"));


        List<Menu> menus = new ArrayList<>();
        menus.add(burgers);
        menus.add(shake);

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
