<template>
<!-- category 1 -->
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view :style='{"padding":"0","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","position":"relative","height":"100%"}'>
			<view class="cu-bar bg-white search" :style='{"width":"calc(100% - 72rpx)","padding":"20rpx 0","margin":"0 auto","background":"#fff","display":"flex","height":"auto"}'>
				<picker v-if="queryList.length>1" mode="selector" :range="queryList" range-key="queryName" :value="queryIndex" @change="queryChange">
					<view :style='{"width":"40rpx","height":"auto"}'>
						<text class="icon iconfont icon-jiantou18" :style='{"width":"40rpx","fontSize":"40rpx","lineHeight":"80rpx","color":"#000"}'></text>
					</view>
				</picker>
				<view :style='{"margin":"0 0 0 12rpx","flex":"1","position":"relative"}' v-if="queryIndex==0" class="search-form round">
					<text class="icon iconfont icon-fangdajing07" :style='{"color":"#8C8C8C","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
					<input :style='{"border":"2rpx solid #000","padding":"12rpx 20rpx 12rpx 80rpx","color":"#333","borderRadius":"10rpx","background":"#F8F8F8","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.dingdanbianhao" type="text" placeholder="订单编号" ></input>
				</view>
				<view :style='{"margin":"0 0 0 12rpx","flex":"1","position":"relative"}' v-if="queryIndex==1" class="search-form round">
					<text class="icon iconfont icon-fangdajing07" :style='{"color":"#8C8C8C","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
					<input :style='{"border":"2rpx solid #000","padding":"12rpx 20rpx 12rpx 80rpx","color":"#333","borderRadius":"10rpx","background":"#F8F8F8","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.shangpinmingcheng" type="text" placeholder="商品名称" ></input>
				</view>
				<view :style='{"margin":"0 0 0 12rpx","flex":"1","position":"relative"}' v-if="queryIndex==2" class="search-form round">
					<text class="icon iconfont icon-fangdajing07" :style='{"color":"#8C8C8C","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
					<input :style='{"border":"2rpx solid #000","padding":"12rpx 20rpx 12rpx 80rpx","color":"#333","borderRadius":"10rpx","background":"#F8F8F8","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.shangpinfenlei" type="text" placeholder="商品分类" ></input>
				</view>
				<button :style='{"border":"0","padding":"0px","margin":"0 0 0 -136rpx","color":"#fff","borderRadius":"10rpx","background":"#000","width":"136rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx","zIndex":"1"}' @tap="search" class="cu-btn shadow-blur round">搜索</button>
			</view>
			

			<view :style='{"padding":"10rpx 0","margin":"20rpx auto 0","borderRadius":"30rpx 30rpx 0 0","flexWrap":"wrap","background":"linear-gradient(134deg, #FF6C53 0%, #FF9257 100%)","display":"flex","width":"calc(100% - 72rpx)","justifyContent":"center"}'>
				<view @click="sortClick('addtime')" :style='{"border":"0","padding":"0 12rpx","margin":"0 8rpx 0 0","outline":"0","borderRadius":"8rpx","background":"none","display":"flex"}'>
					<text :style='{"lineHeight":"48rpx","fontSize":"24rpx","color":"#000","fontWeight":"bold"}'>按日期</text>
					<text v-if="listSort!='addtime'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 8rpx","lineHeight":"48rpx","fontSize":"24rpx","color":"#000","fontWeight":"bold"}'></text>
					<text v-else-if="listSort=='addtime'&&listOrder=='asc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 8rpx","lineHeight":"48rpx","fontSize":"24rpx","color":"#000","fontWeight":"bold"}'></text>
					<text v-else-if="listSort=='addtime'&&listOrder=='desc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 8rpx","lineHeight":"48rpx","fontSize":"24rpx","color":"#000","fontWeight":"bold"}'></text>
				</view>
			</view>
			<view :style='{"width":"100%","background":"#fff","height":"auto"}'>
			
			
			

				<view id="list-box7" class="list-box7 waterfall-body" :style='{"padding":"20rpx 24rpx 0","margin":"0 auto","alignItems":"flex-start","background":"#FFF5EF","display":"flex","width":"calc(100% - 72rpx)","height":"auto"}'>
					<view id="waterfall-left-column-list-6" class="waterfall-column-list-6" :style='{"margin":"0 12rpx 0 0","flex":"1","flexDirection":"column","display":"flex"}'>
						<view @tap="onDetailTap(product)" :style='{"boxShadow":"none","margin":"0 0 20rpx 0","overflow":"hidden","position":"relative","borderRadius":"12rpx"}' v-for="product in leftListList6" :key="product.id" class="left-content">
							<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-if="preHttp(product.tupian)" :src="product.tupian"></image>
							<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-else :src="product.tupian?baseUrl+product.tupian.split(',')[0]:''"></image>
							<view :style='{"width":"100%","flexWrap":"wrap","background":"#FF9257","display":"flex"}'>
								<view :style='{"width":"100%","padding":"0 10rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#fff","order":"1"}' class="title ">{{product.dingdanbianhao}}</view>
								<view :style='{"width":"100%","padding":"0 10rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#fff","order":"1"}' class="title ">{{product.shangpinmingcheng}}</view>
								<view :style='{"width":"100%","padding":"0 10rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#fff","order":"1"}' class="title ">{{product.shangpinfenlei}}</view>
								<view :style='{"width":"100%","padding":"0 10rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#fff","order":"1"}' class="title ">总价格：{{product.zongjiage}}</view>
								<view :style='{"width":"100%","padding":"0 10rpx","order":"6"}'>
									<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"20rpx","color":"#fff"}'></text>
									<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"20rpx"}'>{{product.addtime}}</text>
								</view>
								<view :style='{"padding":"0 10rpx","display":"inline-block","order":"4"}'>
									<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"20rpx","color":"#fff"}'></text>
									<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"20rpx"}'>{{product.yonghuzhanghao}}</text>
								</view>
							</view>
							<!-- #ifdef MP-WEIXIN -->
							<view :style='{"width":"100%","padding":"8rpx 20rpx","background":"#FF9257","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('dingdanxinxi','修改')) || (!userid && isAuthFront('dingdanxinxi','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}' class="cuIcon-edit"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}'>修改</text>
								</view>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('dingdanxinxi','删除')) || (!userid && isAuthFront('dingdanxinxi','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}' class="cuIcon-delete"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}'>删除</text>
								</view>
							</view>
							<!-- #endif -->
							<!-- #ifndef MP-WEIXIN -->
							<view :style='{"width":"100%","padding":"8rpx 20rpx","background":"#FF9257","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('dingdanxinxi','修改')) || (!userid && isAuthFront('dingdanxinxi','修改'))" @tap.stop.proevent="onUpdateTap(product)">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}' class="cuIcon-edit"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}'>修改</text>
								</view>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('dingdanxinxi','删除')) || (!userid && isAuthFront('dingdanxinxi','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}' class="cuIcon-delete"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}'>删除</text>
								</view>
							</view>
							<!-- #endif -->
						</view>
					</view>
					
					<view id="waterfall-right-column-list-6" class="waterfall-column-list-6" :style='{"margin":"0 0 0 12rpx","flex":"1","flexDirection":"column","display":"flex"}'>
						<view @tap="onDetailTap(product)" :style='{"boxShadow":"none","margin":"0 0 20rpx 0","overflow":"hidden","position":"relative","borderRadius":"12rpx"}' v-for="product in rightListList6" :key="product.id" class="right-content">
							<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-if="preHttp(product.tupian)" :src="product.tupian"></image>
							<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-else :src="product.tupian?baseUrl+product.tupian.split(',')[0]:''"></image>

							<view :style='{"width":"100%","flexWrap":"wrap","background":"#FF9257","display":"flex"}'>
								<view :style='{"width":"100%","padding":"0 10rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#fff","order":"1"}' class="title ">{{product.dingdanbianhao}}</view>
								<view :style='{"width":"100%","padding":"0 10rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#fff","order":"1"}' class="title ">{{product.shangpinmingcheng}}</view>
								<view :style='{"width":"100%","padding":"0 10rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#fff","order":"1"}' class="title ">{{product.shangpinfenlei}}</view>
								<view :style='{"width":"100%","padding":"0 10rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#fff","order":"1"}' class="title ">总价格：{{product.zongjiage}}</view>
								<view :style='{"width":"100%","padding":"0 10rpx","order":"6"}'>
									<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"20rpx","color":"#fff"}'></text>
									<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"20rpx"}'>{{product.addtime}}</text>
								</view>
								<view :style='{"padding":"0 10rpx","display":"inline-block","order":"4"}'>
									<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"20rpx","color":"#fff"}'></text>
									<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"20rpx"}'>{{product.yonghuzhanghao}}</text>
								</view>
							</view>
							<!-- #ifdef MP-WEIXIN -->
							<view :style='{"width":"100%","padding":"8rpx 20rpx","background":"#FF9257","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('dingdanxinxi','修改')) || (!userid && isAuthFront('dingdanxinxi','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}' class="cuIcon-edit"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}'>修改</text>
								</view>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('dingdanxinxi','删除')) || (!userid && isAuthFront('dingdanxinxi','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}' class="cuIcon-delete"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}'>删除</text>
								</view>
							</view>
							<!-- #endif -->
							<!-- #ifndef MP-WEIXIN -->
							<view :style='{"width":"100%","padding":"8rpx 20rpx","background":"#FF9257","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('dingdanxinxi','修改')) || (!userid && isAuthFront('dingdanxinxi','修改'))" @tap.stop.proevent="onUpdateTap(product)">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}' class="cuIcon-edit"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}'>修改</text>
								</view>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('dingdanxinxi','删除')) || (!userid && isAuthFront('dingdanxinxi','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}' class="cuIcon-delete"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#fff","display":"inline-block"}'>删除</text>
								</view>
							</view>
							<!-- #endif -->
						</view>
					</view>
				</view>
			

			</view>
			
			
			
		</view>

		<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"40rpx","right":"8rpx","outline":"none","borderRadius":"100%","background":"#FF9257","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="userid && isAuth('dingdanxinxi','新增')" class="add-btn" @click="onAddTap()">新增</button>
		<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"40rpx","right":"8rpx","outline":"none","borderRadius":"100%","background":"#FF9257","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="!userid && isAuthFront('dingdanxinxi','新增')" class="add-btn" @click="onAddTap()">新增</button>
	</view>
</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				leftListList6: [],
				rightListList6: [],
				tempListList6: [],
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				queryList:[
					{
						queryName:"订单编号",
					},
					{
						queryName:"商品名称",
					},
					{
						queryName:"商品分类",
					},
				],
				queryIndex: 0,
				list: [],
				lists: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{},
				CustomBar: '0',
				listSort: 'xiadanshijian',
				listOrder: 'desc',
			};
		},
		watch: {
			copyFlowListList6(nVal, oVal) {
				this.tempListList6 = this.cloneData(this.copyFlowListList6);
				this.splitDataList6();
			},
		},
		mounted() {
			this.tempListList6 = this.cloneData(this.copyFlowListList6);
			this.splitDataList6();
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
			copyFlowListList6() {
				return this.cloneData(this.list);
			},
		},
		async onShow() {
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.hasNext = true
			// 重新加载数据
			this.leftListList6 = []
			this.rightListList6 = []
			this.tempListList6 = []
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		onLoad(options) {
            if(options.userid) {
                this.userid=options.userid;
            } else {
                this.userid = "";
            }
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		components: {
		},
		methods: {
			async splitDataList6() {
				if (!this.tempListList6.length) return;
				let leftRect = await this.uGetRect('#waterfall-left-column-list-6');
				let rightRect = await this.uGetRect('#waterfall-right-column-list-6');
				// 如果左边小于或等于右边，就添加到左边，否则添加到右边
				let item = this.tempListList6[0];
				// 解决多次快速上拉后，可能数据会乱的问题，因为经过上面的两个await节点查询阻塞一定时间，加上后面的定时器干扰
				// 数组可能变成[]，导致此item值可能为undefined
				if (!item) return;
				
				if (leftRect.height < rightRect.height) {
					this.leftListList6.push(item);
				} else if (leftRect.height > rightRect.height) {
					this.rightListList6.push(item);
				} else {
					// 这里是为了保证第一和第二张添加时，左右都能有内容
					// 因为添加第一张，实际队列的高度可能还是0，这时需要根据队列元素长度判断下一个该放哪边
					if (this.leftListList6.length <= this.rightListList6.length) {
						this.leftListList6.push(item);
					} else {
						this.rightListList6.push(item);
					}
				}
				// 移除临时列表的第一项
				this.tempListList6.splice(0, 1);
				// 如果临时数组还有数据，继续循环
				if (this.tempListList6.length) {
					setTimeout(()=>{
						this.splitDataList6();
					}, 100)
					return
				}
			},
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
			sortClick(type){
				if(this.listSort==type){
					if(this.listOrder == 'desc'){
						this.listOrder = 'asc'
					}else{
						this.listOrder = 'desc'
					}
				}else{
					this.listSort = type
					this.listOrder = 'desc'
				}
				this.search()
			},
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//查询条件切换
			queryChange(e) {
				this.queryIndex=e.detail.value;
				this.searchForm.dingdanbianhao="";
				this.searchForm.shangpinmingcheng="";
				this.searchForm.shangpinfenlei="";
			},
			//类别搜索
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size
				}
				params['sort'] = this.listSort;
				params['order'] = this.listOrder;

				if(this.searchForm.dingdanbianhao){
					params['dingdanbianhao'] = '%' + this.searchForm.dingdanbianhao + '%'
				}
				if(this.searchForm.shangpinmingcheng){
					params['shangpinmingcheng'] = '%' + this.searchForm.shangpinmingcheng + '%'
				}
				if(this.searchForm.shangpinfenlei){
					params['shangpinfenlei'] = '%' + this.searchForm.shangpinfenlei + '%'
				}
				let user = uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`dingdanxinxi`, params);
                } else {
                    res = await this.$api.list(`dingdanxinxi`, params);
                }

				// 如果是第一页数据置空
				if (mescroll.num == 1){
					this.leftListList6 = []
					this.rightListList6 = []
					this.tempListList6 = []
				}
				this.list = res.data.list;
				this.$forceUpdate()
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
				this.tempListList6 = this.copyFlowListList6;
				this.splitDataList6();
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			onUpdate(e){
				this.onUpdateTap(e.currentTarget.dataset.row)
			},
			// 修改
			onUpdateTap(row){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${row.id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDelete(e){
				this.onDeleteTap(e.currentTarget.dataset.row.id)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('dingdanxinxi', JSON.stringify([id]));
							_this.$utils.msg('删除成功');
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.search()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				this.leftListList6 = []
				this.rightListList6 = []
				this.tempListList6 = []
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size
				}
				searchForm['sort'] = this.listSort;
				searchForm['order'] = this.listOrder;

				if(this.searchForm.dingdanbianhao){
					searchForm['dingdanbianhao'] = '%' + this.searchForm.dingdanbianhao + '%'
				}
				if(this.searchForm.shangpinmingcheng){
					searchForm['shangpinmingcheng'] = '%' + this.searchForm.shangpinmingcheng + '%'
				}
				if(this.searchForm.shangpinfenlei){
					searchForm['shangpinfenlei'] = '%' + this.searchForm.shangpinfenlei + '%'
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`dingdanxinxi`, searchForm);
                } else {
                    res = await this.$api.list(`dingdanxinxi`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
			}
		}
	};
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.category-one .tab {
		cursor: pointer;
		padding: 0 20rpx;
		margin: 0 10rpx;
		color: #fff;
		background: none;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 60rpx;
	}
	
	.category-one .tab.active {
		cursor: pointer;
		border: 2rpx solid #000;
		padding: 0 20rpx;
		color: #FF9257;
		background: #fff;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		border-width: 2rpx 0 0;
		line-height: 60rpx;
	}
	
	.category-two .tab {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: blue;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	
	.category-two .tab.active {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: #000;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	
	.category-three .tab {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: burlywood;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	
	.category-three .tab.active {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: #000;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
</style>
