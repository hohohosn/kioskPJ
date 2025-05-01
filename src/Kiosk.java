import java.util.*;

public class Kiosk {
    private List<Menu> menus;
    private Cart cart;
    private Scanner scanner;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.cart = new Cart();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            printMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 제거

            switch (choice) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("장바구니가 비어 있어 주문할 수 없습니다.");
                    } else {
                        processOrder();
                    }
                    break;
                case 5:
                    if (cart.isEmpty()) {
                        System.out.println("장바구니가 비어 있어 취소할 수 없습니다.");
                    } else {
                        cancelOrder();
                    }
                    break;
                default:
                    if (choice >= 1 && choice <= menus.size()) {
                        handleMenuSelection(menus.get(choice - 1));
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                    break;
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\n[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, menus.get(i).getName());
        }
        System.out.println("0. 종료 | 종료");

        if (!cart.isEmpty()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }

        System.out.print("\n메뉴 번호를 입력하세요: ");
    }

    private void handleMenuSelection(Menu menu) {
        while (true) {
            System.out.printf("\n[ %s MENU ]\n", menu.getName());
            menu.printMenuItems();

            int itemChoice = scanner.nextInt();
            scanner.nextLine(); // 개행 제거

            if (itemChoice == 0) return;

            if (itemChoice < 1 || itemChoice > menu.getItems().size()) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            MenuItem selectedItem = menu.getItems().get(itemChoice - 1);
            System.out.printf("\n선택한 메뉴: %s | W %.1f | %s\n",
                    selectedItem.getName(), selectedItem.getPrice(), selectedItem.getDescription());

            System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인        2. 취소");
            int confirm = scanner.nextInt();
            scanner.nextLine(); // 개행 제거

            if (confirm == 1) {
                cart.addItem(selectedItem);
                System.out.printf("%s 이(가) 장바구니에 추가되었습니다.\n", selectedItem.getName());
                return;
            } else {
                System.out.println("추가를 취소했습니다.");
                return;
            }
        }
    }

    private void processOrder() {
        System.out.println("\n아래와 같이 주문 하시겠습니까?\n");
        cart.printCart();

        System.out.println("\n1. 주문      2. 메뉴판");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 개행 제거

        if (choice == 1) {
            System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", cart.getTotalPrice());
            cart.clear();
        } else {
            System.out.println("메인 메뉴로 돌아갑니다.");
        }
    }

    private void cancelOrder() {
        System.out.println("\n진행중인 주문을 모두 취소하시겠습니까?");
        System.out.println("1. 확인      2. 취소");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            cart.clear();
            System.out.println("주문이 모두 취소되었습니다.");
        } else {
            System.out.println("취소하지 않았습니다.");
        }
    }
}
