package todolist;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileIO {
    private final int MaxSize = 100;

    public List openFile(int usrId) {
        Item[] itemArr = new Item[MaxSize];
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        org.w3c.dom.Document doc = null;
		try {
			db = fac.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		}
        try {
			//打开.xml文件
			doc = db.parse("../../../res/file/log" + String.valueOf(usrId) + ".xml");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//获取event列表，各event以id区分      event 对应 item
		NodeList eventList = doc.getElementsByTagName("event");
		
        for(int index = 0; index < eventList.getLength(); index++) {
        	org.w3c.dom.Node event = eventList.item(index);
        	NodeList childNodes = event.getChildNodes();
        	itemArr[index].deadline = childNodes.item(0).getTextContent();
        	itemArr[index].title = childNodes.item(1).getTextContent();
        	itemArr[index].isFinnsh = Boolean.valueOf(childNodes.item(2).getTextContent());
        }
     
        List todolist = new List(itemArr,usrId);
        return todolist;
    }

    public boolean saveFile(List todolist, int usrId) {
    	DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
    	try {
			DocumentBuilder db = fac.newDocumentBuilder();
			org.w3c.dom.Document document =  db.newDocument();
			document.setXmlStandalone(true);
			
			for(int index = 0; index < todolist.getItemNum(); index++) {
				//获取item的内容
				org.w3c.dom.Element event = document.createElement("event");
				org.w3c.dom.Element title = document.createElement("title");
				org.w3c.dom.Element ddl = document.createElement("ddl");
				org.w3c.dom.Element status = document.createElement("status");
				title.setTextContent(todolist.getItem(index).title);
				ddl.setTextContent(todolist.getItem(index).deadline);
				status.setTextContent(String.valueOf(todolist.getItem(index).isFinnsh));
				
				//设置event的id属性
				event.setAttribute("id", String.valueOf(index));
				document.appendChild(event);
				event.appendChild(title);
				event.appendChild(ddl);
				event.appendChild(status);
				
			}
			
			TransformerFactory tff = TransformerFactory.newInstance();
			try {
				Transformer tf = tff.newTransformer();
				tf.setOutputProperty(OutputKeys.INDENT, "yes");
				try {
					//将内容写到.xml中
					tf.transform(new DOMSource(document), new StreamResult(new File("../../../res/file/log" + String.valueOf(usrId) + ".xml")));
				} catch (TransformerException e) {
					e.printStackTrace();
				}
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
    	
        return true;
    }
}
