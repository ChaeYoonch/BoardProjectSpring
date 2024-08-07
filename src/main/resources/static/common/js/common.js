const commonLib = {
    /**
     * ajax 요청 공통
     * @param url
     * @param method
     * @param data
     * @param headers
     */
    ajaxLoad(url, method, data, headers) {
        if (!url) {
            return;
        }

        const csrfToken = document.querySelector("mata[name='csrf_token']")?.content?.trim(); // trim() 으로 공백 제거
        const csrfHeader = document.querySelector("mata[name='csrf_header']")?.content?.trim(); // ? -> nullsafe
        const rootUrl = document.querySelector("mata[name='rootUrl']")?.content?.trim() ?? ''; // ? -> nullsafe

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
            .then(res => console.log(res))
            .catch(err => console.log(err))
    }
};