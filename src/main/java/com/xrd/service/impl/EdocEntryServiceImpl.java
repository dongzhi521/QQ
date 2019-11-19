package com.xrd.service.impl;


import com.xrd.mapper.EdocEntryMapper;
import com.xrd.pojo.EdocEntry;
import com.xrd.pojo.EdocEntryExample;
import com.xrd.service.EdocEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EdocEntryServiceImpl implements  EdocEntryService {

    @Autowired
  private  EdocEntryMapper ss;


    @Override
    public List<EdocEntry> getall(EdocEntryExample example) {
        return ss.all(example);
    }

    @Override
    public EdocEntry selectByPrimaryKey(Long id) {
        return ss.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(EdocEntry record, EdocEntryExample example) {
        return ss.updateByExampleSelective(record,example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return ss.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(EdocEntry record) {
        return ss.insertSelective(record);
    }
}
