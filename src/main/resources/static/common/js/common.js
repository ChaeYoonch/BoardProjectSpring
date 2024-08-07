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

        method = method.toUpperCase();
        if (method === 'GET') {
            data = null;
        }

        if (!(data instanceof FormData) && typeof data !== 'string' && data instanceof Object) { // 직렬화
            data = JSON.stringify(data);
        }
    }
};