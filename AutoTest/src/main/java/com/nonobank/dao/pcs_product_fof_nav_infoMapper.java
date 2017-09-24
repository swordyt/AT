package com.nonobank.dao;

import com.nonobank.domain.pcs_product_fof_nav_info;

public interface pcs_product_fof_nav_infoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(pcs_product_fof_nav_info record);

    int insertSelective(pcs_product_fof_nav_info record);

    String selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(pcs_product_fof_nav_info record);

    int updateByPrimaryKey(pcs_product_fof_nav_info record);
}