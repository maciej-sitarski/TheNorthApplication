<#include "structure.ftlh">

<div class="container-fluid fill" style="background-color: #d1efe7;">
    <div class="row" style="height: 15%">
        <div class="col-lg-12  text-center" style="margin-top: 1%">
            <p id="shopHeading"><strong>${name} ul.${street}   ${town}</strong></p>
        </div>
    </div>
    <#if noData?has_content>
        <div class="row">
            <div class="col-md-12  text-center">
                <p id="shopBody" style="margin-top: 10%">Niestety w naszej bazie nie ma jeszcze informacji o Twoim sklepie :(</p>
                <a href="/shareopinion/${id}" type="button" id="submitFormButton"
                   style="text-decoration: none !important; margin-top: 5%; padding-left: 7%;padding-right: 7%">
                    Lecz wspomóż naszą aplikacje i podziel się opinią!
                </a>
            </div>
        </div>

    <#else >

        <div class="row" style="height: 60%">
            <div class="col-md-6  text-center">
                <p id="shopBody">Procentowa szansa, że utkniesz w kolejce</p>

                <a href="#" type="button" id="submitFormButton"
                   style="text-decoration: none !important; margin-top: 10%; padding-left: 7%;padding-right: 7%">
                    Podziel się aktualnymi informacjami!
                </a>
            </div>
            <div class="col-md-6  text-center">
                <p id="shopBody">Dostepność produktów</p>
                <div>
                    <img src="img/maseczka.png" class="img-fluid " alt="Responsive image"
                         style="max-width: 25%; height: auto;">
                </div>

                <div>
                    <img src="img/rękawiczka.png" class="img-fluid" alt="Responsive image"
                         style="max-width: 25%; height: auto">
                </div>
                <div>
                    <img src="img/żel.png" class="img-fluid" alt="Responsive image"
                         style="max-width: 25%; height: auto">
                </div>
            </div>
        </div>
    </#if>
</div>