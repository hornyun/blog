<template>
    <el-container>
        <el-header>
            <el-menu style="height: 75px;letter-spacing: 20px"
                     :default-active="menus[0].index"
                     background-color="#545c64"
                     text-color="#fff"
                     class="el-menu-demo"
                     mode="horizontal"
                     @select="handleSelect"
                     popper-effect="dark"
            >
                <el-menu-item v-for="menu in menus" :index="menu.index">{{ menu.title }}</el-menu-item>
            </el-menu>
        </el-header>
    </el-container>
</template>

<script lang="ts" setup>
import menus from '@/api/menu.api.js';
const handleSelect = (index) => {
    console.log(menus[index - 1]);
}
</script>
<style scoped>
el-header {
    margin: 0 135px;
}
</style>