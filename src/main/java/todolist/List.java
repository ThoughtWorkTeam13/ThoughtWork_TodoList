package todolist;

public class List {

    private Item[] items;

    public List(Item[] item_p) {
        // 构造函数
        this.items = item_p;
    }

    public boolean addItem(String title, String deadline, boolean isFinnsh) {
        return true;
    }

    public boolean deleteItem(int index) {
        return true;
    }

    public boolean finnshItem(int index) {
        return true;
    }
}
