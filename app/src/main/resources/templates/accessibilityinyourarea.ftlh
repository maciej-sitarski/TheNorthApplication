<#include "structure.ftlh">



<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
<#--    <title>Geolocation</title>-->
<#--    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">-->
<#--    <meta charset="utf-8">-->
<#--    <link rel="stylesheet" type="text/css" href="./css/accessibilityinyourarea.css">-->
<#--    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">-->
<#--    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>-->
<#--    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>-->
<#--</head>-->
<#--<body>-->
<div id="map"></div>
<script src="./js/accessibilityinyourarea.js"></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyByf6Wfz_btg3iIOcdwav_UCOJGucPln4g&callback=initMap"></script>
<input id="isProtectiveGlovesNeeded" name="isProtectiveGlovesNeeded" type="hidden" value="${isProtectiveGlovesNeeded?c}">
<input id="isDisinfectantNeeded" name="isDisinfectantNeeded" type="hidden" value="${isDisinfectantNeeded?c}">
<input id="isMaskNeeded" name="isMaskNeeded" type="hidden" value="${isMaskNeeded?c}">
<#--</body>-->
<#--</html>-->
