// Map initialize

var map = L.map( 'map', {
    center: [56.0, 17.0],
    minZoom: 2,
    zoom: 6
});

L.tileLayer( 'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.github.com/imaginalis">@imaginalis</a>',
    subdomains: ['a','b','c']
}).addTo( map );
var controlLoader = L.control.loader().addTo(map);
