<#include "structure.ftlh">

<div class="container-fluid fill" style="background-color: #d1efe7">
    <div class="row">
        <div class="col-1 text-center">
            <div style="font-size: 4vw;margin-top: 8%;">
                <a href="javascript:history.back()"  type="button" > <i class="fas fa-arrow-alt-circle-left" style="color: #60a3bc"></i> </a>
            </div>
        </div>
        <div class="col-lg-10 text-center" >
            <form action="/shareopinionsucces"
                  method="get">
                <p id="heading">
                    PODZIEL SIĘ SWOJĄ OPINIĄ
                </p>
                <div class="row">
                    <div class="col-lg-7 text-center">
                        <p id="questions" style="margin-top: 3%">
                            Czy stałeś w kolejce przed sklepem?
                        </p>
                        <input type="hidden" value="${id}" name="id">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio"  name="queueTrue" id="exampleRadios1" value="true" style=" height: 2vw; width: 2vw;">
                            <label class="form-check-label" for="exampleRadios1">
                                <div style="font-size: 3.5vw;margin-left: 20%">
                                    <i class="far fa-thumbs-up" style="color: #54ab5e; margin-bottom: 50%"></i>
                                </div>
                            </label>
                        </div>
                        <div class="form-check form-check-inline" style="margin-left: 10%">
                            <input class="form-check-input" type="radio"  name="queueTrue" id="exampleRadios2" value="false" style=" height: 2vw; width: 2vw;">
                            <label class="form-check-label" for="exampleRadios2">
                                <div style="font-size: 3.5vw; margin-left: 20%">
                                    <i class="far fa-thumbs-down" style="color: #f25353; margin-top: 50%"></i>
                                </div>
                            </label>
                        </div>

                        <p id="questions" style="margin-top: 2%">
                            Czy w sklepie były dostepne maseczki?
                        </p>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio"  name="maskTrue" id="exampleRadios3" value="true" style=" height: 2vw; width: 2vw;">
                            <label class="form-check-label" for="exampleRadios3">
                                <div style="font-size: 3.5vw;margin-left: 20%">
                                    <i class="far fa-thumbs-up" style="color: #54ab5e; margin-bottom: 50%"></i>
                                </div>
                            </label>
                        </div>
                        <div class="form-check form-check-inline" style="margin-left: 10%">
                            <input class="form-check-input" type="radio"  name="maskTrue" id="exampleRadios4" value="false" style=" height: 2vw; width: 2vw;">
                            <label class="form-check-label" for="exampleRadios4">
                                <div style="font-size: 3.5vw; margin-left: 20%">
                                    <i class="far fa-thumbs-down" style="color: #f25353; margin-top: 50%"></i>
                                </div>
                            </label>
                        </div>

                        <p id="questions" style="margin-top: 2%">
                            Czy w sklepie były dostępne rękawiczki ochronne?
                        </p>

                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio"  name="glovesTrue" id="exampleRadios5" value="true" style=" height: 2vw; width: 2vw;">
                            <label class="form-check-label" for="exampleRadios5">
                                <div style="font-size: 3.5vw;margin-left: 20%">
                                    <i class="far fa-thumbs-up" style="color: #54ab5e; margin-bottom: 50%"></i>
                                </div>
                            </label>
                        </div>
                        <div class="form-check form-check-inline" style="margin-left: 10%">
                            <input class="form-check-input" type="radio"  name="glovesTrue" id="exampleRadios6" value="false" style=" height: 2vw; width: 2vw;">
                            <label class="form-check-label" for="exampleRadios6">
                                <div style="font-size: 3.5vw; margin-left: 20%">
                                    <i class="far fa-thumbs-down" style="color: #f25353; margin-top: 50%"></i>
                                </div>
                            </label>
                        </div>

                        <p id="questions" style="margin-top: 2%">
                            Czy w sklepie były dostepne żele antybakteryjne?
                        </p>

                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio"  name="gelTrue" id="exampleRadios7" value="true" style=" height: 2vw; width: 2vw;">
                            <label class="form-check-label" for="exampleRadios7">
                                <div style="font-size: 3.5vw;margin-left: 20%">
                                    <i class="far fa-thumbs-up" style="color: #54ab5e; margin-bottom: 50%"></i>
                                </div>
                            </label>
                        </div>
                        <div class="form-check form-check-inline" style="margin-left: 10%">
                            <input class="form-check-input" type="radio"  name="gelTrue" id="exampleRadios4" value="false" style=" height: 2vw; width: 2vw;">
                            <label class="form-check-label" for="exampleRadios8">
                                <div style="font-size: 3.5vw; margin-left: 20%">
                                    <i class="far fa-thumbs-down" style="color: #f25353; margin-top: 50%"></i>
                                </div>
                            </label>
                        </div>

                    </div>
                    <div class="col-lg-5 text-center">
                        <p id="questions" style="margin-top: 5%; font-size: 2vw; margin-bottom: 10%">
                            Jakie były ceny w sklepie? (opcjonalne)
                        </p>

                        <label>
                            <p id="questions">
                                Maseczka (1 sztuka, zł)
                            </p>
                        </label>
                        <input type="text"  class="form-control" name="maskPrice" style="margin-left:auto; margin-bottom: 10%;
                        margin-right:auto; height: 2vw; font-size: 1.2vw; color: black; width: 15%">

                        <label>
                            <p id="questions">
                                Rękawiczki (1 para, zł)
                            </p>
                        </label>
                        <input type="text"  class="form-control" name="glovesPrice" style="margin-left:auto; margin-bottom: 10%;
                        margin-right:auto; height: 2vw; font-size: 1.2vw; color: black; width: 15%">

                        <label>
                            <p id="questions">
                                Płyn antybakteryjny (100ml, zł)
                            </p>
                        </label>
                        <input type="text"  class="form-control" name="gelPrice" style="margin-left:auto;
                        margin-right:auto; height: 2vw; font-size: 1.2vw; color: black; width: 15%">
                    </div>
                </div>
                <div>
                    <button type="submit" id="submitFormButton" style="padding-left: 10%;padding-right: 10%">
                        <strong>Zakończ ankietę</strong>
                    </button>
                </div>

            </form>
        </div>
    </div>
</div>
