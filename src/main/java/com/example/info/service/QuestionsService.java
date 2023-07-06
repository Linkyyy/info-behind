package com.example.info.service;

import com.example.info.mapper.QuestionsMapper;
import com.example.info.poji.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {
    @Autowired
    private QuestionsMapper questionsMapper;

    public List<Questions> find(int page, int pageSize){
        int index = (page-1)*pageSize;
        return this.questionsMapper.find(index,pageSize);
    }

    public List<Questions> getQuestionsBySpecialityId(int specialityId, int page, int pageSize) {
        int index = (page - 1) * pageSize;
        return questionsMapper.getQuestionsBySpecialityId(specialityId, index, pageSize);
    }

    public List<Questions> getQuestionsByPaperId(int paperId) {
        return questionsMapper.getQuestionsByPaperId(paperId);
    }

}
