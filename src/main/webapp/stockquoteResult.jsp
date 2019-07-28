<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Stock</title>
</head>
<body>

<h1>Search Result for:</h1>
<h3>
   Symbol: <c:out value="${symbol}"/><br>
     From: <c:out value="${from}"/><br>
       To: <c:out value="${to}"/><br>
 Interval: <c:out value="${interval}"/>
</h3>

<c:forEach items="${result}" var="item" varStatus="loopCounter">

  <c:out value="${loopCounter.count}. "/><c:out value="${item.getSymbol()}" />
  <c:out value="${item.getPrice() }" />
  <c:out value="${item.getDate()  }" /><br><br>

</c:forEach>

</body>
</html>
