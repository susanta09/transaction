<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 1px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 8px;
  padding-bottom: 8px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
	<div>
		<form action="/Bank_Transaction/searchtran/">
			<input type="text" name="rid" placeholder="Enter the Account number">
			<button>Search</button>
			<a class="a" href="/Bank_Transaction/searchT">Refresh</a>
		</form>
	</div>
	<div>
		<div>
			<table id="customers">
			<caption><h1>Transaction History</h1></caption>
				<thead>
					<tr>
						<th><h1>TransactionId</h1></th>
						<th><h1>PaymentType</h1></th>
						<th><h1>Sources</h1></th>
						<th><h1>States</h1></th>
						<th><h1>TAmount</h1></th>
						<th><h1>Date and Time</h1></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${trdh}" var="e">
						<tr>
							<td><h1>${e.getTransactionId()}</h1></td>
							<td><h1>${e.getPaymentType()}</h1></td>
							<td><h1>${e.getSources()}</h1></td>
							<td><h1>${e.getStates()}</h1></td>
							<td><h1>${e.gettAmount()}</h1></td>
							<td><h1>${e.getDate()}</h1></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<table class="t2">
				<tr>
					<c:forEach begin="1" end="${noP}" var="i">
						<c:choose>
							<c:when test="${currentP eq i}">
								<td><h1>
								<a href="/Bank_Transaction/tran/${i}/${rid}" style="text-decoration: none;">p${i}</a>
								</h1></td>
							</c:when>
							<c:otherwise>
								<td><h1>
								<a href="/Bank_Transaction/tran/${i}/${rid}"  style="text-decoration: none;">p${i}</a>			
								</h1></td>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>