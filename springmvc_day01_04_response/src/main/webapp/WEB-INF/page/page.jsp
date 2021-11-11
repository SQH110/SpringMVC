<%--写明格式--%>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html;UTF-8" %>
<html>
<body>
<h1>页面跳转测试中.../WEB-INF/page/page.jsp</h1>
info:${name}<br/><%--EL表达式--%>
book的name:${book.name}<br/><%--注意这个层级关系--%>
book的price:${book.price}<br/>
</body>
</html>