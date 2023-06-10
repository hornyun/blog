import {createRouter, createWebHashHistory} from 'vue-router';
import userStore from "@/stores/module/user";

// @ts-ignore
import nProgress from 'nprogress'; // progress bar
nProgress.configure({showSpinner: false});


const routes = [
    {
        path: '/',
        component: ()=>import('@/components/frame/Frame.vue'),
    },
    {
        path:"/article/first",
        name:'article',
        component: () => import('@/views/article/FirstArticle.vue'),
    },
    {
        path:"/login",
        name:'login',
        component: () => import('@/views/blog/login.vue'),
    },
    {
        path:"/blog/home",
        name:'blog-home',
        component: () => import('@/views/blog/home.vue'),
    },
    {
        path:"/blog/test",
        name:'login-test',
        component: () => import('@/views/blog/test.vue'),
    }
]

const router = createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: createWebHashHistory(),
    routes, // `routes: routes` 的缩写
})
router.beforeEach((to)=>{
    nProgress.start();
    if (to.path.startsWith("/blog")) {
        if (!userStore().userInfo) {
            nProgress.done();
            return '/login';
        }
    }else{
        nProgress.done();
    }
})
export default router;