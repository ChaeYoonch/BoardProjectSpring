/**
 * 파일 업로드, 삭제, 조회 공통 기능
 *
 */

const fileManager = {
    /**
     * 파일 업로드
     *
     */
    upload() {

    },
    /**
     * 파일 삭제
     *
     */
    delete() {

    },
    /**
     * 파일 조회
     *
     */
    search() {

    }
};

window.addEventListener("DOMContentLoaded", function () {
    /* 파일 업로드 버튼 이벤트 처리 S */
    const fileuploads = document.getElementsByClassName("fileuploads");
    const fileEl = document.createElement("input");
    fileEl.type = 'file'; // 위의 fileEl 값 연결

    for (const el of fileuploads) {
        el.addEventListener("click", function() {

        });
    }
    /* 파일 업로드 버튼 이벤트 처리 E */
});