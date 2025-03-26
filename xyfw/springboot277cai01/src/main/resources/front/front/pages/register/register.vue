<template>
<view class="content">
	<view class="box" :style='{"padding":"0px","background":"url(http://codegen.caihongy.cn/20231227/70f0e0886ddd46659b308fea012f9b75.gif)","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"top center","backgroundRepeat":"no-repeat","height":"auto"}'>
		<view :style='{"padding":"24rpx 48rpx 0 0","flexWrap":"wrap","display":"flex","width":"100%","position":"relative","justifyContent":"center","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"block","height":"160rpx"}' src="http://codegen.caihongy.cn/20231227/e3ace86e0e3d40edafe8dee4570484df.png" mode="aspectFill"></image>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<view :style='{"width":"220rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#9c9c9c","textAlign":"right"}' class="label">学号：</view>
				<input :style='{"border":"4rpx solid #FF7B53","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 4rpx","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.xuehao"  type="text"  class="uni-input" name="" placeholder="学号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<view :style='{"width":"220rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#9c9c9c","textAlign":"right"}' class="label">密码：</view>
				<input :style='{"border":"4rpx solid #FF7B53","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 4rpx","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<view :style='{"width":"220rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#9c9c9c","textAlign":"right"}' class="label">确认密码：</view>
				<input :style='{"border":"4rpx solid #FF7B53","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 4rpx","fontSize":"28rpx","height":"88rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" @tap="xueshengtouxiangTap" class="">
				<view :style='{"width":"220rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#9c9c9c","textAlign":"right"}' class="label">头像：</view>
				<image :style='{"width":"160rpx","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<view :style='{"width":"220rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#9c9c9c","textAlign":"right"}' class="label">姓名：</view>
				<input :style='{"border":"4rpx solid #FF7B53","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 4rpx","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.xingming"  type="text"  class="uni-input" name="" placeholder="姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="">
				<view :style='{"width":"220rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#9c9c9c","textAlign":"right"}' class="label">性别：</view>
				<picker :style='{"border":"4rpx solid #FF7B53","width":"calc(100% - 220rpx)","margin":"0 0 24rpx 0","borderWidth":"0 0 4rpx","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'"  @change="xueshengxingbieChange" :value="xueshengxingbieIndex" :range="xueshengxingbieOptions">
					<view>
						<view :style='{"padding":"0 10rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#000","flex":"1"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<view :style='{"width":"220rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#9c9c9c","textAlign":"right"}' class="label">学院：</view>
				<input :style='{"border":"4rpx solid #FF7B53","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 4rpx","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.xueyuan"  type="text"  class="uni-input" name="" placeholder="学院" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<view :style='{"width":"220rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#9c9c9c","textAlign":"right"}' class="label">邮箱：</view>
				<input :style='{"border":"4rpx solid #FF7B53","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 4rpx","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.youxiang"  type="text"  class="uni-input" name="" placeholder="邮箱" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<view :style='{"width":"220rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#9c9c9c","textAlign":"right"}' class="label">手机：</view>
				<input :style='{"border":"4rpx solid #FF7B53","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 4rpx","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.shouji"  type="text"  class="uni-input" name="" placeholder="手机" />
			</view>
			<button :style='{"border":"0","padding":"0px","boxShadow":"inset 0px 4rpx 10rpx 0px rgba(0,0,0,0.3)","margin":"0 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"50%","background":"linear-gradient(180deg, #FF5A4E 0%, #FF9D68 100%)","width":"200rpx","lineHeight":"200rpx","fontSize":"36rpx","fontWeight":"bold","height":"200rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                xueshengxingbieOptions: [],
                xueshengxingbieIndex: 0,
				ruleForm: {
                xuehao: '',
                mima: '',
                touxiang: '',
                xingming: '',
                xingbie: '',
                xueyuan: '',
                youxiang: '',
                shouji: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='xuesheng'){
                this.xueshengxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.xueshengxingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            xueshengtouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },
            // 下拉变化
            xueshengxingbieChange(e) {
                    this.xueshengxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.xueshengxingbieOptions[this.xueshengxingbieIndex]
            },

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
				if((!this.ruleForm.xuehao) && `xuesheng` == this.tableName){
					this.$utils.msg(`学号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `xuesheng` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`xuesheng` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.xingming) && `xuesheng` == this.tableName){
					this.$utils.msg(`姓名不能为空`);
					return
				}
				if((!this.ruleForm.xueyuan) && `xuesheng` == this.tableName){
					this.$utils.msg(`学院不能为空`);
					return
				}
				if(`xuesheng` == this.tableName && this.ruleForm.youxiang&&(!this.$validate.isEmail(this.ruleForm.youxiang))){
					this.$utils.msg(`邮箱应输入邮件格式`);
					return
				}
				if(`xuesheng` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
