/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mattjeon.stock.controller;

import com.mattjeon.stock.service.RecommendService;
import com.mattjeon.stock.vo.RecommendVo;

import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/recommend")
@Controller(value = "recommendController")
public class RecommendController {

    @Resource(name = "recommendService")
    private RecommendService recommendService;

    
    @RequestMapping(value = "/addRecommendCompany", method = RequestMethod.GET)
    @ResponseBody
    public String addRecommend() throws Exception {
    	String resultCode = this.recommendService.addRecommendCompany();
        return resultCode;
    }
    
    @RequestMapping(value = "/getRecommendCompanyDateList", method = RequestMethod.GET)
    public @ResponseBody List<RecommendVo> getRecommendCompanyDateList() throws Exception {
        return this.recommendService.getRecommendCompanyDateList();
    }

    
    @RequestMapping(value = "/getRecommendCompanyListByCondition/{regDate}/{conditionType}", method = RequestMethod.GET)
    public @ResponseBody List<RecommendVo> getRecommendCompanyListByCondition(@PathVariable("regDate") String regDate, @PathVariable("conditionType") String conditionType) throws Exception {
        return this.recommendService.getRecommendCompanyListByCondition(regDate, conditionType);
    }
    
}