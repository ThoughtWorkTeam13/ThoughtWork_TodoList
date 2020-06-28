package todolist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {
    Item ItemUnderTest1 = new Item("Todo1", "2020/6/27", true);
    Item ItemUnderTest2 = new Item("Todo2", "2020/6/28", false);
    Item ItemUnderTest3 = new Item("Todo3", "2020/6/29", false);
    Item Itemlist[] = {ItemUnderTest1, ItemUnderTest2, ItemUnderTest3};
    List ListsUnderTest = new List(Itemlist, 0);

    FileIO ListWantedTobesaved = new FileIO();

    @Test
    void saveFile() {
        assertTrue(ListWantedTobesaved.saveFile(ListsUnderTest, 0));
    }


    @Test
    void openFile() {
        assertNotNull(ListWantedTobesaved.openFile(0));
        assertEquals(ListWantedTobesaved.openFile(0).getItem(0).title, "Todo1");
        assertEquals(ListWantedTobesaved.openFile(0).getItem(0).deadline, "2020/6/27");
        assertTrue(ListWantedTobesaved.openFile(0).getItem(0).isFinnsh);
    }
}