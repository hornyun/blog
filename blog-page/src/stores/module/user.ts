import {defineStore} from 'pinia'
import {getToken, setToken} from '@/api/auth/auth';

export const userStore = defineStore('user', {
    state: () => ({
        token: getToken(),
        userInfo: null,
        role: [],
    }),
//
    getters:{

    },

    actions:{
        clearToken() {
            setToken("");
        },
        async login(form:any){
            // @ts-ignore
            const res = await $api.userApi.login(form)
            if (res?.success) {
                setToken(res.data?.token);
                this.setUserInfo(res.data);
                return true;
            }else{
                return false;
            }

        },
        setUserInfo(data:any) {
            this.$patch(state=>{
                state.userInfo = data;
            })
        },
    }
});
export default userStore;