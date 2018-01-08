/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mattjeon.stock.controller;

import com.mattjeon.stock.service.TechnicalService;
import com.mattjeon.stock.vo.IndicatorVo;
import com.mattjeon.stock.vo.AdDetailVo;
import com.mattjeon.stock.vo.DurationVo;

import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/technical")
@Controller(value = "technicalController")
public class TechnicalController {

    @Resource(name = "technicalService")
    private TechnicalService technicalService;
    
    @RequestMapping(value = "/getTechnicalResult/{companyCode}/{ciType}", method = RequestMethod.GET)
    public @ResponseBody List<IndicatorVo> getTechnicalResult(@PathVariable("companyCode")  String companyCode, @PathVariable("ciType") String ciType) throws Exception {
      return this.technicalService.getTechnicalResult(companyCode, ciType);
    }
    
    @RequestMapping(value = "/getAdDetail/{companyCode}/{ciType}/{regDate}", method = RequestMethod.GET)
    public @ResponseBody AdDetailVo getAdDetail(@PathVariable("companyCode") String companyCode, @PathVariable("ciType") String ciType, @PathVariable("regDate") String regDate) throws Exception {
      return this.technicalService.getAdDetail(companyCode, ciType, regDate);
    }
        
}
