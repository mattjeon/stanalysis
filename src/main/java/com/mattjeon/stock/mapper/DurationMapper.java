/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mattjeon.stock.mapper;


import com.mattjeon.stock.vo.DurationVo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jeon-yeongsu on 2014. 6. 17..
 */
@Repository(value = "durationMapper")
public interface DurationMapper { 

   
    DurationVo getInvestorDurationIncome(@Param("companyCode") String companyCode, @Param("fromDate") String fromDate, @Param("toDate") String toDate);
    
    List<DurationVo> getCompanyCommercialBand(@Param("companyCode") String companyCode, @Param("fromDate") String fromDate, @Param("toDate") String toDate);

    
    
    List<DurationVo>  getIndustryInvestorSumByDurationListByPower( @Param("fromCode") String fromCode,  @Param("toCode") String toCode, @Param("fromDate") String fromDate,  @Param("toDate") String toDate );

    List<DurationVo>  getIndustryInvestorSumByDurationListByLeader( @Param("fromCode") String fromCode,  @Param("toCode") String toCode, @Param("fromDate") String fromDate,  @Param("toDate") String toDate );

    List<DurationVo>  getIndustryInvestorSumByDurationListByForeigner( @Param("fromCode") String fromCode,  @Param("toCode") String toCode, @Param("fromDate") String fromDate,  @Param("toDate") String toDate );
    
    List<DurationVo>  getIndustryInvestorSumByDurationListByOrgSum(@Param("fromCode") String fromCode,  @Param("toCode") String toCode, @Param("fromDate") String fromDate,  @Param("toDate") String toDate );
    

    
    
    List<DurationVo>  getCompanyInvestorSumByDurationListByPower(@Param("fromCode") String fromCode,  @Param("toCode") String toCode, @Param("fromDate") String fromDate,  @Param("toDate") String toDate );

    List<DurationVo>  getCompanyInvestorSumByDurationListByLeader(@Param("fromCode") String fromCode,  @Param("toCode") String toCode, @Param("fromDate") String fromDate,  @Param("toDate") String toDate );

    List<DurationVo>  getCompanyInvestorSumByDurationListByForeigner(@Param("fromCode") String fromCode,  @Param("toCode") String toCode, @Param("fromDate") String fromDate,  @Param("toDate") String toDate );
    
    List<DurationVo>  getCompanyInvestorSumByDurationListByOrgSum(@Param("fromCode") String fromCode,  @Param("toCode") String toCode, @Param("fromDate") String fromDate,  @Param("toDate") String toDate );
    

}
