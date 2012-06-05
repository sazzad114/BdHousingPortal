<%--
  Created by IntelliJ IDEA.
  User: ashraf
  Date: 4/25/12
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Food Voting</title>

    <!-- This template was created by Mantis-a [http://www.mantisa.cz/]. For more templates visit Free website templates [http://www.mantisatemplates.com/]. -->

    <meta name="Description" content="..."/>
    <meta name="Keywords" content="..."/>
    <meta name="robots" content="all,follow"/>
    <meta name="author" content="..."/>

    <!-- Javascript -->
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>

    <!-- CSS -->
    <link rel="stylesheet" href="/Foodvoting/resources/css/style.css" type="text/css" media="screen, projection, tv"/>
    <link rel="stylesheet" href="/Foodvoting/resources/css/style-print.css" type="text/css" media="print"/>

    <!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
</head>

<body>
<div id="wrapper">

    <!-- Header -->
    <div id="header">

        <!-- Your website name  -->
        <h1><a href="#">Food Voting</a></h1>
        <!-- Your website name end -->

        <!-- Your slogan -->
        <h2>Your favourite dishes are waiting for your vote&hellip;</h2>
        <!-- Your slogan end -->

        <div id="header-arrow"></div>
    </div>
    <!-- Header end -->

    <!-- Menu -->
    <a href="#skip-menu" class="hidden">Skip menu</a>

    <ul id="menu" class="cleaning-box">
        <%--<c:if test="${isLoggedIn == true}">--%>
            <li><a href="/Foodvoting/app/home.htm">HOME</a></li>
            <li><a href="/Foodvoting/app/foodList.htm">FOOD LIST</a></li>
            <li><a href="/Foodvoting/app/vote.htm">VOTE</a></li>
            <li><a href="/Foodvoting/app/logout.htm">LOG OUT</a></li>
            <%--<c:if test="${USER.admin == true}">--%>
                <%--<li><a href="/hibernateOracle/app/home.htm">VIEW VOTE</a></li>--%>
            <%--</c:if>--%>
            <%--<li><a href="/hibernateOracle/app/home.htm">LOG OUT</a></li>--%>
        <%--</c:if>--%>
    </ul>

    <!-- Menu end -->

    <hr class="noscreen"/>

    <div id="content-box">



                <div class="content-box-left-in">
                  <div style="padding:50px;line-height:200%;">
                    <decorator:body/>
                   </div>
                </div>


            <hr class="noscreen"/>

            <div class="cleaner">&nbsp;</div>

    </div>

    <hr class="noscreen"/>

    <!-- Footer -->

    <!-- Footer end -->
</div>
<div id="footer">
    <p class="left">&copy; <a class="b" href="#">food voting</a>, 2012.</p>

    <p class="right"><a href="http://www.mantisatemplates.com/">Free web templates</a>, <a
            href="http://csstemplatesfree.net/">Free web templates</a>, tip
        <a class="b" href="http://www.junglegym.cz/uvodni-stranka.aspx"
           title="Dětská hřiště, skluzavky a houpačky Jungle Gym">Dětská Hřiště</a></p>
</div>
</body>
</html>

