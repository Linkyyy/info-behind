package com.example.info.service;

import com.example.info.mapper.AchievementMapper;
import com.example.info.poji.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService {
    @Autowired
    private AchievementMapper achievementMapper;

    public List<Achievement> find(int page, int pageSize){
        int index = (page-1)*pageSize;
        return this.achievementMapper.find(index,pageSize);
    }
}
