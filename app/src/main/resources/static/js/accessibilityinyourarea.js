var map;
var infoWindow;
var isProtectiveGlovesNeeded;
var isDisinfectantNeeded;
var isMaskNeeded;
var InforObj = [];
var stores = [];

function initMap() {
    isProtectiveGlovesNeeded = document.getElementById('isProtectiveGlovesNeeded').value;
    isDisinfectantNeeded = document.getElementById('isDisinfectantNeeded').value;
    isMaskNeeded = document.getElementById('isMaskNeeded').value;

    console.log(isProtectiveGlovesNeeded);
    console.log(isDisinfectantNeeded);
    console.log(isMaskNeeded);

    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 55.257532, lng: 18.993839},
        zoom: 15
    });

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

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
    console.log('/rest/api/nearbyshops?lat=' + positionLat.toString() + '&lng=' + positionLng.toString() + '&radius=2000');
    $.getJSON('/rest/api/nearbyshops?lat=' + positionLat.toString() + '&lng=' + positionLng.toString() + '&radius=2000', function (dataset1) {
        for (var i = 0; i < dataset1.length; i++) {
            const store = dataset1[i];
            stores.push(store);

            const id = stores[i].id;
            const name = stores[i].name;
            const street = stores[i].street;
            const town = stores[i].town;
            const country = stores[i].country;
            const lat = stores[i].lat;
            const lng = stores[i].lng;

            console.log(store);

            const markerCoordinates = {lat: +lat, lng: +lng};

            const statStoreFromDatabase = stores[i].storeEntityDto;
            console.log(statStoreFromDatabase);

            let iconPath;
            if(statStoreFromDatabase.availabilityDto===null){
                iconPath = 'http://maps.google.com/mapfiles/ms/icons/red-dot.png';
            } else if((statStoreFromDatabase.availabilityDto.maskAvailability===isMaskNeeded || statStoreFromDatabase.availabilityDto.maskAvailability===true) &&
                      (statStoreFromDatabase.availabilityDto.glovesAvailability===isProtectiveGlovesNeeded || statStoreFromDatabase.availabilityDto.maskAvailability===true) &&
                      (statStoreFromDatabase.availabilityDto.gelAvailability===isDisinfectantNeeded || statStoreFromDatabase.availabilityDto.maskAvailability===true)) {
               iconPath = 'http://maps.google.com/mapfiles/ms/icons/green-dot.png';
            } else {
               iconPath = 'http://maps.google.com/mapfiles/ms/icons/red-dot.png';
            }
            const marker = new google.maps.Marker({position: markerCoordinates,title: stores[i].name, map: map});
            marker.setIcon(iconPath);

            let maskAvailability, gelAvailability, glovesAvailability;
            let maskPrize, gelPrize, glovesPrize;

            if(statStoreFromDatabase.availabilityDto !== null) {

                if (statStoreFromDatabase.availabilityDto.maskAvailability === undefined || statStoreFromDatabase.availabilityDto.maskAvailability === false) {
                    maskAvailability="/img/maseczkaFalse.png";
                } else {
                    maskAvailability="/img/maseczkaTrue.png";
                }

                if (statStoreFromDatabase.availabilityDto.gelAvailability === undefined || statStoreFromDatabase.availabilityDto.gelAvailability === false) {
                    gelAvailability="/img/zelFalse.png";
                } else {
                    gelAvailability="/img/zelTrue.png";
                }

                if (statStoreFromDatabase.availabilityDto.glovesAvailability === undefined || statStoreFromDatabase.availabilityDto.glovesAvailability === false) {
                    glovesAvailability="/img/rekawiczkaFalse.png";
                } else {
                    glovesAvailability="/img/rekawiczkaTrue.png";
                }
            } else {
                maskPrize = '?';
                gelPrize = '?';
                glovesPrize = '?';
                maskAvailability = "/img/maseczkaFalse.png";
                gelAvailability = "/img/zelFalse.png";
                glovesAvailability = "/img/rekawiczkaFalse.png";
            }

            const contentString = '<div id="content" class="text-center" style="height: 230px; width: 300px; background-color: #d1efe7">'+
                '<div id="siteNotice">'+
                '</div>'+
                '<h3 id="firstHeading" class="firstHeading" style="font-family: Montserrat">' + stores[i].name + '</h3>'+
                '<div id="bodyContent">'+
                '<p style="display: inline;margin-right: 20px;"><img src='+maskAvailability+' alt="Dostępnosc maseczek" height="80" width="80"></p>'+
                '<p style="display: inline;margin-right: 20px;"><img src='+gelAvailability+' alt="Dostępnosc plynu dezynfekujacego" height="80" width="80"></p>'+
                '<p style="display: inline-block;"><img src='+glovesAvailability+' alt="Dostępnosc rekawiczek" height="80" width="80"></p>'+
                '<p style="display: inline;margin-right: 20px;">'+maskPrize+' zł'+'</p>'+
                '<p style="display: inline;margin-right: 20px;">'+gelPrize+' zł'+'</p>'+
                '<p style="display: inline-block;">'+glovesPrize+' zł'+'</p>'+

                '<a class="btn btn-info d-block mb-1" href="/shareopinion?id='+stores[i].id+'">'+
                'Podziel się opinią :)</a> '+
                '<a class="btn btn-primary d-block" href="/storeDetails?id='+stores[i].id+ '&name='+ name+'&street='+ street+'&town='+ town +'">'+
                'Przejdz do sklepu</a> '+
                '</div>'+
                '</div>';

            const infowindow = new google.maps.InfoWindow({
                content: contentString,


            });

            marker.addListener('click', function () {
                closeOtherInfo();
                infowindow.open(marker.get('map'), marker);
                InforObj[0] = infowindow;
            });
        }
    });
}

function closeOtherInfo() {
    if (InforObj.length > 0) {
        InforObj[0].set("marker", null);
        InforObj[0].close();
        InforObj.length = 0;
    }
}
