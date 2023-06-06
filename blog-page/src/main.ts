import { createApp } from 'vue'
import { createPinia } from 'pinia'
import router from "@/router";
import App from '@/App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import global from '@/common/global';
// v-md-editor
// @ts-ignore
import VMdPreview from '@kangc/v-md-editor/lib/preview';
import '@kangc/v-md-editor/lib/style/preview.css';
// @ts-ignore
import githubTheme from '@kangc/v-md-editor/lib/theme/github.js';
import '@kangc/v-md-editor/lib/theme/style/github.css';
// highlightjs of v-md-editor
import hljs from 'highlight.js';
VMdPreview.use(githubTheme, {
    Hljs: hljs,
});

// markDown插件
// @ts-ignore
import Markdown from 'vue3-markdown-it';
import 'highlight.js/styles/monokai.css';


const app = createApp(App);
global(app);
app.use(ElementPlus);
app.use(createPinia());
app.use(router);
app.use(VMdPreview);
app.use(Markdown);

app.mount('#app');
app.component('');
