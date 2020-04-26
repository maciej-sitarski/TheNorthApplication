<#include "structure.ftlh">

<div class="container-fluid fill" style="background-color: #d1efe7;">
    <div class="row" style="height: 15%">
        <div class="col-1 text-center">
            <div style="font-size: 4vw;margin-top: 8%;">
                <a href="javascript:history.back()"  type="button" > <i class="fas fa-arrow-alt-circle-left" style="color: #60a3bc"></i> </a>
            </div>
        </div>
        <div class="col-11  text-center" >
            <p id="shopHeading" style="margin-top: 1.2%; margin-right: 10%"><strong>${name}  ul.${street}   ${town}</strong></p>
        </div>
    </div>
    <#if noData?has_content>
        <div class="row">
            <div class="col-md-12  text-center">
                <p id="shopBody" style="margin-top: 10%">Niestety w naszej bazie nie ma jeszcze informacji o Twoim
                    sklepie :(</p>
                <input type="hidden" id="idShop" value="${id}">
                <button onclick="goToForm2()" id="submitFormButton"
                   style="text-decoration: none !important; margin-top: 5%; padding-left: 7%;padding-right: 7%">
                    <strong>Wspomóż innych i podziel się informacjami!</strong>
                </button>
            </div>
        </div>

    <#else >

        <div class="row" style="height: 60%; margin-top: 2%">
            <div class="col-md-6  text-center">
                <p id="shopBody">Prawdopodobieństwo utknięcia w kolejce</p>
                <input type="hidden" id="idShop" value="${id}">
                <div id="piechart1" style="margin-top: 7%;width: 100%;height:65%"></div>
                <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                <script src="/js/charts.js"></script>
                <button onclick="goToForm2()"  id="submitFormButton"
                   style="text-decoration: none !important;  padding-left: 7%;padding-right: 7%">
                    Podziel się aktualnymi informacjami!
                </button>
            </div>
            <div class="col-md-6  text-center">
                <p id="shopBody">Dostepność produktów</p>
                <div>
                    <#if mask?has_content>
                        <img src="img/maseczkaTrue.png" class="img-fluid " alt="Responsive image"
                             style="max-width: 20%; height: auto;">
                    <#else >
                        <img src="img/maseczkaFalse.png" class="img-fluid " alt="Responsive image"
                             style="max-width: 20%; height: auto;">
                    </#if>

                </div>

                <div style="margin-top: 5%">
                    <#if gloves?has_content>
                        <img src="img/rekawiczkaTrue.png" class="img-fluid" alt="Responsive image"
                             style="max-width: 20%; height: auto">
                    <#else >
                        <img src="img/rekawiczkaFalse.png" class="img-fluid" alt="Responsive image"
                             style="max-width: 20%; height: auto">
                    </#if>
                </div>

                <div style="margin-top: 5%">
                    <#if gel?has_content>
                    <img src="img/zelTrue.png" class="img-fluid" alt="Responsive image"
                         style="max-width: 20%; height: auto">
                    <#else>
                        <img src="img/zelFalse.png" class="img-fluid" alt="Responsive image"
                             style="max-width: 20%; height: auto">
                    </#if>
                </div>
            </div>
        </div>
    </#if>
</div>
