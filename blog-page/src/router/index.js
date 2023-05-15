import {createRouter, createWebHashHistory, RouteRecordRaw} from 'vue-router';

const routes = [
    { path: '/', component: Home },
    { path: '/about', component: About },
]

const router = VueRouter.createRouter(({
    history: VueRouter.createWebHashHistory(),
    routes: routes,
}))
export default router