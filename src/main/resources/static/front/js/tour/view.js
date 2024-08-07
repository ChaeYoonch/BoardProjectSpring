const items = [
    [126.94062742683245, 37.557756188912954], // 경도, 위도
    [126.94120499658828, 37.557287959390024]
];

window.addEventListener("DOMContentLoaded", function() {
    const mapEl = document.getElementById("map");
    mapEl.style.width = "1000px";
    mapEl.style.height = "600px";

    const map = new kakao.maps.Map(mapEl, {
        center: new kakao.maps.LatLng(items[0][1], items[0][0]),
        level: 3,
    }); // map 객체 생성
    const markers = items.map(pos => new kakao.maps.LatLng(pos[1], pos[0]));

    markers.forEach(marker => marker.setMap(map));

    /*
    let map;

    navigator.geolocation.getCurrentPosition((pos) => {
        const { latitude, longitude } = pos.coords;

        const mapOption = {
            center: new kakao.maps.LatLng(latitude, longitude),
            level: 3,
        };

        map = new kakao.maps.Map(mapEl, mapOption);

        const makerPos = new kakao.maps.LatLng(latitude, longitude); // 좌표 **
        const marker = new kakao.maps.Marker({
            position: makerPos
        });

        marker.setMap(map); // 마커 표기 -> IP 기반이므로 정확하지는 않음
        mapProcess(map);
    });

    function  mapProcess(map) {
        // 지도 클릭 시 좌표 정보
        kakao.maps.event.addListener(map, 'click', function (e) { // ** 객체 만든 것!
            const latLnt = e.latLnt;
            const marker = new kakao.maps.Marker({
                position: latLng
            });

            marker.setMap(map);
        });
    } */
});