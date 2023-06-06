import { defineConfig } from 'vite';
import AutoImport from 'unplugin-auto-import/vite';
import { resolve } from 'path';
import Vue from '@vitejs/plugin-vue';

export default defineConfig({
  plugins: [
    Vue(),
    AutoImport({
      imports: [
        'vue',
        'vitest',
        {
          '@/utils/libs/lodash': [['default', '_']]
        }
      ],
      dts: './test/auto-imports.d.ts'
    })
  ],
  // test: {
  //   include: ['test/**/*.test.ts'],
  //   globals: true,
  //   environment: 'jsdom'
  // },
  resolve: {
    alias: {
      '~': resolve(__dirname, './'),
      '@': resolve(__dirname, 'src')
    }
  }
});
