<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample List</title>
 
<script type="text/javascript">
<!--
 
function fnCmdNew() {
    document.sampleVo.sampleNo.value = 0;
    document.sampleVo.action = 'form.do';
    document.sampleVo.submit();
}
 
function fnCmdEdit(sampleNo) {
    document.sampleVo.sampleNo.value = sampleNo;
    document.sampleVo.action = 'form.do';
    document.sampleVo.submit(); 
}
 
function fnCmdDelete(sampleNo) {
    document.sampleVo.sampleNo.value = sampleNo;
    document.sampleVo.action = 'delete.do';
    document.sampleVo.submit(); 
}
 
 
// -->
</script>
 
</head>
<body>
 
메시지 : ${message}<br />
 
<a href="#" onclick="fnCmdNew()">[신규]</a>
 
<form:form id="sampleVo" name="sampleVo" method="post">
    <input type="hidden" name="sampleNo" />
 
    <table border="1">
        <thead>
            <tr>
                <th>Sample No</th>
                <th>Title</th>
                <th>Description</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="result" items="${list}" varStatus="status">
                <tr>
                    <td>${result.sampleNo}</td>
                    <td>${result.title}</td>
                    <td>${result.description}</td>
                    <td><a href="#" onclick="fnCmdEdit('${result.sampleNo}')">수정</a></td>
                    <td><a href="#" onclick="fnCmdDelete('${result.sampleNo}')">삭제</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</form:form>
 
</body>
</html>