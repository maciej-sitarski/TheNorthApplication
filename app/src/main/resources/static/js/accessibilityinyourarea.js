var map;
var infoWindow;
var isProtectiveGlovesNeeded;
var isDisinfectantNeeded;
var isMaskNeeded;

function initMap() {
    isProtectiveGlovesNeeded = document.getElementById('isProtectiveGlovesNeeded').value;
    isDisinfectantNeeded = document.getElementById('isDisinfectantNeeded').value;
    isMaskNeeded = document.getElementById('isMaskNeeded').value;

    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 55.257532, lng: 18.993839},
        zoom: 50
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
    console.log('/rest/api/nearbyshops?lat=' + positionLat.toString() + '&lng=' + positionLng.toString() + '&radius=5000');
    $.getJSON('/rest/api/nearbyshops?lat=' + positionLat.toString() + '&lng=' + positionLng.toString() + '&radius=5000', function (dataset1) {

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

            var statStoreFromDatabase = getStoreInfoById(id);

            var iconPath;
            if(statStoreFromDatabase===undefined){
                iconPath = 'http://maps.google.com/mapfiles/ms/icons/red-dot.png';
            } else if(statStoreFromDatabase.availabilityDto.maskAvailability===isMaskNeeded &&
               statStoreFromDatabase.availabilityDto.glovesAvailability===isProtectiveGlovesNeeded &&
               statStoreFromDatabase.availabilityDto.gelAvailability===isDisinfectantNeeded) {
               iconPath = 'http://maps.google.com/mapfiles/ms/icons/green-dot.png';
            } else {
               iconPath = 'http://maps.google.com/mapfiles/ms/icons/red-dot.png';
            }
            var marker = new google.maps.Marker({position: markerCoordinates,map: map});
            marker.setIcon(iconPath);
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

function getStoreInfoById(id) {
    var store;
    $.getJSON('/rest/api/store/' + id, function (data) {
        return data;
    });
}
