<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!doctype html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"> 
	
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/highstock.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/highcharts.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/module/exporting.js"></script>
	
	<script>
  
 	$(function() {
		
	    $( "#tabs" ).tabs();
	    
	    <%
	    String req = request.getParameter("companyCode");
	    String req2 = request.getParameter("industryCode");
	    String req3 = request.getParameter("marketKind");
	    %>
	   
	    var companyCode = '<%=req%>';
	    var industryCode = '<%=req2%>';
	    var marketKind = '<%=req3%>';
	    
		$( "#input_company_code" ).val(companyCode);
		$( "#input_industry_code" ).val(industryCode);
		$( "#input_market_kind" ).val(marketKind);
		$( "#input_company_name" ).focus();
		
	    
	    //달력세팅
  		$( "#from_date_duravol" ).datepicker({ dateFormat: "yymmdd" });
		$( "#from_date_duravol" ).datepicker("setDate", -365);
		$( "#to_date_duravol" ).datepicker({  dateFormat: "yymmdd" });
		$( "#to_date_duravol" ).datepicker("setDate", "today");
		$( "#input_trade_regdate" ).datepicker({ dateFormat: "yymmdd"	});


	    // 종목  AutoComplete
	    var projects = [];
	    
	    $.getJSON('common/getAllCompanyList',	function(data) {
			$.each( data, function( key, val){
				projects.push({'value': val.companyCode, 'label':val.companyName, 'value2': val.industryCode, 'value3': val.marketKind});
			});
		});
	    
	    $( "#input_company_name" ).autocomplete({
	      minLength: 0,
	      source: projects,
	      focus: function( event, ui ) {
	    	$( "#input_company_name" ).val( ui.item.label );
	    	$( "#input_company_code" ).val( ui.item.value );
	        $( "#input_industry_code" ).val( ui.item.value2 );
	    	$( "#input_market_kind" ).val( ui.item.value3 );
	        return false;
	      },
	      select: function( event, ui ) {
	    	$( "#input_company_name" ).val( ui.item.label );
	        $( "#input_company_code" ).val( ui.item.value );
	        $( "#input_industry_code" ).val( ui.item.value2 );
	        $( "#input_market_kind" ).val( ui.item.value3 );
	        
	        getCompanyInformation(ui.item.value, ui.item.value3, ui.item.value2);
	        return false;
	      }
	    })
	    .autocomplete( "instance" )._renderItem = function( ul, item ) {
	      return $( "<li>" )
	        .append( "<a>" + item.label + "[" + item.value + "][" + item.value3 + "][" + item.value2 + "]</a>" )
	        .appendTo( ul );
	    };
	    
	    // 업종 AutoComplete
        var projectsi = [];
	    
	    $.getJSON('common/getAllIndustryList',	function(data) {
			$.each( data, function( key, val){
				projectsi.push({'value': val.industryCode, 'label':val.industryName});
			});
		});
	    
	    $( "#input_industry_name" ).autocomplete({
	      minLength: 0,
	      source: projectsi,
	      focus: function( event, ui ) {
	    	$( "#input_industry_name" ).val( ui.item.label );
	        return false;
	      },
	      select: function( event, ui ) {
	    	$( "#input_industry_name" ).val( ui.item.label );
	        $( "#input_industry_code" ).val( ui.item.value );
	        
	        getIndustryInformation(ui.item.value);
	        return false;
	      }
	    })
	    .autocomplete( "instance" )._renderItem = function( ul, item ) {
	      return $( "<li>" )
	        .append( "<a>" + item.label + "[" + item.value + "]</a>" )
	        .appendTo( ul );
	    };
	    
 
	    //자동조회
	    if($("#input_company_code").val() != "null"){
	    	getCompanyInformation($("#input_company_code").val(), $("#input_market_kind").val(), $("#input_industry_code").val());
	    }
	    
	    if($("#input_company_code").val() == "null" && $("#input_industry_code").val() != "null"){
	    	getIndustryInformation($("#input_industry_code").val());
	    }
	    
  	});
  
  	
  	
  	
   // 버튼 처리
	$(function() {
		
		$("#search_btn_company").click(function() {
	    	event.preventDefault();
	        var companyCode = $("#input_company_code").val();
	        var industryCode = $("#input_industry_code").val();
	        var marketKind = $("#input_market_kind").val();
	        getCompanyInformation(companyCode, marketKind, industryCode);
	    });
	    
	    $("#search_btn_industry").click(function() {
	    	event.preventDefault();
	        var industryCode = $("#input_industry_code").val();
	        getIndustryInformation(industryCode);
	    });

	    //이동
	    $("#nav_btn_overview").click(function() {
	    	event.preventDefault();
	        window.open('Overview.jsp', '_blank');
        });
	    
	    $("#nav_btn_recommend").click(function() {
	    	event.preventDefault();
	        window.open('Recommend.jsp', '_blank');
        });
	       
        $("#nav_btn_duration").click(function() {
	    	event.preventDefault();
	        window.open('Duration.jsp', '_blank');
        });
        
	    $("#nav_btn_adDetail").click(function() {
	    	event.preventDefault();
	        var companyCode = $("#input_company_code").val();
	        var companyName = $("#input_company_name").val();
	        var industryCode = $("#input_industry_code").val();
	        var marketKind = $("#input_market_kind").val();
	        var url = 'AdDetailAnalysis.jsp?companyName='+encodeURI(encodeURIComponent(companyName))+'&companyCode='+companyCode+'&industryCode='+industryCode+'&marketKind='+marketKind;
      	    window.open(url, 'popup01', 'width=1000px, height=600px, scrollbars=1, toolbar=0, menubar=no');
        });

	});
  
  //get Company 
  function getCompanyInformation(searchCode, marketKind, industryCode) {
	  $.ajax({
	        async   : true,
	  });
	  
	  $("body").addClass("loading");

	  $.getJSON("fundamental/getCompanyFundamental/"+searchCode, function(data) {
	   		if( data == null ){    alert("Not Found Data"); }
	   	 	else{
	   			createFundamentalTable( data );
	   		}
	   });
 
	  $.getJSON("technical/getTechnicalResult/"+searchCode+"/C", function(data) {
		   
			if( data == null ){    alert("Not Found Data"); }
			else{
				createIndicateChart(data);
				createLdsTable( data );

 			}
			 $("body").removeClass("loading");
	   });

 	   createFnguidePage(searchCode);
	   createPaxnetPage(searchCode);
	   createThinkpoolThemePage(searchCode);
	   createInfostockTradePage(searchCode);
  }
  
  
  //get Industry 
  function getIndustryInformation(searchCode) {
	  $("body").addClass("loading");
	  
      $('#company_review_table').html("");
	  $('#fundamental_review_table').html("");
	   
	  $.getJSON("technical/getTechnicalResult/"+searchCode+"/I", function(data) {
		   
			if( data == null ){    alert("Not Found Data"); }
			else{
				createIndicateChart(data);
				createLdsTable( data );

			}
			 $("body").removeClass("loading");
	   });
  }
  
  function createFundamentalTable(data){
	    var qBusinessProfit = (data.qBusinessProfit/1000000).toFixed(0);
	    var qTermNetProfit = (data.qTermNetProfit/1000000).toFixed(0);
	    var yBusinessProfit = (data.yBusinessProfit/1000000).toFixed(0);
	    var yTermNetProfit = (data.yTermNetProfit/1000000).toFixed(0);
	    var qSales = data.qSales;
	    var ySales = data.ySales;
	    
	    var currentTotalPrice = data.totalStocks*data.closePrice;
	    currentTotalPrice = (currentTotalPrice.toString()).substring(0, (currentTotalPrice.toString()).length-9);
	    
	    //타이틀 설정   
		document.title = data.companyName+"_"+data.companyCode+"_"+data.regDate; 
		
	    var content = "<table>";
		    content += "<thead > ";
		    content += "<tr>";
		    content += "  <th width='10%'>종목명</th>";
		    content += "  <th width='5%'>시장</th>";
		    content += "  <th width='10%'>업종</th>";
		    content += "  <th width='5%'>KOSPI200</th>";
		    content += "  <th width='5%'>현주가 </th>";
		    content += "  <th width='7%'>주식수 </th>";
		    content += "  <th width='8%'>시가총액(십억원) </th>";
		    content += "  <th width='8%'>자본금(백만원) </th>";
		    content += "  <th width='7%'>액면가(원) </th>";
		    content += "</tr>";
		    content += "</thead > ";
		    content += "<tbody > ";
		    content += "<tr>";
		    content += "  <th >"+data.companyName+" ["+data.companyCode+"]</th>";
		    content += "  <th >"+data.marketKind+"</th>";
		    content += "  <th ><a href='Analysis.jsp?industryCode="+data.industryCode+"' , target='_blank'>"+data.industryName+" ["+data.industryCode+"] </a></th>";
		    content += "  <th >"+data.kospi200+"</th>";
		    content += "  <th >"+addCommas(data.closePrice)+"</th>";
		    content += "  <th >"+addCommas(data.totalStocks)+"</th>";
		    content += "  <th >"+addCommas(currentTotalPrice)+"</th>";
		    content += "  <th >"+addCommas(data.capital)+"</th>";
		    content += "  <th >"+addCommas(data.faceValue)+"</th>";
		    content += "</tr>";
		    content += " </tbody> ";
		    content += " </table> <BR>";
		    $('#company_review_table').html(content);
			
		    TOTAL_STOCKS = data.totalStocks;
		    
			content = "<table>";
		    content += "<thead >";
		    content += " <tr>  ";
		    content += "  <th width='10%' rowspan = '2'>재무평가</th>";
		    content += "  <th width='20%' colspan='3'>주가적정성</th><th width='20%' colspan='3'> 수익성(백만원)  </th>";
		    content += "  <th width='20%' colspan='3'>성장성(%) </th><th width='20%' colspan='2'>안정성 </th>";
		    content += " </tr>  ";
		    content += " <tr>  ";
		    content += "  <th >PBR<BR> <= 1 </th ><th>PER<BR> <= 15 </th><th>ROE<BR> >= 5 </th>";
		    content += "  <th >매출액</th><th >영업이익</th><th >순이익</th>";
		    content += "  <th >매출액증가율</th><th >영업이익증가율</th><th >순이익증가율</th>";
		    content += "  <th >부채비율<BR> <= 100 </th><th >유보율<BR> >= 500</th>";
		    content += "  </tr>  ";
		    content += "</thead>  ";
		    content += "<tbody > ";
		    
		    content += "<tr id='fundmental'>";
		    content += "  <th>"+data.qSettingYyyymm+" (분기)</th>";
		    content += "  <th id='pbr'>"+data.qPbr.toFixed(1)+"</th><th id='per'>"+data.qPer.toFixed(1)+"</th><th id='roe'>"+data.qRoe.toFixed(1)+"</th>";
		    content += "  <th id='growth'>"+qSales+"</th><th id='growth'>"+qBusinessProfit+"</th><th id='growth'>"+qTermNetProfit+"</th>";
		    content += "  <th id='growth'>"+data.qSalesRiseRatio+" </th><th id='growth'>"+data.qBusinessProfitRiseRatio+"</th><th id='growth'>"+data.qNetProfitRiseRatio+"</th>";
		    content += "  <th id='debt'>"+data.qDebtRatio+"</th><th id='retention'>"+data.qRetentionRatio+"</th>";
		    content += "</tr>";
		    content += "<tr id='fundmental'>";
		    content += "  <th>"+data.ySettingYyyymm+" (연간)</th>";
		    content += "  <th id='pbr'>"+data.yPbr.toFixed(1)+"</th><th id='per'>"+data.yPer.toFixed(1)+"</th><th id='roe'>"+data.yRoe.toFixed(1)+"</th>";
		    content += "  <th id='growth'>"+ySales+"</th><th id='growth'>"+yBusinessProfit+"</th><th id='growth'>"+yTermNetProfit+"</th>";
		    content += "  <th id='growth'>"+data.ySalesRiseRatio+" </th><th id='growth'>"+data.yBusinessProfitRiseRatio+"</th><th id='growth'>"+data.yNetProfitRiseRatio+"</th>";
		    content += "  <th id='debt'>"+data.yDebtRatio+"</th><th id='retention' >"+data.yRetentionRatio+"</th>";
		    content += "</tr>";
		    content += " </tbody> ";
		    content += " </table> <BR>";
			$('#fundamental_review_table').html(content);
			// 스타일 시트 적용 
			$('#fundmental > #pbr').filter( function(index){ if( $(this).text() > 2 ){ return true; } }).css('background-color', 'orange');
			$('#fundmental > #pbr').filter( function(index){ if( $(this).text() <= 2 && $(this).text() > 1.0){ return true; } }).css('background-color', 'beige');
			$('#fundmental > #pbr').filter( function(index){ if( $(this).text() <= 1.0 ){ return true; } }).css('background-color', 'palegreen');
			$('#fundmental > #per').filter( function(index){ if( $(this).text() >= 20 ){ return true;} }).css('background-color', 'orange');
			$('#fundmental > #per').filter( function(index){ if( $(this).text() < 25 && $(this).text() >= 15){ return true;} }).css('background-color', 'beige');
			$('#fundmental > #per').filter( function(index){ if( $(this).text() <= 15){ return true;} }).css('background-color', 'palegreen');
			$('#fundmental > #roe').filter( function(index){ if( $(this).text() < 0.1  ){ return true; } }).css('background-color', 'orange');
			$('#fundmental > #roe').filter( function(index){ if( $(this).text() >= 0.1 && $(this).text() < 5  ){ return true; } }).css('background-color', 'beige');
			$('#fundmental > #roe').filter( function(index){ if( $(this).text() >= 5  ){ return true; } }).css('background-color', 'palegreen');
			$('#fundmental > #growth').filter( function(index){ if( $(this).text() > 0 ){ return true; } }).css('background-color', 'palegreen');
			$('#fundmental > #growth').filter( function(index){ if( $(this).text() <= 0 ){ return true; } }).css('background-color', 'orange');
			$('#fundmental > #debt').filter( function(index){ if( $(this).text() >= 100 ){ return true; } }).css('background-color', 'orange');
			$('#fundmental > #debt').filter( function(index){ if( $(this).text() < 100 ){ return true; } }).css('background-color', 'palegreen');
			$('#fundmental > #retention').filter( function(index){ if( $(this).text() <= 500 ){ return true; }}).css('background-color', 'orange');
			$('#fundmental > #retention').filter( function(index){ if( $(this).text() > 500 ){ return true; }}).css('background-color', 'palegreen');
	}
 

  // 싱크로나이즈 챠트 작성 
  var chart1;
  var chart2;
  function syncronizeCrossHairs(chart) {
      var container = $(chart.container),
          offset = container.offset(),
          x, y, isInside, report;

      container.mousemove(function(evt) {
    	    //var chart = Highcharts.charts[0];
    	    x = evt.clientX - chart.plotLeft - offset.left;
            y = evt.clientY - chart.plotTop - offset.top;
            
    	    var xaxis = chart.xAxis[0];
    	    var yaxis = chart.yAxis[0];
    	    var x = xaxis.toValue(evt.offsetX, false);
    	    var y = yaxis.toValue(evt.offsetY, false);
    	    
    	    // Chart1
    	    var xaxis1 = chart1.xAxis[0];
    	    var yaxis1 = chart1.yAxis[0];
    	    
    	    xaxis1.removePlotLine('plot-line-x');
    	    yaxis1.removePlotLine('plot-line-y');
    	    
    	    xaxis1.addPlotLine({
    	        value: x,
    	        color: 'red',
    	        width: 1,
    	        id: 'plot-line-x'
    	    });
    	    yaxis1.addPlotLine({
    	        value: y,
    	        color: 'red',
    	        width: 1,
    	        id: 'plot-line-y'
    	    });
    	    
    	    // Chart2
    	    var xaxis2 = chart2.xAxis[0];
    	    var yaxis2 = chart2.yAxis[0];
    	    
    	    xaxis2.removePlotLine('plot-line-x');
    	    yaxis2.removePlotLine('plot-line-y');
    	    
    	    xaxis2.addPlotLine({
    	        value: x,
    	        color: 'red',
    	        width: 1,
    	        id: 'plot-line-x'
    	    });
    	    yaxis2.addPlotLine({
    	        value: y,
    	        color: 'red',
    	        width: 1,
    	        id: 'plot-line-y'
    	    });
    	    
     	});
  }

  
  function createIndicateChart(data){
	  $(document).ready(function() {
		  
		  // Data 정리  
		  var vdate;
		  var lastIndex = data.length - 1;
		  
		  // 주가 지표 및 이평선, 볼린저 밴드, 업종 가격
		  var ohlc = [];
		  var openPrice = [], highPrice = [], lowPrice = [], closePrice = [];
		  var ma5 = [],  ma20 = [], ma60 = [], ma240 = [], ma720 = [];
		  // 거래량 및 거래량 이평선
		  var volume = [], volume20 = [];
		  var updownRatio = [];

		  // 거래신호
		  var tradeSignal = [];
		  var tradeSignalPower = [];
		  var tradeSignalLeader = [];
		  var tradeSignalForeigner = [];
		  var tradeSignalOrgSum = [];

		   var upperBand = [], middleBand = [], lowerBand = [];
		  //보조지표
		  var macd = [], macdSignal = [], macdHist = [], macdRate = [];

		  var powerCorrelLong = [], leaderCorrelLong = [];
		  var powerCorrelShort = [], leaderCorrelShort = [];

		  // 수급 분산 비율
 		  var personalWL = [], powerWL = [], leaderWL = [], foreignerWL = [], orgSumWL = [];

		  var powerAccr = [], leaderAccr = [], foreignerAccr = [], orgSumAccr = [];
 		  
		  var power = [], leader = [], foreigner = [], orgSum = [];
		  var investTrust = [], pension = [];


		// 수급 분산 비율
		  var powerSum = [], leaderSum = [], foreignerSum = [], orgSumSum= [];
		  var pensionSum = [], investTrustSum = [];

		  // 수급 분산 비율
		  var powerLds5 = [], leaderLds5 = [], foreignerLds5 = [], orgSumLds5 = [];
		  var pensionLds5 = [], investTrustLds5 = [];

		  var powerLds20 = [], leaderLds20 = [], foreignerLds20 = [], orgSumLds20 = [];
		  var pensionLds20 = [], investTrustLds20 = [];

		  $.each( data, function( key, val){
			    vdate = chartDateFormat(val.regDate);
			    
			    //
			    openPrice.push([ vdate, val.openPrice]);
			    highPrice.push([ vdate, val.highPrice]);
			    lowPrice.push([ vdate, val.lowPrice]);
			    closePrice.push([ vdate, val.closePrice]);
				//주가
			    ohlc.push([ vdate, val.openPrice, val.highPrice, val.lowPrice, val.closePrice ]);
				ma5.push([ vdate, val.ma5 ]);
				ma20.push([ vdate, val.ma20 ]);
				ma60.push([ vdate, val.ma60 ]);
				ma240.push([ vdate, val.ma240 ]);
				ma720.push([ vdate, val.ma720 ]);

				volume20.push([ vdate, val.volume20 ]);
				// 
				volume.push([ vdate, val.volume ]); 
				updownRatio.push([ vdate, val.updownRatio ]); 

				//
				tradeSignal.push([vdate, val.tradeSignal]);
 				tradeSignalPower.push([vdate, val.tradeSignalPower]);
				tradeSignalLeader.push([vdate, val.tradeSignalLeader]);
				tradeSignalForeigner.push([vdate, val.tradeSignalForeigner]);
				tradeSignalOrgSum.push([vdate, val.tradeSignalOrgSum]);

/* 				upperBand.push([ vdate, val.upperBand ]);
				middleBand.push([ vdate, val.middleBand ]);
				lowerBand.push([ vdate, val.lowerBand ]);
 */
/* 				macd.push([vdate, val.macd]);
				macdSignal.push([vdate, val.macdSignal]);
				macdHist.push([vdate, val.macdHist/100]);
 */				macdRate.push([vdate, val.macdRate]);

/* 				rsi.push([vdate, val.rsi]);
				rsiSignal.push([vdate, val.rsiSignal]);
 */
				//slowK.push([vdate, val.slowK]);
				//slowD.push([vdate, val.slowD]);

//				obv.push([vdate, val.obv]);


 			    powerCorrelLong.push([ vdate, val.powerCorrelLong]);
 			    leaderCorrelLong.push([ vdate, val.leaderCorrelLong]);

 			    powerCorrelShort.push([ vdate, val.powerCorrelShort]);
 			    leaderCorrelShort.push([ vdate, val.leaderCorrelShort]);

 			    //수급
 			    personalWL.push([ vdate, val.personalWL]);
 			    powerWL.push([ vdate, val.powerWL]);
 			    leaderWL.push([ vdate, val.leaderWL]);
			    foreignerWL.push([ vdate, val.foreignerWL]);
			    orgSumWL.push([ vdate, val.orgSumWL]);

			    powerAccr.push([ vdate, val.powerAccr]);
 			    leaderAccr.push([ vdate, val.leaderAccr]);
			    foreignerAccr.push([ vdate, val.foreignerAccr]);
			    orgSumAccr.push([ vdate, val.orgSumAccr]);
//			    personalAccr.push([ vdate, val.personalAccr]);
//			    finInvestAccr.push([  vdate, val.finInvestAccr ]);
//		  		insuranceAccr.push([ vdate, val.insuranceAccr]);
//		  		investTrustAccr.push([  vdate, val.investTrustAccr ]);
/*		  		bankAccr.push([  vdate, val.bankAccr ]);
		  		etcFinAccr.push([  vdate, val.etcFinAccr ]);
		  		pensionAccr.push([ vdate, val.pensionAccr ]);
		  		etcCorpAccr.push([ vdate, val.etcCorpAccr ]);
		  		etcForeignerAccr.push([ vdate, val.etcForeignerAccr ]);
		  		privateFundAccr.push([ vdate, val.privateFundAccr ]);
		  		nationAccr.push([ vdate, val.nationAccr ]);
 */		 
				powerSum.push([	vdate, val.powerSum ]);
  				leaderSum.push([ vdate, val.leaderSum]);
				foreignerSum.push([  vdate, val.foreignerSum ]);
		  		orgSumSum.push([  vdate, val.orgSumSum ]);
		  		investTrustSum.push([  vdate, val.investTrustSum ]);
		  		pensionSum.push([ vdate, val.pensionSum ]);

				//
 				power.push([vdate, val.power]);
 			    leader.push([ vdate, val.leader]);
				foreigner.push([vdate, val.foreigner]);
				orgSum.push([vdate, val.orgSum]);
		  		investTrust.push([  vdate, val.investTrust ]);
		  		pension.push([ vdate, val.pension ]);

			    powerLds5.push([ vdate, val.powerLds5]);
 			    leaderLds5.push([ vdate, val.leaderLds5]);
			    foreignerLds5.push([ vdate, val.foreignerLds5]);
			    orgSumLds5.push([ vdate, val.orgSumLds5]);
		  		investTrustLds5.push([  vdate, val.investTrustLds5 ]);
		  		pensionLds5.push([ vdate, val.pensionLds5 ]);

			    powerLds20.push([ vdate, val.powerLds20]);
 			    leaderLds20.push([ vdate, val.leaderLds20]);
			    foreignerLds20.push([ vdate, val.foreignerLds20]);
			    orgSumLds20.push([ vdate, val.orgSumLds20]);
		  		investTrustLds20.push([  vdate, val.investTrustLds20 ]);
		  		pensionLds20.push([ vdate, val.pensionLds20 ]);

			});
		  
		  // AD Chart 
		  
		  chart1 = new Highcharts.StockChart({
	          chart: {
	              renderTo: 'overview_chart',
	              type: 'line',
	              zoomType: 'x',
	              borderColor: 'black',
	              backgroundColor: 'lightgray',
	              borderWidth: 1,
	              isZoomed:true,
/* 	              events: {
	                  load: function () {
	                	  chart1.yAxis[0].setExtremes(2000, 6000, true, true);
	                  }
	              }
 */	          },
	          title : $('#input_company_name').val(),
	          plotOptions: {
	        	  candlestick: {  color: 'green', upColor: 'red'  }
	              , column: { stacking: 'normal' }
	          	  , series: { marker: { states: { hover: { enabled: false } } } }
	          },
			  rangeSelector : {
					buttons : [{ type : 'year',	    count : 1,	text : '1Y' },
					           { type : 'year',		count : 2,	text : '2Y' }, 
					           { type : 'year',		count : 3,	text : '3Y' }, 
					           { type : 'year',		count : 5,	text : '5Y' }, 
					           { type : 'all',		count : 1,	text : 'All'}],
					selected :1,
					inputEnabled : false
			  },
			  legend: { enabled: true },   
			  navigator : { enabled : true },
			  scrollbar : { enabled : true },
			  tooltip: {
				   crosshairs: [{  width: 1, color: 'red'}, { width: 1, color: 'red' }],
				    headerFormat: '<span style="font-size:10px">{point.key}</span><table style="background-color:transparent;">',
		            pointFormat: '<tr><td style="color:{series.color};background-color:transparent;padding:0">{series.name}: </td>' +
		                '<td style="background-color:transparent;padding:0"><b>{point.y}</b></td></tr>',
		            footerFormat: '</table>',
		            shared: true,
		            useHTML: true
		        },
			  xAxis: { lineColor: 'black', lineWidth: 1 },
			  yAxis: [
			           { title: { text:  '', margin:0, rotation:90, offset:-20, textAlign:'right'}, labels:{ enabled:true },  top: '0%', height: '50%' }  
					   , { title: { text: ''},  labels:{ enabled:false }, top: '0%', height: '40%' }
					   , { title: { text: ''},  labels:{ enabled:false }, top: '0%', height: '40%' }
					   , { title: { text: ''},  labels:{ enabled:false }, top: '0%', height: '40%' }
					   , { title: { text: ''},  labels:{ enabled:false }, top: '0%', height: '40%' }
					   , { title: { text: ''},  labels:{ enabled:false }, top: '0%', height: '40%' }
					   , { title: { text: ''},  labels:{ enabled:false }, top: '0%', height: '40%' }

					   //7,8
					   , { title: { text: 'MACD r', margin:0, rotation:90, offset:-20, textAlign:'right'}, labels:{ enabled:false }, top: '40%', height: '10%'
						      , plotBands : [{ from: -2, to: 2, color : 'palegreen'}], plotLines : [{ value : 0, color : 'black', width : 2 }]   }
					   , { title: { text:  '' }, labels:{ enabled:false , margin:0, rotation:90, offset:-20, textAlign:'right' }, top: '40%', height: '10%'}

					   //9~13
						, { title: { text: '세력합', margin:0, rotation:90, offset:-20, textAlign:'right'}, top: '50%', height: '6%' 
						   	, plotLines : [{ value : 0, color : 'black', width : 2 }] }
						, { title: { text: '리더', margin:0, rotation:90, offset:-20, textAlign:'right'},  top: '56%', height: '6%' 
							, plotLines : [{ value : 0, color : 'black', width : 2 }]}
		     			, { title: { text: '외인',  margin:0, rotation:90, offset:-20, textAlign:'right'}, top: '62%', height: '6%' 
		     				, plotLines : [{ value : 0, color : 'black', width : 2 }]}
						, { title: { text: '기관', margin:0, rotation:90, offset:-20, textAlign:'right'}, top: '68%', height: '6%' 
							, plotLines : [{ value : 0, color : 'black', width : 2 }]}
						, { title: { text: '투신', margin:0, rotation:90, offset:-20, textAlign:'right'},  top: '74%', height: '6%'
							, plotLines : [{ value : 0, color : 'black', width : 2 }]}
						, { title: { text: '연기금', margin:0, rotation:90, offset:-20, textAlign:'right'},  top: '80%', height: '6%'
							, plotLines : [{ value : 0, color : 'black', width : 2 }]}

						//14,15
  				       , { title: { text: ''}, labels:{ enabled:false }, top: '86%', height: '6%' }
						, { title: { text: ''},  labels:{ enabled:false }, top: '92%', height: '2%' 
	    	  				, plotLines : [{ value : 0, color : 'black', width : 2 }], min:-1, max:1 }
						, { title: { text: ''},  labels:{ enabled:false }, top: '94%', height: '2%' 
	    	  				, plotLines : [{ value : 0, color : 'black', width : 2 }], min:-1, max:1 }
						, { title: { text: ''},  labels:{ enabled:false }, top: '96%', height: '2%' 
	    	  				, plotLines : [{ value : 0, color : 'black', width : 2 }], min:-1, max:1 }
						, { title: { text: ''},  labels:{ enabled:false }, top: '98%', height: '2%' 
	    	  				, plotLines : [{ value : 0, color : 'black', width : 2 }], min:-1, max:1 }
						//16
						, { title: { text: ''},  labels:{ enabled:false }, top: '0%', height: '0%' }
			    ], 
			  series: [ 
			    	  // 0
 					  {  type: 'candlestick', name: 'PRICE', data: ohlc }
 				   	  , {  name: 'MA20', data: ma20, tooltip: { valueDecimals: 0 }, color:'red',  lineWidth:1 }
				   	  , {  name: 'MA60', data: ma60, tooltip: { valueDecimals: 0 }, color:'blue',  lineWidth:1 }
				   	  , {  name: 'MA240', data: ma240, tooltip: { valueDecimals: 0 }, color:'green',  lineWidth:1 }
				   	  , {  name: 'MA720', data: ma720, tooltip: { valueDecimals: 0 }, color:'purple',  lineWidth:1 }
		    	      //, {   name: 'B-Up', data: upperBand, tooltip: { valueDecimals: 0 },  color:'gray' ,  lineWidth:1.5}
			    	  //, {  name: 'B-Lo', data: lowerBand, tooltip: { valueDecimals: 0 },  color:'gray' ,  lineWidth:1.5 }

				       , {dashStyle: 'ShortDash', name: '세력매집합',      data: powerSum, tooltip: { valueDecimals: 0 },   color:'black', lineWidth:1.5, yAxis:1 }
				       , { dashStyle: 'ShortDash', name: '리더매집합',    data: leaderSum, tooltip: { valueDecimals: 0 },  color:'green',   lineWidth:1.5, yAxis:2 }
					   , { dashStyle: 'ShortDash', name: '외인매집합',    data: foreignerSum, tooltip: { valueDecimals: 0 },  color:'red',   lineWidth:1, yAxis:3  }
				       , { dashStyle: 'ShortDash', name: '기관매집합',    data: orgSumSum, tooltip: { valueDecimals: 0 },  color:'blue',   lineWidth:1, yAxis:4 }
				       //, {dashStyle: 'ShortDash', name: '투신매집합',      data: investTrustSum, tooltip: { valueDecimals: 0 },  color:'orange', lineWidth:1, yAxis:5 }
				       //, {dashStyle: 'ShortDash', name: '연기금매집합',      data: pensionSum, tooltip: { valueDecimals: 0 }, color:'purple', lineWidth:1, yAxis:6 }

 				       , {dashStyle: 'ShortDash', name: '세력매집률',      data: powerAccr, tooltip: { valueDecimals: 0 },   color:'black', lineWidth:1.5, yAxis:20 }
				       , { dashStyle: 'ShortDash', name: '리더매집률',    data: leaderAccr, tooltip: { valueDecimals: 0 },  color:'green',   lineWidth:1.5, yAxis:20 }
					   , { dashStyle: 'ShortDash', name: '외인매집률',    data: foreignerAccr, tooltip: { valueDecimals: 0 },  color:'red',   lineWidth:1, yAxis:20  }
				       , { dashStyle: 'ShortDash', name: '기관매집률',    data: orgSumAccr, tooltip: { valueDecimals: 0 },  color:'blue',   lineWidth:1, yAxis:20 }
				    	  
			    	  , {  name: 'PCL', data: powerCorrelLong, tooltip: { valueDecimals: 2 }, color:'gray', yAxis:20	}
			    	  , {  name: 'LCL', data: leaderCorrelLong, tooltip: { valueDecimals: 2 }, color:'gray', yAxis:20	}
			    	  , {  name: 'PCS', data: powerCorrelShort, tooltip: { valueDecimals: 2 }, color:'gray', yAxis:20	}
			    	  , {  name: 'LCS', data: leaderCorrelShort, tooltip: { valueDecimals: 2 }, color:'gray', yAxis:20	}

//				       , {dashStyle: 'ShortDash', name: '투신매집률',      data: investTrustAccr, tooltip: { valueDecimals: 0 },  color:'orange', lineWidth:1, yAxis:20 }
//				       , {dashStyle: 'ShortDash', name: '연기금매집률',      data: pensionAccr, tooltip: { valueDecimals: 0 }, color:'purple', lineWidth:1, yAxis:20 }
				        //, {dashStyle: 'ShortDash', name: '개인매집액',      data: personalAccr, tooltip: { valueDecimals: 0 },  color:'gray', lineWidth:1, yAxis:6 }

 					  , {  dashStyle: 'ShortDash', name: 'MACDRate', data: macdRate, tooltip: { valueDecimals: 1 }, color:'red',  lineWidth:2, yAxis:7 }

					  , {  type: 'column', name: '세력',    data: power, tooltip: { valueDecimals: 0 }, color:'black', lineWidth:1.5, yAxis:9  }
					  , {  name: '세력20',    data: powerLds20, tooltip: { valueDecimals: 0 }, color:'red', lineWidth:1.5, yAxis:9  }
					  , {  name: '세력5',    data: powerLds5, tooltip: { valueDecimals: 0 }, color:'black', lineWidth:1, yAxis:9  }
					  , {  type: 'column', name: '리더',    data: leader, tooltip: { valueDecimals: 0 }, color:'black', lineWidth:1, yAxis:10  }
					  , {  name: '리더20',    data: leaderLds20, tooltip: { valueDecimals: 0 }, color:'red', lineWidth:1.5, yAxis:10  }
					  , {  name: '리더5',    data: leaderLds5, tooltip: { valueDecimals: 0 }, color:'black', lineWidth:1, yAxis:10  }
				      , {   type: 'column', name: '외인',    data: foreigner, tooltip: { valueDecimals: 0 }, color:'black', lineWidth:1, yAxis:11  }
				      , {  name: '외인20',    data: foreignerLds20, tooltip: { valueDecimals: 0 }, color:'red', lineWidth:1.5, yAxis:11  }
				      , {  name: '외인5',    data: foreignerLds5, tooltip: { valueDecimals: 0 }, color:'black', lineWidth:1, yAxis:11  }
			    	  , {   type: 'column', name: '기관',    data: orgSum, tooltip: { valueDecimals: 0 }, color:'black',  lineWidth:1.5, yAxis:12 }
			    	  , {  name: '기관20',    data: orgSumLds20, tooltip: { valueDecimals: 0 }, color:'red',  lineWidth:1.5, yAxis:12 }
			    	  , {  name: '기관5',    data: orgSumLds5, tooltip: { valueDecimals: 0 }, color:'black',  lineWidth:1.5, yAxis:12 }
 			    	  , {  type: 'column',  name: '투신',    data: investTrust, tooltip: { valueDecimals: 0 }, color:'black', lineWidth:1, yAxis:13  }
			    	  , {  name: '투신20',    data: investTrustLds20, tooltip: { valueDecimals: 0 }, color:'red', lineWidth:1.5, yAxis:13  }
			    	  , {  name: '투신5',    data: investTrustLds5, tooltip: { valueDecimals: 0 }, color:'black', lineWidth:1, yAxis:13  }
			    	  , {  type: 'column',  name: '연기금',    data: pension, tooltip: { valueDecimals: 0 }, color:'black',  lineWidth:1.5, yAxis:14 }
			    	  , {  name: '연기금20',    data: pensionLds20, tooltip: { valueDecimals: 0 }, color:'red',  lineWidth:1.5, yAxis:14 }
			    	  , {  name: '연기금5',    data: pensionLds5, tooltip: { valueDecimals: 0 }, color:'black',  lineWidth:1.5, yAxis:14 }

   					  , {  type: 'column', name: '거래량', data: volume, color:'gray', yAxis:15	}

   					  , {dashStyle: 'ShortDash', name: '개인WL',      data: personalWL, tooltip: { valueDecimals: 0 },   color:'gray', lineWidth:1.5, yAxis:20 }
   					  , {dashStyle: 'ShortDash', name: '세력WL',      data: powerWL, tooltip: { valueDecimals: 0 },   color:'black', lineWidth:1.5, yAxis:20 }
				       , { dashStyle: 'ShortDash', name: '리더WL',    data: leaderWL, tooltip: { valueDecimals: 0 },  color:'green',   lineWidth:1.5, yAxis:20 }
					   , { dashStyle: 'ShortDash', name: '외인WL',    data: foreignerWL, tooltip: { valueDecimals: 0 },  color:'red',   lineWidth:1, yAxis:20  }
				       , { dashStyle: 'ShortDash', name: '기관WL',    data: orgSumWL, tooltip: { valueDecimals: 0 },  color:'blue',   lineWidth:1, yAxis:20 }

 					  //, { type: 'column',  name: '매매신호', data: tradeSignal, color:'black', yAxis:16}
 					  , { type: 'column',  name: '세력매매신호', data: tradeSignalPower, color:'black', yAxis:16}
  					  , { type: 'column',  name: '리더매매신호', data: tradeSignalLeader, color:'green', yAxis:17}
  					  , { type: 'column',  name: '외인매매신호', data: tradeSignalForeigner, color:'red', yAxis:18}
  					  , { type: 'column',  name: '기관매매신호', data: tradeSignalOrgSum, color:'blue', yAxis:19}
			    	 
			    	  , {  name: '등락률', data: updownRatio, tooltip: {valueDecimals: 1, valueSuffix: '%' }, lineWidth:1, yAxis:20	}
			    	  , {  name: 'Open', data: openPrice, tooltip: { valueDecimals: 0 }, color:'gray', yAxis:20	}
			    	  , {  name: 'High', data: highPrice, tooltip: { valueDecimals: 0 }, color:'gray', yAxis:20	}
			    	  , {  name: 'Low', data: lowPrice, tooltip: { valueDecimals: 0 }, color:'gray', yAxis:20	}
			    	  , {  name: 'Close', data: closePrice, tooltip: { valueDecimals: 0 }, color:'gray', yAxis:20	}
			   	      ]
		  }, function(chart) {   syncronizeCrossHairs(chart);  });

		});
	  
	}
  
  function createLdsTable(data){
	    var lastIndex = data.length - 1;
		    
		var content = "<table>";
		    content += "<thead >";
		    content += " <tr>  ";
		    content += "  <th></th>";
		    content += "  <th>가격</th> ";
		    content += "  <th></th>"
		   	content += "  <th>개인</th>";
		    content += "  <th>세력</th>";
		    content += "  <th>리더</th>";
		   	content += "  <th>외인</th>";
		   	content += "  <th>기관</th>";
		   	content += "  <th></th>";
		    content += "  <th>금융투자</th>";
		    content += "  <th>보험</th>";
		    content += "  <th>투신</th>";
		    content += "  <th>은행</th>";
		    content += "  <th>기타금융</th>";
		    content += "  <th>연기금</th>";
		    content += "  <th>사모펀드</th>";
		    content += "  <th>국가</th>"; 
		    content += "  <th>기타법인</th>"; 
		    content += "  <th>기타외인 </th>";
		    content += "</tr> ";
		    content += "</thead>  ";
		    
		    content += "<tbody > ";
 		    content += "<tr id='t_wl'>";
		    content += "  <th><B>영향력</B></th>";
		    content += "  <th>-</th>";
		   	content += "  <th></th>";
		   	content += "  <th>"+data[lastIndex].personalWL.toFixed(1)+"</th>";
		    content += "  <th>"+data[lastIndex].powerWL.toFixed(1)+"</th>";
		    content += "  <th>"+data[lastIndex].leaderWL.toFixed(1)+"</th>";
		    content += "  <th>"+data[lastIndex].foreignerWL.toFixed(1)+"</th>";
		    content += "  <th>"+data[lastIndex].orgSumWL.toFixed(1)+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].finInvestWL.toFixed(1)+"</th>";
		    content += "  <th>"+data[lastIndex].insuranceWL.toFixed(1)+"</th>";
		    content += "  <th>"+data[lastIndex].investTrustWL.toFixed(1)+"</th>";
		    content += "  <th>"+data[lastIndex].bankWL.toFixed(1)+"</th>";
		    content += "  <th>"+data[lastIndex].etcFinWL.toFixed(1)+"</th>";
		    content += "  <th>"+data[lastIndex].pensionWL.toFixed(1)+"</th>";
		    content += "  <th>"+data[lastIndex].privateFundWL.toFixed(1)+"</th>";
		    content += "  <th>"+data[lastIndex].nationWL.toFixed(1)+"</th>";
		    content += "  <th>"+data[lastIndex].etcCorpWL.toFixed(1)+"</th>";
		    content += "  <th>"+data[lastIndex].etcForeignerWL.toFixed(1)+"</th>";
		    content += "</tr>";
 		    
		    content += "<tr id='t_effect'>";
		    content += "  <th><B>매매비중</B></th>";
		    content += "  <th>-</th>";
		   	content += "  <th></th>";
		   	content += "  <th>"+data[lastIndex].personalLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].powerLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].leaderLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].foreignerLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].orgSumLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].finInvestLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].insuranceLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].investTrustLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].bankLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].etcFinLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].pensionLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].privateFundLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].nationLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].etcCorpLeadingRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].etcForeignerLeadingRatio.toFixed(0)+"</th>";
		    content += "</tr>";
		    
		  /*   content += "<tr id='relratio'>";
		    content += "  <th><B>보유비율</B></th>";
		    content += "  <th>-</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].personalRelNetRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].powerRelNetRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].foreignerRelNetRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].orgSumRelNetRatio.toFixed(0)+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].finInvestRelNetRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].insuranceRelNetRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].investTrustRelNetRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].bankRelNetRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].etcFinRelNetRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].pensionRelNetRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].privateFundRelNetRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].nationRelNetRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].etcCorpRelNetRatio.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].etcForeignerRelNetRatio.toFixed(0)+"</th>";
		    content += "</tr>"; 
		    		    
		    content += "<tr  id='accr'>";
		    content += "  <th><B>매집율(%)</B></th>";
		    content += "  <th>-</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].personalAccr.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].powerAccr.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].foreignerAccr.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].orgSumAccr.toFixed(0)+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].finInvestAccr.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].insuranceAccr.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].investTrustAccr.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].bankAccr.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].etcFinAccr.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].pensionAccr.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].privateFundAccr.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].nationAccr.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].etcCorpAccr.toFixed(0)+"</th>";
		    content += "  <th>"+data[lastIndex].etcForeignerAccr.toFixed(0)+"</th>";
		    content += "</tr>";
		    */
		    content += "<tr id='correl'>";
		    content += "  <th><B>상관률(3Y)</B></th>";
		    content += "  <th>-</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].personalCorrelLong.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].powerCorrelLong.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].leaderCorrelLong.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].foreignerCorrelLong.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].orgSumCorrelLong.toFixed(2)+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].finInvestCorrelLong.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].insuranceCorrelLong.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].investTrustCorrelLong.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].bankCorrelLong.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].etcFinCorrelLong.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].pensionCorrelLong.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].privateFundCorrelLong.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].nationCorrelLong.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].etcCorpCorrelLong.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].etcForeignerCorrelLong.toFixed(2)+"</th>";
		    content += "</tr>";
		    content += "<tr id='correl'>";
		    content += "  <th><B>상관률(3M)</B></th>";
		    content += "  <th>-</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].personalCorrelShort.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].powerCorrelShort.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].leaderCorrelShort.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].foreignerCorrelShort.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].orgSumCorrelShort.toFixed(2)+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].finInvestCorrelShort.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].insuranceCorrelShort.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].investTrustCorrelShort.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].bankCorrelShort.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].etcFinCorrelShort.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].pensionCorrelShort.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].privateFundCorrelShort.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].nationCorrelShort.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].etcCorpCorrelShort.toFixed(2)+"</th>";
		    content += "  <th>"+data[lastIndex].etcForeignerCorrelShort.toFixed(2)+"</th>";
		    content += "</tr>";

			content += "<tr>";
		    content += "  <td colspan='17' text-align='left'><B>매매량</B></td>";
		    content += "</tr>";

		    content += "<tr id='accs'>";
		    content += "  <th >1주 순매수량</th>";
		    content += "  <th>"+addCommas(data[lastIndex].ma5.toFixed(0))+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].personalLds5+"</th>";
		    content += "  <th>"+data[lastIndex].powerLds5+"</th>";
		    content += "  <th>"+data[lastIndex].leaderLds5+"</th>";
		    content += "  <th>"+data[lastIndex].foreignerLds5+"</th>";
		    content += "  <th>"+data[lastIndex].orgSumLds5+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].finInvestLds5+"</th>";
		    content += "  <th>"+data[lastIndex].insuranceLds5+"</th>";
		    content += "  <th>"+data[lastIndex].investTrustLds5+"</th>";
		    content += "  <th>"+data[lastIndex].bankLds5+"</th>";
		    content += "  <th>"+data[lastIndex].etcFinLds5+"</th>";
		    content += "  <th>"+data[lastIndex].pensionLds5+"</th>";
		    content += "  <th>"+data[lastIndex].privateFundLds5+"</th>";
		    content += "  <th>"+data[lastIndex].nationLds5+"</th>";
		    content += "  <th>"+data[lastIndex].etcCorpLds5+"</th>";
		    content += "  <th>"+data[lastIndex].etcForeignerLds5+"</th>";
		    content += "</tr>";
		    
		    content += "<tr id='accs'>";
		    content += "  <th >1달 순매수량</th>";
		    content += "  <th>"+addCommas(data[lastIndex].ma20.toFixed(0))+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].personalLds20+"</th>";
		    content += "  <th id='power'>"+data[lastIndex].powerLds20+"</th>";
		    content += "  <th id='power'>"+data[lastIndex].leaderLds20+"</th>";
		    content += "  <th>"+data[lastIndex].foreignerLds20+"</th>";
		    content += "  <th>"+data[lastIndex].orgSumLds20+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].finInvestLds20+"</th>";
		    content += "  <th>"+data[lastIndex].insuranceLds20+"</th>";
		    content += "  <th>"+data[lastIndex].investTrustLds20+"</th>";
		    content += "  <th>"+data[lastIndex].bankLds20+"</th>";
		    content += "  <th>"+data[lastIndex].etcFinLds20+"</th>";
		    content += "  <th>"+data[lastIndex].pensionLds20+"</th>";
		    content += "  <th>"+data[lastIndex].privateFundLds20+"</th>";
		    content += "  <th>"+data[lastIndex].nationLds20+"</th>";
		    content += "  <th>"+data[lastIndex].etcCorpLds20+"</th>";
		    content += "  <th>"+data[lastIndex].etcForeignerLds20+"</th>";
		    content += "</tr>";
		    
		    content += "<tr id='accs'>";
		    content += "  <th >1분기 순매수량</th>";
		    content += "  <th>"+addCommas(data[lastIndex].ma60.toFixed(0))+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].personalLds60+"</th>";
		    content += "  <th id='power'>"+data[lastIndex].powerLds60+"</th>";
		    content += "  <th id='power'>"+data[lastIndex].leaderLds60+"</th>";
		    content += "  <th>"+data[lastIndex].foreignerLds60+"</th>";
		    content += "  <th>"+data[lastIndex].orgSumLds60+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].finInvestLds60+"</th>";
		    content += "  <th>"+data[lastIndex].insuranceLds60+"</th>";
		    content += "  <th>"+data[lastIndex].investTrustLds60+"</th>";
		    content += "  <th>"+data[lastIndex].bankLds60+"</th>";
		    content += "  <th>"+data[lastIndex].etcFinLds60+"</th>";
		    content += "  <th>"+data[lastIndex].pensionLds60+"</th>";
		    content += "  <th>"+data[lastIndex].privateFundLds60+"</th>";
		    content += "  <th>"+data[lastIndex].nationLds60+"</th>";
		    content += "  <th>"+data[lastIndex].etcCorpLds60+"</th>";
		    content += "  <th>"+data[lastIndex].etcForeignerLds60+"</th>";
		    content += "</tr>";

		    content += "<tr id='accs'>";
		    content += "  <th >1년 순매수량</th>";
		    content += "  <th>"+addCommas(data[lastIndex].ma240.toFixed(0))+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].personalLds240+"</th>";
		    content += "  <th id='power'>"+data[lastIndex].powerLds240+"</th>";
		    content += "  <th id='power'>"+data[lastIndex].leaderLds240+"</th>";
		    content += "  <th>"+data[lastIndex].foreignerLds240+"</th>";
		    content += "  <th>"+data[lastIndex].orgSumLds240+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].finInvestLds240+"</th>";
		    content += "  <th>"+data[lastIndex].insuranceLds240+"</th>";
		    content += "  <th>"+data[lastIndex].investTrustLds240+"</th>";
		    content += "  <th>"+data[lastIndex].bankLds240+"</th>";
		    content += "  <th>"+data[lastIndex].etcFinLds240+"</th>";
		    content += "  <th>"+data[lastIndex].pensionLds240+"</th>";
		    content += "  <th>"+data[lastIndex].privateFundLds240+"</th>";
		    content += "  <th>"+data[lastIndex].nationLds240+"</th>";
		    content += "  <th>"+data[lastIndex].etcCorpLds240+"</th>";
		    content += "  <th>"+data[lastIndex].etcForeignerLds240+"</th>";
		    content += "</tr>";
		    content += "<tr id='accs'>";
		    content += "  <th >3년 순매수량</th>";
		    content += "  <th>"+addCommas(data[lastIndex].ma720.toFixed(0))+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].personalLds720+"</th>";
		    content += "  <th id='power'>"+data[lastIndex].powerLds720+"</th>";
		    content += "  <th id='power'>"+data[lastIndex].leaderLds720+"</th>";
		    content += "  <th>"+data[lastIndex].foreignerLds720+"</th>";
		    content += "  <th>"+data[lastIndex].orgSumLds720+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data[lastIndex].finInvestLds720+"</th>";
		    content += "  <th>"+data[lastIndex].insuranceLds720+"</th>";
		    content += "  <th>"+data[lastIndex].investTrustLds720+"</th>";
		    content += "  <th>"+data[lastIndex].bankLds720+"</th>";
		    content += "  <th>"+data[lastIndex].etcFinLds720+"</th>";
		    content += "  <th>"+data[lastIndex].pensionLds720+"</th>";
		    content += "  <th>"+data[lastIndex].privateFundLds720+"</th>";
		    content += "  <th>"+data[lastIndex].nationLds720+"</th>";
		    content += "  <th>"+data[lastIndex].etcCorpLds720+"</th>";
		    content += "  <th>"+data[lastIndex].etcForeignerLds720+"</th>";
		    content += "</tr>";
		    content += " </tbody> ";
		content += " </table> <BR>";
	
		$('#investor_review_table').html(content);
		
		// 스타일 시트 적용 
	    $('#t_wl > th').filter( function(index){ if( $(this).text() > 0 ){ return true; } }).css('background-color', 'orange');
	    $('#t_wl > th').filter( function(index){ if( $(this).text() >= 0 ){ return true; } }).css('background-color', 'beige');
	    $('#t_wl > th ').filter(function(index){ if( $(this).text() >= 30 ){ return true; }}).css('background-color', 'palegreen');
	    $('#t_effect > th').filter( function(index){ if( $(this).text() <= 3 ){ return true; } }).css('background-color', 'gray');
	    $('#t_effect > th ').filter(function(index){ if( $(this).text() > 3 ){ return true; }}).css('background-color', 'beige');
	    $('#t_effect > th ').filter(function(index){ if( $(this).text() >= 10 ){ return true; }}).css('background-color', 'palegreen');
	    $('#accs > #power').filter( function(index){	if( $(this).text() > 0 ){ return true; } }).css('background-color', 'palegreen');
	    $('#accs > #power').filter( function(index){	if( $(this).text() < 0 ){ return true; } }).css('background-color', 'orange');
	    $('#accs > th').filter( function(index){	if( $(this).text() > 0 ){ return true; } }).css('color', 'red');
	    $('#accs > th').filter( function(index){	if( $(this).text() < 0 ){ return true; } }).css('color', 'blue');
	    $('#income > th').filter( function(index){ if( $(this).text() < 0 ){ return true; }  }).css('background-color', 'palegreen');
	    $('#correl > th').filter( function(index){ if( $(this).text() < 0.0 ){ return true; }  }).css('background-color', 'orange');
	    $('#correl > th').filter( function(index){ if( $(this).text() >= 0.3 ){ return true; }  }).css('background-color', 'beige');
	    $('#correl > th').filter( function(index){ if( $(this).text() >= 0.6 ){ return true; }  }).css('background-color', 'palegreen');
	    //$('#relratio > th').filter( function(index){	if( $(this).text() >= 20 ){ return true; }  }).css('background-color', 'palegreen');
	}

  function createFnguidePage(data){
	  $('#fnguide_page').html("");
	  
	  var shortCode = data;
	  var content = "<iframe id='coinfo_cp' src='http://asp01.fnguide.com/svo/handbook_New/xml/SVD_Main.asp?pGB=1&gicode="; 
	      content += shortCode + "&cID=&MenuYn=Y&ReportGB=&NewMenuID=101&stkGb=701' width='1300' height='5279' marginheight='0' bottommargin='0' topmargin='0' ";
	      content += " scrolling='no' frameborder='0' style='height: 5279px;'></iframe> ";
	  
	      $('#fnguide_page').html(content);
  }
  
  function createPaxnetPage(data){
	  var shortCode = data.substr(1,6);
	  var content = "<iframe id='coinfo_cp' src='http://paxnet.asiae.co.kr/asiae/stockIntro/indCurrent.jsp?code="; 
	      content += shortCode + "' width='1300' height='5279' marginheight='0' bottommargin='0' topmargin='0' ";
	      content += " scrolling='no' frameborder='0' style='height: 5279px;'></iframe> ";
	  
	      $('#paxnet_news_page').html(content);
  }
  
  function createThinkpoolThemePage(data){
	  
	  var shortCode = data.substr(1,6);
	  var content = "<iframe id='coinfo_cp' src=http://www.thinkpool.com/itemanal/i/theme_main.jsp?code="; 
	      content += shortCode + "&mcd=Q0E&Gcode=001_011_001' width='1300' height='5279' marginheight='0' bottommargin='0' topmargin='0' ";
	      content += " scrolling='no' frameborder='0' style='height: 5279px;'></iframe> ";
	  
	      $('#thinkpool_theme_page').html(content);
  }
  
  function createInfostockTradePage(data){
	  
	  var shortCode = data.substr(1,6);
	  var content = "<iframe id='coinfo_cp' src=http://www.infostock.co.kr/site/3d/3d_show.asp?codename="; 
	      content += shortCode + "#top' width='1300' height='5279' marginheight='0' bottommargin='0' topmargin='0' ";
	      content += " scrolling='no' frameborder='0' style='height: 5279px;'></iframe> ";
	  
	      $('#infostock_trade_page').html(content);
  }
  
 
		  
  function createMarketPage(data){
	  
	  var shortCode = data;
	  var content = "<iframe id='coinfo_cp' src='http://localhost:8080/sample-spring-webapp/Recommend.jsp"; 
	      // content = "<iframe id='coinfo_cp' src='http://bbs.moneta.co.kr/nbbs/bbs.normalm.lst.screen?p_bbs_id=N10256&service=stock&top=3&sub=1&depth=2&menu=menu_invest&wlog_Invest=T_marketLeader"; 
          content += "' width='1300' height='5279' marginheight='0' bottommargin='0' topmargin='0' ";
	      content += " scrolling='no' frameborder='0' style='height: 5279px;'></iframe> ";
	  
	      $('#market_page').html(content);
  }
  

  function chartDateFormat(tmp){
	    var vd = tmp.substr(4,2)+"/"+tmp.substr(6,2)+"/"+tmp.substr(0,4);
		var vdate = new Date(vd).getTime() + 86400000;
		return vdate;
  }
  
  function addCommas(n){ 
	    strValue = String(n);
	    var objRegExp = new RegExp('(-?[0-9]+)([0-9]{3})'); 
	    while(objRegExp.test(strValue)) {
	        strValue = strValue.replace(objRegExp, '$1,$2');
	    } 
	    return strValue;
  }
  
  //콤마제거 
  function delCommas(strValue){
	    var objRegExp = new RegExp('[,]'); 
	    while(objRegExp.test(strValue)) {
	        strValue = strValue.replace(objRegExp, '');
	    } 
	    return strValue;
  }
  
  </script>
  
  <style>
  #overview_chart {
	height: 1200px;
	margin-left: 0px;
	margin-right: 0px;
 	padding:0;
  }  
	


  </style>
</head>

<body>
<div id="frame">

	<div id="header" > 
	  <div >
		<B>종목 검색</B>: <input type="text" id="input_company_name"><input type="text"  id="input_company_code" disabled>
		  <input type="submit" id="search_btn_company" value="종목 분석">
		  <input type="hidden"  id="input_market_kind" disabled>
		  
		&nbsp; || &nbsp;  
		<B>업종 검색</B>: <input type="text" id="input_industry_name"><input type="text" id="input_industry_code" disabled>
		  <input type="submit" id="search_btn_industry" value="업종 분석">

	    &nbsp;  || &nbsp; 
	  	<input type="submit" id="nav_btn_overview" value="종합현황으로"> 
	  	&nbsp;  || &nbsp; 
	  	<input type="submit" id="nav_btn_recommend" value="추천종목으로"> 
	  	&nbsp;  || &nbsp; 
		 <input type="submit" id="nav_btn_duration" value="기간별매집현황으로"> 
	  	&nbsp;  || &nbsp; 
	  	
	   </div>	
	</div>
	
	
	<div id="content">	
		<div id="company_review_table"></div> 
		<div id="fundamental_review_table"></div>    

		<div id="tabs" >
		  <ul>
		    <li><a href="#tabs-technical">Technical</a></li>
		    <li><a href="#tabs-fnguide">Fundamental(FnGuide)</a></li>
		    <li><a href="#tabs-infostock_trade">Company Review(InfoStock)</a></li>
		    <li><a href="#tabs-thinkpool_theme">Company Review(ThinkPool)</a></li>
		    <li><a href="#tabs-paxnet_news">Company Review(Paxnet)</a></li>
		  </ul>
		  
		  <div id="tabs-technical">
		    <div>
		    	<input type="submit" id="nav_btn_adDetail" value="상세수급분석"> 
	  		</div>
	  	    <div id="investor_review_table"></div>
    		<B>종합 차트</B>
           	<div id="overview_chart" ></div>
           	<BR>
		    <B>수급 상세 차트</B>
		  	<div id="ad_chart"></div>
		  </div>
		  
		  <div id="tabs-fnguide">
		  	<div id="fnguide_page"></div>
		  </div>
		  
		  <div id="tabs-infostock_trade">
               <div id="infostock_trade_page"></div>
		  </div>
		  
		  <div id="tabs-thinkpool_theme">
               <div id="thinkpool_theme_page"></div>
		  </div>
		  
		  <div id="tabs-paxnet_news">
               <div id="paxnet_news_page"></div>
		  </div>
		  
		  <div id="tabs-market">
               <div id="market_page"></div>
		  </div>
		   
		</div> <!-- End tabs -->

		<BR>
		
	</div> <!-- End Contents -->
</div> <!-- End frame -->
<div class="modal"><!-- Place at bottom of page --></div>
</body>
</html>
