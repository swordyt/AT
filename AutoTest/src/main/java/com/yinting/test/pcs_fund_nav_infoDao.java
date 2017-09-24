package com.yinting.test;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
@Service
public interface pcs_fund_nav_infoDao {
	@Select("select count(*) from pcs_fund_nav_info")
	public String getCount();
}

