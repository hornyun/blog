const content = [
    {
        id: '1',
        title: "UserInfo",
        data:[
            {
                label: 'UserInfoDeTail',
                message: 'UserInfoMessage',
            },
            {
                label: 'UserInfoDeTail',
                message: 'UserInfoMessage',
            },
            {
                label: 'UserInfoDeTail',
                message: 'UserInfoMessage',
            },
            {
                label: 'UserInfoDeTail',
                message: 'UserInfoMessage',
            },
            {
                label: 'UserInfoDeTail',
                message: 'UserInfoMessage',
            }
        ]
    },
    {
        id: '2',
        title: "UserInfo2",
        data:[
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
        ]
    },
    {
        id: '3',
        title: "UserInfo3",
        data:[
            {
                label: 'RoleInfoDeTail3',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
        ]
    },
    {
        id: '4',
        title: "UserInfo4",
        data:[
            {
                label: 'RoleInfoDeTail4',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
        ]
    },
    {
        id: '5',
        title: "UserInfo5",
        data:[
            {
                label: 'RoleInfoDeTail5',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
            {
                label: 'RoleInfoDeTail',
                message: 'RoleInfoMessage',
            },
        ]
    }
];
export default function getContents(id){
    return content.find(e=>e.id === id);
}