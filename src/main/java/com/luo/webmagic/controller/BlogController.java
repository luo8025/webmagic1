package com.luo.webmagic.controller;

import com.luo.webmagic.common.ResultDTO;
import com.luo.webmagic.entity.Blog;
import com.luo.webmagic.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mongo")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/queryAll")
    ResponseEntity<ResultDTO> query(){
        ResultDTO retDTO = new ResultDTO();
        retDTO.setStatus(HttpStatus.OK.value());
        retDTO.setMessage("success");
        retDTO.setData(blogService.query());
        retDTO.setRel(true);
        return ResponseEntity.ok(retDTO);
    }


    @PostMapping("/add")
    ResponseEntity<ResultDTO> add(@RequestBody Blog blog) throws Exception{
        ResultDTO retDTO = new ResultDTO();
        try {
            blogService.add(blog);
            retDTO.setStatus(HttpStatus.OK.value());
            retDTO.setMessage("success");
        }catch (Exception e){
            e.printStackTrace();
            retDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            retDTO.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(retDTO);
    }

}
