package com.xrd.service.impl;

import com.xrd.mapper.EdocCategoryMapper;
import com.xrd.pojo.EdocCategory;
import com.xrd.pojo.EdocCategoryExample;
import com.xrd.service.EdocCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdocCategoryServiceImpl implements EdocCategoryService {

    @Autowired
    private EdocCategoryMapper cm;

    @Override
    public List<EdocCategory> selectByExample(EdocCategoryExample example) {
        return cm.selectByExample(null);
    }
}
