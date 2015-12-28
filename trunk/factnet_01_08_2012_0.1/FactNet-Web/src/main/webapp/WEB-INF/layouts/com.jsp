<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="/WEB-INF/struts-tiles"  %>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- link rel="shortcut icon" href="images/favicon.gif" type="image/x-icon"  /-->
    <link rel="stylesheet" media="screen" href="css/reset.css" type="text/css"> 
    <link rel="stylesheet" media="screen" href="css/style_fact_com.css" type="text/css"> 
    <link rel="stylesheet" media="all" href="css/shadowbox/shadowbox.css" /> 
    <script type="text/javascript" src="javascript/script.js"></script>
    <script type="text/javascript" src="javascript/shadowbox/shadowbox.js"></script>
    <script type="text/javascript" src="javascript/jquery-1.8.1.min.js"></script>
    <script type="text/javascript">
    	Shadowbox.init();
    </script>
    <title>FACT Net Informatica</title>
</head>

<body>
    <div id="all">
    <div id="header">
        <tiles:insert attribute="util" ignore="true"/>
        <tiles:insert attribute="header"/>
    </div>
    <div id="promo">
        <tiles:insert attribute="promo"/>
    </div>
    <div id="content">
        <tiles:insert attribute="body"/>
    </div>
    <div id="footer">
        <tiles:insert attribute="footer"/>
    </div>
    </div>

</body>
</html>