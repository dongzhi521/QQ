package com.xrd.service;

import com.xrd.pojo.EdocCategory;
import com.xrd.pojo.EdocCategoryExample;

import java.util.List;

public interface EdocCategoryService {

    List<EdocCategory> selectByExample(EdocCategoryExample example);
}
