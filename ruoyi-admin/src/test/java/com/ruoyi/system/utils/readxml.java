package com.ruoyi.system.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.util.ArrayList;

public class readxml {

    public static ArrayList readXml(String file) throws DocumentException {
        List list=new ArrayList();//List<Element>
        String path=ClassLoader.getSystemResource(file).getPath();
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(path);
            Element root = document.getRootElement();

            for(Iterator iter = root.elementIterator(); iter.hasNext();) {
                Element element = (Element) iter.next();
                HashMap<String, String> hm = new HashMap<>();
                for (Iterator iterIn = element.elementIterator(); iterIn.hasNext(); ) {
                    int num = 0;
                    Element elementIn = (Element) iterIn.next();

//                    if (elementIn.getName().contains("PType") || elementIn.getName().contains("PCard") ||
//                            elementIn.getName().contains("Area") || elementIn.getName().contains("Space") ||
//                            elementIn.getName().contains("Price")||elementIn.getName().contains("Ticketprice")) {
//                        hm.put(elementIn.getName(), elementIn.getText());
//                    } else {
//                        for (Iterator iterInner1 = elementIn.elementIterator(); iterInner1.hasNext(); ) {
//                            num++;
//                            Element element1 = (Element) iterInner1.next();
//                            hm.put(String.format(element1.getName() + "%s", num), element1.getText());
//                            hm.put("num", String.valueOf(num));
//                        }
//                    }


                    if(elementIn.getName().contains("RoomId")|| elementIn.getName().contains("Introduction")||
                            elementIn.getName().contains("Location")|| elementIn.getName().contains("UserNum")){
                        hm.put(elementIn.getName(), elementIn.getText());
                    }
                }
                list.add(hm);
            }

        }catch (DocumentException e){
            e.printStackTrace();
        }
        return (ArrayList) list;
    }

}
