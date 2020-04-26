<#include "structure.ftlh">

<div class="container-fluid fill" style="background-color: #d1efe7;">
    <div class="row" >
        <div class="col-10 offset-1 text-center">
            <form action="/accessibilityinyourarea?isProtectiveGlovesNeeded=isProtectiveGlovesNeeded&isDisinfectantNeeded=isDisinfectantNeeded&isMaskNeeded=isMaskNeeded"
                  method="get">
            <div>
                <p style="margin-top: 5%; font-family: 'Montserrat', sans-serif; font-size: 3vw; color: #35676f">
                    Czego potrzebujesz?
                </p>
            </div>
            <div class="row">
                <div class="col-lg-4 text-center" style="margin-top: 3%">
                    <img src="img/maseczka.png" class="img-fluid" alt="Responsive image">
                    <div class="form-check text-center">
                        <input class=" position-static" name="isMaskNeeded"  type="checkbox"  style="height: 2.5vw; width: 2.5vw; ">
                    </div>
                </div>
                <div class="col-lg-4 text-center" style="margin-top: 4%">
                    <img src="img/rękawiczka.png" class="img-fluid" alt="Responsive image">
                    <div class="form-check text-center ">
                        <input class=" position-static " name="isProtectiveGlovesNeeded" type="checkbox"  style="height: 2.5vw; width: 2.5vw; margin-top: 3%">
                    </div>
                </div>
                <div class="col-lg-4 text-center" style="margin-top: 3%">
                    <img src="img/żel.png" class="img-fluid" alt="Responsive image">
                    <div class="checkbox checkbox-circle checkbox-red ">
                        <input  class=" position-static " name="isDisinfectantNeeded" type="checkbox"  style="height: 2.5vw; width: 2.5vw; ">
                    </div>
                </div>
            </div>
            <button  id="submitFormButton" type="submit"  style="text-decoration: none !important; margin-top: 5%; padding-left: 15%; padding-right: 15%">
                <p style="font-family: 'Montserrat', sans-serif; margin-top: 10%">
                    <strong>Dalej</strong>
                </p>
            </button>
            </form>
        </div>
    </div>
</div>