package todolist;

public class List {

    private Item[] items;
    private final int usrId;   // 通过usrId打开对应的文件
    private int itemNum;   // Item的有效长度

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

    public void printAllTask() {
        //列表顶部
        System.out.println("---------------------------查看任务--------------------------");
        System.out.println("任务序号        任务内容    截止时间    是否完成");
        //列表中部
        for (int i = 0; i < this.itemNum; i++) {
            System.out.println("  " + i +"\t"+this.items[i].title+"\t"+this.items[i].deadline+"    "+this.items[i].isFinnsh);
        }
        //列表底部
        System.out.println("-------------------------------------------------------------");

    }

    public boolean addItem(String title, String deadline, boolean isFinnsh) {
        try {
            this.items[itemNum] = new Item(title, deadline, isFinnsh);
            this.itemNum += 1;
            return true;
        }
        catch (RuntimeException err) {  // 可能发生数组越界
            return false;
        }
    }

    public boolean deleteItem(int index) {
        if(index < 0 || index >= itemNum) {
            return false;
        }
        else {
            for(int i=index;i<this.itemNum-1;++i)
            {
                this.items[i] = this.items[i+1];
            }
            this.itemNum -= 1;
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
