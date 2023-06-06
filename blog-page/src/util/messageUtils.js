/** 重置message，防止重复点击重复弹出message弹框 */

import {ElMessage} from 'element-plus';

let messageInstance = null;
const mainMessage = function DoneMessage(options) {
    // 如果弹窗已存在先关闭
    if (messageInstance) {
        messageInstance.close();
    }
    messageInstance = ElMessage(options);
};
const arr = ['success', 'warning', 'info', 'error'];
arr.forEach(function(type) {
    mainMessage[type] = function(options) {
        if (typeof options === 'string') {
            options = {
                message: options
            };
        }
        options.type = type;
        return mainMessage(options);
    };
});



const messageUtils = {
    /**
     * 显示一次消息
     * */
    onceMessage: mainMessage,
    /**
     * 显示一次消息
     * */
    mainMessage,
    /**
     * 显示服务端返回消息
     * */
    showResponseMessage(res, options = {}) {
        return new Promise((resolve, reject) => {
            mainMessage({
                message: res.message || '系统服务异常，请联系管理员！',
                type: res.success ? 'success' : 'error',
                duration: res.success ? 3000 : 6000,
                showClose: true,
                ...options
            });
            if (res.success) {
                return resolve(res);
            }
            reject(res);
        });
    },
    showResponseErrorMessage(message, options = {}) {
        return this.showResponseMessage({ success: false, message }, options);
    },
    /**
     * 通用确认方法
     * */
    async confirm(message, {
        title = '提示',
        confirmButtonText = '确定',
        cancelButtonText = '取消',
        type = 'warning',
        ...options
    } = {}) {
        return await MessageBox.confirm(message, title, {
            confirmButtonText,
            cancelButtonText,
            type,
            ...options
        });
    }
};

export default messageUtils;
