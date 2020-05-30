<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
	//邮箱验证
		function isEmail(val){
	          	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,4}$/;
				if(!myreg.test(val)){
					$("#emailValidMsg").html("<h3 style='color:red;'><img src='${pageContext.request.contextPath}/front/images/wrong.gif' />邮箱格式错误,请输入正确的邮箱格式</h3>");
					return false;
				}else{
					$("#emailValidMsg").html("<h3 style='color:green;'><img src='${pageContext.request.contextPath}/front/images/right.gif' />邮箱格式正确</h3>");
					return true;
				}
			}
		//用户名验证
		function nickName(val){
			//获取到值后遍历该字符串
			var realPath = 0;
			var charCode = 0;
			var boo=true;
			for(var i=0;i<val.length;i++){
				realPath = val.charCodeAt(i);
				//不是字符每次加2
				//是字符每次加1
				if(realPath > 127 || realPath < 0){
					charCode+=2;
					//48~57 是数字
					//97~122 a~z
					//65~90 A~Z
				}else if((realPath >= 48 && realPath <= 57) || (realPath >= 97 && realPath <= 122)){
					charCode+=1;
				}else{
					boo=false;
				}
				// realPath >= 65 && realPath <= 90 || 
			}
			//判断长度
			if(charCode>=4 && charCode<=20){
				//符合规则
				$("#nickNameValidMsg").html("<h3 style='color:green;'><img src='${pageContext.request.contextPath}/front/images/right.gif' />用户名符合规则</h3>");
				return true;
			}else if(boo==false){
				$("#nickNameValidMsg").html("<h3 style='color:red;'><img src='${pageContext.request.contextPath}/front/images/wrong.gif' />只能由数字，小写字母，汉字组成</h3>");
				return false;
			}else{
				//不符合规则
				$("#nickNameValidMsg").html("<h3 style='color:red;'><img src='${pageContext.request.contextPath}/front/images/wrong.gif' />用户名不符合规则，请重新输入</h3>");
				return false;
			}
		}
		//密码验证
		function password(val){
			//获取到值后遍历该字符串
			var realPath = 0;
			var charCode = 0;
			var boo=true;
			for(var i=0;i<val.length;i++){
				realPath = val.charCodeAt(i);
				//不是字符每次加2
				//是字符每次加1
				if(realPath > 127 || realPath < 0){
					charCode+=2;
					//48~57 是数字
					//97~122 a~z
					//65~90 A~Z
				}else if((realPath >= 48 && realPath <= 57) ||  (realPath >= 65 && realPath <= 90) || (realPath >= 97 && realPath <= 122)){
					charCode+=1;
				}else{
					boo=false;
				}
			}
			//判断长度
			if(charCode>=4 && charCode<=20){
				//符合规则
				$("#passwordValidMsg").html("<h3 style='color:green;'><img src='${pageContext.request.contextPath}/front/images/right.gif' />用户名符合规则</h3>");
				return true;
			}else if(boo==false){
				$("#passwordValidMsg").html("<h3 style='color:red;'><img src='${pageContext.request.contextPath}/front/images/wrong.gif' />只能由数字，字母，汉字组成</h3>");
				return false;
			}else{
				//不符合规则
				$("#passwordValidMsg").html("<h3 style='color:red;'><img src='${pageContext.request.contextPath}/front/images/wrong.gif' />用户名不符合规则，请重新输入</h3>");
				return false;
			}
		}
		//再次判断密码
		function upassword(val){
			var password = $("#txtPassword").val();
			if(password === val){
				$("#repeatPassValidMsg").html("<h3 style='color:green;'><img src='${pageContext.request.contextPath}/front/images/right.gif' />密码一致</h3>");
			}else{
				$("#repeatPassValidMsg").html("<h3 style='color:red;'><img src='${pageContext.request.contextPath}/front/images/wrong.gif' />密码不一致，请重新输入！</h3>");
			}
		}

	</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="/add" id="f" >
				<h2>
					以下均为必填项&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<span style="color:red;font-size: 21px;margin-left: 45px;">${message}</span>
				</h2>
				<table class="tab_login" >
					<tr>
				
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="email"  type="text" id="txtEmail" onblur="isEmail(this.value)" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
								<span id="emailInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="nickname"  type="text" id="txtNickName" onblur="nickName(this.value)" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="password" type="password" id="txtPassword" onblur="password(this.value)" class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass" onblur="upassword(this.value)" class="text_input"/>
							
							<div class="text_left" id="repeatPassValidMsg">
								<span id="password1Info"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath}/user/getCode" />
							<input name="code" type="text" id="txtVerifyCode" class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									<a href="" id="change" >看不清楚？换个图片</a>
									<br/>
									<span id="codeInfo"></span>
								</p>
							</div>
						</td>
					</tr>
				</table>
				<div class="login_in">
					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

