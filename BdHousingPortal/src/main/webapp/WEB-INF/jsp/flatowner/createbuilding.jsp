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
<div id="content">
    <div class="contentbg">
        <div class="post">
            <h2 class="title">${title}</h2>
        </div>
        <div class="post">
            <div class="entry">
                <form:form action="" modelAttribute="building" method="post">
                    <table>
                        <tr>
                            <td>
                                <fmt:message key="building.name"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="buildingName"/><br/>
                                <span class="error"><form:errors path="buildingName"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="building.numberoffloors"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>

                                <form:select path="numberOfFloors" itemLabel="-Number Of Floors-">
                                    <form:option value="2">2</form:option>
                                    <form:option value="3">3</form:option>
                                    <form:option value="4">4</form:option>
                                    <form:option value="5">5</form:option>
                                    <form:option value="6">6</form:option>
                                    <form:option value="7">7</form:option>
                                    <form:option value="8">8</form:option>
                                    <form:option value="9">9</form:option>
                                    <form:option value="10">10</form:option>
                                </form:select>
                                <span class="error"><form:errors path="numberOfFloors"/></span>
                            </td>
                        </tr>


                        <tr>
                            <td>
                                <fmt:message key="user.houseNo"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="address.houseNo"/><br/>
                                <form:errors path="address.houseNo"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.roadNo"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="address.roadNo"/><br/>
                                <form:errors path="address.roadNo"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.area"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="address.area"/><br/>
                                 <form:errors path="address.area"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.thana"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="address.thana"/><br/>
                                   <form:errors path="address.thana"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.district"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:select path="address.district" itemLabel="-select district-">
                                    <form:option value="dhaka">Dhaka</form:option>
                                </form:select><br/>
                                 <form:errors path="address.district"/>
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