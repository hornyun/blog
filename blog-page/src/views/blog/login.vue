<template>
    <el-container class="login-container">
        <el-row class="login-wrapper">
            <el-row><span>博客后台管理系统</span></el-row>
            <el-row>
                <el-col :span="24">
                    <el-form class="login-form" :model="form" label-width="70px">
                        <el-form-item label="账号：">
                            <el-input v-model="form.username"/>
                        </el-form-item>
                        <el-form-item label="密码：">
                            <el-input v-model="form.password"/>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="onSubmit">登录</el-button>
                        </el-form-item>
                    </el-form>
                </el-col>
            </el-row>
        </el-row>
    </el-container>
</template>
<style scoped>
.login-container {
    width: 100%;
    height: 100%;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    background: url("@/assets/img/login.jpeg") no-repeat;
    background-size: 100%;
    box-shadow: 0 15px 25px 0 rgba(0, 0, 0, .6);
}

.login-wrapper {
    width: 400px;
    height: 364px;
    background-color: rgb(65, 59, 69, 0.8);
    margin: 100px auto;
    border-radius: 10px;
    padding: 40px;
    box-sizing: border-box;
    display: flex;
    justify-content: center;
    align-items: center;
}

.login-form {
    color: #67C23A;
}
</style>
<script setup>
import {reactive} from 'vue'
import router from "@/router";
import userStore from "@/stores/module/user";

const form = reactive({
  username: '',
  password: ''
})

const onSubmit = async () => {
    const success = await userStore().login(form);
    if (success) {
        await router.push({path:"/blog/home"});
    }else{
        $utils.messageUtils.mainMessage.warning("验证失败");
    }

}

</script>
