import axios from 'axios';
import {getToken} from '@/api/auth/auth';
import router from '@/router';
import userStore from "@/stores/module/user";


// create an axios instance
const instance = axios.create({
    baseURL:"/"+ import.meta.env.VITE_APP_BASE_API, //
    withCredentials: true, // send cookies when cross-domain requests
    timeout: 25000 // request timeout
});

// request interceptor
instance.interceptors.request.use(
    config => {
        return config;
    },
    error => {
        // do something with request error
        console.log(error); // for debug
        return Promise.reject(error);
    }
);

// response interceptor
instance.interceptors.response.use(
    response => {
        return response.data;
    },
    async error => {
        console.log(error);
        if (error.response) {
            if (error.response.status === 401) {
                await router.replace({
                    path: '/blog/login',
                });
            }
            //@ts-ignore
            await $utils.messageUtils.showResponseErrorMessage(error.response.data.message);
        } else {
            if (error.code === 'ECONNABORTED') {
                //@ts-ignore
                $utils.messageUtils.message.error('请求连接超时，请联系管理员！');
            }
        }
        return Promise.reject(error.response.data);
    }
);

export default instance;
