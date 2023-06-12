import request from "@/utils/request";

const userApi = {
    async login(data) {
        return request({
            url: '/login',
            method: 'post',
            data,
        });
    },
    async getUser() {
        return request({
            url:'/login/user',
            method:'get',
        })
    },
}
export default userApi;