import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems;

    // 생성자
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    // 기능
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem item = menuItems.get(i);
                System.out.printf("%d. %s   | W %.1f | %s%n",
                        i + 1, item.getName(), item.getPrice(), item.getDescription());
            }
            System.out.println("0. 종료    | 종료");

            System.out.print("번호를 선택하세요: ");
            int input = scanner.nextInt();

            if (input == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (input >= 1 && input <= menuItems.size()) {
                MenuItem selected = menuItems.get(input - 1);
                System.out.printf("선택한 메뉴: %s | W %.1f | %s%n",
                        selected.getName(), selected.getPrice(), selected.getDescription());
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
        scanner.close();
    }
}
