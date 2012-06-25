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
    <style type="text/css">
    span.error {
        color: #D8000C;
        font-size: 12px;
    }
</style>
</head>
<body>
<div id="wrapper">
    <div id="header-wrapper">
        <div id="header">
            <div id="logo">
                <h1><a href="#">BD HOUSING PORTAL</a></h1>

                <p>You are one step away from your dream home...</p>
            </div>
        </div>
    </div>
    <!-- end #header -->
    <div id="menu-wrapper">
        <ul id="menu">
            <li class="current_page_item"><a href="/BdHousingPortal/app/welcome.htm"><span>Home</span></a></li>
            <li><span>Register As</span>
                <ul>
                    <li class="first"><a href="/BdHousingPortal/app/customerreg.htm">Customer</a></li>
                    <li><a href="/BdHousingPortal/app/flatownerreg.htm">Flat owner</a></li>
                    <li class="last"><a href="#">Housing developer</a></li>
                </ul>
            </li>
            <li><a href="#"><span>Contact</span></a></li>
            <li><a href="#"><span>About</span></a></li>
        </ul>
        <script type="text/javascript">
            $('#menu').dropotron();
        </script>
    </div>
    <!-- end #menu -->
    <div id="splash"><img src="/BdHousingPortal/resources/img/pics01.jpg" width="980" height="300" alt=""/></div>
    <div id="page">
        <div id="content">
            <div class="contentbg">


                <div class="post">
                    <h2 class="title">Log In :</h2>
                </div>

                <div class="post">
                    <br/>
                    <fieldset style="width:120px; padding-right:120px;border-color:#dbdada;border-width:1px">

                        <form action="/BdHousingPortal/app/login.htm" method="post">

                            <ul style="list-style-type:none;">
                                <li>
                                    <label>Email : </label>
                                    <input type="text" name="email"/>
                                </li>
                                <li>
                                    <br/>
                                    <label>Password : </label>
                                    <input type="password" name="password"/>
                                </li>
                                <br/>

                                <c:if test="${param['errorcode'] == 1}">
                                    <span class="error"><c:out value="invalid email or password "/></span>
                                </c:if>
                                <li>
                                    <input type="submit" value="Log in"/>
                                </li>

                            </ul>

                        </form>
                    </fieldset>
                </div>

                <div style="clear: both;">&nbsp;</div>
            </div>
        </div>
        <!-- end #content -->
        <div id="sidebar-bg">
            <div id="sidebar">
                <ul>

                    <li>
                        <h2>Search for</h2>
                        <ul>
                            <li><a href="/BdHousingPortal/app/customersearch.htm">Flat customers</a></li>
                            <li><a href="/BdHousingPortal/app/flatsearch.htm">Flats</a></li>
                            <li><a href="#">Housing developers</a></li>
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
