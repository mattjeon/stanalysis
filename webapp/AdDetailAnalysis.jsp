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
		
	    
	    <%
	    String req = request.getParameter("companyCode");
	    String req2 = request.getParameter("industryCode");
	    String req3 = request.getParameter("marketKind");
	    String req4 = request.getParameter("companyName");
	    %>
	   
	    var companyCode = '<%=req%>';
	    var industryCode = '<%=req2%>';
	    var marketKind = '<%=req3%>';
	    var companyName = '<%=req4%>';
	    
		$( "#input_company_code" ).val(companyCode);
		$( "#input_market_kind" ).val(marketKind);
		$( "#input_company_name" ).val(companyName);;
		
	    
	    //달력세팅
  		$( "#from_date_duravol" ).datepicker({ dateFormat: "yymmdd" });
		$( "#from_date_duravol" ).datepicker("setDate", -365);
		$( "#to_date_duravol" ).datepicker({  dateFormat: "yymmdd" });
		$( "#to_date_duravol" ).datepicker("setDate", "today");


	    //자동조회
		  $.ajax({
		        async   : true,
		  });
		
    	var companyCode = $("#input_company_code").val();
        var fromdate_c = $("#from_date_duravol" ).val();
  		var todate_c = $("#to_date_duravol").val();
  		
  		$.getJSON("duration/getInvestorDurationIncome/"+companyCode+"/"+fromdate_c+"/"+todate_c, function(data) {
		    if( data == null ){    alert("Not Found Data"); }
			else{
				createInvestorDurationVolumeTable(data);
			}
   		 });
  		  
		  
	  	$.getJSON("duration/getCompanyCommercialBand/"+companyCode+"/"+fromdate_c+"/"+todate_c, function(data) {
	   		if( data == null ){    alert("Not Found Data"); }
	   	 	else{
	   			createCompanyCommercialBandTable( data );
	   		}
	   }); 
  	});
  	
  	
   // 버튼 처리
	$(function() {
		
	    $("#search_btn_duravol").click(function() {
	    	event.preventDefault();
	    	
	    	var companyCode = $("#input_company_code").val();
	        var fromdate_c = $("#from_date_duravol" ).val();
	  		var todate_c = $("#to_date_duravol").val();
	  		
	  		$.getJSON("duration/getInvestorDurationIncome/"+companyCode+"/"+fromdate_c+"/"+todate_c, function(data) {
			    if( data == null ){    alert("Not Found Data"); }
				else{
					createInvestorDurationVolumeTable(data);
				}
	   		 });
	  		
	  	   $.getJSON("duration/getCompanyCommercialBand/"+companyCode+"/"+fromdate_c+"/"+todate_c, function(data) {
		   		if( data == null ){    alert("Not Found Data"); }
		   	 	else{
		   			createCompanyCommercialBandTable( data );
		   		}
		   });
	    });
	    
	       
  	});

 
			
  	function createInvestorDurationVolumeTable(data){
	    var content = "<table>";
		    content += "<thead >";
		    content += " <tr>  ";
		    content += "  <th></th>";
		   	content += "  <th>개인</th>";
		    content += "  <th>세력</th>";
		    content += "  <th>리더</th>"
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
		    content += "<tr id='accs'>";
		    content += "  <th><B>총 순매집량</B></th>";
		   	content += "  <th>"+data.personalSum+"</th>";
		    content += "  <th>"+data.powerSum+"</th>";
		    content += "  <th>"+data.leaderSum+"</th>"
		    content += "  <th>"+data.foreignerSum+"</th>";
		    content += "  <th>"+data.orgSumSum+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+data.finInvestSum+"</th>";
		    content += "  <th>"+data.insuranceSum+"</th>";
		    content += "  <th>"+data.investTrustSum+"</th>";
		    content += "  <th>"+data.bankSum+"</th>";
		    content += "  <th>"+data.etcFinSum+"</th>";
		    content += "  <th>"+data.pensionSum+"</th>";
		    content += "  <th>"+data.privateFundSum+"</th>";
		    content += "  <th>"+data.nationSum+"</th>";
		    content += "  <th>"+data.etcCorpSum+"</th>";
		    content += "  <th>"+data.etcForeignerSum+"</th>";
		    content += "</tr>";
		    content += "<tr id='accs'>";
		    content += "  <th><B>평균매입단가량</B></th>";
		   	content += "  <th>"+addCommas(data.personalAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th>"+addCommas(data.powerAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th>"+addCommas(data.leaderAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th>"+addCommas(data.foreignerAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th>"+addCommas(data.orgSumAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+addCommas(data.finInvestAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th>"+addCommas(data.insuranceAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th>"+addCommas(data.investTrustAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th>"+addCommas(data.bankAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th>"+addCommas(data.etcFinAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th>"+addCommas(data.pensionAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th>"+addCommas(data.privateFundAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th>"+addCommas(data.nationAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th>"+addCommas(data.etcCorpAvgBuyPrice.toFixed(0))+"</th>";
		    content += "  <th>"+addCommas(data.etcForeignerAvgBuyPrice.toFixed(0))+"</th>";
		    content += "</tr>";
		    
		    content += "<tr id='accs'>";
		    content += "  <th><B>평균수익률</B></th>";
		   	content += "  <th>"+addCommas(data.personalAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th>"+addCommas(data.powerAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th>"+addCommas(data.leaderAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th>"+addCommas(data.foreignerAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th>"+addCommas(data.orgSumAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th></th>";
		    content += "  <th>"+addCommas(data.finInvestAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th>"+addCommas(data.insuranceAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th>"+addCommas(data.investTrustAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th>"+addCommas(data.bankAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th>"+addCommas(data.etcFinAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th>"+addCommas(data.pensionAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th>"+addCommas(data.privateFundAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th>"+addCommas(data.nationAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th>"+addCommas(data.etcCorpAvgIncomeRate.toFixed(1))+"</th>";
		    content += "  <th>"+addCommas(data.etcForeignerAvgIncomeRate.toFixed(1))+"</th>";
		    content += "</tr>";
		    
			content += " </tbody> ";
			content += " </table> <BR>";
			
		$('#investor_vol_table').html(content);  
		
		$('#accs > th').filter( function(index){	if( $(this).text() > 0 ){ return true; } }).css('color', 'red');
	    $('#accs > th').filter( function(index){	if( $(this).text() < 0 ){ return true; } }).css('color', 'blue');
	    
  }

  	 

	function createCompanyCommercialBandTable(data){
	      
		var content = "<table>";
		    content += "<thead > ";
		    content += "<tr>";
		    content += "  <th>매물가격</th>";
		    content += "  <th>거래량</th>";
		    content += "  <th>비율</th>";
		    content += "  <th>이격도</th>";
		    content += "  <th></th>";
		   	content += "  <th>개인</th>";
		    content += "  <th>세력</th>";
		    content += "  <th>리더</th>"
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
		    content += "</tr>";
		    content += "</thead > ";
		    content += "<tbody > "
		    
		    $.each( data, function( key, val){
		    	content += "<tr id='c_band'>";
			    content +=  "  <th>"+ data[key].closePrice.toFixed(0)+"</th>";
			  	content +=  "  <th>"+addCommas(data[key].volume)+"</th>";
			  	content +=  "  <th id='vol_ratio'>"+data[key].volumeRatio.toFixed(0)+"</th>";
			  	content +=  "  <th>"+data[key].deviation.toFixed(0)+"</th>";
			  	content += "  <th></th>"
				content += "  <th>"+data[key].personalSum+"</th>";
			    content += "  <th>"+data[key].powerSum+"</th>";
			    content += "  <th>"+data[key].leaderSum+"</th>"
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
		$('#commercial_band_table').html(content);  
		
		$('#c_band > th').filter( function(index){	if( $(this).text() > 0 ){ return true; } }).css('color', 'red');
	    $('#c_band > th').filter( function(index){	if( $(this).text() < 0 ){ return true; } }).css('color', 'blue');

	    $('#c_band > #vol_ratio').filter( function(index){ if( $(this).text() >= 10 ){ return true; } }).css('background-color', 'yellow');
		$('#c_band > #vol_ratio').filter( function(index){ if( $(this).text() >= 20 ){ return true; } }).css('background-color', 'orange');
		$('#c_band > #vol_ratio').filter( function(index){ if( $(this).text() >= 30 ){ return true; } }).css('background-color', 'coral');
			
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
  #commercial_band_table {
	height: 750px;
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
		<input type="text" id="input_company_name" disabled>
		<input type="text"  id="input_company_code" disabled>
  	    <input type="hidden"  id="input_market_kind" disabled>
		<label >From</label>
		<input type="text" class="textbox" id="from_date_duravol" name="from_date_duravol">
		<label >to</label>
		<input type="text" class="textbox" id="to_date_duravol" name="to_date_duravol">
		<input type="submit" id="search_btn_duravol" value="조회">
	  	
	   </div>	
	</div>
	
	<div id="content">	
		<B>평균매수단가 및 수익률</B>
        <div id="investor_vol_table"></div> 
	    <B>매물대</B>
        <div id="commercial_band_table" ></div>
	</div> <!-- End Contents -->
</div> <!-- End frame -->
<div class="modal"><!-- Place at bottom of page --></div>
</body>
</html>
