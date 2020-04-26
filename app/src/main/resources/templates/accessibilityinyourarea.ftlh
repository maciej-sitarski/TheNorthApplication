<#include "structure.ftlh">
<#--<div class="container-fluid" style="background-color: #d7fbf1">-->
<#--    <div class="row" >-->
<#--        <div style="font-size: 4vw; margin-left: auto; margin-right: auto">-->
<#--            <a href="javascript:history.back()"  type="button" > <i class="fas fa-arrow-alt-circle-left" style="color: #60a3bc"></i> </a>-->
<#--        </div>-->
<#--    </div>-->
<#--</div>-->

<div id="map"></div>
<script src="./js/accessibilityinyourarea.js"></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyByf6Wfz_btg3iIOcdwav_UCOJGucPln4g&callback=initMap"></script>
<input id="isProtectiveGlovesNeeded" name="isProtectiveGlovesNeeded" type="hidden" value="${isProtectiveGlovesNeeded?c}">
<input id="isDisinfectantNeeded" name="isDisinfectantNeeded" type="hidden" value="${isDisinfectantNeeded?c}">
<input id="isMaskNeeded" name="isMaskNeeded" type="hidden" value="${isMaskNeeded?c}">
