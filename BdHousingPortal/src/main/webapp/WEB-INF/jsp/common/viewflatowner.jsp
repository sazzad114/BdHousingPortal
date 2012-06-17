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
<div id="content">
    <div class="contentbg">
        <div class="post">
            <h2 class="title">${title}</h2>
        </div>
        <div class="post">
            <div class="entry">

                <table>

                    <tr>
                        <td>
                            <fmt:message key="user.name"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${flatowner.flatOwnerName}<br/>

                        </td>
                    </tr>

                    <tr>
                        <td>
                            <fmt:message key="user.dateOfBirth"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${flatowner.dateOfBirth}<br/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <fmt:message key="user.email"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${flatowner.user.email}<br/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fmt:message key="user.contact"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${flatowner.contactNo}<br/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <fmt:message key="user.houseNo"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${flatowner.address.houseNo}<br/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fmt:message key="user.roadNo"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${flatowner.address.roadNo}<br/>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fmt:message key="user.area"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${flatowner.address.area}<br/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fmt:message key="user.thana"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${flatowner.address.thana}<br/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fmt:message key="user.district"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${flatowner.address.thana}<br/>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fmt:message key="user.occupation"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${flatowner.occupation}<br/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fmt:message key="user.occupation.details"/>

                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td align="justify">

                            ${flatowner.occupationDetails}<br/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <fmt:message key="user.description"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${flatowner.description}<br/>
                        </td>
                    </tr>

                </table>

            </div>
        </div>

        <div style="clear: both;">&nbsp;</div>
    </div>
</div>
</body>
</html>