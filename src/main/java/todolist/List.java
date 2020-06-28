package todolist;

public class List {

    private Item[] items;
    private final int usrId;
    private int itemNum;

    public List(Item[] item_p, int id, int len) {
        // 构造函数
        this.items = item_p;
        this.usrId = id;
        this.itemNum = len;
    }
    
    public int getItemNum() {
    	return itemNum;
    }
    
    public Item getItem(int index) {
    	return items[index];
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
