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