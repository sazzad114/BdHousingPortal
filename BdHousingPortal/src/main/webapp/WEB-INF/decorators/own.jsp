<%@ taglib prefix="decorator" uri="/SiteMash" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name : Commercial
Description: A two-column, fixed-width design with simple color scheme.
Version : 1.0
Released : 20120520
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>BdHousingPortal</title>
    <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css"/>
    <link href="/BdHousingPortal/resources/css/style.css" rel="stylesheet" type="text/css" media="screen"/>
    <script type="text/javascript" src="/BdHousingPortal/resources/js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="/BdHousingPortal/resources/js/jquery.dropotron-1.0.js"></script>
</head>
<body>
<div id="wrapper">
    <div id="header-wrapper">
        <div id="header">
            <div id="logo">
                <h1><a href="own.jsp#">BD HOUSING PORTAL</a></h1>

                <p>You are one step away from your dream home...</p>
            </div>
        </div>
    </div>
    <!-- end #header -->
    <div id="menu-wrapper">
        <ul id="menu">
            <li class="current_page_item"><a href="/BdHousingPortal/own/home.htm"><span>Home</span></a></li>
            <li><a href="/BdHousingPortal/own/flatownerprofile/view.htm"><span>Profile</span></a></li>
            <li><a href="/BdHousingPortal/own/building/buildinglist.htm"><span>Buildings</span></a></li>
            <li><a href="/BdHousingPortal/own/logout.htm"><span>Logout</span></a></li>
        </ul>
        <script type="text/javascript">
            $('#menu').dropotron();
        </script>
    </div>
    <!-- end #menu -->
    <div id="splash"><img src="/BdHousingPortal/resources/img/pics01.jpg" width="980" height="300" alt=""/></div>
    <div id="page">
        <decorator:body/>
        <!-- end #content -->
        <div id="sidebar-bg">
            <div id="sidebar">
                <ul>
                    <li>
                        <h2>Search for</h2>
                        <ul>
                            <li><a href="/BdHousingPortal/own/customersearch.htm">Flat customers</a></li>
                            <li><a href="/BdHousingPortal/own/flatsearch.htm">Flats</a></li>
                            <li><a href="#">Housing developers</a></li>
                        </ul>
                        <h2>Add new</h2>
                        <ul>
                            <li><a href="/BdHousingPortal/own/building/create.htm">Add new Building</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- end #sidebar -->
        <div style="clear: both;">&nbsp;</div>
    </div>
    <!-- end #page -->
</div>
<div id="footer">
    <p>All rights reserved by BdHousingPortal</p>
</div>
<!-- end #footer -->
</body>
</html>
