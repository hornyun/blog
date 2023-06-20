<template>
    <div class="blog-content">
        <div class="content-header">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>系统管理</el-breadcrumb-item>
                <el-breadcrumb-item>用户管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="content-main">
            <el-table :data="tableData" style="width: 100%">
                <el-table-column prop="date" label="Date" width="180"/>
                <el-table-column prop="name" label="Name" width="180"/>
                <el-table-column prop="address" label="Address"/>
            </el-table>
        </div>
    </div>
</template>
<script setup>
const tableData = [
    {
        date: '2016-05-03',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    },
    {
        date: '2016-05-02',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    },
    {
        date: '2016-05-04',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    },
    {
        date: '2016-05-01',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    },
]
</script>
<style scoped>
.blog-content{
    .content-header{
        margin-left: 10px;
        margin-top: 10px;
        margin-bottom: 10px;

    }
}
</style>