<template>
    <div class="home-container">
        <el-container>
            <el-header>
                <NavBar/>
            </el-header>
            <el-container>
                <el-aside class="layout-aside">
                    <SideMenu/>
                </el-aside>
                <el-main class="layout-main">
                    <Main/>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>
<script setup>
import NavBar from './layout/navbar.vue';
import SideMenu from './layout/side-menu.vue';
import Main from './layout/main.vue';



</script>
<style scoped>
.home-container{
    margin:0;
    padding:0;
    width: 100%;
    height: 100%;
    background-color: #f0f9eb;

    .layout-main{
        margin-left: -70px;
    }
}

.layout-aside{
    width: 20%;
    min-width: 200px;
}
</style>