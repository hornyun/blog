import {fileURLToPath, URL} from 'node:url'

import {loadEnv} from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import {ElementPlusResolver} from "unplugin-vue-components/resolvers";
import Components from 'unplugin-vue-components/vite';


// @ts-ignore
export default ({mode}) => {
    process.env = {...process.env, ...loadEnv(mode, process.cwd())};
    console.log('VITE_APP_BASE_URL', process.env.VITE_APP_BASE_URL);
    console.log('VITE_APP_BASE_API', process.env.VITE_APP_BASE_API);
    console.log('VITE_APP_BASE_PORT', process.env.VITE_APP_BASE_PORT);
    // @ts-ignore
    // @ts-ignore
    return {
        plugins: [
            vue(),
            AutoImport({
                imports: ['vue', 'vue-router',
                    {
                        '@/api': [['default', '$api']],
                        '@/utils': [['default', '$utils']],
                    }
                ],
                dts: 'src/auto-imports.d.ts',
                resolvers: [ElementPlusResolver()],
            }),
            Components({
                resolvers: [ElementPlusResolver()],
            }),
        ],
        resolve: {
            alias: {
                '@': fileURLToPath(new URL('./src', import.meta.url))
            }
        },
        server:{
            host: "0.0.0.0",
            hmr: { overlay: false }, // 禁用或配置 HMR 连接 设置 server.hmr.overlay 为 false 可以禁用服务器错误遮罩层
            port:Number(process.env.VITE_APP_BASE_PORT),
            open: false, // 类型： boolean | string在服务器启动时自动在浏览器中打开应用程序；
            cors: true, // 类型： boolean | CorsOptions 为开发服务器配置 CORS。默认启用并允许任何源
            proxy:{
                [`/${process.env.VITE_APP_BASE_API}`]:{
                    // target: process.env.VITE_APP_BASE_URL,
                    target: "http://localhost:8066/blog",
                    changeOrigin: true,
                    // @ts-ignore
                    rewrite: path => path.replace(/^\/dev-api/, '')
                }
            }
        }
    }


}
