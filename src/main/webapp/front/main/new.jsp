<%@page contentType="text/html;charset=utf-8"%>
<h2>
	<span class="more"><a href="${pageContext.request.contextPath}/front/common/introduce.jsp" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach items="${booktime }" var="Date">
	<div class="second_d_wai">
	
		<div class="img">
			<a href="${pageContext.request.contextPath}/book/selectOneBook?id=${Date.id }" target='_blank'>
				<img class="aa" src="${pageContext.request.contextPath}/back/img/${Date.cover}" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath}/book/selectOneBook?id=${Date.id }" target="_blank">${Date.name}</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${Date.price}
		</div>
		<div class="price">
			当当价：￥${Date.dprice }
		</div>
		<div class="price">
			销量：<font color="red">${Date.sale }</font>
		</div>
		
	</div>
	<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>