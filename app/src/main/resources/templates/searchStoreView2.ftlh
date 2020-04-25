<#include "structure.ftlh">

<div class="container-fluid fill" style="background-color: #d1efe7;">
    <div class="row">
        <div class="col-lg-6 offset-md-3 text-center" style="margin-top: 2%">
            <p id="heading"> Znajdz swój sklep</p>
            <form action="/validationOfShops?city=city&shop=shop"
                  method="get">
                <label id="questions" style="margin-top: 3vw">Wpisz nazwę miasta</label>
                <input type="text"  class="form-control"
                       id="city" name="city"
                       style="height: 2vw; font-size: 1.5vw; color: black; width: 40%;margin-right: auto; margin-left: auto "
                       required
                        <#if city!="empty">
                            value=${city}
                        </#if>
                >

                <label id="questions" style="margin-top: 2vw">Wpisz nazwę sklepu</label>
                <input type="text"  class="form-control"
                       id="shop" name="shop"
                       style="height: 2vw; font-size: 1.5vw; color: black; width: 40%;margin-right: auto; margin-left: auto "
                       required
                        <#if shop!="empty">
                       value=${shop}
                       </#if>
                >
                <button type="submit" id="submitFormButton">
                    <p style="font-family: 'Montserrat', sans-serif; margin-top: 3%"  >
                        <strong>Znajdź sklepy</strong>
                    </p>

                </button>
            </form>
            <label id="questions" style="margin-top: 3vw;">Wybierz konkretny sklep</label>
            <#if listOfStores?has_content>
            <select class="form-control" name="specificStore"
                    style="font-size: 1.5vw; color: black; width: 40%;margin-right: auto; margin-left: auto ">
                <#list listOfStores as store>
                    <option class="option">${store.name}  ${store.street}</option>
                </#list>
            </select>
            <#else>
                <p>Brak wyników dla danego miasta</p>
            </#if>
        </div>
    </div>
</div>