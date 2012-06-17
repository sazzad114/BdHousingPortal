
<%--
  Created by IntelliJ IDEA.
  User: ashraf
  Date: 5/29/12
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fn" %>
<html>
<head></head>
<body>
<div id="content">
    <div class="contentbg">
        <div class="post">
            <h2 class="title">${title}</h2>
        </div>
        <c:if test="${customerlist ne  null and fn:length(customerlist) == 0}">
            <div  class="post">
                <div class="entry">
                    <span style="text-align:center;">No customers found for your flats.</span>
                </div>
            </div>
        </c:if>
        <c:forEach items="${customerlist}" var="customer">
        <div class="post">
            <div class="entry">
                 <a href="viewcusprofile.htm?customerid=${customer.customerId}">
                 ${customer.customerName}<span>&nbsp;&nbsp;&nbsp;</span>
                 ${customer.occupation}<span>&nbsp;&nbsp;&nbsp;</span>
                </a>
            </div>
        </div>
        </c:forEach>

        <div style="clear: both;">&nbsp;</div>
    </div>
</div>
</body>

</html>