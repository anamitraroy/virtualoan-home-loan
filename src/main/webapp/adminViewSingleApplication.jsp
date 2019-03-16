<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base href="/virtuloan-home-loan/">
<title>Insert title here</title>
</head>
<body>

	Application Number: ${ currentApplication.applicationNo } <br/>
	User ID: ${ currentApplication.userId } <br/>
	Requested Loan Amount: ${ currentApplication.requestedLoanAmount } <br/>
	Duration of Loan: ${ currentApplication.duration } months <br/>
	<c:if test = "${ currentApplication.isVerified == false }">
		<a href="<c:url value="controller/verifyApplication">
											<c:param name="applicationNo" value="${currentApplication.applicationNo }" />
																</c:url>">Verify Loan</a><br/>
	</c:if>
	<c:if test = "${ currentApplication.isVerified == true && currentApplication.isApproved == false }">
		<a href="<c:url value="controller/approveApplication">
											<c:param name="applicationNo" value="${currentApplication.applicationNo }" />
																</c:url>">Approve Loan</a><br/>
	</c:if>
	=======================<br/>
	<a href="controller/fetchApplications">Back To Applications</a>
</body>
</html>