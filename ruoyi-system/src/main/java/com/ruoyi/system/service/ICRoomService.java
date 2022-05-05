package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CRoom;

/**
 * 辅导室Service接口
 *
 * @author ruoyi
 * @date 2022-04-21
 */
public interface ICRoomService
{
    /**
     * 查询辅导室
     *
     * @param roomId 辅导室主键
     * @return 辅导室
     */
    public CRoom selectCRoomByRoomId(Long roomId);

    /**
     * 查询辅导室列表
     *
     * @param cRoom 辅导室
     * @return 辅导室集合
     */
    public List<CRoom> selectCRoomList(CRoom cRoom);

    /**
     * 新增辅导室
     *
     * @param cRoom 辅导室
     * @return 结果
     */
    public int insertCRoom(CRoom cRoom);

//    public int insertcroom(CRoom cRoom);


    /**
     * 修改辅导室
     *
     * @param cRoom 辅导室
     * @return 结果
     */
    public int updateCRoom(CRoom cRoom);

    /**
     * 批量删除辅导室
     *
     * @param roomIds 需要删除的辅导室主键集合
     * @return 结果
     */
    public int deleteCRoomByRoomIds(Long[] roomIds);

    /**
     * 删除辅导室信息
     *
     * @param roomId 辅导室主键
     * @return 结果
     */
    public int deleteCRoomByRoomId(Long roomId);

    /**
     *
     * @return
     */
    public List<CRoom> selectTlocationList();

}
