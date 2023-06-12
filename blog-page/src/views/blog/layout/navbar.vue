<template>
    <el-row class="nav-bar">
        <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            :ellipsis="false"
            @select="handleSelect"
        >
            <el-menu-item index="0">LOGO</el-menu-item>
            <div class="flex-grow" />
            <el-menu-item index="1">Processing Center</el-menu-item>
            <el-sub-menu index="2">
                <template #title>Workspace</template>
                <el-menu-item index="2-1">item one</el-menu-item>
                <el-menu-item index="2-2">item two</el-menu-item>
                <el-menu-item index="2-3">item three</el-menu-item>
                <el-sub-menu index="2-4">
                    <template #title>item four</template>
                    <el-menu-item index="2-4-1">item one</el-menu-item>
                    <el-menu-item index="2-4-2">item two</el-menu-item>
                    <el-menu-item index="2-4-3">item three</el-menu-item>
                </el-sub-menu>
            </el-sub-menu>
        </el-menu>
    </el-row>
</template>
<script type="ts" setup>
const activeIndex = ref('1')
const handleSelect = (key, keyPath) => {
    console.log(key, keyPath)
}
</script>
<style scoped>
.navbar {
    height: 60px;
    line-height: 60px;
    border-radius: 0 !important;

    .navbar-tip {
        color: #fff;
        font-size: 16px;
        line-height: 53px;
        height: 50px;
        float: left;
    }

    .hamburger-container {
        line-height: $navBarHeight;
        height: $navBarHeight;
        float: left;
        padding: 0 10px;
        cursor: pointer;
    }

    .breadcrumb-container {
        float: left;
    }

    .errLog-container {
        display: inline-block;
        vertical-align: top;
    }

    .right-menu {
        float: right;
        height: 100%;

        :deep(.el-button) {
            color: #fff;
            background: transparent !important;
            border: none !important;
        }

        :deep(.el-dropdown) {
            color: #fff;
        }

        &:focus {
            outline: none;
        }

        .right-menu-item {
            display: inline-block;
            margin: 0 8px;
        }

        .screenfull {
            height: 20px;
        }

        .right-menu-item {
            vertical-align: top;
        }

        .theme-switch {
            vertical-align: 15px;
        }

        .avatar-container {
            height: 50px;
            margin-right: 10px;

            .avatar-wrapper {
                margin-top: 12px;
                position: relative;
                height: 30px;
                line-height: 30px;

                .user-avatar {
                    float: left;
                    cursor: pointer;
                    width: 30px;
                    height: 30px;
                    border-radius: 10px;
                }

                span {
                    margin-left: 10px;
                    line-height: 30px;
                    float: left;
                    cursor: pointer;
                }

                .el-icon-caret-bottom {
                    cursor: pointer;
                    position: absolute;
                    right: -18px;
                    top: 8px;
                    font-size: 12px;
                }
            }
        }
    }
}

.rowBC {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
}
.flex-grow {
    flex-grow: 1;
}

.nav-bar {
    height: 60px;
    line-height: 60px;
    margin:0;
    padding:0;
    width: 100%;
    border-radius: 0 !important;
    background: linear-gradient(270deg, #586ea0 12.99%, #3C4B6F 79.2%);
}
</style>