import {fileURLToPath, URL} from 'node:url'

import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import {ElementPlusResolver} from "unplugin-vue-components/resolvers";
import Components from 'unplugin-vue-components/vite';

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [
        vue(),
        AutoImport({
            imports:['vue','vue-router',
                {
                    '@/api': [['default', '$api']],
                    '@/util': [['default', '$utils']],
                }
                ],
            dts:'auto-imports.d.ts',
            resolvers:[ElementPlusResolver()]
        }),
        Components({
            resolvers: [ElementPlusResolver()],
        })
    ],
    resolve: {
        alias: {
            '@': fileURLToPath(new URL('./src', import.meta.url))
        }
    }
})
