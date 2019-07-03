<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<meta name="description"
	content="Example of using default thumbnails from w3cschool.cc">
<meta name="viewport" content="width=device-width,initial-scale=1" />
<script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="../css/bootstrap.min.css" />
<link rel="stylesheet"
	href="../css/common.css" />

<title>Insert title here</title>
</head>


<body>
	<div class="container">
		<%@include file="head.html"%>
		<div class="row content">
			<!-- 左侧导航 -->
			<%@include file="bar.html"%>
			<div class="col-lg-10">
				<div class="row content-head">

					<div class="row fix-head">
						<div class="title">
							<h2>定区管理</h2>
						</div>
             
					</div>
					<div class="row">
						<div class="col-lg-2"></div>
						<div class="head-bar">
							<a class="add btn btn-danger" href="addfixedArea">
								添加
							</a> 
							<a class="btn btn-danger">
								批量删除
							</a>
							<form action="partFixedArea" method="get" class="partForm">
							<input class="form-control search-input" name="fixed_area_name" >
							<button class="search btn btn-danger" type="submit" >搜索</button>
							</form>
						</div>
					</div>
					<div class="all">
					
						<jsp:include page="allFixedArea.jsp" flush="true" />
					</div>
					
				</div>
			</div>

		</div>
   </div>
</body>

</html>