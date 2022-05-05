
package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.CRoom;
import com.ruoyi.system.mapper.CRoomMapper;
import com.ruoyi.system.service.impl.CRoomServiceImpl;
import com.ruoyi.system.utils.readxml;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.*;


import static org.testng.Assert.*;


//@Guice
public class ICRoomServiceTest {
    class serroom{
        Long roomId;
        String introduction;
        String location;
        Long userNum;
        String a;
    }
    private static String b;

    @DataProvider(name="ro")
    public Object[][] provider() throws IOException, DocumentException {
        List roomList= readxml.readXml("blacktest.xml");
        List<Object> item=new ArrayList<Object>();
        for(int i=0;i<roomList.size();i++){
            Map<String,String> map=(Map<String, String>) roomList.get(i);
            serroom serroom=new serroom();
            serroom.roomId= Long.valueOf(map.get("RoomId"));
            serroom.location=map.get("Location");
            serroom.introduction=map.get("Introduction");
            serroom.userNum= Long.valueOf(map.get("UserNum"));

            item.add(serroom);
        }
        Object[][] result=new Object[item.size()][];
        for(int i=0;i<item.size();i++){
            result[i]=new Object[]{item.get(i)};
        }
        return  result;
    }

    @AfterMethod
    public void tearDown() {

    }

    @Autowired
    private ICRoomService cRoomService;
    @Test(dataProvider = "ro")//,dataProviderClass = RoomData.class
    public void testInsertCRoom(serroom serroom) throws Exception{
        CRoom cro=new CRoom();
        cro.setRoomId(serroom.roomId);
        cro.setIntroduction(serroom.introduction);
        cro.setLocation(serroom.location);
        cro.setUserNum(serroom.userNum);

        cRoomService.insertCRoom(cro);
//        CRoomMapper.insertcroom(cro);
    }

    @Test
    public void testDeleteCRoomByRoomIds() {
    }

    @Test
    public void testDeleteCRoomByRoomId() {
    }
}

