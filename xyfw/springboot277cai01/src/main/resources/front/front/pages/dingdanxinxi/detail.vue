
<template>
<view>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view class="container" :style='{"padding":"0 36rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","position":"relative","height":"100%"}'>
						<swiper :style='{"boxShadow":"0 4rpx 10rpx rgba(0,0,0,.3)","overflow":"hidden","borderRadius":"10rpx","background":"#fff","width":"100%","height":"360rpx","order":"1"}' class="swiper" :indicator-dots='false' :autoplay='false' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
				<swiper-item :style='{"width":"100%","background":"#fff","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index">
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" v-if="swiper.substring(0,4)=='http'" :src="swiper"></image>
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" v-else :src="baseUrl+swiper"></image>
				</swiper-item>
			</swiper>
												            <view :style='{"padding":"0","flexWrap":"wrap","background":"#FFF5EF","display":"flex","width":"100%","height":"auto","order":"2"}' class="detail-content">

				<view :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderWidth":"0","background":"#FFF5EF","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}' class="detail-list-item title">
					<view :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="lable">订单编号：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}' class="text">{{detail.dingdanbianhao}}</view>
				</view>
				<view :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderWidth":"0","background":"#FFF5EF","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}' class="detail-list-item title">
					<view :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="lable">商品名称：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}' class="text">{{detail.shangpinmingcheng}}</view>
				</view>
				<view :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderWidth":"0","background":"#FFF5EF","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}' class="detail-list-item title">
					<view :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="lable">商品分类：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}' class="text">{{detail.shangpinfenlei}}</view>
				</view>
				<view :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderWidth":"0","background":"#FFF5EF","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}' class="detail-list-item title">
					<view :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="lable">总价格：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}' class="text">{{detail.zongjiage}}</view>
				</view>

				<view class="detail-list-item" :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderWidth":"0","background":"#FFF5EF","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>价格：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}'>{{detail.jiage}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderWidth":"0","background":"#FFF5EF","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>购买数量：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}'>{{detail.shuliang}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderWidth":"0","background":"#FFF5EF","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>下单时间：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}'>{{detail.xiadanshijian}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderWidth":"0","background":"#FFF5EF","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>学号：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}'>{{detail.xuehao}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderWidth":"0","background":"#FFF5EF","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>学号：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}'>{{detail.yonghuzhanghao}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderWidth":"0","background":"#FFF5EF","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>购买人：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}'>{{detail.goumairen}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderWidth":"0","background":"#FFF5EF","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>用户手机：</view>
					<view style="text-decoration: underline" @tap="callClick(detail.yonghushouji)"  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}'>{{detail.yonghushouji}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderWidth":"0","background":"#FFF5EF","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"2"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>交易地址：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}'>{{detail.jiaoyidizhi}}</view>
				</view>








				<view class="bottom-content bg-white tabbar border shop" :style='{"padding":"10rpx 24rpx","alignItems":"center","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto","order":"6"}'>

					<button :style='{"border":"0","padding":"0 40rpx","margin":"0 10rpx 10rpx","color":"#000","borderRadius":"60rpx","background":"#FF9257","width":"auto","fontSize":"28rpx","lineHeight":"60rpx","height":"60rpx"}' @tap="onPayTap" v-if="userid&&isAuth('dingdanxinxi','支付') && detail.ispay!='已支付'"  class="cu-btn bg-brown round shadow-blur">支付</button>
					<button :style='{"border":"0","padding":"0 40rpx","margin":"0 10rpx 10rpx","color":"#000","borderRadius":"60rpx","background":"#FF9257","width":"auto","fontSize":"28rpx","lineHeight":"60rpx","height":"60rpx"}' @tap="onPayTap" v-if="!userid&&isAuthFront('dingdanxinxi','支付') && detail.ispay!='已支付'"  class="cu-btn bg-brown round shadow-blur">支付</button>
					<button :style='{"border":"0","padding":"0 40rpx","margin":"0 10rpx 10rpx","color":"#000","borderRadius":"60rpx","background":"#FF9257","width":"auto","fontSize":"28rpx","lineHeight":"60rpx","height":"60rpx"}' v-if="!isAuth('dingdanxinxi','支付') && detail.ispay!='已支付'" class="cu-btn bg-brown round shadow-blur">未支付</button>
					<button :style='{"border":"0","padding":"0 40rpx","margin":"0 10rpx 10rpx","color":"#000","borderRadius":"60rpx","background":"#FF9257","width":"auto","fontSize":"28rpx","lineHeight":"60rpx","height":"60rpx"}' v-if="detail.ispay=='已支付'"  class="cu-btn bg-brown round shadow-blur">已支付</button>
					<button :style='{"border":"0","padding":"0 40rpx","margin":"0 10rpx 10rpx","color":"#000","borderRadius":"60rpx","background":"#FF9157","width":"auto","fontSize":"28rpx","lineHeight":"60rpx","height":"60rpx"}' v-if="userid&&isAuth('dingdanxinxi','私聊')" @tap="chatClick">联系TA</button>
					<button :style='{"border":"0","padding":"0 40rpx","margin":"0 10rpx 10rpx","color":"#000","borderRadius":"60rpx","background":"#FF9157","width":"auto","fontSize":"28rpx","lineHeight":"60rpx","height":"60rpx"}' v-if="!userid&&isAuthFront('dingdanxinxi','私聊')" @tap="chatClick">联系TA</button>
					
				</view>
			</view>
		</view>
	</view>
</mescroll-uni>
</view>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				id: '',
                userid: '',
				detail: {},
				swiperList: [],
				commentList: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				user: {},
				count: 0,
				timer: null,
				title:'',
			}
		},
		components: {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(options) {
			// #ifdef APP-PLUS
			let page = getCurrentPages()
			this.href = this.baseUrl + 'front/h5/#/' + page[page.length - 1].route
			// #endif
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.id = options.id;
            if(options.userid) {
                this.userid = options.userid;
            }
			// 渲染数据
			this.init();
		},
		// #ifdef MP-WEIXIN
		onShareAppMessage(){
			var obj = {
				title: this.title,
				imageUrl: this.swiperList[0]?this.baseUrl + this.swiperList[0]: ''
			}
			return obj
		},
		// #endif
        onUnload() {
            if(this.timer) {
                clearInterval(this.timer);
            }
        },
		async onShow(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			let crossCleanType = uni.getStorageSync('crossCleanType')
            if(crossCleanType) {
				uni.removeStorageSync('crossCleanType')
                res = await this.$api.info('dingdanxinxi', this.id);
                this.detail = res.data;
				this.title = this.detail.dingdanbianhao
            }
			let payType = uni.getStorageSync('payType')
			if(payType){
				uni.removeStorageSync('payType')
				this.mescroll.num = 1
				this.upCallback(this.mescroll)
				this.init();
			}
		},
		destroyed: function() {
			//window.clearInterval(this.inter);
		},
		methods: {
			// 拨打电话
			callClick(row){
				uni.makePhoneCall({
					phoneNumber: row
				})
			},
			// 支付
			onPayTap(){
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				uni.setStorageSync('paytable','dingdanxinxi');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
            onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
                this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
            },
			// 跨表
			async onAcrossTap(tableName,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue,type=1){
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				if(crossOptPay=='是'&&this.detail.ispay!='已支付') {
					this.$utils.msg('请支付完成再操作')
					return
				}
				uni.setStorageSync('crossTable','dingdanxinxi');
				uni.setStorageSync(`crossObj`, this.detail);
				uni.setStorageSync(`statusColumnName`, statusColumnName);
				uni.setStorageSync(`statusColumnValue`, statusColumnValue);
				uni.setStorageSync(`tips`, tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = uni.getStorageSync('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$utils.msg(tips);
							return
						}
					}
				}
				this.$utils.jump(`../${tableName}/add-or-update?cross=true`);
			},
			// 获取详情
			async init(type=1){
                if(this.timer) {
                    clearInterval(this.timer);
                }
				let res = await this.$api.info('dingdanxinxi', this.id);
				this.detail = res.data;

				this.title = this.detail.dingdanbianhao
				// 轮播图片
				this.swiperList = this.detail.tupian ? this.detail.tupian.split(",") : [];
				

				if(type==2){
					this.detail.discussnum++
					await this.$api.update('dingdanxinxi',this.detail)
				}
			},
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				mescroll.endSuccess(mescroll.size, this.hasNext);

            },



			onChatTap() {
				this.$utils.jump('../chat/chat')
			},
			// 下载
			download(url){
				let _this = this;
				url=_this.$base.url +  url;
				uni.downloadFile({
					url: url,
					success: (res) => {
						if (res.statusCode === 200) {
							_this.$utils.msg('下载成功');
							 window.open(url);
						}
					}
				});
			},
			//
			onCartTabTap() {
				this.$utils.tab('../shop-cart/shop-cart')
			},
		}
	}
</script>

<style lang="scss">
	page {
	  --animate-duration: 1s;
	  --animate-delay: 1s;
	  --animate-repeat: 1;
	}
	
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.seat-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		background: #FFFFFF;
		margin: 20upx;
		border-radius: 20upx;
		padding: 20upx;
		font-size: 30upx;
		.seat-item {
			width: 33.33%;
			display: flex;
			align-items: center;
			flex-direction: column;
			margin-bottom: 20upx;
	
			.seat-icon {
				width: 50upx;
				height: 50upx;
				margin-bottom: 10upx;
			}
		}
	}
	
	audio {
		display: flex;
		flex-direction: column;
	}
	
	.audio /deep/ .uni-audio-default {
		width: inherit;
	}
	

</style>
