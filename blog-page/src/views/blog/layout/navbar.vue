<template>
    <el-row class="nav-bar">
        <el-menu
                :default-active="activeIndex"
                class="nav-menu"
                mode="horizontal"
                active-text-color="#d9ecff"
                :ellipsis="false"
                @select="handleSelect"
        >
            <el-menu-item index="0">浩宇-个人博客</el-menu-item>
            <div class="flex-grow"/>
            <el-menu-item index="1">Processing Center</el-menu-item>
            <el-sub-menu index="2">
                <template #title>个人信息</template>
                <el-menu-item index="2-1">GITHUB</el-menu-item>
                <el-menu-item index="2-2">邮箱</el-menu-item>
                <el-menu-item index="2-3">修改密码</el-menu-item>
            </el-sub-menu>
        </el-menu>
    </el-row>
</template>
<script type="ts" setup>
const activeIndex = ref('0')
const handleSelect = (key, keyPath) => {
    console.log(key, keyPath)
}
</script>
<style scoped>

.flex-grow {
    flex-grow: 1;
}

.nav-bar {
    height: 70px;
    line-height: 70px;
    margin-top: 10px;
    padding: 0;
    width: 100%;
    border-radius: 0 !important;

    .nav-menu {
        width: 100%;
        background: #409EFF;
        border-radius: 5px;
    }
    //--bg-color: #409EFF;
    --text-color:red;
    --active-color: #d9ecff;
    --el-menu-hover-bg-color: #337ecc;


}
</style>