<#include "structure.ftlh">
<div id="map"></div>
<script src="./js/accessibilityinyourarea.js"></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyByf6Wfz_btg3iIOcdwav_UCOJGucPln4g&callback=initMap"></script>
<input id="isProtectiveGlovesNeeded" name="isProtectiveGlovesNeeded" type="hidden" value="${isProtectiveGlovesNeeded?c}">
<input id="isDisinfectantNeeded" name="isDisinfectantNeeded" type="hidden" value="${isDisinfectantNeeded?c}">
<input id="isMaskNeeded" name="isMaskNeeded" type="hidden" value="${isMaskNeeded?c}">
