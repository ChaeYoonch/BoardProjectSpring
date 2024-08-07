const mapLib = {
    /**
     * 지도 로드
     * @param mapId : 지도를_출력할_요소_Id_이름
     * @param width : 지도_너비
     * @param height : 지도_높이
     * @param options : 옵션
     *                 - center : { lat: 위도, lng: 경도 } - 필수
     *                 - zoom : 확대 정도 (1~10) -> 숫자가 작을수록 확대
     *                 - markerImage : 공통 마커 이미지 주소, 개별 마커 이미지가 있는 경우 그것으로 대체함
     *                 - marker : [{ lat: 위도, lng: 경도, info: html 데이터 (인포윈도우로 출력), image: 이미지 주소 - 마커 이미지 }]
     */
     load(mapId, width= 300, height= 300, options) {
            const mapEl = document.getElementById(mapId);
            if (!mapEl || !options?.center) return;

            mapEl.style.width = `${width}px`;
            mapEl.style.height = `${height}px`;

        let { center, marker, markerImage } = options;

        /* 지도 가운데 좌표 처리 S */
        const zoom = options?.zoom ?? 3; // 기본값 = 3 | optional chaing 옵셔널 체이닝 연산자
        const position = new kakao.maps.LatLng(center.lat, center.lng); // 위도, 경도 값 설정
        const map = new kakao.maps.Map(mapEl, {
            center: position, // 가운데 좌표 설정
            level: zoom, // 확대 레벨 -> 숫자가 작을수록 가까이 보임
        });
        /* 지도 가운데 좌표 처리 E */

        /* 마커 출력 처리 S */
        if (marker) {
            if(!Array.isArray(marker)) marker = [marker];

            const markers = marker.map(m => {
                const _marker = new kakao.maps.Marker({
                    position: new kakao.maps.LatLng(m.lat, m.lng),
                });

                _marker.setMap(map);

                return _marker;
            });
        } // endif
        /* 마커 출력 처리 E */
     }
};