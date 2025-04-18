<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>수강 신청하기</title>
    <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css">
    <style>
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }
        .form-control {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .error {
            color: #ff0000;
            font-size: 0.9em;
            margin-top: 5px;
        }
        .submit-btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1em;
        }
        .submit-btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>수강 신청하기</h2>
        <form:form modelAttribute="courses" method="post">
            <div class="form-group">
                <label for="year">년도</label>
                <form:input path="year" class="form-control" value="2025" readonly="true"/>
                <form:errors path="year" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <label for="semester">학기</label>
                <form:input path="semester" class="form-control" value="2" readonly="true"/>
                <form:errors path="semester" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <label for="courseCode">과목 코드</label>
                <form:input path="courseCode" class="form-control"/>
                <form:errors path="courseCode" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <label for="courseName">과목명</label>
                <form:input path="courseName" class="form-control"/>
                <form:errors path="courseName" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <label for="courseType">과목 구분</label>
                <form:select path="courseType" class="form-control">
                    <form:option value="교필">교양필수</form:option>
                    <form:option value="선필교">선택필수교양</form:option>
                    <form:option value="전기">전공기초</form:option>
                    <form:option value="전필">전공필수</form:option>
                    <form:option value="전선">전공선택</form:option>
                    <form:option value="일선">일반선택</form:option>
                </form:select>
                <form:errors path="courseType" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <label for="professor">담당교수</label>
                <form:input path="professor" class="form-control"/>
                <form:errors path="professor" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <label for="credit">학점</label>
                <form:select path="credit" class="form-control">
                    <form:option value="1">1학점</form:option>
                    <form:option value="2">2학점</form:option>
                    <form:option value="3">3학점</form:option>
                </form:select>
                <form:errors path="credit" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <input type="submit" value="수강 신청" class="submit-btn">
            </div>
        </form:form>
        
        <a href="<c:url value='/'/>" class="back-link">홈으로 돌아가기</a>
    </div>
</body>
</html> 