/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package todolist;
import java.util.Scanner;

public class App {

    public String getGreeting() {
        return "欢迎使用";
    }

     public static void exit(){
        System.out.println("----------------退出---------------");
        System.out.println("您已退出");
     }


    /**
     * 任务管理功能菜单
     * @return 键盘输入的功能操作序号
     */
    public static int chooseFunction() {
        System.out.println("-------------待办事项管理------------");
        System.out.println("1.查看任务");
        System.out.println("2.增加任务");
        System.out.println("3.删除任务");
        System.out.println("4.标记完成任务");
        System.out.println("5.保存并退出");

        System.out.println("请输入要执行的操作序号：");
        //接收键盘输入的功能选项序号
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    
    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        final int usrId = 0;
        FileIO fp = new FileIO();
        List todolist = fp.openFile(usrId);

        //通过while循环进行功能重复选择操作
        while (true) {
            Scanner input = new Scanner(System.in);

            //打印功能菜单操作,接收键盘输入的功能选项序号
            int choose = chooseFunction();
            //执行序号对应的功能
            switch (choose) {
                case 1://查看任务
                    todolist.printAllTask();
                    break;
                case 2://增加任务
                    System.out.println("请输入需要增加任务的信息");
                    Scanner sc = new Scanner(System.in);
                    System.out.print("请输入任务名称：");
                    String name = sc.next();
                    System.out.print("请输入任务截止时间：");
                    String ddl = sc.next();
                    if(todolist.addItem(name, ddl, false)) {
                        System.out.println("添加成功！");
                    }
                    else {
                        System.out.println("添加失败！");
                    }

                    break;
                case 3://删除任务
                    System.out.println("请输入需要删除任务的序号");
                    int index3 = input.nextInt();
                    if(todolist.deleteItem(index3)) {
                        System.out.println("删除成功！");
                    }
                    else {
                        System.out.println("删除失败，任务不存在！");
                    }
                    break;
                case 4://标记完成任务
                    System.out.println("请输入完成任务的序号");
                    int index4 = input.nextInt();
                    if(todolist.finnshItem(index4)) {
                        System.out.println("设置成功！");
                    }
                    else {
                        System.out.println("设置失败，该任务已完成或不存再！");
                    }
                    break;
                case 5: //保存List为文件并退出
                    fp.saveFile(todolist, usrId);
                    exit();
                    return;
                default:
                    System.out.println("----------------------------------");
                    System.out.println("功能选择有误，请输入正确的功能序号!");
                    break;
            }
        }
    }
}

