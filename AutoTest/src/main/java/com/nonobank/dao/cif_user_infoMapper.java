package com.nonobank.dao;

import com.nonobank.domain.cif_user_info;

public interface cif_user_infoMapper {
    int deleteByPrimaryKey(String id);

    int insert(cif_user_info record);

    int insertSelective(cif_user_info record);

    String selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(cif_user_info record);

    int updateByPrimaryKey(cif_user_info record);
}