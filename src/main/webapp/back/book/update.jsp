<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/btn.css" />
	
<style type="text/css">
td{
	padding-top: 8px;
}
#file_upload1 {
	display: none;
}
#file_upload1_label {
	display: inline-block;
	border: 1px solid #aaa;
	width: 120px;
	height: 145px;
	margin-left: 20px;
	text-align: center;
	line-height: 145px;
	cursor: pointer;
}
</style>


</head>

<body style="background-color: #f0f9fd;text-align: center">
	<div style="font-size:25px">修改图书信息</div>
	<hr />
	<div align="center">
	<form action="${pageContext.request.contextPath}/book/updatebook" method="post" enctype="multipart/form-data">
			<table>
			<tr>
					<td><input type="hidden" name="id" class="el-input__inner" value="${book.id}"></td>
					</tr>
				<tr>
				
					<td>名称：</td>
					<td><input type="text" name="name" class="el-input__inner" value="${book.name }"></td>
					<td rowspan="14" style="width: 300px">
					<td>页数：</td>
					<td><input type="number" name="page_num" class="el-input__inner" value="${book.page_num}" ></td>
				</tr>
				<tr>
					<td>所属分类：</td>
					<td>
						<select name="category_id" class="el-select__inner inner2">
							<c:forEach items="${category}" var="list" >
							<option value="${list.id }">${list.name}</option>
							</c:forEach>
						</select>
					</td>
					<td>字数：</td>
					<td><input type="number" name="word_num" class="el-input__inner" value="${book.word_num}" ></td>
				</tr>
				
				<tr>
					<td>原价：</td>
					<td><input type="number" name="price" class="el-input__inner" value="${book.price }"></td>
					<td>封面：</td>
					<td rowspan="3">
						<label id="file_upload1_label" for="file_upload1">
							<img id="uploadimg" src="${pageContext.request.contextPath}/back/img/${book.cover}" alt="" width="120" height="145" />
						</label>
						<input type="hidden" name="cover" value="${book.cover}">
						<input type="file" name="myFile" class="" id="file_upload1"	onchange="upload_review()">
					</td>
				</tr>
				
				<tr>
					<td>当当价：</td>
					<td><input type=number name="dprice" class="el-input__inner" value="${book.dprice }"></td>
					<td></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="number" name="stock" class="el-input__inner" value="${book.stock }"></td>
					<td></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="author" class="el-input__inner" value="${book.author}"></td>
					<td>编辑推荐：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="editor_recommend">${book.editor_recommend }</textarea></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="press" class="el-input__inner" value="${book.press }"></td>
					<td></td>
				</tr>
				<tr>
					<td>出版时间：</td>
					<td><input type="date" name="press_date" class="el-input__inner" value="${book.press_date }"></td>
					<td>内容简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="content_abstract" >${book.content_abstract }</textarea></td>
				</tr>
				<tr>
					<td>版次：</td>
					<td><input type="text" name="edition" class="el-input__inner" value="${book.edition }"></td>
					<td></td>
				</tr>
				<tr>
					<td>印刷时间：</td>
					<td><input type="date" name="print_date" class="el-input__inner" value="${book.print_date }"/></td>
					<td>作者简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="author_abstract">${book.author_abstract }</textarea></td>
				</tr>
				<tr>
					<td>印次：</td>
					<td><input type="text" name="impression" class="el-input__inner" value="${book.impression }"></td>
					<td></td>
				</tr>
				<tr>
					<td>ISBN：</td>
					<td><input type="text" name="isbn" class="el-input__inner" value="${book.isbn }"></td>
					<td>基本目录：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="director" >${book.director }</textarea></td>
				</tr>
				<tr>
					<td>开本：</td>
					<td><input type="text" name="sizes" class="el-input__inner" value="${book.sizes }"></td>
					<td></td>
				</tr>
				<tr>
					<td>纸张：</td>
					<td><input type="text" name="paper" class="el-input__inner" value="${book.paper }"></td>
					<td>媒体评论：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name=media_commentary>${book.media_commentary }</textarea></td>
				</tr>
				<tr>
					<td>包装：</td>
					<td><input type="text" name="pack" class="el-input__inner" value="${book.pack }"></td>
					<td></td>
				</tr>
			</table>
			<input type="submit" class="button btn-p" value="提交" />&emsp; 
			<input type="button" class="button btn-p" value="返回上级" onclick="history.go(-1);" />
		</form>
	</div>
	<script>
		function upload_review() {
			var img = document.getElementById("uploadimg");
			var input = document.getElementById("file_upload1");
			var tip = document.getElementById("uploadtip");			

			var file = input.files.item(0);
			var freader = new FileReader();
			freader.readAsDataURL(file);
			freader.onload = function(e) {
				img.src = e.target.result;
				tip.style.display = "none";
			};
		}
	</script>
</body>
</html>

