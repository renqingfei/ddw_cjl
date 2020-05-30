<%@page contentType="text/html;charset=utf-8"%>
<h2>
	<span class="more"><a href="${pageContext.request.contextPath}/front/common/introduce.jsp" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">
	<!--热销图书A开始-->
	<c:forEach items="${booksale}" var="sale">
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath}/book/selectOneBook?id=${sale.id }" target='_blank'>
				<img class="aa" src="${pageContext.request.contextPath}/back/img/${sale.cover}" border=0 />
			</a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath}/book/selectOneBook?id=${sale.id }" target="_blank">${sale.name }</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${sale.price }
		</div>
		<div class="price">
			当当价：￥${sale.dprice }
		</div>
		<div class="price">
			销量：<font color="red">${sale.sale }</font>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
	</c:forEach>
</div>
<div class="clear"></div>