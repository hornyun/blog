import {createRouter, createWebHashHistory} from 'vue-router';
import userStore from "@/stores/module/user";

// @ts-ignore
import nProgress from 'nprogress'; // progress bar
nProgress.configure({showSpinner: false});


const routes = [
    {
        path: '/',
        component: () => import('@/components/frame/Frame.vue'),
    },
    {
        path: "/article/first",
        name: 'article',
        component: () => import('@/views/article/FirstArticle.vue'),
    },
    {
        path: "/login",
        name: 'login',
        component: () => import('@/views/blog/login.vue'),
    },
    {
        path: "/blog/home",
        name: 'blog-home',
        component: () => import('@/views/blog/home.vue'),
        children:[
            {
                path:'/user',
                name:'user-management',
                component: () => import('@/views/blog/system/user-management.vue'),
            }
        ]
    },
    {
        path: "/blog/test",
        name: 'login-test',
        component: () => import('@/views/blog/test.vue'),
    }
]

const router = createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: createWebHashHistory(),
    routes, // `routes: routes` 的缩写
})
router.beforeEach(async (to) => {
    nProgress.start();
    let store = userStore();

    if (to.path.startsWith("/blog")) {
        console.log("store.userInfo is ", store.userInfo);
        if (!store.userInfo) {
            const user = await store.getUserInfo();
            if (user) {
                nProgress.done();
                return true;
            }else{
                nProgress.done();
                return true;
            }
        }
    }
    else if (to.path === '/login') {
        if (store.userInfo) {
            return '/blog/home';
        }else{
            return true;
        }
    } else {
        nProgress.done();
        return true;
    }
})
export default router;