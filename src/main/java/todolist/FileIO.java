package todolist;

public class FileIO {
    private String path;

    public List openFile(String fn) {
        Item[] iteamArr = new Item[1000];

        // 读取文件，往iteamArr添加Item对象

        List todolist = new List(iteamArr);
        return todolist;
    }

    public boolean saveFile(List todolist) {
        return true;
    }
}
