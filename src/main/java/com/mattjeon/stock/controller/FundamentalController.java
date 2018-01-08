/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mattjeon.stock.controller;

import com.mattjeon.stock.service.FundamentalService;
import com.mattjeon.stock.vo.FundamentalVo;

import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/fundamental")
@Controller(value = "fundamentalController")
public class FundamentalController {

    @Resource(name = "fundamentalService")
    private FundamentalService fundamentalService;

    
    @RequestMapping(value = "/getCompanyFundamental/{companyCode}", method = RequestMethod.GET)
    public @ResponseBody FundamentalVo getCompanyFundamental(@PathVariable String companyCode) throws Exception {
      return this.fundamentalService.getFundamental(companyCode);
    }
        

    @RequestMapping(value = "/getGoodCompanyList", method = RequestMethod.GET)
    public @ResponseBody List<FundamentalVo> getGoodCompanyList() throws Exception {
        return this.fundamentalService.getGoodCompanyList();
    }

}