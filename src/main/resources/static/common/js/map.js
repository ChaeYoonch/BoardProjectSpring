const mapLib = {
    /**
     * 지도 로드
     * @param mapId : 지도를_출력할_요소_Id_이름
     * @param width : 지도_너비
     * @param height : 지도_높이
     * @param options : 옵션 / center : { lat: 위도, lng: 경도 ... } - 필수 | zoom : 확대 정도 (1~10) -> 숫자가 작을수록 확대
     */
     load(mapId, width= 300, height= 300, options) {
            const mapEl = document.getElementById(mapId);
            if (!mapEl || !options?.center) return;

            mapEl.style.width = `${width}px`;
            mapEl.style.height = `${height}px`;

        /* 지도 가운데 좌표 처리 S */
        const { center } = options;
        const zoom = options?.zoom ?? 3; // 기본값 = 3 | optional chaing 옵셔널 체이닝 연산자
        const position = new kakao.maps.LatLng(center.lat, center.lng); // 위도, 경도 값 설정
        const map = new kakao.maps.Map(mapEl, {
            center: position,
            level: zoom,
        });
        /* 지도 가운데 좌표 처리 E */
     }
};