package view;

public interface Menu {
    void show();
    void back();
    void exit();

    void back();

    default void showItems(String[] items) {
        for (String item : items) {
            System.out.println("-------------");
            System.out.println(item);
        }
    }
}
