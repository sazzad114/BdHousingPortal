<%--
  Created by IntelliJ IDEA.
  User: ashraf
  Date: 5/31/12
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="/spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fn" %>
<html>

<head>

    <title>Simple jsp page</title>
    <style type="text/css">
        span.error {
            color: #D8000C;
        }
    </style>
</head>
<body>
<script type="text/javascript">

    function disAbleRent() {

        document.getElementById("sell").disabled = true;
        document.getElementById("rent").disabled = false;
    }

    function disAbleSell() {

        document.getElementById("sell").disabled = false;
        document.getElementById("rent").disabled = true;
    }

</script>
<div id="content">
    <div class="contentbg">
        <div class="post">
            <h2 class="title">${title}</h2>
        </div>
        <div class="post">
            <div class="entry">
                <form:form action="" modelAttribute="criteria" method="post">
                    <table>
                        <tr>
                            <td>
                                <fmt:message key="search.area"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>

                                <select name="area">
                                    <c:forEach items="${arealist}" var="area">
                                        <option value="${area.areaName}">${area.areaName}</option>
                                    </c:forEach>
                                </select>

                                <span class="error"><form:errors path="area"/></span>
                            </td>

                            <td>
                                <fmt:message key="search.numberofbeds"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>

                                <form:select path="numberOfBeds" items="${numberofbeds}"/>
                                <span class="error"><form:errors path="numberOfBeds"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="search.forRent"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>


                                <input id="forRent" onchange="disAbleSell()" type="radio" checked="checked"
                                       name="forRent" value="true"/>For Rent
                            </td>
                            <td>
                                <input id="forSell" onchange="disAbleRent()" type="radio" name="forRent" value="false"/>For
                                Sell


                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="search.price"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input id="rent" disabled="true" path="priceOrRent"/><br/>
                                <form:errors path="priceOrRent"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="search.rent"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input id="sell" path="priceOrRent"/><br/>
                                <form:errors path="priceOrRent"/>
                            </td>
                        </tr>

                    </table>


                    <input type="submit" value="<fmt:message key="search.submit"/>"/>
                </form:form>
            </div>
        </div>
        <c:if test="${flatlist ne  null and fn:length(flatlist) == 0}">
            <div  class="post">
                <div class="entry">
                    <span style="text-align:center;">No results found for your query.</span>
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