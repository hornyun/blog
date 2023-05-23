<template>
    <el-container>
        <el-header class="my-header">
            <el-menu style="height: 75px;letter-spacing: 20px"
                     text-color="#000"
                     class="el-menu-demo"
                     :index="currentPage"
                     mode="horizontal"
                     @select="handleSelect"
                     popper-effect="dark"
            >
                <el-menu-item v-for="menu in menus" :index="menu.index">{{ menu.title }}</el-menu-item>
            </el-menu>
        </el-header>
        <el-container style="margin: 30px 0;height: 800px;padding: 0 32px">

            <el-main>
                <el-space direction="vertical" alignment="start" :size="30">
                    <el-descriptions :title="contentList.title" style="border: 1px solid #000;padding: 5px 5px">
                        <el-descriptions-item v-for="content in contentList.data" :label="content.label">
                            {{ content.message }}
                        </el-descriptions-item>
                    </el-descriptions>
                </el-space>
            </el-main>
            <el-aside>
                ASIDE
            </el-aside>
        </el-container>
        <el-footer>
            FOOTER
            <v-md-preview :text="text"></v-md-preview>
            <div>
                <Markdown source="../../../assets/article.md" />
            </div>
        </el-footer>
    </el-container>
</template>

<script lang="ts" setup>
import getMenus from '@/api/menu.api.js';
import getContents from '@/api/content.api.js';
import {onMounted, reactive, ref, computed} from "vue";
import Markdown from 'vue3-markdown-it';

let currentPage = ref('1');
let menus = ref(getMenus());
let contentList = reactive({});
const text = "# 这是一个一级表头";
const source = "@/assets/article.md"
onMounted(() => {
    Object.assign(contentList, getContents(currentPage));
})

const handleSelect = (index) => {
    currentPage = index.toString();
    contentList = Object.assign(contentList, getContents(currentPage));
}

interface Content {
    title: String,
    id: String,
}
</script>
<style scoped>
el-header {
    margin: 0 135px;
}

.my-header {
    padding: 0 32px;
    background-color: #ffffff;
    color: #000;
}
</style>