<%--
  Created by IntelliJ IDEA.
  User: ashraf
  Date: 5/29/12
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></head>
<body>
<div id="content">
    <div class="contentbg">
        <div class="post">
            <h2 class="title">${title}</h2>
        </div>
        <c:if test="${flatlist ne  null and fn:length(flatlist) == 0}">
            <div class="post">
                <div class="entry">
                    <span style="text-align:center;">No flats found for your criteria.</span>
                </div>
            </div>
        </c:if>
        <c:forEach items="${flatlist}" var="flat">
            <div class="post">
                <div class="entry">
                    <a href="flat/view.htm?flatid=${flat.flatId}">
                            ${flat.building.buildingName}<span>&nbsp;&nbsp;&nbsp;</span>
                            ${flat.numberOfBeds}<span>&nbsp;Beds&nbsp;&nbsp;</span>
                            ${flat.priceOrRent}<span>&nbsp;Tk&nbsp;</span>
                        <c:if test="${flat.forRent == true}">
                            per month
                        </c:if>
                        <c:if test="${flat.forRent == false}">
                            per sqr feet
                        </c:if>
                    </a>
                </div>
            </div>
        </c:forEach>

        <div style="clear: both;">&nbsp;</div>
    </div>
</div>
</body>

</html>