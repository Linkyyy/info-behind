package com.example.info.controller.admin;

import com.example.info.poji.Testpaper;
import com.example.info.service.TestpaperService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class TestpaperController {
    @Autowired
    private TestpaperService testPaperService;

    @GetMapping("/getPaper")
    @ResponseBody
    public Result getPaper(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        System.out.println(page);
        List<Testpaper> list= testPaperService.find(page,pageSize);
        return Result.ok().data(list).message("查询成功！");
    }
}
