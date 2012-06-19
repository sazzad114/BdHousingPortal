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
<div id="content">
    <div class="contentbg">
        <div class="post">
            <h2 class="title">${title}</h2>
        </div>
        <div class="post">
            <div class="entry">
                <form:form action="" commandName="flatowner" method="post">
                    <table>
                        <tr>
                            <td>
                                <fmt:message key="user.name"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="flatOwnerName"/><br/>
                                <span class="error"><form:errors path="flatOwnerName"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="user.dateOfBirth"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="dateOfBirth"/><br/>
                                <span class="error"><form:errors path="dateOfBirth"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="user.contact"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="contactNo"/><br/>
                                <span class="error"><form:errors path="contactNo"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="user.houseNo"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="address.houseNo"/><br/>
                                <span class="error"><form:errors path="address.houseNo"/></span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.roadNo"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="address.roadNo"/><br/>
                                <span class="error"><form:errors path="address.roadNo"/></span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.area"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="address.area"/><br/>
                                <span class="error"><form:errors path="address.area"/></span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.thana"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="address.thana"/><br/>
                                <span class="error"><form:errors path="address.thana"/> </span>
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
                                <span class="error"><form:errors path="address.district"/></span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.occupation"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="occupation"/><br/>
                                <span class="error"><form:errors path="occupation"/></span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.occupation.details"/>

                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td align="justify">
                                <form:textarea path="occupationDetails" cols="40" rows="5"/><br/>
                                <span class="error"><form:errors path="occupationDetails"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="user.description"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:textarea path="description" cols="40" rows="5"/><br/>
                                <span class="error"><form:errors path="description"/></span>
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