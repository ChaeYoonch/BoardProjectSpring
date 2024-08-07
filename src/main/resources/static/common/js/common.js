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
    }
};