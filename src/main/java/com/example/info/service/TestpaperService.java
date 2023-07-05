package com.example.info.service;

import com.example.info.mapper.TestpaperMapper;
import com.example.info.poji.Testpaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestpaperService {
    @Autowired
    private TestpaperMapper testPaperMapper;

    public List<Testpaper> find(int page, int pageSize){
        int index = (page-1)*pageSize;
        return this.testPaperMapper.find(index,pageSize);
    }
}
