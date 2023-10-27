package com.ruoyi.chat.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yixiaofei
 * @description:
 * @date: 2023/10/24 16:19
 */
@RestController
@RequestMapping("test/")
public class ChatController extends BaseController {

    @GetMapping("{id}")
    public AjaxResult test(@PathVariable String id){
        return AjaxResult.success("哈哈哈..."+id);
    }
}
