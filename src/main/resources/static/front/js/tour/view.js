window.addEventListener("DOMContentLoaded", function() {
    const mapEl = document.getElementById("map");
    mapEl.style.width = "1000px";
    mapEl.style.height = "600px";

    let map;

    navigator.geolocation.getCurrentPosition((pos) => {
        const { latitude, longitude } = pos.coords;

        const mapOption = {
            center: new kakao.maps.LatLng(latitude, longitude),
            level: 3,
        };

        map = new kakao.maps.Map(mapEl, mapOption); // map 객체 생성

        const markerPos = new kakao.maps.LatLng(latitude, longitude); // 좌표
        const marker = new kakao.maps.Marker({
            position: markerPos
        });

        marker.setMap(map); // 마커 표기 -> IP 기반이므로 정확하지는 않음
    });

    // 지도 클릭 시 좌표 정보
    if (map) {
        kakao.maps.event.addListener(map, 'click', function (e) {

        });
    }
});