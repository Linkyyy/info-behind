package com.example.info.controller.admin;

import com.example.info.poji.Achievement;
import com.example.info.service.AchievementService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    @GetMapping("/getAchievement")
    @ResponseBody
    public Result getAchievement(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        System.out.println(page);
        try {
            System.out.println(page);
            List<Achievement> list = achievementService.find(page, pageSize);
            return Result.ok().data(list).message("查询成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("查询失败：" + e.getMessage());
        }
    }
}
