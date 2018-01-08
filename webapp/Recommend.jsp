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
	  
  <script>
  	$(function() {

  		//Set Title
  		var currentDate = new Date();
  		var curr_date = (currentDate.getDate() < 10) ? '0'+currentDate.getDate() : currentDate.getDate() ;
  		var curr_month = ((currentDate.getMonth() + 1) < 10) ? '0' + (currentDate.getMonth() + 1) : (currentDate.getMonth() + 1);
  		var curr_year = currentDate.getFullYear();
  		var todayDate = curr_year+"-"+curr_month+"-"+curr_date;
  		
	    document.title = "추천 현황_"+todayDate;

  		//$( "#tabs" ).tabs();
  		$("#tabs").tabs({
  		  beforeActivate: function (event, ui) {
  		    document.title = ui.newTab.context.innerText +"_"+todayDate;
  		  }
  		});

  		//일별 추천 조회
  		getRecommendCompanyDateList();
   		
    });
    
    // 버튼 처리
    $(function() {
        
        //업종 및 추천 종목 평가 분석 후 저장
  		$("#add_btn_recommend_company").click(function() {
	    	event.preventDefault();
	  //  	alert("ddd");
	    	addRecommend();
	    });
  		
        //일별 추천 종목 조회
  		$("#search_btn_recommend_company").click(function() {
	    	event.preventDefault();
	    	getRecommendCompanyDateList();
	    });
        
        $("#nav_btn_detail").click(function() {
	    	event.preventDefault();
	        window.open('Analysis.jsp', '_blank');
         });
  		
        $("#nav_btn_overview").click(function() {
	    	event.preventDefault();
	        window.open('Overview.jsp', '_blank');
         });
  		
        $("#nav_btn_duration").click(function() {
	    	event.preventDefault();
	        window.open('Duration.jsp', '_blank');
         });

    }); 		
    
   //추천종목 분석 저장
   function addRecommend() {
	  
	   //$.ajaxSetup({
	   //     async: false
	   //});
	   
	   $('#analysis_message').val("분석중..20분 후 조회.");
	   document.getElementById("add_btn_recommend_company").disabled = true;
	   
  	   $.getJSON("recommend/addRecommendCompany", function(data) {
  		 $.each( data, function( key, val){
   			if( data == null ){    alert("Not Found Data"); }
			else{
				if( data[0] == '0' ){
					alert("OK");
					$('#analysis_message').val("분석이 성공적으로 수행되었습니다.");
				}
				else{
					alert("Failed" + data[0] );
					$('#analysis_message').val("분석이 실패 되었습니다.");
					document.getElementById("add_btn_recommend_company").disabled = false;
				}
			}
			$('#analysis_message').val("");

  		 });
   	   });

    }
    
    // 일별 추천 종목수 조회
    function getRecommendCompanyDateList() {
   	   $.getJSON("recommend/getRecommendCompanyDateList", function(data) {
  	   		if( data == null ){    alert("Not Found Data"); }
  	   	 	else{
  		   	 	var content = "<table id='date_accr'>";
	  			    content += "<thead >";
	  			    content += " <tr >  ";
	  			    content += "  <th>일자</th><th>수</th>";
	  			    content += "</tr> ";
	  			    content += "</thead>  ";
	  			    
	  			    content += "<tbody > ";
	  			    $.each( data, function( key, val){
	  			    	content += " <tr id='recommend'>  ";
	  			    	content += "  <td id='regdate'><span style='text-decoration:underline;'>"+data[key].regDate+"</span></td><td>"+data[key].cnt+"</td>";
	  				    content += "</tr> ";
	  			   	});
	  			    content += " </tbody> ";
	  				content += " </table> <BR>";
	  			   	
  				$('#recommend_company_date_table').html(content);
  			   
  				// 자동조회 설정
  				//alert(data[0].regDate );
   				getRecommendCompanyListByCondition(data[0].regDate, 'daily');
  				getRecommendCompanyListByCondition(data[0].regDate, 'monthly');
  				
  				$('#recommend > #regdate').click(function() {
  			    	event.preventDefault();
  			    	var curdate = $(this).text();
  			    	
  			    	getRecommendCompanyListByCondition(curdate, 'daily');
	  				getRecommendCompanyListByCondition(curdate, 'monthly');
  			    });
  	   	 	}
  	   });
      }


    //조건별 추천 종목 조회 
    function getRecommendCompanyListByCondition(curdate, conditionType) {
    	
    	//alert( curdate +":"+ conditionType);
		$('#recomm_daily_company_table').html("");
		$('#recomm_monthly_company_table').html("");
	
		$.getJSON("recommend/getRecommendCompanyListByCondition/"+curdate+"/"+conditionType, function(data) {
  		    
			if( data == null ){    alert("Not Found Data"); }
 	   	 	else{
 	   	 	    
 		   	 	var content = "<table>";
 			    content += "<thead >";
 			    content += " <tr>  ";
 			    content += "  <th>종목명</th><th>추천일자</th>";
				content += "  <th>매매신호</th>"; 
 			    content += "  <th>현재<BR>상승률</th><th>최대<BR>상승률</th>"; 
			    content += "</tr> ";
 			    content += "</thead>  ";
 			    content += "<tbody > ";
 			    
 			    $.each( data, function( key, val){
 			    	content += " <tr>  ";
 			    	content += "  <th><a href='Analysis.jsp?companyCode="+data[key].companyCode+"&marketKind=&industryCode="+"', target='_blank'>"+data[key].companyName+"</a></th>";
 			    	content += "  <th>"+data[key].regDate+"</th>;"
			    	content += "  <th>"+data[key].tradeSignal+"</th>";
 			    	content += "  <th>"+data[key].updownRatio.toFixed(1)+"</th>";
 			    	content += "  <th>"+data[key].maxUpdownRatio.toFixed(1)+"</th>";
 			    	content += "</tr> ";
 			   	});
 			    
 			    content += " </tbody> ";
 				content += " </table> <BR>";
 			
	 			if( conditionType == 'daily'){
	 	 			$('#recomm_daily_company_table').html(content);
	 			}else if( conditionType == 'monthly'){
	 	 	 		$('#recomm_monthly_company_table').html(content);
	 	   	 	}
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
 
    
    #all_recommend_table {
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
		 <input type="submit" id="nav_btn_duration" value="기간별매집현황으로"> 
	   </div>	
	</div>
	
	
	<div id="content">

			 <table>
				<tr>
					<td width='10%' valign="top" >
						<input type="submit" id="search_btn_recommend_company" value="추천종목 조회">
						<BR>
					    <input type="submit" id="add_btn_recommend_company" value="분석(20여분 소요)">
						<input type="text" id="analysis_message" disabled>
						<div id="recommend_company_date_table"></div>
					</td>
					<td valign="top">   
					    * 모든 신호 및 데이터는 추천시점의 자료입니다. 
					    <BR>
					    <B><font color='green'> 당일 종목</font></B>
						<div id="recomm_daily_company_table"></div>
						<BR>
						<B><font color='green'> 월간 종목</font></B>
						<div id="recomm_monthly_company_table"></div>
						<BR>
					</td>
				</tr>
			</table>
	</div>
</div>
<div class="modal"><!-- Place at bottom of page --></div>

</body>
</html>