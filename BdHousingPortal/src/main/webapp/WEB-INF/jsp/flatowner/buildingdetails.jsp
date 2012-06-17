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
<div id="content">
    <div class="contentbg">
        <div class="post">
            <a href="/BdHousingPortal/own/flat/create.htm?buildingid=${building.buildingId}" style="float:right;">Add new Flat</a>
            <h2 class="title">${title}</h2>
        </div>
        <div class="post">
            <div class="entry">

                <table>
                    <tr>
                        <td>
                            <fmt:message key="building.name"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${building.buildingName}

                        </td>
                    </tr>

                    <tr>
                        <td>
                            <fmt:message key="building.numberoffloors"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>


                            ${building.numberOfFloors}

                        </td>
                    </tr>


                    <tr>
                        <td>
                            <fmt:message key="user.houseNo"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${building.address.houseNo}

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fmt:message key="user.roadNo"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${building.address.roadNo}

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fmt:message key="user.area"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${building.address.area}

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fmt:message key="user.thana"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${building.address.thana}

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fmt:message key="user.district"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>

                            ${building.address.district}

                        </td>
                    </tr>

                </table>


            </div>
        </div>




        <div class="post">
            <h2 class="title">Flat type List</h2>
        </div>
        <c:if test="${building.flatTypeCount == 0}">
           <div class="post">
             <div class="entry">
             <c:out value="No Flat Type added"/>
             </div>
          </div>
        </c:if>
        <c:if test="${building.flatList != null}">
        <c:forEach items="${building.flatList}" var="flat">
          <div class="post">
             <div class="entry">
                  <a href="/BdHousingPortal/own/flat/view.htm?flatid=${flat.flatId}">${flat.numberOfBeds} Beds, Type-${flat.typeNumber}</a>
             </div>
          </div>
        </c:forEach>
        </c:if>


        <div style="clear: both;">&nbsp;</div>
    </div>
</div>
</body>
</html>