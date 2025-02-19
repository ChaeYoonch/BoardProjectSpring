/**
 * 파일 업로드, 삭제, 조회 공통 기능
 */

const fileManager = {
    /**
     * 파일 업로드
     */
    upload(files, gid, location) { // location = 그룹 안의 위치 값
        try {
            if (!files || files.length == 0) { // 파일이 없는 경우
                throw new Error("파일을 선택 하세요.");
            }

            if (!gid || !gid.trim()) { // gid 가 없는 경우
                throw new Error("필수 항목 누락 입니다(gid).");
            }

            const formData = new FormData();
            formData.append("gid", gid.trim());

            for (const file of files) {
                formData.append("file", file);
            }

            if (location && location.trim()) { // 값이 있을 때만 설정
                formData.append("location", location.trim());
            }

            const { ajaxLoad } = commonLib; // 비구조 할당

            ajaxLoad('/file/upload', 'POST', formData)
                .then(res => {
                    if (!res.success) {
                        alert(res.message);
                        return;
                    }
                    // 파일 업로드 후 처리는 다양, fileUploadCallback 을 직접 상황에 맞게 정의 처리
                    if (typeof parent.fileUploadCallback === 'function') {
                        parent.fileUploadCallback(res.data);
                    } // 함수가 정의된 경우에만 !
                })
                .catch(err => alert(err.message));

        } catch (e) {
            console.log(e);
            alert(e.message);
        }
    },
    /**
     * 파일 삭제
     */
    delete() {

    },
    /**
     * 파일 조회
     */
    search() {

    }
};

window.addEventListener("DOMContentLoaded", function () {
    /* 파일 업로드 버튼 이벤트 처리 S */
    const fileuploads = document.getElementsByClassName("fileuploads");
    const fileEl = document.createElement("input");
    fileEl.type = 'file'; // 위의 fileEl 값 연결
    fileEl.multiple = true; // 위의 fileEl 값 연결

    for (const el of fileuploads) {
        el.addEventListener("click", function() {
            fileEl.value = ""; // 값 초기화
            delete fileEl.gid;
            delete fileEl.location;

            const dataset = this.dataset;
            fileEl.gid = dataset.gid; // gid & location 은 변할 수 있는 값
            if (dataset.location) fileEl.location = dataset.location;

            fileEl.click();
        });
    }
    /* 파일 업로드 버튼 이벤트 처리 E */

    /* 파일 업로드 처리 */
    fileEl.addEventListener("change", function (e) {
        const files = e.target.files; // 아래의 gid, location 값을 가져옴
        fileManager.upload(files, fileEl.gid, fileEl.location);
    });
});