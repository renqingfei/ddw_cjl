<%@page contentType="text/html;charset=utf-8"%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->

			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<c:forEach items="${cateone}" var="cat">
				<h3>
					[<a href='${pageContext.request.contextPath}/book/selectSecond?fid=${cat.id}'>${cat.name}</a>]
				</h3>

				<c:forEach items="${cat.sons }" var="sons">
				<ul class="ul_left_list">
						<!--2级分类开始-->
						<li>
							<a href='${pageContext.request.contextPath}/book/selectSecond?fid=${cat.id}&sid=${sons.id}'>${sons.name }</a>
						</li>
						<!--2级分类结束-->
				</ul>
				</c:forEach>
				
				<div class="empty_left">
				</div>
				</c:forEach>
			</div>
			<div class="more2">
			</div>
		

			


		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
