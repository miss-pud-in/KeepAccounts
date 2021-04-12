<template>
	<div class="login-register">
		<div class="contain">
			<div class="big-box" :class="{active:isLogin}">
				<div class="big-contain" v-if="isLogin">
					<div class="btitle">账户登录

					</div>
					<div class="bform">
						
                        <el-form ref="form" :model="form" label-width="80px">
  							<el-form-item label="用户名">
    							<el-input v-model="form.username"></el-input>
  							</el-form-item>
  							<el-form-item label="密码">
    							<el-input type="password" v-model="form.userpwd"></el-input>
  							</el-form-item>
                        </el-form>
						
					</div>
					<button class="bbutton" @click="login">登录</button>

				</div>
				<div class="big-contain" v-else>
					<div class="btitle">创建账户</div>
					<div class="bform">	
                        <el-form ref="form" :model="form" label-width="80px">
  							<el-form-item label="用户名">
    							<el-input v-model="form.username"></el-input>
  							</el-form-item>
  							<el-form-item label="密码">
    							<el-input type="password" v-model="form.userpwd"></el-input>
  							</el-form-item>
							<el-form-item label="确认密码">
    							<el-input type="password" v-model="form.userpwdtwo"></el-input>
  							</el-form-item>
                        </el-form>
					</div>
					<button class="bbutton" @click="register">注册</button>
						<!--<span v-for="(item,i) in form.list" :key="i">{{item.id}},{{item.name}}
						</span>-->
				</div>
			</div>
			<div class="small-box" :class="{active:isLogin}">
				<div class="small-contain" v-if="isLogin">
					<div class="stitle">你好，朋友!</div>
					<p class="scontent">开始注册，和我们一起旅行</p>
					<button class="sbutton" @click="changeType">注册</button>
				</div>
				<div class="small-contain" v-else>
					<div class="stitle">欢迎回来!</div>
					<p class="scontent">与我们保持联系，请登录你的账户</p>
					<button class="sbutton" @click="changeType">登录</button>
				</div>
			</div>
		</div>
		
	</div>
</template>

<script>
import Qs from 'qs';
	export default{
		name:'login-register',
		props: {
      //接收父组件传来的值
      comName: String
    },

		data(){
			return {
				isLogin:true,
				passwordError: false,
				existed: false,
				form:{
					username:'',
					userpwd:'',
					userpwdtwo:'',
					//list:[],
					//datas:'',
				},
			}
		},
		mounted(){
			//this.update();//在html加载完成后进行，相当于在页面上同步显示后端数据
		},
		methods:{
			/*
			update(){
				this.axios({
        				method: 'post',
        				url: '/api/user/getUser/',
      				})
					.then( res => {
						this.form.datas=res;
						this.form.list=res.data;
						})
			},*/
			changeType() {
				this.isLogin = !this.isLogin
				this.form.username = ''
				this.form.userpwd = ''
				this.form.userpwdtwo=''
			},
			login() {
				const that = this;
				if (that.form.username != "" && that.form.userpwd != "") {
					const mydata = {
        				username: that.form.username,
        				password: that.form.userpwd
      				}
					that.axios({
        				method: 'post',
        				url: '/api/user/loginIn/',
        				data: Qs.stringify(mydata)
      				})
					.then( res => {
						if(res.data=="2"){
							this.$message({
          					message: '登录成功',
          					type: 'success'
        					});
							sessionStorage.setItem('username',that.form.username);
							this.$emit("changeComponent1Data", "first-view",false);
						}
						else if(res.data=="1"){
							this.$message.error('密码错误！');
						}
						else
							this.$message.error('用户名不存在！');
						})
				} else{
					this.$message('用户名/密码不能为空');
				}
			},
			register(){
				const that = this;
				if(that.form.username != ""   && that.form.userpwd != ""&&that.form.userpwdtwo!=""){
					if(that.form.userpwd==that.form.userpwdtwo){
						const mydata = {
        				username: that.form.username,
        				password: that.form.userpwd
      				}
					that.axios({
        				method: 'post',
        				url: '/api/user/register/',
        				data: Qs.stringify(mydata)
      				})
					.then( res => {
						if(res.data=="1"){
							this.$message({
          					message: '注册成功',
          					type: 'success'
        					});
							//this.update();
							this.isLogin = !this.isLogin;
						}
						else
							this.$message.error('用户名已存在！');
						})
					}
					else{
						this.$message('两次密码输入必须一致！');
					}
				} else {
					this.$message('用户名/密码不能为空');
				}
			}
		}
	}

</script>

<style scoped="scoped">
	.login-register{
		width: 90vw;
		height: 90vh;
		box-sizing: border-box;
	}
	.contain{
		width: 800px;
		height: 500px;
		position: relative;
		top: 50%;
		left: 55%;
		transform: translate(-50%,-50%);
		background-color: #fff;
		border-radius: 20px;
		box-shadow: 0 0 3px #f0f0f0,
					0 0 6px #f0f0f0;
	}
	.big-box{
		width: 70%;
		height: 100%;
		position: absolute;
		top: 0;
		left: 30%;
		transform: translateX(0%);
		transition: all 1s;
	}
	.big-contain{
		width: 100%;
		height: 100%;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	.btitle{
		font-size: 1.5em;
		font-weight: bold;
		color: pink;
	}
	.bform{
		width: 100%;
		height: 40%;
		padding: 2em 0;
		display: flex;
		flex-direction: column;
		justify-content: space-around;
		align-items: center;
	}
	.bform .errTips{
		display: block;
		width: 50%;
		text-align: left;
		color: red;
		font-size: 0.7em;
		margin-left: 1em;
	}
	.bform input{
		width: 50%;
		height: 50px;
		border: none;
		outline: none;
		border-radius: 10px;
		padding-left: 2em;
		background-color: #f0f0f0;
	}
	.bbutton{
		width: 20%;
		height: 40px;
		border-radius: 24px;
		border: none;
		outline: none;
		background-color: pink;
		color: #fff;
		font-size: 0.9em;
		cursor: pointer;
	}
	.small-box{
		width: 30%;
		height: 100%;
		background: linear-gradient(135deg,pink,pink);
		position: absolute;
		top: 0;
		left: 0;
		transform: translateX(0%);
		transition: all 1s;
		border-top-left-radius: inherit;
		border-bottom-left-radius: inherit;
	}
	.small-contain{
		width: 100%;
		height: 100%;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	.stitle{
		font-size: 1.5em;
		font-weight: bold;
		color: #fff;
	}
	.scontent{
		font-size: 0.8em;
		color: #fff;
		text-align: center;
		padding: 2em 4em;
		line-height: 1.7em;
	}
	.sbutton{
		width: 60%;
		height: 40px;
		border-radius: 24px;
		border: 1px solid #fff;
		outline: none;
		background-color: transparent;
		color: #fff;
		font-size: 0.9em;
		cursor: pointer;
	}
	
	.big-box.active{
		left: 0;
		transition: all 0.5s;
	}
	.small-box.active{
		left: 100%;
		border-top-left-radius: 0;
		border-bottom-left-radius: 0;
		border-top-right-radius: inherit;
		border-bottom-right-radius: inherit;
		transform: translateX(-100%);
		transition: all 1s;
	}
</style>
