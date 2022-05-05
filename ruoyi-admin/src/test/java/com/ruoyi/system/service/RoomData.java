package com.ruoyi.system.service;

import com.ruoyi.system.utils.readxml;
import org.dom4j.DocumentException;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoomData {
    class serroom {
        Long roomId;
        String introduction;
        String location;
        Long userNum;
        String a;
    }

    @DataProvider(name = "data")
    public Object[][] roomDate() throws DocumentException {
        List roomList = readxml.readXml("blacktest.xml");
        List<Object> item = new ArrayList<Object>();
        for (int i = 0; i < roomList.size(); i++) {
            Map<String, String> map = (Map<String, String>) roomList.get(i);
            serroom serroom = new serroom();
            serroom.roomId = Long.valueOf(map.get("RoomId"));
            serroom.location = map.get("Location");
            serroom.introduction = map.get("Introduction");
            serroom.userNum = Long.valueOf(map.get("UserNum"));

            item.add(serroom);
        }
        Object[][] result = new Object[item.size()][];
        for (int i = 0; i < item.size(); i++) {
            result[i] = new Object[]{item.get(i)};
        }
        return result;
    }

    ;
}
