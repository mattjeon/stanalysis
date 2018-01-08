<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample View</title>
 
<script type="text/javascript">
<!--
 
function fnCmdSave() {
    document.sampleVo.action = '${commandUrl}';
    document.sampleVo.submit();
}
 
// -->
</script>
 
</head>
<body>
 
<a href="#" onclick="fnCmdSave()">[Submit]</a>
 
<form:form id="sampleVo" name="sampleVo" method="post">
    <input type="hidden" id="sampleNo" name="sampleNo" value="${result.sampleNo}" />
     
    <table border="1">
        <tr>
            <th>Title</th>
            <td><input name="title" size="50" value="${result.title}" /></td>
        </tr>
        <tr>
            <th>Description</th>
            <td><input name="description" size="50" value="${result.description}" /></td>
        </tr>
    </table>
</form:form>
 
</body>
</html>