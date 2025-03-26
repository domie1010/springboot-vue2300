const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "学生",
                    "menuJump": "列表",
                    "tableName": "xuesheng"
                }],
                "menu": "学生管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-flashlightopen",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "商品分类",
                    "menuJump": "列表",
                    "tableName": "shangpinfenlei"
                }],
                "menu": "商品分类管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "查看评论", "购买"],
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除", "查看评论", "审核"],
                    "menu": "闲置商品",
                    "menuJump": "列表",
                    "tableName": "xianzhishangpin"
                }],
                "menu": "闲置商品管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "支付"],
                    "appFrontIcon": "cuIcon-goods",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "订单信息",
                    "menuJump": "列表",
                    "tableName": "dingdanxinxi"
                }],
                "menu": "订单信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论"],
                    "appFrontIcon": "cuIcon-full",
                    "buttons": ["查看", "修改", "删除", "查看评论"],
                    "menu": "失物招领",
                    "menuJump": "列表",
                    "tableName": "shiwuzhaoling"
                }],
                "menu": "失物招领管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-pic",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "周边服务",
                    "menuJump": "列表",
                    "tableName": "zhoubianfuwu"
                }],
                "menu": "周边服务管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-group",
                    "buttons": ["查看", "删除"],
                    "menu": "在线交流",
                    "tableName": "forum"
                }],
                "menu": "在线交流"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "校园新闻分类",
                    "tableName": "newstype"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-attentionfavor",
                    "buttons": ["查看", "修改"],
                    "menu": "轮播图管理",
                    "tableName": "config"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "校园新闻",
                    "tableName": "news"
                }],
                "menu": "系统管理"
            }],
            "frontMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "查看评论", "购买"],
                    "appFrontIcon": "cuIcon-album",
                    "buttons": ["查看", "购买"],
                    "menu": "闲置商品列表",
                    "menuJump": "列表",
                    "tableName": "xianzhishangpin"
                }],
                "menu": "闲置商品模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-pay",
                    "buttons": ["查看"],
                    "menu": "考试信息列表",
                    "menuJump": "列表",
                    "tableName": "kaoshixinxi"
                }],
                "menu": "考试信息模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论"],
                    "appFrontIcon": "cuIcon-qrcode",
                    "buttons": ["查看"],
                    "menu": "失物招领列表",
                    "menuJump": "列表",
                    "tableName": "shiwuzhaoling"
                }],
                "menu": "失物招领模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-qrcode",
                    "buttons": ["查看"],
                    "menu": "周边服务列表",
                    "menuJump": "列表",
                    "tableName": "zhoubianfuwu"
                }],
                "menu": "周边服务模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "管理员",
            "tableName": "users"
        }, {
            "backMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "查看评论", "购买"],
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "闲置商品",
                    "menuJump": "列表",
                    "tableName": "xianzhishangpin"
                }],
                "menu": "闲置商品管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "支付"],
                    "appFrontIcon": "cuIcon-goods",
                    "buttons": ["查看", "删除", "支付"],
                    "menu": "订单信息",
                    "menuJump": "列表",
                    "tableName": "dingdanxinxi"
                }],
                "menu": "订单信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论"],
                    "appFrontIcon": "cuIcon-full",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "失物招领",
                    "menuJump": "列表",
                    "tableName": "shiwuzhaoling"
                }],
                "menu": "失物招领管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-favor",
                    "buttons": ["查看", "删除"],
                    "menu": "我的收藏",
                    "menuJump": "1",
                    "tableName": "storeup"
                }],
                "menu": "我的收藏管理"
            }],
            "frontMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "查看评论", "购买"],
                    "appFrontIcon": "cuIcon-album",
                    "buttons": ["查看", "购买"],
                    "menu": "闲置商品列表",
                    "menuJump": "列表",
                    "tableName": "xianzhishangpin"
                }],
                "menu": "闲置商品模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-pay",
                    "buttons": ["查看"],
                    "menu": "考试信息列表",
                    "menuJump": "列表",
                    "tableName": "kaoshixinxi"
                }],
                "menu": "考试信息模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论"],
                    "appFrontIcon": "cuIcon-qrcode",
                    "buttons": ["查看"],
                    "menu": "失物招领列表",
                    "menuJump": "列表",
                    "tableName": "shiwuzhaoling"
                }],
                "menu": "失物招领模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-qrcode",
                    "buttons": ["查看"],
                    "menu": "周边服务列表",
                    "menuJump": "列表",
                    "tableName": "zhoubianfuwu"
                }],
                "menu": "周边服务模块"
            }],
            "hasBackLogin": "否",
            "hasBackRegister": "否",
            "hasFrontLogin": "是",
            "hasFrontRegister": "是",
            "roleName": "学生",
            "tableName": "xuesheng"
        }]
    }
}
export default menu;
