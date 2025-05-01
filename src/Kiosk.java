import java.util.*;

public class Kiosk {
    private List<Menu> menus;
    private Scanner scanner;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, menus.get(i).getName());
            }
            System.out.println("0. 종료 | 종료");

            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (choice < 1 || choice > menus.size()) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            Menu selectedMenu = menus.get(choice - 1);
            System.out.printf("[ %s MENU ]\n", selectedMenu.getName());
            selectedMenu.printMenuItems();

            int itemChoice = scanner.nextInt();
            if (itemChoice == 0) continue;

            if (itemChoice < 1 || itemChoice > selectedMenu.getItems().size()) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            MenuItem selectedItem = selectedMenu.getItems().get(itemChoice - 1);
            System.out.printf("선택한 메뉴: %s | W %.1f | %s\n\n",
                    selectedItem.getName(), selectedItem.getPrice(), selectedItem.getDescription());
        }
    }
}
