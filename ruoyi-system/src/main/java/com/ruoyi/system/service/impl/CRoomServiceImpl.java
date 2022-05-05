package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CRoomMapper;
import com.ruoyi.system.domain.CRoom;
import com.ruoyi.system.service.ICRoomService;

/**
 * 辅导室Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-21
 */
@Service
public class CRoomServiceImpl implements ICRoomService
{
    @Autowired
    private CRoomMapper cRoomMapper;

    /**
     * 查询辅导室
     *
     * @param roomId 辅导室主键
     * @return 辅导室
     */
    @Override
    public CRoom selectCRoomByRoomId(Long roomId)
    {
        return cRoomMapper.selectCRoomByRoomId(roomId);
    }

    /**
     * 查询辅导室列表
     *
     * @param cRoom 辅导室
     * @return 辅导室
     */
    @Override
    public List<CRoom> selectCRoomList(CRoom cRoom)
    {
        return cRoomMapper.selectCRoomList(cRoom);
    }

    /**
     * 新增辅导室
     *
     * @param cRoom 辅导室
     * @return 结果
     */
    @Override
    public int insertCRoom(CRoom cRoom)
    {
        return cRoomMapper.insertCRoom(cRoom);
    }

//    public static int insertcroom(CRoom cRoom)
//    {
//        return cRoomMapper.insertcroom(cRoom);
//    }

    /**
     * 修改辅导室
     *
     * @param cRoom 辅导室
     * @return 结果
     */
    @Override
    public int updateCRoom(CRoom cRoom)
    {
        return cRoomMapper.updateCRoom(cRoom);
    }

    /**
     * 批量删除辅导室
     *
     * @param roomIds 需要删除的辅导室主键
     * @return 结果
     */
    @Override
    public int deleteCRoomByRoomIds(Long[] roomIds)
    {
        return cRoomMapper.deleteCRoomByRoomIds(roomIds);
    }

    /**
     * 删除辅导室信息
     *
     * @param roomId 辅导室主键
     * @return 结果
     */
    @Override
    public  int deleteCRoomByRoomId(Long roomId)
    {
        return cRoomMapper.deleteCRoomByRoomId(roomId);
    }

    /**
     *
     * @return
     */
    @Override
    public List<CRoom> selectTlocationList(){return cRoomMapper.selectTlocationList();};

}
