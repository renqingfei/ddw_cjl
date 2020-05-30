<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<title>图书详情</title>
		<link rel="stylesheet" type="text/css" href="../css/book_detail.css"/>
		<link href="../css/public_footer.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		<br/>
		<div>
			<h1>
				丛书名：${bookone.name }
			</h1>
			<hr/>
		</div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img src="${pageContext.request.contextPath}/back/img/${bookone.cover}" width="240px" height="340px" /></td>
				<td colspan="2">作者：${bookone.author }</td>
			</tr>
			<tr>
				<td colspan="2">出版社：${bookone.press }</td>
			</tr>
			<tr>
				<td>出版时间：${bookone.press_date } </td>
				<td>字数：${bookone.word_num }</td>
			</tr>
			<tr>
				<td>版次：${bookone.edition }</td>
				<td>页数：${bookone.page_num }</td>
			</tr>
			<tr>
				<td>印刷时间：${bookone.print_date }</td>
				<td>开本：${bookone.sizes }</td>
			</tr>
			<tr>
				<td>印次：${bookone.impression }</td>
				<td>纸张：${bookone.paper}</td>
			</tr>
			<tr>
				<td>ISBN：${bookone.isbn }</td>
				<td>包装：${bookone.pack }</td>
			</tr>
			<tr>
				<td colspan="2">定价：￥${bookone.price }&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥${bookone.dprice }</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥${bookone.price-bookone.dprice }</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${pageContext.request.contextPath}/cart/addCart?id=${bookone.id }">
						<img src='${pageContext.request.contextPath}/front/images/buttom_goumai.gif' />
					</a>
				</td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>编辑推荐
		${bookone.editor_recommend }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>内容简介${bookone.content_abstract }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>作者简介${bookone.author_abstract }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>目录${bookone.director }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>媒体评论${bookone.media_commentary }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>书摘插图</h2>
		<p>&nbsp;&nbsp;</p>
		<!--页尾开始 -->
		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img src="${pageContext.request.contextPath}/front/images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
	</body>
</html>
