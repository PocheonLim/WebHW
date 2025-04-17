<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2022/12/13
  Time: 12:55 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>학사관리 시스템</title>
  </head>
  <body>
    <h2>학사관리 시스템</h2>
    <p><a href="${pageContext.request.contextPath}/credits">학년별 이수 학점 조회</a></p>
    <p><a href="${pageContext.request.contextPath}/enroll">수강 신청하기</a></p>
    <p><a href="${pageContext.request.contextPath}/enrollments">수강 신청 조회</a></p>
  </body>
</html>
