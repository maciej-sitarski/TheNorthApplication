<#include "structure.ftlh">

<div class="container-fluid fill" style="background-color: #d1efe7;">
    <div class="row">
        <div class="col-1 text-center">
            <div style="font-size: 4vw;margin-top: 8%;">
                <a href="javascript:history.back()"  type="button" > <i class="fas fa-arrow-alt-circle-left" style="color: #60a3bc"></i> </a>
            </div>
        </div>
        <div class="col-lg-6 offset-md-2 text-center" style="margin-top: 2%">

            <p id="heading"> ZNAJDŹ SWÓJ SKLEP</p> <p id="heading" style="font-size: 1.5vw">(Przeszukujemy najpopularniejsze sieci sklepów) </p>



            <form action="/validationOfShops?city=city&shop=shop"
                  method="get">

                <label id="questions" style="margin-top: 3vw">Wpisz nazwę miasta</label>
                <input type="text"  class="form-control"
                       id="city" name="city"
                       style="height: 2vw; font-size: 1.5vw; color: black; width: 40%;margin-right: auto; margin-left: auto "
                       required>

                <label id="questions" style="margin-top: 2vw">Wpisz nazwę sklepu</label>
                <input type="text"  class="form-control"
                       id="shop" name="shop"
                       style="height: 2vw; font-size: 1.5vw; color: black; width: 40%;margin-right: auto; margin-left: auto "
                       required>
                <button type="submit" id="submitFormButton"  style="padding-left: 10%; padding-right: 10%;">
                        <strong>Znajdź sklepy</strong>
                </button>
            </form>
        </div>
    </div>
</div>