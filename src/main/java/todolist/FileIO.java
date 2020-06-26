package todolist;

public class FileIO {
    private String path;

    public List openFile(int usrId) {
        Item[] iteamArr = new Item[1000];

        // 读取文件，往iteamArr添加Item对象

        List todolist = new List(iteamArr,usrId);
        return todolist;
    }

    public boolean saveFile(List todolist, int usrId) {
        return true;
    }
}
