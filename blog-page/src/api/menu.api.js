const menus = [
    {
        id:'1',
        index:1,
        title: '技术交流',
    },
    {
        id:'2',
        index:2,
        title: '源码分享',
    },
    {
        id:'3',
        index:3,
        title: '程序人生',
    },
    {
        id:'4',
        index:4,
        title: '时间轴',
    },
    {
        id:'5',
        index:5,
        title: '关于本人',
    },
];
const sideMenus = [
    {
        name:'系统管理',
        children:[
            {
                name:'用户管理',
            },

        ]
    }
    ,
]

export default function (){
    return menus;
};