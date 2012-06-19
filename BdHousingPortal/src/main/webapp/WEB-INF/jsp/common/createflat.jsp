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
<style type="text/css">
    span.error {
        color: #D8000C;
        font-size: 12px;
    }
</style>
<script type="text/javascript">

    document.body.onload = function() {

        if (document.getElementById("forRent").checked == true) {
            document.getElementById("sell").value = "";
            document.getElementById("sell").disabled = true;
            document.getElementById("rent").disabled = false;
        }
        if (document.getElementById("forSell").checked == true) {
            document.getElementById("rent").value = "";
            document.getElementById("sell").disabled = false;
            document.getElementById("rent").disabled = true;
        }

    }

    function disAbleRent() {

        document.getElementById("rent").value = "";
        document.getElementById("rent").disabled = true;
        document.getElementById("sell").disabled = false;

    }

    function disAbleSell() {

        document.getElementById("sell").value = "";
        document.getElementById("sell").disabled = true;
        document.getElementById("rent").disabled = false;
    }

    function adjust() {
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
                <form:form action="" commandName="flat" method="POST" enctype="multipart/form-data">
                    <table>
                        <tr>
                            <td>
                                <fmt:message key="flat.numberOfFlats"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="numberOfFlats"/><br/>
                                <span class="error"><form:errors path="numberOfFlats"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="flat.totalArea"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>

                                <form:input path="totalArea"/><br/>
                                <span class="error"><form:errors path="totalArea"/></span>
                            </td>
                        </tr>


                        <tr>
                            <td>
                                <fmt:message key="flat.numberOfRooms"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="numberOfRooms"/><br/>
                                <span class="error"><form:errors path="numberOfRooms"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="flat.numberOfBeds"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="numberOfBeds"/><br/>
                                <span class="error"><form:errors path="numberOfBeds"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="search.forRent"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>

                                <input id="forRent" onchange="disAbleSell()" type="radio"
                                       <c:if test="${flat.forRent == true}">checked</c:if> name="forRent"
                                       value="true"/>For Rent

                            </td>
                            <td>
                                <input id="forSell" onchange="disAbleRent()" type="radio"
                                       <c:if test="${flat.forRent == false}">checked</c:if> name="forRent"
                                       value="false"/>For Sell

                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="flat.rent"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input id="rent" disabled="true" path="priceOrRent"/><br/>
                                <span class="error"><form:errors path="priceOrRent"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="flat.price"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input id="sell" path="priceOrRent"/><br/>
                                <span class="error"><form:errors path="priceOrRent"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="flat.description"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:textarea path="description" cols="40" rows="5"/><br/>
                                <span class="error"><form:errors path="description"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="flat.description"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <c:forEach items="${floorlist}" var="floor">
                                    <form:checkbox path="flatInFloors" value="${floor}" label="${floor}"/>
                                </c:forEach>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="flat.file"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <input type="file" name="imageFile"/>
                            </td>
                        </tr>

                    </table>


                    <input type="submit" value="<fmt:message key="flatOwner.submit"/>"/>

                </form:form>
            </div>
        </div>

        <div style="clear: both;">&nbsp;</div>
    </div>
</div>
</body>
</html>