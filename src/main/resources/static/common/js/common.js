const commonLib = {
    /**
     * ajax 요청 공통
     * @param responseType : 응답 데이터 타입 (text - text 로, 그 외는 json 으로)
     */
    ajaxLoad(url, method, data, headers, responseType) {
        if (!url) {
            return;
        }

        const csrfToken = document.querySelector("mata[name='csrf_token']")?.content?.trim(); // trim() 으로 공백 제거
        const csrfHeader = document.querySelector("mata[name='csrf_header']")?.content?.trim(); // ? -> nullsafe
        let rootUrl = document.querySelector("mata[name='rootUrl']")?.content?.trim() ?? ''; // ? -> nullsafe
        rootUrl = rootUrl === '/' ? '' : rootUrl;

        url = location.protocol + "://" + location.host + rootUrl + url;

        method = method.toUpperCase();
        if (method === 'GET') {
            data = null;
        }

        if (!(data instanceof FormData) && typeof data !== 'string' && data instanceof Object) { // 직렬화
            data = JSON.stringify(data);
        }

        if (csrfHeader && csrfToken) {
            headers = headers ?? {};
            headers[csrfHeader] = csrfToken;
        }

        const options = {
            method
        };

        if (data) options.body = data;
        if (headers) options.headers = headers;

        fetch(url, options)
            .then(res => res.json) // res.json() : json 형태 | res.text() : text 형태
            .then(res => console.log(res))
            .catch(err => console.log(err));
    }
};