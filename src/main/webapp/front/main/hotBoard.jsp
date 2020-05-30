<%@page contentType="text/html;charset=utf-8"%>
	<h2 class="t_xsrm">
		新书热卖榜
	</h2>
	
	<div id="NewProduct_1_o_t" onmouseover="">
	<c:forEach items="${timesale}" var="hot">
	<ul>
		<li>&nbsp;&nbsp;&nbsp;
			<a  target='_blank' href="${pageContext.request.contextPath}/book/selectOneBook?id=${hot.id }">
				${hot.name }
			</a>
		</li>
	</ul>
	</c:forEach>
	<h3 class="second">
		<span class="dot_r"> </span><a href="${pageContext.request.contextPath}/front/common/introduce.jsp" target="_blank">更多&gt;&gt;</a>
	</h3>
</div>