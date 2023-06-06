import request from '@/util/request';

const loginApi = {
    async login(data) {
        return request({
            url: '/login/token',
            method:"post",
            params:data
        })
    }
};

export default loginApi;