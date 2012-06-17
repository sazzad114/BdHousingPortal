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

</head>
<body>
<style type="text/css">
        span.error {
            color: #D8000C;
        }
        td.head{
          width:150px;
        }
    </style>
<div id="content">
<div class="contentbg">
<div class="post">

    <h2 class="title">${title}</h2>
</div>
<div class="post">
<div class="entry">

<img  width="585" height="200"  src="../image/flatimage.htm?flatid=${flat.flatId}" alt="../image/flatimage.htm?flatid=${flat.flatId}"/>
<hr style="border-color: #7F7F81;"/><br/>


<table>


    <tr>
        <td class="head">
            <fmt:message key="building.name"/>

        </td>
        <td>

            ${flat.building.buildingName}

        </td>
    </tr>
    <tr>
        <td class="head">
            <fmt:message key="flat.ownername"/>

        </td>
        <td>
            <a href="../viewownerprofile.htm?flatownerid=${flat.building.flatOwner.flatOwnerId}">
                ${flat.building.flatOwner.flatOwnerName}
            </a>
        </td>
    </tr>
    <tr>
        <td class="head">
            <fmt:message key="building.numberoffloors"/>

        </td>
        <td>

            ${flat.building.numberOfFloors}

        </td>
    </tr>
    <tr>
        <td class="head">
            <fmt:message key="user.houseNo"/>

        </td>
        <td>

            ${flat.building.address.houseNo}

        </td>
    </tr>
    <tr>
        <td class="head">
            <fmt:message key="user.roadNo"/>

        </td>
        <td>

            ${flat.building.address.roadNo}

        </td>
    </tr>
    <tr>
        <td class="head">
            <fmt:message key="user.area"/>

        </td>
        <td>

            ${flat.building.address.area}

        </td>
    </tr>
    <tr>
        <td class="head">
            <fmt:message key="user.thana"/>

        </td>
        <td>

            ${flat.building.address.thana}

        </td>
    </tr>
    <tr>
        <td class="head">
            <fmt:message key="user.district"/>

        </td>
        <td>

            ${flat.building.address.district}

        </td>
    </tr>
    <tr>
        <td class="head">
            <fmt:message key="flat.numberOfFlats"/>

        </td>
        <td>

            ${flat.numberOfFlats}

        </td>
    </tr>

    <tr>
        <td class="head">
            <fmt:message key="flat.totalArea"/>

        </td>
        <td>


            ${flat.totalArea}

        </td>
    </tr>
    <tr>
        <td class="head">
            <fmt:message key="flat.numberOfRooms"/>

        </td>
        <td>
            ${flat.numberOfRooms}
        </td>
    </tr>
    <tr>
        <td class="head">
            <fmt:message key="flat.numberOfBeds"/>

        </td>
        <td>

            ${flat.numberOfBeds}

        </td>
    </tr>

    <tr>
        <td class="head">
            <c:if test="${flat.forRent == true}">
                <fmt:message key="flat.rent"/>

            </c:if>
            <c:if test="${flat.forRent == false}">
                <fmt:message key="flat.price"/>

            </c:if>

        </td>
        <td>

            ${flat.priceOrRent}

        </td>
    </tr>
    <tr>
        <td class="head">
            <fmt:message key="flat.description"/>

        </td>
        <td>

            ${flat.description}

        </td>
    </tr>
    <tr>
        <td class="head">
            <fmt:message key="flat.flatinfloors"/>

        </td>
        <td>

            <c:forEach items="${flat.flatInFloors}" var="floornumber">

                ${floornumber}
                <c:choose>
                    <c:when test="${floornumber % 10 == 1}">
                        st
                    </c:when>
                    <c:when test="${floornumber % 10 == 2}">
                        nd
                    </c:when>
                    <c:when test="${floornumber % 10 == 3}">
                        rd
                    </c:when>
                    <c:otherwise>
                        th
                    </c:otherwise>
                </c:choose>
                &nbsp;Floor&nbsp;&nbsp;
            </c:forEach>

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