<template>
<view class="content">
	<view :style='{"width":"100%","flexWrap":"wrap","background":"#fff","display":"flex","height":"100%"}'>
		<swiper :style='{"boxShadow":"0px 4rpx 10rpx 0px rgba(0,0,0,0.3)","margin":"40rpx auto 0","overflow":"hidden","borderRadius":"10rpx","background":"#fff","width":"calc(100% - 72rpx)","height":"360rpx","order":"3"}' class="swiper" :indicator-dots='true' :autoplay='true' :circular='true' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
			<swiper-item :style='{"width":"100%","background":"#fff","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
				<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
				<view v-if="false" :style='{"width":"100%","padding":"0 8rpx","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","background":"#fff"}'>{{ swiper.title }}</view>
			</swiper-item>
		</swiper>
		<!-- menu -->
		<view v-if="true" class="menu" :style='{"padding":"0 0 20rpx","margin":"0","borderRadius":"0 0 60rpx 60rpx","flexWrap":"wrap","background":"linear-gradient(179deg, #FF6552 0%, #FF9557 100%)","display":"flex","width":"100%","height":"auto","order":"2"}'>
            <block v-for="(item,index1) in menuList" v-bind:key="item.roleName">
                <block v-if="index1==0" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
                    <block v-bind:key="sort" v-for=" (child,sort) in menu.child">
                        <block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
                            <view :style='{"width":"23%","padding":"12rpx 0","margin":"10rpx 2% 0 0","textAlign":"center","height":"auto"}' class="menu-list" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2('../'+child.tableName+'/list')">
                                <view class="iconarr" :class="child.appFrontIcon" :style='{"padding":"0","margin":"0px auto","color":"#fff","borderRadius":"100%","background":"none","display":"block","fontSize":"64rpx"}'></view>
                                <view :style='{"padding":"0","margin":"12rpx auto 0","color":"#000","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{child.menu.split("列表")[0]}}</view>
                            </view>
                        </block>
                    </block>
                </block>
            </block>
		</view>
		<!-- menu -->
		<!-- 商品推荐 -->
		<view class="listBox recommend" :style='{"width":"calc(100% - 72rpx)","padding":"20rpx 10rpx","margin":"0 auto 20rpx","borderRadius":"30rpx","background":"#FFF5EF","order":"7"}'>
			<view class="title" :style='{"padding":"0 60rpx","margin":"0","background":"url(http://codegen.caihongy.cn/20231228/087ca9772a3a4efaa15ad26606e3fc90.png)","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","height":"80rpx"}'>
				<view :style='{"fontSize":"32rpx","lineHeight":"60rpx","color":"#fff","fontWeight":"bold"}'>闲置商品推荐</view>
			</view>
			<!-- 样式2 -->
			<view class="list-box style2" :style='{"width":"100%","padding":"24rpx 10rpx","height":"auto"}'>
			  <view class="tabView" :style='{"width":"100%","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>
			    <view class="tab" :class="xianzhishangpinIndex2 == index ?'tabActive':''" v-for="(item,index) in xianzhishangpinCateList2" :key="index" @click="recommendTabClick2(index,'xianzhishangpin')">
			      <text class="icon iconfont icon-zhankai19" :style='{"margin":"0 4rpx 0 0","lineHeight":"40rpx","fontSize":"26rpx","color":"inherit"}'></text>
			      <text :style='{"color":"inherit","lineHeight":"40rpx","fontSize":"26rpx"}'>{{item.shangpinfenlei}}</text>
			    </view>
			  </view>
			  <view :style='{"padding":"24rpx 0","margin":"0","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
			    <view @tap="onDetailTap('xianzhishangpin',product.id)" v-for="(product,index) in xianzhishangpinlist" :key="index" class="list-item" :style='{"boxShadow":"none","margin":"0 0 20rpx","backgroundColor":"#FF9257","overflow":"hidden","borderRadius":"10rpx","flexWrap":"wrap","display":"flex","width":"48%","position":"relative","height":"auto"}'>
					<view :style='{"padding":"4rpx 10rpx","color":"#fff","width":"100%","lineHeight":"2","fontSize":"32rpx","fontWeight":"bold","order":"2"}' class="list-item-title ">{{product.shangpinmingcheng}}</view>
					<view :style='{"padding":"4rpx 10rpx","color":"#fff","width":"100%","lineHeight":"2","fontSize":"32rpx","fontWeight":"bold","order":"2"}' class="list-item-title ">{{product.shangpinfenlei}}</view>
					<image :style='{"padding":"0","margin":"0","objectFit":"cover","borderRadius":"10rpx","display":"block","width":"100%","height":"300rpx","order":"1"}' class="list-item-image" mode="aspectFill" v-if="product.tupian.substring(0,4)=='http'" :src="product.tupian"></image>
					<image :style='{"padding":"0","margin":"0","objectFit":"cover","borderRadius":"10rpx","display":"block","width":"100%","height":"300rpx","order":"1"}' class="list-item-image" mode="aspectFill" v-else :src="product.tupian?baseUrl+product.tupian.split(',')[0]:''"></image>
					<view :style='{"padding":"4rpx 10rpx","color":"#fff","width":"100%","lineHeight":"2","fontSize":"32rpx","fontWeight":"bold","order":"2"}' class="list-item-title ">价格:{{product.jiage}}</view>
				  <view :style='{"padding":"0 20rpx","display":"none"}'>
			        <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
			        <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
			      </view>
			      <view :style='{"padding":"0 20rpx","display":"none"}'>
			        <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
			        <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.xuehao}}</text>
			      </view>
			      <view :style='{"padding":"0 10rpx 10rpx","order":"4"}'>
			        <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"20rpx","color":"#fff"}'></text>
			        <text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"20rpx"}'>{{product.storeupnum}}</text>
			      </view>
			    </view>
			  </view>
			</view>
		</view>
		<!-- 商品推荐 -->
		
		<!-- 商品列表 -->
		<!-- 商品列表 -->
		<!-- 新闻资讯 -->
		<view class="listBox news" :style='{"width":"calc(100% - 72rpx)","margin":"40rpx auto","background":"#fff","order":"4"}'>
			<view class="title" :style='{"padding":"0 24rpx 30rpx","margin":"0","alignItems":"flex-end","background":"url(http://codegen.caihongy.cn/20231227/ef26c4dec0f349e7a9c23dbc022a48d6.png)","display":"flex","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"space-between","height":"148rpx"}'>
				<view :style='{"fontSize":"32rpx","lineHeight":"1","color":"#fff","fontWeight":"bold"}'>校园新闻</view>
				<view :style='{"alignItems":"center","justifyContent":"center","display":"flex"}' @tap="onPageTap('news')">
				  <text :style='{"color":"#fff","fontSize":"28rpx"}'>查看更多</text>
				  <text class="icon iconfont icon-gengduo1" :style='{"color":"#fff","fontSize":"28rpx"}'></text>
				</view>
			</view>
		  <!-- 样式5 -->
		  <view class="news-box2" :style='{"padding":"20rpx","margin":"20rpx 0","overflow":"hidden","borderRadius":"10rpx","background":"#FFF5EF","width":"100%","height":"auto"}'>
			<block v-for="(item,index) in news" :key="index">
			  <view @tap="onNewsDetailTap(item.id)" v-if="index==0" class="list-item" :style='{"padding":"0","margin":"0 0 20rpx","overflow":"hidden","borderRadius":"10rpx","width":"100%","position":"relative","height":"auto"}'>
				<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"370rpx"}' mode="aspectFill" class="listmpic" :src="baseUrl+item.picture"></image>
				<view :style='{"padding":"10rpx 0","left":"0","flexWrap":"wrap","bottom":"0","background":"rgba(0,0,0,.3)","display":"flex","width":"100%","position":"absolute"}'>
					<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#fff","flexWrap":"wrap","display":"flex","width":"100%","lineHeight":"1.5","fontSize":"32rpx","textOverflow":"ellipsis","order":"1"}' class="title">{{item.title}}</view>
					<view :style='{"padding":"0 20rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#fff","width":"100%","lineHeight":"1.5","fontSize":"28rpx","textOverflow":"ellipsis","order":"2"}' class="text">{{item.introduction}}</view>
					<view :style='{"padding":"0 20rpx","display":"none"}'>
					  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
					  <text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.addtime}}</text>
					</view>
					<view :style='{"padding":"0 20rpx","display":"none"}'>
					  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
					  <text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.name}}</text>
					</view>
					<view :style='{"padding":"0 20rpx","display":"inline-block","order":"3"}'>
					  <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
					  <text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.thumbsupnum}}</text>
					</view>
					<view :style='{"padding":"0 20rpx","display":"inline-block","order":"4"}'>
					  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
					  <text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.storeupnum}}</text>
					</view>
					<view :style='{"padding":"0 20rpx","display":"inline-block","order":"5"}'>
					  <text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
					  <text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.clicknum}}</text>
					</view>
				</view>
			  </view>
			  <view @tap="onNewsDetailTap(item.id)" v-if="index>0" class="list-item" :style='{"padding":"40rpx 0","borderColor":"#ccc","margin":"0 0 20rpx 0","display":"flex","overflow":"hidden","borderRadius":"10rpx","flexWrap":"wrap","borderWidth":"0","background":"url(http://codegen.caihongy.cn/20231228/246092dd884d4d53bd5f479a4ab7f7ab.png)","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","borderStyle":"solid","backgroundRepeat":"no-repeat","height":"auto"}'>
				<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"1.5","fontSize":"28rpx","textOverflow":"ellipsis"}' class="title">{{item.title}}</view>
				<view :style='{"padding":"0 20rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#9E9E9E","width":"100%","lineHeight":"2","fontSize":"28rpx","textOverflow":"ellipsis"}' class="text">{{item.introduction}}</view>
				<view :style='{"padding":"0 20rpx","display":"none"}'>
				  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
				  <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.addtime}}</text>
				</view>
				<view :style='{"padding":"0 20rpx","display":"none"}'>
				  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
				  <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.name}}</text>
				</view>
				<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
				  <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#9E9E9E"}'></text>
				  <text :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.thumbsupnum}}</text>
				</view>
				<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
				  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#9E9E9E"}'></text>
				  <text :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.storeupnum}}</text>
				</view>
				<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
				  <text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#9E9E9E"}'></text>
				  <text :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.clicknum}}</text>
				</view>
			  </view>
			</block>
		  </view>
		</view>
		<!-- 新闻资讯 -->
	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
				  'cuIcon-same',
				  'cuIcon-deliver',
				  'cuIcon-evaluate',
				  'cuIcon-shop',
				  'cuIcon-ticket',
				  'cuIcon-cascades',
				  'cuIcon-discover',
				  'cuIcon-question',
				  'cuIcon-pic',
				  'cuIcon-filter',
				  'cuIcon-footprint',
				  'cuIcon-pulldown',
				  'cuIcon-pullup',
				  'cuIcon-moreandroid',
				  'cuIcon-refund',
				  'cuIcon-qrcode',
				  'cuIcon-remind',
				  'cuIcon-profile',
				  'cuIcon-home',
				  'cuIcon-message',
				  'cuIcon-link',
				  'cuIcon-lock',
				  'cuIcon-unlock',
				  'cuIcon-vip',
				  'cuIcon-weibo',
				  'cuIcon-activity',
				  'cuIcon-friendadd',
				  'cuIcon-friendfamous',
				  'cuIcon-friend',
				  'cuIcon-goods',
				  'cuIcon-selection'
				],
                role : '',
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',

				//轮播
				swiperList: [],
				xianzhishangpinIndex2: 0,
				xianzhishangpinCateList2: [],
				xianzhishangpinlist: [],
				news: [],
			}
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
        async onLoad(){
            
        },
		async onShow() {
			this.swiperMenuList = []
			this.role = uni.getStorageSync("appRole");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
			this.menuList.forEach((item,key) => {
			    if(key==0) {
			        item.frontMenu.forEach((item2,key2) => {
			            if(item2.child[0].buttons.indexOf("查看")>-1) {
			                this.swiperMenuList.push(item2);
			            }
			        })
			    }
			})
            // let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.list('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name,
						url: item.url
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			

			// 推荐信息
			if(uni.getStorageSync("appUserid")) {
			    res = await this.$api.page('shangpinfenlei', {page:1,limit:100});
			} else {
			    res = await this.$api.list('shangpinfenlei', {page:1,limit:100});
			}
			res.data.list.splice(0,0,{id:0,shangpinfenlei:'全部'})
			this.xianzhishangpinIndex2 = 0
			this.xianzhishangpinCateList2 = res.data.list
			this.getRecommendList()
			this.getHomeList()
			this.getNewsList()
		},
		methods: {
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			newsTabClick2(index){
				this.newsIndex2 = index
				this.getNewsList()
			},
			async getNewsList(){
				let res;
				let params = {
					page: 1,
					limit: 6,
					sort: 'id',
					order: 'desc',
				}
				// 校园新闻
				res = await this.$api.list('news', params)
				this.news = res.data.list
			},
			homeTabClick2(index,name){
				this['home' + name + 'Index2'] = index
				this.getHomeList()
			},
			async getHomeList(){
				let res;
				let params;
			},
			recommendTabClick2(index,name){
				this[name + 'Index2'] = index
				this.getRecommendList()
			},
			async getRecommendList(){
				let res;
				let params;
				// 推荐信息
				params = {
					page: 1,
					limit: 6,
                    sfsh: '是',
				}
				if(this.xianzhishangpinIndex2){
					params.shangpinfenlei = this.xianzhishangpinCateList2[this.xianzhishangpinIndex2].shangpinfenlei
				}
				if(uni.getStorageSync("appUserid")) {
					res = await this.$api.recommend2('xianzhishangpin', params);
				} else {
					res = await this.$api.recommend('xianzhishangpin', params);
				}
				this.xianzhishangpinlist = res.data.list
				

			},
			//轮播图跳转
			onSwiperTap(e) {
				if(e.url) {
					if (e.url.indexOf('https') != -1) {
						window.open(e.url)
					} else {
						this.$utils.jump(e.url)
					}
				}
			},
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(url) {
                uni.setStorageSync("useridTag",0);
                uni.navigateTo({
                    url: url,
                    fail: function() {
                        uni.switchTab({
                            url: url
                        });
                    }
                });
            }
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.recommend {
		.style2 {
			.tabView {
				.tab {
					border: 2rpx solid #FF9257;
					border-radius: 40rpx;
					padding: 0 10rpx;
					margin: 0 10rpx 10rpx;
					color: #FF9257;
					background: none;
				}
				.tabActive {
					border: 2rpx solid #FF9257;
					border-radius: 40rpx;
					padding: 0 10rpx;
					margin: 0 10rpx 10rpx;
					color: #fff;
					background: #FF9257;
				}
			}
		}
	}

</style>
