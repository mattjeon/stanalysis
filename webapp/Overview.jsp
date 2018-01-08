
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!doctype html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>수급현황</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"> 
	
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/highstock.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/highcharts.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/module/exporting.js"></script>
	  
  <script>
  	$(function() {

  		//Set Title
  		var currentDate = new Date();
  		var curr_date = (currentDate.getDate() < 10) ? '0'+currentDate.getDate() : currentDate.getDate() ;
  		var curr_month = ((currentDate.getMonth() + 1 ) < 10) ? '0' + (currentDate.getMonth() + 1) : (currentDate.getMonth() + 1);
  		var curr_year = currentDate.getFullYear();
  		var todayDate = curr_year+"-"+curr_month+"-"+curr_date;
  		
  		
	    document.title = "종합 현황_"+todayDate;

  		//$( "#tabs" ).tabs();
  		$("#tabs").tabs({
  		  beforeActivate: function (event, ui) {
  		    document.title = ui.newTab.context.innerText +"_"+todayDate;
  		  }
  		});
  		
		//시장별 리스트
  		getIndustryInformation('001');
 		getIndustryInformation('002');
 		getIndustryInformation('003');
 		getIndustryInformation('004');
 		getIndustryInformation('201');
 		        
    });
    
    // 버튼 처리
    $(function() {
    	
 
        $("#nav_btn_detail").click(function() {
	    	event.preventDefault();
	        window.open('Analysis.jsp', '_blank');
         });
        
        $("#nav_btn_recommend").click(function() {
	    	event.preventDefault();
	        window.open('Recommend.jsp', '_blank');
         });
  		
        $("#nav_btn_duration").click(function() {
	    	event.preventDefault();
	        window.open('Duration.jsp', '_blank');
         });
   }); 		



   
   function getIndustryInformation(searchCode) {
	  $("body").addClass("loading");
	  
		if( searchCode == '001'){
			$('#kospi_total_table').html('');
		}else if( searchCode == '002'){
			$('#kospi_big_table').html('');
		}else if( searchCode == '003'){
			$('#kospi_mid_table').html('');
		}else if( searchCode == '004'){
			$('#kospi_small_table').html('');
		}else if( searchCode == '202'){
			$('#kosdaq_total_table').html('');
		}
	   
	  $.getJSON("technical/getTechnicalResult/"+searchCode+"/I", function(data) {
		   
			if( data == null ){    alert("Not Found Data"); }
			else{
				createIndicateChart(data, searchCode);
				createLdsTable( data, searchCode );

			}
			 $("body").removeClass("loading");
	   });
  }
  
   function createIndicateChart(data, searchCode){

		  $(document).ready(function() {
			  
			  // Data 정리  
			  var vdate;
			  var lastIndex = data.length - 1;
			  
			  // 주가 지표 및 이평선, 볼린저 밴드, 업종 가격
			  var closePrice = [];
			  var ma5 = [],  ma20 = [], ma60 = [], ma240 = [], ma720 = [];
			  //보조지표
			  var macd = [], macdSignal = [], macdHist = [], macdRate = [];

			// 수급 분산 비율
			  var powerSum = [], leaderSum = [], foreignerSum = [], orgSumSum= [];
			  var pensionSum = [], investTrustSum = [];

			  $.each( data, function( key, val){
				    vdate = chartDateFormat(val.regDate);
					//주가
				    closePrice.push([ vdate, val.closePrice ]);
					ma5.push([ vdate, val.ma5 ]);
					ma20.push([ vdate, val.ma20 ]);
					ma60.push([ vdate, val.ma60 ]);
					ma240.push([ vdate, val.ma240 ]);
					ma720.push([ vdate, val.ma720 ]);
	/* 				macd.push([vdate, val.macd]);
					macdSignal.push([vdate, val.macdSignal]);
					macdHist.push([vdate, val.macdHist/100]);
	 */				macdRate.push([vdate, val.macdRate]);

					powerSum.push([	vdate, val.powerSum ]);
	  				leaderSum.push([ vdate, val.leaderSum]);
					foreignerSum.push([  vdate, val.foreignerSum ]);
			  		orgSumSum.push([  vdate, val.orgSumSum ]);
			  		investTrustSum.push([  vdate, val.investTrustSum ]);
			  		pensionSum.push([ vdate, val.pensionSum ]);

				});
			  
			  // AD Chart 
			   var container = '';
	   
			   if( searchCode == '001'){
				   //chart1 = $('#kospi_total_chart').highcharts(options);
				   container = 'kospi_total_chart';
				}else if( searchCode == '002'){
					   //chart1 = $('#kospi_big_chart').highcharts(options);
					   container = 'kospi_big_chart';
				}else if( searchCode == '003'){
					   //chart1 = $('#kospi_mid_chart').highcharts(options);
					   container = 'kospi_mid_chart';
				}else if( searchCode == '004'){
					   //chart1 = $('#kospi_small_chart').highcharts(options);
					   container = 'kospi_small_chart';
				}else if( searchCode == '201'){
					   //chart1 = $('#kosdaq_total_chart').highcharts(options);
					   container = 'kosdaq_total_chart';
				}
			   			   
			  //chart1 = new Highcharts.StockChart(chartOptions);
			  
			  chart1 = new Highcharts.StockChart({
		          chart: {
		              renderTo: container,
		              type: 'line',
		              zoomType: 'x',
		              borderColor: 'black',
		              backgroundColor: 'lightgray',
		              borderWidth: 1,
		              isZoomed:true,
	 	          },
		          title : $('#input_company_name').val(),
		          plotOptions: {
		        	  candlestick: {  color: 'green', upColor: 'red'  }
		              , column: { stacking: 'normal' }
		          	  , series: { marker: { states: { hover: { enabled: false } } } }
		          },
				  rangeSelector : {
						buttons : [{ type : 'month',	    count : 6,	text : '6M' },
						           { type : 'year',	    count : 1,	text : '1Y' },
						           { type : 'year',		count : 2,	text : '2Y' }, 
						           { type : 'year',		count : 3,	text : '3Y' }, 
						           { type : 'year',		count : 5,	text : '5Y' }, 
						           { type : 'all',		count : 1,	text : 'All'}],
						selected :0,
						inputEnabled : false
				  },
				  legend: { enabled: false },   
				  navigator : { enabled : false },
				  scrollbar : { enabled : false },
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
				           { title: { text:  '', margin:0, rotation:90, offset:-20, textAlign:'right'}, labels:{ enabled:true },  top: '0%', height: '90%' }  
						   , { title: { text: ''},  labels:{ enabled:false }, top: '0%', height: '90%' }
						   , { title: { text: ''},  labels:{ enabled:false }, top: '0%', height: '90%' }
						   , { title: { text: ''},  labels:{ enabled:false }, top: '0%', height: '90%' }
						   , { title: { text: ''},  labels:{ enabled:false }, top: '0%', height: '90%' }
						   , { title: { text: ''},  labels:{ enabled:false }, top: '0%', height: '90%' }
						   , { title: { text: ''},  labels:{ enabled:false }, top: '0%', height: '90%' }

						   //7,8
						   , { title: { text: 'MACD r', margin:0, rotation:90, offset:-20, textAlign:'right'}, labels:{ enabled:false }, top: '90%', height: '10%'
							      , plotBands : [{ from: -2, to: 2, color : 'palegreen'}], plotLines : [{ value : 0, color : 'black', width : 2 }]   }

				    ], 
				  series: [ 
				    	  // 0
	 					  {  name: '종가', data: closePrice, tooltip: { valueDecimals: 0 }, color:'black',  lineWidth:2}
	 				   	  , {  name: 'MA20', data: ma20, tooltip: { valueDecimals: 0 }, color:'red',  lineWidth:1 }
					   	  , {  name: 'MA60', data: ma60, tooltip: { valueDecimals: 0 }, color:'blue',  lineWidth:1 }
					   	  //, {  name: 'MA240', data: ma240, tooltip: { valueDecimals: 0 }, color:'green',  lineWidth:1 }
					   	  //, {  name: 'MA720', data: ma720, tooltip: { valueDecimals: 0 }, color:'purple',  lineWidth:1 }

					       , {dashStyle: 'ShortDash', name: '세력매집합',      data: powerSum, tooltip: { valueDecimals: 0 },   color:'black', lineWidth:1.5, yAxis:1 }
					       //, { dashStyle: 'ShortDash', name: '리더매집합',    data: leaderSum, tooltip: { valueDecimals: 0 },  color:'green',   lineWidth:1.5, yAxis:2 }
						   , { dashStyle: 'ShortDash', name: '외인매집합',    data: foreignerSum, tooltip: { valueDecimals: 0 },  color:'red',   lineWidth:1, yAxis:3  }
					       , { dashStyle: 'ShortDash', name: '기관매집합',    data: orgSumSum, tooltip: { valueDecimals: 0 },  color:'blue',   lineWidth:1, yAxis:4 }
					       //, {dashStyle: 'ShortDash', name: '투신매집합',      data: investTrustSum, tooltip: { valueDecimals: 0 },  color:'orange', lineWidth:1, yAxis:5 }
					       //, {dashStyle: 'ShortDash', name: '연기금매집합',      data: pensionSum, tooltip: { valueDecimals: 0 }, color:'purple', lineWidth:1, yAxis:6 }

	 					  , {  dashStyle: 'ShortDash', name: 'MACDRate', data: macdRate, tooltip: { valueDecimals: 1 }, color:'red',  lineWidth:2, yAxis:7 }
				   	      ]
			  });

			});
		  
		}
	  
	  function createLdsTable(data, searchCode){
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
			    content += "  <th>투신</th>";
			    content += "  <th>연기금</th>";
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
			    content += "  <th>"+data[lastIndex].investTrustWL.toFixed(1)+"</th>";
			    content += "  <th>"+data[lastIndex].pensionWL.toFixed(1)+"</th>";
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
			    content += "  <th>"+data[lastIndex].investTrustLeadingRatio.toFixed(0)+"</th>";
			    content += "  <th>"+data[lastIndex].pensionLeadingRatio.toFixed(0)+"</th>";
			    content += "</tr>";

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
			    content += "  <th>"+data[lastIndex].investTrustCorrelLong.toFixed(2)+"</th>";
			    content += "  <th>"+data[lastIndex].pensionCorrelLong.toFixed(2)+"</th>";
			    content += "</tr>";

				content += "<tr>";
			    content += "  <td colspan='17' text-align='left'><B>매매량</B></td>";
			    content += "</tr>";

			    content += "<tr id='accs'>";
			    content += "  <th >1주 순매수량</th>";
			    content += "  <th>"+addCommas(data[lastIndex].ma5.toFixed(0))+"</th>";
			    content += "  <th></th>";
			    content += "  <th>"+data[lastIndex].personalLds5+"</th>";
			    content += "  <th id='power'>"+data[lastIndex].powerLds5+"</th>";
			    content += "  <th id='power'>"+data[lastIndex].leaderLds5+"</th>";
			    content += "  <th>"+data[lastIndex].foreignerLds5+"</th>";
			    content += "  <th>"+data[lastIndex].orgSumLds5+"</th>";
			    content += "  <th></th>";
			    content += "  <th>"+data[lastIndex].investTrustLds5+"</th>";
			    content += "  <th>"+data[lastIndex].pensionLds5+"</th>";
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
			    content += "  <th>"+data[lastIndex].investTrustLds20+"</th>";
			    content += "  <th>"+data[lastIndex].pensionLds20+"</th>";
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
			    content += "  <th>"+data[lastIndex].investTrustLds60+"</th>";
			    content += "  <th>"+data[lastIndex].pensionLds60+"</th>";
			    content += "</tr>";

			    content += " </tbody> ";
			content += " </table> <BR>";
		
			if( searchCode == '001'){
				$('#kospi_total_table').html(content);
			}else if( searchCode == '002'){
				$('#kospi_big_table').html(content);
			}else if( searchCode == '003'){
				$('#kospi_mid_table').html(content);
			}else if( searchCode == '004'){
				$('#kospi_small_table').html(content);
			}else if( searchCode == '201'){
				$('#kosdaq_total_table').html(content);
			}

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

  </script>
  
  <style>
  #kospi_total_chart {
	height: 400px;
  	margin-left: 0px;
	margin-right: 0px;
 	padding:0;
	z-index: 5;
  }  
    
  #kospi_big_chart {
	height: 400px;
  	margin-left: 0px;
	margin-right: 0px;
 	padding:0;
	z-index: 5;
  }  

  #kospi_mid_chart {
	height: 400px;
  	margin-left: 0px;
	margin-right: 0px;
 	padding:0;
	z-index: 5;
  }  

  #kospi_small_chart {
	height: 400px;
  	margin-left: 0px;
	margin-right: 0px;
 	padding:0;
	z-index: 5;
  }  

   #kosdaq_total_chart {
	height: 400px;
  	margin-left: 0px;
	margin-right: 0px;
 	padding:0;
	z-index: 5;
  }  
    
  </style>
  
</head>

<body>
<div id="frame">

	<div id="header" > 
	  <div >
		 <input type="submit" id="nav_btn_detail" value="종목분석으로"> 
		 	&nbsp;  || &nbsp; 
		 <input type="submit" id="nav_btn_recommend" value="추천종목으로"> 
		 	&nbsp;  || &nbsp; 
		 <input type="submit" id="nav_btn_duration" value="기간별분석으로"> 
	   </div>	
	</div>
	
	
	<div id="content">
	    <table>
			<tbody>
			<tr>
				<td width='50%'> 
				 <B>KOSPI 종합</B>
					<div id="kospi_total_chart" ></div>  
					<div id="kospi_total_table" ></div>  
				</td>
				<td  width='50%'> 
				 <B>KOSPI 대형주</B>
					<div id="kospi_big_chart" ></div>  
					<div id="kospi_big_table" ></div>  
				</td>
			</tr>
			<tr>
				<td> 
				 <B>KOSPI 중형주</B>
					<div id="kospi_mid_chart" ></div>  
					<div id="kospi_mid_table" ></div>  
				</td>
				<td> 
				 <B>KOSPI 소형주</B>
					<div id="kospi_small_chart" ></div>  
					<div id="kospi_small_table" ></div>  
				</td>
			</tr>
			<tr>
				<td> 
				 <B>KOSDAQ 종합</B>
					<div id="kosdaq_total_chart" ></div>  
					<div id="kosdaq_total_table" ></div>  
				</td>
				<td> 
				</td>
			</tr>
			</tbody>
		</table>

	</div>
</div>
<div class="modal"><!-- Place at bottom of page --></div>

</body>
</html>
