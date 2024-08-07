const mapLib = {
    /**
     * 지도 로드
     * @param mapId : 지도를_출력할_요소_Id_이름
     * @param width : 지도_너비
     * @param height : 지도_높이
     * @param options : 옵션 / center: { lat: 위도, lng: 경도 ... } - 필수
     */
     load(mapId, width= 300, height= 300, options) {
            const mapEl = document.getElementById(mapId);
            if (!mapEl || !options?.center) return;

            mapEl.style.width = `${width}px`;
            mapEl.style.height = `${height}px`;

            // 지도 가운데 좌표 처리
     }
};