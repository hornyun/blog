import userStore from "@/stores/module/user";

const blogStore = ()=>({
    user:userStore(),
})
export default blogStore();