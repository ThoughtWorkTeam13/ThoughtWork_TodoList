package todolist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    Item ItemUnderTest1 = new Item("Todo1", "2020/6/27",true);
    Item ItemUnderTest2 = new Item("Todo2", "2020/6/28",false);
    Item ItemUnderTest3 = new Item("Todo3", "2020/6/29",false);
    Item Itemlist[] = {ItemUnderTest1,ItemUnderTest2,ItemUnderTest3};
    List ListsUnderTest = new List(Itemlist,0);
    //初始化一个对象

    @Test
    void getItemNum() {
        assertNotNull(ListsUnderTest.getItemNum());
    }

    @Test
    void getItem() {
        assertNotSame(ListsUnderTest.getItem(1),ListsUnderTest.getItem(2)); //测试对象返回
        assertEquals(ListsUnderTest.getItem(1).deadline,"2020/6/28");//测试ddl
        assertEquals(ListsUnderTest.getItem(0).deadline,"2020/6/27");//测试ddl2
        assertEquals(ListsUnderTest.getItem(0).title,"Todo1");//测试title
        assertTrue(ListsUnderTest.getItem(0).isFinnsh);//测试完成状态
    }

    @Test
    void addItem() {
        assertTrue(ListsUnderTest.addItem("Todo4","2020/6/30",false));//测试是否成功添加
    }

    @Test
    void deleteItem() {
        assertTrue(ListsUnderTest.deleteItem(2));//删除第3个
        assertNull(ListsUnderTest.getItem(2));//测试是否成功
    }

    @Test
    void finnshItem() {
        assertTrue(ListsUnderTest.finnshItem(2));//完成第三个
        assertTrue(ListsUnderTest.getItem(2).isFinnsh);//测试是否成功改变状态
    }
}