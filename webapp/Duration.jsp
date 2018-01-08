<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!doctype html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>기간별분석현황</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"> 
	
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/highstock.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/highcharts.js"></script>
	  
  <script>
  	$(function() {
  		//Set Title
  		var currentDate = new Date();
/*   		var curr_date = (currentDate.getDate() < 10) ? '0'+currentDate.getDate() : currentDate.getDate() ;
  		var curr_month = ((currentDate.getMonth() + 1) < 10) ? '0' + (currentDate.getMonth() + 1) : (currentDate.getMonth() + 1);
  		var curr_year = currentDate.getFullYear();
  		var todayDate = curr_year+"-"+curr_month+"-"+curr_date;
 */   	
        
        $('input:radio[name=industry]:nth(0)').attr('checked',true);
	    $("#fromCode").val("004");
	    $("#toCode").val("030");
    	
        $("#kospi").click(function () {
        	$("#fromCode").val("004");
        	$("#toCode").val("030");
        });
        
        $("#kosdaq").click(function () {
        	$("#fromCode").val("031");
        	$("#toCode").val("699");
        });
        
    	//세력별 업종 매집합 현황
  		$( "#from_date" ).datepicker({
          dateFormat: "yymmdd",
          changeMonth: true,
          numberOfMonths: 3,
          onClose: function( selectedDate ) {
            $( "#to_date" ).datepicker( "option", "minDate", selectedDate );
          }
        });
  		$("#from_date").datepicker("setDate", -30);
        
        $( "#to_date" ).datepicker({
          dateFormat: "yymmdd",
          changeMonth: true,
          numberOfMonths: 3,
          onClose: function( selectedDate ) {
            $( "#from_date" ).datepicker( "option", "maxDate", selectedDate );
          }
        });
        $("#to_date").datepicker("setDate", currentDate);

        
    	//세력별 종목 매집합 현황
        
        //var fromDate = $( "#from_date" ).val();
  		//var toDate = $("#to_date").val();
  		
    });
    
    // 버튼 처리
    $(function() {
    	
    	var fromCode = $("#fromCode").val();
    	var toCode = $("#toCode").val();

  		var fromDate = $( "#from_date" ).val();
  		var toDate = $("#to_date").val();

        $("#search_btn_week").click(function() {
	    	event.preventDefault();
	  		$("#from_date").datepicker("setDate", -7);
	    });
        
        $("#search_btn_month").click(function() {
	    	event.preventDefault();
	  		$("#from_date").datepicker("setDate", -30);
	    });
        
        $("#search_btn_3month").click(function() {
	    	event.preventDefault();
	  		$("#from_date").datepicker("setDate", -90);
	    });
  		
  		//세력별 업종 매집합 현황
        $("#search_btn_industry_power").click(function() {
	    	event.preventDefault();
	    	
	    	fromCode = $("#fromCode").val();
	    	toCode = $("#toCode").val();
	  		fromDate = $( "#from_date" ).val();
	  		toDate = $("#to_date").val();

	  		getIndustryInvestorSumByDurationList(fromCode, toCode, fromDate, toDate,'power');
	    });
  		
        $("#search_btn_industry_leader").click(function() {
        	event.preventDefault();
	    	
        	fromCode = $("#fromCode").val();
	    	toCode = $("#toCode").val();
	  		fromDate = $( "#from_date" ).val();
	  		toDate = $("#to_date").val();

	  		getIndustryInvestorSumByDurationList(fromCode, toCode, fromDate, toDate, 'leader');
	    });
        
        $("#search_btn_industry_foreigner").click(function() {
	    	event.preventDefault();
	    	
        	fromCode = $("#fromCode").val();
	    	toCode = $("#toCode").val();
	  		fromDate = $( "#from_date" ).val();
	  		toDate = $("#to_date").val();

	  		getIndustryInvestorSumByDurationList(fromCode, toCode, fromDate, toDate,'foreigner');
	    });
  		
        $("#search_btn_industry_orgSum").click(function() {
	    	event.preventDefault();
	    	
        	fromCode = $("#fromCode").val();
	    	toCode = $("#toCode").val();
	  		fromDate = $( "#from_date" ).val();
	  		toDate = $("#to_date").val();

	  		getIndustryInvestorSumByDurationList(fromCode, toCode, fromDate, toDate,'orgSum');
	    });

    	//세력별 종목 매집합 현황
        $("#search_btn_company_power").click(function() {
	    	event.preventDefault();
	    	
        	fromCode = $("#fromCode").val();
	    	toCode = $("#toCode").val();
	  		fromDate = $( "#from_date" ).val();
	  		toDate = $("#to_date").val();

	  		getCompanyInvestorSumByDurationList(fromCode, toCode, fromDate, toDate,'power');
	    });
  		
        $("#search_btn_company_leader").click(function() {
        	event.preventDefault();
	    	
        	fromCode = $("#fromCode").val();
	    	toCode = $("#toCode").val();
	  		fromDate = $( "#from_date" ).val();
	  		toDate = $("#to_date").val();

	  		getCompanyInvestorSumByDurationList(fromCode, toCode, fromDate, toDate, 'leader');
	    });
        
        $("#search_btn_company_foreigner").click(function() {
	    	event.preventDefault();
	    	
        	fromCode = $("#fromCode").val();
	    	toCode = $("#toCode").val();
	  		fromDate = $( "#from_date" ).val();
	  		toDate = $("#to_date").val();

	  		getCompanyInvestorSumByDurationList(fromCode, toCode, fromDate, toDate,'foreigner');
	    });
  		
        $("#search_btn_company_orgSum").click(function() {
	    	event.preventDefault();
	    	
        	fromCode = $("#fromCode").val();
	    	toCode = $("#toCode").val();
	  		fromDate = $( "#from_date" ).val();
	  		toDate = $("#to_date").val();

	  		getCompanyInvestorSumByDurationList(fromCode, toCode, fromDate, toDate,'orgSum');
	    });
        
        $("#nav_btn_detail").click(function() {
	    	event.preventDefault();
	        window.open('Analysis.jsp', '_blank');
         });
  		
        $("#nav_btn_overview").click(function() {
	    	event.preventDefault();
	        window.open('Overview.jsp', '_blank');
         });
  		
	    $("#nav_btn_recommend").click(function() {
	    	event.preventDefault();
	        window.open('Recommend.jsp', '_blank');
        });

    }); 		
    


    //업종의 투자주체별로 기간동안의 매집합 조회
  	function getIndustryInvestorSumByDurationList(fromCode, toCode, fromdate, todate, investorType){
	  	$.getJSON("duration/getIndustryInvestorSumByDurationList/"+fromCode+"/"+toCode+"/"+fromdate+"/"+todate+"/"+investorType, function(data) {
  	   		
	  		if( data == null ){    alert("Not Found Data"); }
  	   	 	else{
	  	   	 	var content = "<table>";
			    content += "<thead >";
			    content += " <tr>  ";
			    content += "  <th>업종명</th>";
			    content += "  <th>코드</th>";
			    content += "  <th></th>";
			   	content += "  <th>개인</th>";
			    content += "  <th>세력합</th>";
			    content += "  <th>리더합</th>"
			   	content += "  <th>외국인</th>";
			   	content += "  <th>기관합</th>";
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
  			    
				$.each( data, function( key, val){
					content += "<tr id='ldslist'>";
				    content += "  <th>"+data[key].industryName+"</th>";
				    content += "  <th>"+data[key].industryCode+"</th>";
				    content += "  <th></th>";
				   	content += "  <th>"+data[key].personalSum+"</th>";
				    content += "  <th>"+data[key].powerSum+"</th>";
				    content += "  <th>"+data[key].leaderSum+"</th>";
				    content += "  <th>"+data[key].foreignerSum+"</th>";
				    content += "  <th>"+data[key].orgSumSum+"</th>";
				    content += "  <th></th>";
				    content += "  <th>"+data[key].finInvestSum+"</th>";
				    content += "  <th>"+data[key].insuranceSum+"</th>";
				    content += "  <th>"+data[key].investTrustSum+"</th>";
				    content += "  <th>"+data[key].bankSum+"</th>";
				    content += "  <th>"+data[key].etcFinSum+"</th>";
				    content += "  <th>"+data[key].pensionSum+"</th>";
				    content += "  <th>"+data[key].privateFundSum+"</th>";
				    content += "  <th>"+data[key].nationSum+"</th>";
				    content += "  <th>"+data[key].etcCorpSum+"</th>";
				    content += "  <th>"+data[key].etcForeignerSum+"</th>";
				    content += "</tr>";
  			   	});
  			   	content += " </tbody> ";
	  			content += " </table> <BR>";
  			
  				$('#industry_investor_sum_table').html(content);
  				
  			    $('#ldslist > th').filter( function(index){	if( $(this).text() > 0 ){ return true; } }).css('background-color', 'palegreen');
  			    $('#ldslist > th').filter( function(index){	if( $(this).text() < 0 ){ return true; } }).css('background-color', 'orange');

  	   	 	}
  	   });
	}

    
    //종목의 투자주체별로 기간동안의 매집합 조회
  	function getCompanyInvestorSumByDurationList(fromCode, toCode, fromdate, todate, investorType){
	  	$.getJSON("duration/getCompanyInvestorSumByDurationList/"+fromCode+"/"+toCode+"/"+fromdate+"/"+todate+"/"+investorType, function(data) {
  	   		
	  		if( data == null ){    alert("Not Found Data"); }
  	   	 	else{
	  	   	 	var content = "<table>";
			    content += "<thead >";
			    content += " <tr>  ";
			    content += "  <th>종목명</th>";
			    content += "  <th>업종명</th>";
			    content += "  <th></th>";
			   	content += "  <th>개인</th>";
			    content += "  <th>세력합</th>";
			    content += "  <th>리더합</th>"
			   	content += "  <th>외국인</th>";
			   	content += "  <th>기관합</th>";
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
  			    
				$.each( data, function( key, val){
					content += "<tr id='ldslist'>";
				    content += "  <th><a href='Analysis.jsp?companyCode="+data[key].companyCode+"&marketKind=&industryCode="+"', target='_blank'>"+data[key].companyName+"</a></th>";
				    content += "  <th>"+data[key].industryName+"</th>";
				    content += "  <th></th>";
				   	content += "  <th>"+(data[key].personalSum/1000000).toFixed(0)+"</th>";
				    content += "  <th>"+(data[key].powerSum/1000000).toFixed(0)+"</th>";
				    content += "  <th>"+(data[key].leaderSum/1000000).toFixed(0)+"</th>";
				    content += "  <th>"+(data[key].foreignerSum/1000000).toFixed(0)+"</th>";
				    content += "  <th>"+(data[key].orgSumSum/1000000).toFixed(0)+"</th>";
				    content += "  <th></th>";
				    content += "  <th>"+(data[key].finInvestSum/1000000).toFixed(0)+"</th>";
				    content += "  <th>"+(data[key].insuranceSum/1000000).toFixed(0)+"</th>";
				    content += "  <th>"+(data[key].investTrustSum/1000000).toFixed(0)+"</th>";
				    content += "  <th>"+(data[key].bankSum/1000000).toFixed(0)+"</th>";
				    content += "  <th>"+(data[key].etcFinSum/1000000).toFixed(0)+"</th>";
				    content += "  <th>"+(data[key].pensionSum/1000000).toFixed(0)+"</th>";
				    content += "  <th>"+(data[key].privateFundSum/1000000).toFixed(0)+"</th>";
				    content += "  <th>"+(data[key].nationSum/1000000).toFixed(0)+"</th>";
				    content += "  <th>"+(data[key].etcCorpSum/1000000).toFixed(0)+"</th>";
				    content += "  <th>"+(data[key].etcForeignerSum/1000000).toFixed(0)+"</th>";
				    content += "</tr>";
  			   	});
  			   	content += " </tbody> ";
	  			content += " </table> <BR>";
  			
  				$('#company_investor_sum_table').html(content);
  				
  			    $('#ldslist > th').filter( function(index){	if( $(this).text() > 0 ){ return true; } }).css('background-color', 'palegreen');
  			    $('#ldslist > th').filter( function(index){	if( $(this).text() < 0 ){ return true; } }).css('background-color', 'orange');

  	   	 	}
  	   });
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
    
    #industry_investor_sum_table {
		float: left;
		width: 100%;
	  	margin: 0;
	 	padding: 0;
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
		 <input type="submit" id="nav_btn_overview" value="종합현황으로"> 
	  	    &nbsp;  || &nbsp; 
	  	<input type="submit" id="nav_btn_recommend" value="추천종목으로"> 
	   </div>	
	</div>
	
	
	<div id="content">

			<table>
		    	<tr>
		    		<td valign="top" colspan='2'>
		    		
		    		    <input type="radio" name="industry" id="kospi" value="kospi">KOSPI</input>
						<input type="radio" name="industry" id="kosdaq" value="kosdaq">KOSDAQ</input>
						
						<input type="text" name="fromCode" id="fromCode" value="">
						<input type="text" name="toCode" id="toCode" value="">
						&nbsp;&nbsp;
						<label >From</label>
						<input type="text" id="from_date" name="from_date">
						<label >to</label>
						<input type="text" id="to_date" name="to_date">
						&nbsp;
						<input type="submit" id="search_btn_week" value="1주">
						<input type="submit" id="search_btn_month" value="1개월">
					    <input type="submit" id="search_btn_3month" value="3개월">
						
					</td>
				</tr>
			</table>
			
			<table>
		    	<tr>
		    		<td valign="top" colspan='2'>
		    		
						<input type="submit" id="search_btn_industry_power" value="세력합매집상위업종조회">
						<input type="submit" id="search_btn_industry_leader" value="리더합매집상위업종조회">
					    <input type="submit" id="search_btn_industry_foreigner" value="외국인매집상위업종조회">
					    <input type="submit" id="search_btn_industry_orgSum" value="기관매집상위업종조회">
					    <BR>
			 			<div id="industry_investor_sum_table"></div>
					</td>
		    	</tr>
		    </table>
		    
		    <BR>

			<table>
		    	<tr>
		    		<td valign="top" colspan='2'>
						<input type="submit" id="search_btn_company_power" value="세력합매집상위종목조회">
						<input type="submit" id="search_btn_company_leader" value="리더합매집상위종목조회">
					    <input type="submit" id="search_btn_company_foreigner" value="외국인매집상위종목조회">
					    <input type="submit" id="search_btn_company_orgSum" value="기관매집상위종목조회">
					    <BR>
			 			<div id="company_investor_sum_table"></div>
					</td>
		    	</tr>
		    </table>

	</div>
</div>
<div class="modal"><!-- Place at bottom of page --></div>

</body>
</html>