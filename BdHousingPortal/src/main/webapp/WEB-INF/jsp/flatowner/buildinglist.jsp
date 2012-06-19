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

        <c:if test="${buildingList ne  null and fn:length(buildingList) == 0}">
            <div class="post">
                <div class="entry">
                    <span style="text-align:center;">You did not add any building.</span>
                </div>
            </div>
        </c:if>
        <c:forEach items="${buildingList}" var="building">

            <div class="post">

                <div class="entry">

                    <a href="/BdHousingPortal/own/building/buildingdetails.htm?buildingId=${building.buildingId}">${building.buildingName}</a>

                    <div style="float:right;"><a
                            href="/BdHousingPortal/own/building/delete.htm?buildingid=${building.buildingId}">delete</a>
                    </div>

                </div>
            </div>

        </c:forEach>


        <div style="clear: both;">&nbsp;</div>
    </div>
</div>
</body>

</html>