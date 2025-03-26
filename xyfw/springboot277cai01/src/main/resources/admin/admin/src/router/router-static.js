import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import zhoubianfuwu from '@/views/modules/zhoubianfuwu/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import dingdanxinxi from '@/views/modules/dingdanxinxi/list'
    import xianzhishangpin from '@/views/modules/xianzhishangpin/list'
    import kaoshixinxi from '@/views/modules/kaoshixinxi/list'
    import storeup from '@/views/modules/storeup/list'
    import shiwuzhaoling from '@/views/modules/shiwuzhaoling/list'
    import kemu from '@/views/modules/kemu/list'
    import forum from '@/views/modules/forum/list'
    import shangpinfenlei from '@/views/modules/shangpinfenlei/list'
    import discussxianzhishangpin from '@/views/modules/discussxianzhishangpin/list'
    import config from '@/views/modules/config/list'
    import discussshiwuzhaoling from '@/views/modules/discussshiwuzhaoling/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '校园新闻',
        component: news
      }
      ,{
	path: '/zhoubianfuwu',
        name: '周边服务',
        component: zhoubianfuwu
      }
      ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
      ,{
	path: '/dingdanxinxi',
        name: '订单信息',
        component: dingdanxinxi
      }
      ,{
	path: '/xianzhishangpin',
        name: '闲置商品',
        component: xianzhishangpin
      }
      ,{
	path: '/kaoshixinxi',
        name: '考试信息',
        component: kaoshixinxi
      }
      ,{
	path: '/storeup',
        name: '我的收藏',
        component: storeup
      }
      ,{
	path: '/shiwuzhaoling',
        name: '失物招领',
        component: shiwuzhaoling
      }
      ,{
	path: '/kemu',
        name: '科目',
        component: kemu
      }
      ,{
	path: '/forum',
        name: '在线交流',
        component: forum
      }
      ,{
	path: '/shangpinfenlei',
        name: '商品分类',
        component: shangpinfenlei
      }
      ,{
	path: '/discussxianzhishangpin',
        name: '闲置商品评论',
        component: discussxianzhishangpin
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/discussshiwuzhaoling',
        name: '失物招领评论',
        component: discussshiwuzhaoling
      }
      ,{
	path: '/newstype',
        name: '校园新闻分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
