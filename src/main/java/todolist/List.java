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
        Item aitem = new Item(title, deadline, isFinnsh);
        this.items[itemNum] = aitem;
        this.itemNum += 1;
        return true;
    }

    public boolean deleteItem(int index) {
        if(index < 0 || index >= itemNum) {
            return false;
        }
        else {
            for(int i=index;i<this.itemNum-1;++i)
            {
                this.items[i] = this.items[i+1];
                this.itemNum -= 1;
            }
            return true;
        }
    }

    public boolean finnshItem(int index) {
        if(index < 0 || index >= itemNum) {
            return false;
        }
        else if(this.items[index].isFinnsh == true) {
            return false;
        }
        else {
            this.items[index].isFinnsh = true;
            return true;
        }
    }
}
