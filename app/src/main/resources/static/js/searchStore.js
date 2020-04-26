$(function() {
    $("#city").autocomplete({
        source: "city",
        minLength: 2,
    });
});

$(function() {
    $("#shop").autocomplete({
        source: "shop",
        minLength: 2,
    });
});

function goToShop(){
    let String = $("#specificShop").val();
    let array = String.split(';');
    let id = array[0];
    let name = array[1];
    let street = array[2];
    let town = array[3];
    window.location = '/storeDetails?id='+id+'&name='+name+'&street='+street+'&town='+town

}

function goToForm(){
    let String = $("#specificShop").val();
    let array = String.split(';');
    let id = array[0];
    window.location = '/shareopinion/'+id

}
