import {defineStore} from 'pinia'
import {getToken, setToken} from '@/api/auth/auth';

export const userStore = defineStore('user', {
    state: () => ({
        userInfo: null,
        role: [],
    }),
    getters:{

    },

    actions:{
        async login(form:any){
            const res = await $api.userApi.login(form)
            console.log("login res is ", res);
            if (res?.success) {
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
            const res = await $api.userApi.getUser();
            console.log("res is ", res);
            if (res?.success) {
                this.setUserInfo(res?.data);
                return res?.data;
            }else{
                return undefined;
            }
        }
    }
});
export default userStore;