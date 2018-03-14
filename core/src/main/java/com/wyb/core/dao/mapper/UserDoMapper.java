package com.wyb.core.dao.mapper;

import com.wyb.core.dao.entity.UserDo;

/**
 * @author Kunzite
 */
public interface UserDoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDo record);

    int insertSelective(UserDo record);

    UserDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDo record);

    int updateByPrimaryKey(UserDo record);
}