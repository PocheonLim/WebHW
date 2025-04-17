<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>학년별 이수 학점 조회</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/main.css'/>">
</head>
<body>
    <div class="container">
        <h2>학년별 이수 학점 조회</h2>
        <table>
            <tr>
                <th>년도</th>
                <th>학기</th>
                <th>취득 학점</th>
                <th>상세보기</th>
            </tr>
            <c:forEach var="yearEntry" items="${creditsByYearAndSemester}">
                <c:forEach var="semesterEntry" items="${yearEntry.value}">
                    <tr>
                        <td>${yearEntry.key}</td>
                        <td>${semesterEntry.key}</td>
                        <td>${semesterEntry.value}</td>
                        <td>
                            <a href="<c:url value='/credits/detail'>
                                <c:param name='year' value='${yearEntry.key}'/>
                                <c:param name='semester' value='${semesterEntry.key}'/>
                            </c:url>" class="detail-link">상세보기</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>
        <div class="total-credits">
            총 이수 학점: ${totalCredits}학점
        </div>
        <a href="<c:url value='/'/>" class="back-link">홈으로 돌아가기</a>
    </div>
</body>
</html> 