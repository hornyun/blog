import { createApp } from 'vue'
import { createPinia } from 'pinia'
import router from "@/router";
import App from '@/App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'


// v-md-editor
import VMdPreview from '@kangc/v-md-editor/lib/preview';
import '@kangc/v-md-editor/lib/style/preview.css';
import githubTheme from '@kangc/v-md-editor/lib/theme/github.js';
import '@kangc/v-md-editor/lib/theme/style/github.css';
// highlightjs of v-md-editor
import hljs from 'highlight.js';
VMdPreview.use(githubTheme, {
    Hljs: hljs,
});



const app = createApp(App);
app.use(ElementPlus);
app.use(createPinia());
app.use(router);
app.use(VMdPreview);

app.mount('#app');
app.component('');
