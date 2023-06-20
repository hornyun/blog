<template>
    <el-row class="side-bar">
        <el-menu
                default-active="2"
                class="side-menu"
                @open="handleOpen"
                @close="handleClose"
        >
            <el-sub-menu index="1">
                <template #title>
                    <span>系统管理</span>
                </template>
                <el-menu-item-group class="test">
                    <el-menu-item index="1-1"><router-link :to="{name:'user-management'}">用户管理</router-link></el-menu-item>
                    <el-menu-item index="1-2">角色管理</el-menu-item>
                    <el-menu-item index="1-3">菜单管理</el-menu-item>
                </el-menu-item-group>
            </el-sub-menu>
        </el-menu>
    </el-row>
</template>
<script setup>
function handleOpen() {

}

function handleClose() {

}
</script>
<style scoped>
.side-bar {
    margin-top: 40px;
    width: 100%;
    .side-menu{
        margin-left: 10px;
        width: 180px;
        border-radius: 5px;
        background: #409EFF;
        .test{
            background: #c6e2ff;
        }
    }
}

</style>