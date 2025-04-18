<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>수강 신청 내역</title>
    <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="container">
        <h2>2025년 2학기 수강 신청 내역</h2>
        
        <table>
            <thead>
                <tr>
                    <th>과목 코드</th>
                    <th>과목명</th>
                    <th>구분</th>
                    <th>담당교수</th>
                    <th>학점</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="course" items="${courses}">
                    <tr>
                        <td>${course.courseCode}</td>
                        <td>${course.courseName}</td>
                        <td>${course.courseType}</td>
                        <td>${course.professor}</td>
                        <td>${course.credit}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="total-credits">
            총 신청 학점: ${totalCredits}학점
        </div>
        
        <a href="<c:url value='/enroll'/>" class="back-link">추가 수강 신청</a>
        <a href="<c:url value='/'/>" class="back-link" style="margin-left: 20px;">홈으로 돌아가기</a>
    </div>
</body>
</html> 