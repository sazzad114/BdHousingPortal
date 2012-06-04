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
            <h2 class="title">Flat Owner Registration Form</h2>
        </div>
        <div class="post">
            <div class="entry">
                <form:form action="" commandName="flatOwner" method="post">
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
                                <form:errors path="dateOfBirth"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="user.email"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="user.email"/><br/>
                                <form:errors path="user.email" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.contact"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="contactNo"/><br/>
                                <form:errors path="contactNo"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.password"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:password path="user.password"/><br/>
                                <form:errors path="user.password"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.confirmPassword"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:password path="user.confirmPassword"/><br/>
                                <form:errors path="user.confirmPassword"/>
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
                        <tr>
                            <td>
                                <fmt:message key="user.occupation"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="occupation"/><br/>
                                 <form:errors path="occupation"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.occupation.details"/>

                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td align="justify">
                                <form:textarea path="occupationDetails" cols="40" rows="5"/><br/>
                                <form:errors path="occupationDetails"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="user.description"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:textarea path="description" cols="40" rows="5"/><br/>
                                 <form:errors path="description"/>
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