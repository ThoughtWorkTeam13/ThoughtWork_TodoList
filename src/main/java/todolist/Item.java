package todolist;

public class Item {
    public String deadline;
    public String title;
    public boolean isFinnsh;

    public Item(String tt, String ddl, boolean status) {
        // 构造函数
        this.title = tt;
        this.deadline = ddl;
        this.isFinnsh = status;
    }
}
