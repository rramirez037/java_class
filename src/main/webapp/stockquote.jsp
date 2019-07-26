<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stock Quote</title>

</head>
<body>

<h2>
    Search <br>
	
</h2>

<form name="myform" action="servlets/StockSearchServlet" method="post">
    Stock Symbol : <input type="text" name="symbol" >
            from : <input type="text" name="from"   >	   
	       until : <input type="text" name="until" ><br>
	
	Intervals  :    <input type="radio" name="Intervals" value="daily"> Daily
                   <input type="radio" name="Intervals" value="weekly"> Weekly
                   <input type="radio" name="Intervals" value="monthly" checked> Monthly <br><br>
	                 
    <input type="SUBMIT" value="Search">
    <input type="HIDDEN" name="submit" value="true">
	
</form>

</body>
</html>