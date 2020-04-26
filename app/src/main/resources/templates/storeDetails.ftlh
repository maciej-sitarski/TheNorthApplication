<#include "structure.ftlh">

<div class="container-fluid fill" style="background-color: #d1efe7;">
    <div class="row" style="height: 15%">
        <div class="col-1 text-center">
            <div style="font-size: 4vw;margin-top: 8%;">
                <a href="javascript:history.back()" type="button"> <i class="fas fa-arrow-alt-circle-left"
                                                                      style="color: #60a3bc"></i> </a>
            </div>
        </div>
        <div class="col-11  text-center">
            <p id="shopHeading" style="margin-top: 1.2%; margin-right: 10%"><strong>${name}
                    ul.${street}   ${town}</strong></p>
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
    <div class="row">
        <div class="col-10 offset-1">
            <div class="row" style="height: 60%; margin-top: 2%">
                <div class="col-md-6  text-center">
                    <p id="shopBody">Prawdopodobieństwo utknięcia w kolejce</p>
                    <input type="hidden" id="idShop" value="${id}">
                    <div id="piechart1" style="margin-top: 7%;width: 100%;height:58%"></div>
                    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                    <script src="/js/charts.js"></script>
                    <button onclick="goToForm2()" id="submitFormButton"
                            style="text-decoration: none !important;  padding-left: 7%;padding-right: 7%; margin-top: 4%;width: 80%; ">
                        Podziel się aktualnymi informacjami!
                    </button>
                </div>
                <div class="col-md-6  text-center">
                    <p id="shopBody" style="margin: 0">Dostepność produktów</p>
                    <p id="shopBody" style="font-size: 1.5vw; margin: 0 0 5% 0">(Podane ceny są orientacyjne)</p>
                    <div style="display: inline;">
                        <#if mask?has_content>
                            <img src="img/maseczkaTrue.png" class="img-fluid " alt="Responsive image"
                                 style="max-width: 25%; height: auto; display: inline-block">
                        <#else >
                            <img src="img/maseczkaFalse.png" class="img-fluid " alt="Responsive image"
                                 style="max-width: 25%; height: auto; display: inline-block">
                        </#if>
                        <p id="questions" style="display: inline-block; font-size: 1vw">
                            Cena(za jedną maseczkę):
                        </p>
                        <#if maskPrice?has_content>
                            <p id="questions" style="display: inline-block; font-size: 1vw"> ${maskPrice} zł
                            </p>
                        <#else>
                            <p id="questions" style="display: inline-block; font-size: 1vw"> Brak danych
                            </p>
                        </#if>

                    </div>
                    <div style="margin-top: 5%;"></div>
                    <div style=" display: inline;">
                        <#if gloves?has_content>
                            <img src="img/rekawiczkaTrue.png" class="img-fluid" alt="Responsive image"
                                 style="max-width: 25%; height: auto; display: inline-block">
                        <#else >
                            <img src="img/rekawiczkaFalse.png" class="img-fluid" alt="Responsive image"
                                 style="max-width: 25%; height: auto; display: inline-block">
                        </#if>
                        <p id="questions" style="display: inline-block; font-size: 1vw">
                            Cena(za jedną parę rękawiczek):
                        </p>
                        <#if glovesPrice?has_content>
                            <p id="questions" style="display: inline-block; font-size: 1vw"> ${glovesPrice} zł
                            </p>
                        <#else>
                            <p id="questions" style="display: inline-block; font-size: 1vw"> Brak danych
                            </p>
                        </#if>
                    </div>
                    <div style="margin-top: 5%"></div>

                    <div style=" display: inline;">
                        <#if gel?has_content>
                            <img src="img/zelTrue.png" class="img-fluid" alt="Responsive image"
                                 style="max-width: 25%; height: auto; display: inline-block">
                        <#else>
                            <img src="img/zelFalse.png" class="img-fluid" alt="Responsive image"
                                 style="max-width: 25%; height: auto; display: inline-block">
                        </#if>
                        <p id="questions" style="display: inline-block; font-size: 1vw">
                            Cena(za 100ml płynu):
                        </p>
                        <#if gelPrice?has_content>
                            <p id="questions" style="display: inline-block; font-size: 1vw"> ${gelPrice} zł
                            </p>
                        <#else>
                            <p id="questions" style="display: inline-block; font-size: 1vw"> Brak danych
                            </p>
                        </#if>
                    </div>
                </div>
            </div>
            </#if>
        </div>
    </div>
</div>
