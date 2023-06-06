import request from "@/util/request";

const userApi = {
    async login(data) {
        return request({
            url: '/login/token',
            method: 'post',
            data,
        });
    },
}
export default userApi;