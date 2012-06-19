<%--
  Created by IntelliJ IDEA.
  User: ashraf
  Date: 5/29/12
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></head>
<body>
<div id="content">
    <div class="contentbg">
        <div class="post">
            <h2 class="title">${title}</h2>
        </div>
        <c:forEach items="${criterialist}" var="criteria">
            <div class="post">
                <div class="entry">

                        ${criteria.area}<br/>
                        ${criteria.numberOfBeds}&nbsp;beds<br/>

                    <c:if test="${criteria.forRent == true}">

                        Rent :&nbsp;${criteria.priceOrRent}&nbsp;Tk per month<br/>
                    </c:if>
                    <c:if test="${criteria.forRent == false}">
                        Price :&nbsp;${criteria.priceOrRent}&nbsp;Tk per square feet<br/>
                    </c:if>
                    <a href="/BdHousingPortal/cus/criteria/delete.htm?criteriaid=${criteria.criteriaId}"
                       style="float:right;">Delete criteria</a>
                </div>
            </div>

        </c:forEach>
        <div style="float:right;">
            <c:forEach begin="1" end="${pagecount}" var="counter">

                <c:if test="${param['curr'] eq counter}">
                    <a href="/BdHousingPortal/cus/criteria/view.htm?curr=${counter}" style="color:#dc143c;">
                            ${counter}
                    </a>

                </c:if>
                <c:if test="${param['curr'] ne counter}">
                    <a href="/BdHousingPortal/cus/criteria/view.htm?curr=${counter}">
                            ${counter}
                    </a>
                </c:if>
                &nbsp;

            </c:forEach>
        </div>
        <div style="clear: both;">&nbsp;</div>
    </div>
</div>
</body>

</html>