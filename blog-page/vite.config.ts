import {fileURLToPath, URL} from 'node:url'

import {loadEnv} from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import {ElementPlusResolver} from "unplugin-vue-components/resolvers";
import Components from 'unplugin-vue-components/vite';

// https://vitejs.dev/config/


export default ({command, mode}) => {
    process.env = {...process.env, ...loadEnv(mode, process.cwd())};
    console.log('VITE_APP_BASE_URL', process.env.VITE_APP_BASE_URL);
    console.log('VITE_APP_BASE_API', process.env.VITE_APP_BASE_API);
    return {
        plugins: [
            vue(),
            AutoImport({
                imports: ['vue', 'vue-router',
                    {
                        '@/api': [['default', '$api']],
                        '@/util': [['default', '$utils']],
                    }
                ],
                dts: false,
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
            proxy:{
                [`/${process.env.VITE_APP_BASE_API}`]:{
                    target: process.env.VITE_APP_BASE_URL,
                    changeOrigin: true,
                    rewrite: (path) => path.replace(/^\/dev-api/, '')
                }
            }
        }
    }


}
