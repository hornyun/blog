import {defineStore} from 'pinia'
import {getToken, setToken} from '@/api/auth/auth';

export const userStore = defineStore('user', {
    state: () => ({
        token: getToken(),
        userInfo: null,
        role: [],
    }),
    getters:{

    },

    actions:{
        clearToken() {
            setToken("");
        },
        async login(form:any){
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
        async getUserInfo(){
            const res = await $api.userApi.getUserInfo();
            if (res?.success) {
                this.setUserInfo(res.d());
                return true;
            }else{
                return false;
            }
        }
    }
});
export default userStore;