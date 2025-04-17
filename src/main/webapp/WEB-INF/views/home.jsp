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
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
  </head>
  <body>
    <div class="container">
      <h1>학사관리 시스템</h1>
      <ul class="menu-list">
        <li class="menu-item">
          <a href="${pageContext.request.contextPath}/credits" class="menu-link">
            학년별 이수 학점 조회
          </a>
        </li>
        <li class="menu-item">
          <a href="${pageContext.request.contextPath}/enroll" class="menu-link">
            수강 신청하기
          </a>
        </li>
        <li class="menu-item">
          <a href="${pageContext.request.contextPath}/enrollments" class="menu-link">
            수강 신청 조회
          </a>
        </li>
      </ul>
    </div>
  </body>
</html>
