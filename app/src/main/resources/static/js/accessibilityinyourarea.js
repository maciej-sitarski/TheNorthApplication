var map, infoWindow;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 55.257532, lng: 18.993839},
        zoom: 19
    });
    infoWindow = new google.maps.InfoWindow;

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

            infoWindow.setPosition(pos);
            infoWindow.setContent('Location found.');
            infoWindow.open(map);
            map.setCenter(pos);

            drawMarkers(position.coords.latitude, position.coords.longitude);

        }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        handleLocationError(false, infoWindow, map.getCenter());
    }
}
function drawMarkers(positionLat, positionLng) {
    console.log('/rest/api/nearbyshops?lat=' + positionLat.toString() + '&lon=' + positionLng.toString() + '&radius=10000');
    $.getJSON('/rest/api/nearbyshops?lat=' + positionLat.toString() + '&lon=' + positionLng.toString() + '&radius=10000', function (dataset1) {

        for (var i = 0; i < dataset1.length; i++) {
            var store = dataset1[i];

            console.log(store);

            var id = store.id;
            var name = store.name;
            var street = store.street;
            var town = store.town;
            var country = store.country;
            var lat = store.lat;
            var lng = store.lng;

            console.log(store);

            var markerCoordinates = {lat: +lat, lng: +lng};
            var marker = new google.maps.Marker({position: markerCoordinates, map: map});
        }
    });
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
        'Error: The Geolocation service failed.' :
        'Error: Your browser doesn\'t support geolocation.');
    infoWindow.open(map);
}
