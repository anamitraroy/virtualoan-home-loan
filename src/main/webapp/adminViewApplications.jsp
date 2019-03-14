<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/virtuloan-home-loan/">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table align=center>
		<thead>
			<tr>
				<th>Application Number</th>
				<th>User ID</th>
				<th>Requested Loan Amount</th>
				<th>Status </th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ listOfApplications }" var = "app">
		<tr> 
			<td>${ app.applicationNo } </td>
			<td>${ app.userId } </td>
			<td>${ app.requestedLoanAmount } </td>
			<td><c:choose>
						<c:when test="${app.isApproved == true}">Loan Approved. <br/></c:when>
						<c:when test="${app.isSent == true && app.isVerified == true && app.isApproved == false}">Loan Verified, Pending Approval. <br/></c:when>
						<c:when test="${app.isSent == true && app.isApproved == false && app.isApproved == false}">Loan sent for Verification and Approval. <br/></c:when>
					</c:choose>
			</td>
			<td><a href="<c:url value="controller/viewSingleApplication">
											<c:param name="applicationNo" value="${app.applicationNo }" />
																</c:url>">Take Action</a></td>
		</tr>
		</c:forEach>
		</tbody>
</table>
<a href="adminDashboard.jsp">Back To Dashboard</a>
</body>
</html>