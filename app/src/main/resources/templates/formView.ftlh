<#include "structure.ftlh">

<div class="container-fluid fill" style="background-color: #d1efe7">
    <div class="row">
        <div class="col-lg-8 offset-md-2 text-center" style="margin-top: 2%">
            <form>
                <p id="heading">
                    <strong>Podziel się swoją opinią</strong>
                </p>


                <p id="questions" style="margin-top: 3%">
                    Czy stałeś w kolejce przed sklepem?
                </p>

                <#--                <i class="far fa-thumbs-up"></i>-->
                <#--                <i class="far fa-thumbs-down"></i>-->


                <#--                <div class="btn-group" data-toggle="buttons">-->
                <#--                    <label class="btn btn-cyan btn-rounded form-check-label waves-effect waves-light active">-->
                <#--                        <input class="form-check-input" type="radio" checked autocomplete="off">-->
                <#--                        <i class="far fa-thumbs-up"></i>-->
                <#--                    </label>-->

                <#--                    <label class="btn btn-cyan btn-rounded form-check-label">-->
                <#--                        <input class="form-check-input" type="radio" autocomplete="off">-->
                <#--                        <i class="far fa-thumbs-down"></i>-->
                <#--                    </label>-->
                <#--                </div>-->
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio"  name="inlineRadioOptions" id="exampleRadios1" value="option1" style=" height: 2vw; width: 2vw;">
                    <label class="form-check-label" for="exampleRadios1">
                        <div style="font-size: 4vw;margin-left: 20%">
                            <i class="far fa-thumbs-up" style="color: darkgreen"></i>
                        </div>
                    </label>
                </div>
                <div class="form-check form-check-inline" style="margin-left: 20%">
                    <input class="form-check-input" type="radio"  name="inlineRadioOptions" id="exampleRadios2" value="option2" style=" height: 2vw; width: 2vw;">
                    <label class="form-check-label" for="exampleRadios2">
                        <div style="font-size: 4vw; margin-left: 20%">
                        <i class="far fa-thumbs-down" style="color: red"></i>
                        </div>
                    </label>
                </div>

                <p id="questions">
                    Czy w sklepie były dostepne maseczki?
                </p>

                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio"  name="inlineRadioOptions2" id="exampleRadios3" value="option1" style=" height: 2vw; width: 2vw;">
                    <label class="form-check-label" for="exampleRadios3">
                        <div style="font-size: 4vw;margin-left: 20%">
                            <i class="far fa-thumbs-up" style="color: darkgreen"></i>
                        </div>
                    </label>
                </div>
                <div class="form-check form-check-inline" style="margin-left: 20%">
                    <input class="form-check-input" type="radio"  name="inlineRadioOptions2" id="exampleRadios4" value="option2" style=" height: 2vw; width: 2vw;">
                    <label class="form-check-label" for="exampleRadios4">
                        <div style="font-size: 4vw; margin-left: 20%">
                            <i class="far fa-thumbs-down" style="color: red"></i>
                        </div>
                    </label>
                </div>

                <p id="questions">
                    Czy w sklepie były dostępne rękawiczki ochronne?
                </p>

                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio"  name="inlineRadioOptions3" id="exampleRadios5" value="option1" style=" height: 2vw; width: 2vw;">
                    <label class="form-check-label" for="exampleRadios5">
                        <div style="font-size: 4vw;margin-left: 20%">
                            <i class="far fa-thumbs-up" style="color: darkgreen"></i>
                        </div>
                    </label>
                </div>
                <div class="form-check form-check-inline" style="margin-left: 20%">
                    <input class="form-check-input" type="radio"  name="inlineRadioOptions3" id="exampleRadios6" value="option2" style=" height: 2vw; width: 2vw;">
                    <label class="form-check-label" for="exampleRadios6">
                        <div style="font-size: 4vw; margin-left: 20%">
                            <i class="far fa-thumbs-down" style="color: red"></i>
                        </div>
                    </label>
                </div>

                <p id="questions">
                    Czy w sklepie były dostepne żele antybakteryjne?
                </p>

                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio"  name="inlineRadioOptions4" id="exampleRadios7" value="option1" style=" height: 2vw; width: 2vw;">
                    <label class="form-check-label" for="exampleRadios7">
                        <div style="font-size: 4vw;margin-left: 20%">
                            <i class="far fa-thumbs-up" style="color: darkgreen"></i>
                        </div>
                    </label>
                </div>
                <div class="form-check form-check-inline" style="margin-left: 20%">
                    <input class="form-check-input" type="radio"  name="inlineRadioOptions4" id="exampleRadios4" value="option2" style=" height: 2vw; width: 2vw;">
                    <label class="form-check-label" for="exampleRadios8">
                        <div style="font-size: 4vw; margin-left: 20%">
                            <i class="far fa-thumbs-down" style="color: red"></i>
                        </div>
                    </label>
                </div>
                <div>
                    <button type="submit" id="submitFormButton">
                        <p style="font-family: 'Montserrat', sans-serif; margin-top: 5%" >
                            <strong>Zakończ ankietę</strong>
                        </p>
                    </button>
                </div>


            </form>
        </div>
    </div>
</div>