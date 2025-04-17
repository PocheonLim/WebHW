<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>학기별 상세 내역</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/main.css'/>">
</head>
<body>
    <div class="container">
        <h2>${year}년 ${semester}학기 상세 내역</h2>
        <table>
            <tr>
                <th>년도</th>
                <th>학기</th>
                <th>교과목명</th>
                <th>교과구분</th>
                <th>담당교수</th>
                <th>학점</th>
            </tr>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.year}</td>
                    <td>${course.semester}</td>
                    <td>${course.courseName}</td>
                    <td>${course.courseType}</td>
                    <td>${course.professor}</td>
                    <td>${course.credit}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="<c:url value='/credits'/>" class="back-link">목록으로 돌아가기</a>
    </div>
</body>
</html> 