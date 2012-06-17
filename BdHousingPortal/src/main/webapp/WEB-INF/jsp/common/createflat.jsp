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
        span.error{
           color:#D8000C;
        }
    </style>
</head>
<body>
 <script type="text/javascript">

        function disAbleRent(){

            document.getElementById("sell").disabled = true;
            document.getElementById("rent").disabled = false;
        }

        function disAbleSell(){

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
                <form:form  action="" commandName="flat" method="POST" enctype="multipart/form-data">
                    <table >
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

                                <form:input path="totalArea" /><br/>
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
                                <form:errors path="numberOfRooms"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="flat.numberOfBeds"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="numberOfBeds"/><br/>
                                <form:errors path="numberOfBeds"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="flat.forRent"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>

                               <input id="forRent" onchange="disAbleSell()" type="radio" checked="checked" name="forRent" value="true"/>For Rent
                               <input id="forSell" onchange="disAbleRent()" type="radio" name="forRent" value="false"/>For Sell

                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="flat.price"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input id="rent" disabled="true" path="priceOrRent"/><br/>
                                <form:errors path="priceOrRent"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="flat.rent"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input id="sell" path="priceOrRent"/><br/>
                                <form:errors path="priceOrRent"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="flat.description" />
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:textarea path="description" cols="40" rows="5"/><br/>
                                <form:errors path="description"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="flat.description" />
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
                                <fmt:message key="flat.file" />
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <input  type="file" name="imageFile"/>
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