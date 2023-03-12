<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<form:form action="tran" modelAttribute="tr">
			<table>
			<caption><h1>Transaction Amount</h1></caption>
				<tr>
					<td><form:label path="accountNoFrom">AccountNo(From):</form:label></td>
					<td><form:input path="accountNoFrom"/></td>
				</tr>
				<tr>
					<td><form:label path="accountNoTo">AccountNo(To):</form:label></td>
					<td><form:input path="accountNoTo"/></td>
				</tr>
				<tr>
					<td><form:label path="accountType">AccountType:</form:label></td>
					<td><form:select path="accountType" size="1" multiple="false">
					<form:option value="saving" label="Saving"/>
					<form:option value="busnees" label="busnees"/>
					</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="tAmount">Amount:</form:label></td>
					<td><form:input path="tAmount"/></td>
				</tr>
				<tr>
				<td><form:hidden path="paymentType" value="Transaction"/></td>
				</tr>
				<tr>
				<td><form:hidden path="sources" value="online"/></td>
				</tr>
				<tr>
				<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form:form>
</div>
</body>
</html>