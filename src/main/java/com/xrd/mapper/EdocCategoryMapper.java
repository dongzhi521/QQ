package com.xrd.mapper;

import com.xrd.pojo.EdocCategory;
import com.xrd.pojo.EdocCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EdocCategoryMapper {
    int countByExample(EdocCategoryExample example);

    int deleteByExample(EdocCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EdocCategory record);

    int insertSelective(EdocCategory record);

    List<EdocCategory> selectByExample(EdocCategoryExample example);

    EdocCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EdocCategory record, @Param("example") EdocCategoryExample example);

    int updateByExample(@Param("record") EdocCategory record, @Param("example") EdocCategoryExample example);

    int updateByPrimaryKeySelective(EdocCategory record);

    int updateByPrimaryKey(EdocCategory record);
}