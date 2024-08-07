window.addEventListener("DOMContentLoaded", function() {
    const options = { // 실제 option 객체의 구조
        center: {
            lat: 37.557756188912954,
            lng: 126.94062742683245,
        }
    };

    mapLib.load("map1", 300, 300, options);
    mapLib.load("map2", 400, 400, options);
    mapLib.load("map3", 500, 500, options);
});