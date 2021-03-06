/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mattjeon.stock.mapper;


import com.mattjeon.stock.vo.IndicatorVo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jeon-yeongsu on 2014. 6. 17..
 */
@Repository(value = "rawDataMapper")
public interface RawDataMapper { 

    List<IndicatorVo> getCompanyRawData(@Param("companyCode") String companyCode );
    
    List<IndicatorVo> getIndustryRawData(@Param("companyCode") String companyCode );

}
