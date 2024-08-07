const mapLib = {
    /**
     * 지도 로드
     * @param mapId : 지도를_출력할_요소_Id_이름
     * @param width : 지도_너비
     * @param height : 지도_높이
     */
     load(mapId, width= 300, height= 300) {
            const mapEl = document.getElementById(mapId);
            if (!mapEl) return;

            mapEl.style.width = `${width}px`;
            mapEl.style.height = `${height}px`;
     }
};