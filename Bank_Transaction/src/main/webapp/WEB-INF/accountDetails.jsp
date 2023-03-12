<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	position: relative;
	top: 40px;
	left: 100px;
	/* border: 2px solid red; */
	border-collapse: collapse;
}
table,td,th{
 border: 2px solid red;
}
th{
 padding-right: 8px;
 font-size: 22px;
}
td {
	text-align: center;
	font-size: 22px;
}
caption{
font-size: 22px;
color: highlight;
}
label,input {
	font-size: 22px;
}
.a {
	text-decoration: none;
	border:1px solid;
	padding: 2px 10px;
	margin-left: 4px;	
	background-color: 
}
.a1{
text-decoration: none;
padding: 2px 11px;
}
a:hover {
	background-color: aqua;
}
</style>
</head>
<body>
	<div>
	  <form action="/Bank_Transaction/acc/"  >
	    <input type="text" name="acno" value="${acc.getAccountNo()}" placeholder="Enter the Account number">
	    <button>Search</button>
	    <a class="a" href="/Bank_Transaction/admin">Refresh</a>
	  </form>
	</div>
	<div>
		<table>
			<caption>Account Details</caption>
			<thead>
				<tr>
					<th>accountNo</th>
					<th>accountType</th>
					<th>totalAmount</th>
					<th>Last update date</th>
					<th>rid</th>
					<th>access</th>
					<th>Unblock</th>
					<th>Block</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${acc.getAccountNo()}</td>
					<td>${acc.getAccountType()}</td>
					<td>${acc.getTotalAmount()}</td>
					<td>${acc.getDate()}</td>
					<td>${acc.getRid()}</td>
					<td>${acc.getAccess()}</td>
					<td><a class="a1" href="/Bank_Transaction/acBlockUnblock/unblock/${acc.getAccountNo()}">Unblock</a></td>
					<td><a class="a1" href="/Bank_Transaction/acBlockUnblock/block/${acc.getAccountNo()}">Block</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>