package com.xrd.service;

import com.xrd.pojo.EdocEntry;
import com.xrd.pojo.EdocEntryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EdocEntryService {
  List<EdocEntry> getall(EdocEntryExample example);

  EdocEntry selectByPrimaryKey(Long id);
  int updateByExampleSelective(@Param("record") EdocEntry record, @Param("example") EdocEntryExample example);


  int deleteByPrimaryKey(Long id);

  int insertSelective(EdocEntry record);
}
