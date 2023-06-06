import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import * as auth from '@/api/auth/auth';
import {getToken, setToken} from "@/api/auth/auth";

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

    }
});
export default userStore;