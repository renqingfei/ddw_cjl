<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#address").change(function(){
		var val=$(this).find("option:selected").val();
		if(val != "" && val != undefined){
			window.location.href="${pageContext.request.contextPath}/address/getAddressById?id="+val;
		}else {
			$("#receiveName").val("");
			$("#fullAddress").val("");
			$("#postalCode").val("");
			$("#phone").val("");
			$("#addressId").val("");
		}
		});
	});
	</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：<span style="color:red;font-size: 21px;margin-left: 45px;">${message}</span>
				<select id="address">
				<option value="">
				填写新地址
				</option>
				<c:forEach items="${list }" var="list">
					<c:if test="${address.id==list.id }">
					<option selected value="${list.id}">${list.local }</option>
					</c:if>
					<c:if test="${address.id!=list.id }">
					<option value="${list.id}">${list.local }
					</option>
					</c:if>
					</c:forEach>
				</select>
			</p>
			<form name="ctl00" method="get" action="${pageContext.request.contextPath}/order/addorder" id="f">
				<input type="hidden" name="id" id="addressId" value="${address.id }"/>

					<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="name" id="receiveName" value="${address.name} "/>
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="local" class="text_input" id="fullAddress" value="${address.local }"/>
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" class="text_input" name="zip_code" id="postalCode" value="${address.zip_code }"/>
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" class="text_input" name="phone" id="phone" value="${address.phone }"/>
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
							</div>
						</td>
					</tr>
					
				</table>

				<div class="login_in">
					<a href="${pageContext.request.contextPath}/front/order/order_info.jsp">
						<input id="btnClientRegister" class="button_1" name="submit" type="button" value="取消" />
					</a>			
				<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

