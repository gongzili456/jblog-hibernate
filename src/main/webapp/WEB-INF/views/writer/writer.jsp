<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html ng-app="writer_app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Jblog-writing</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="resources/css/font-awesome.min.css" />
<link rel="stylesheet" href="resources/simditor/styles/font-awesome.css" />
<link rel="stylesheet" href="resources/simditor/styles/simditor.css" />
<link rel="stylesheet" href="resources/css/article/article_editor.css" />

</head>
<body>

	<nav class="navbar navbar-inverse navbar-static-top" role="navigation">

	</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-2 rightLine">
				<div class="new-article-group">
					<a href="javascript:;"> <span
						class="glyphicon glyphicon-plus group-icon"></span> 新建文集
					</a>
				</div>


				<ul class="list-group group-ul" ng-controller="groupsController">
					<li class="list-group-item group-item" ng-repeat="group in groups" ng-class="{active1: $index == selected}" >
						<a href="javascript:;" class="group-name" ng-click="groupClick($index,group.id)"> 
							<i class="icon-book"></i> 
							<span>{{group.name}}</span>
						</a> 
						<a href="javascript:;" class="edit-group"> <i class="icon-edit"></i></a> 
						<a href="javascript:;" class="delete-group"> <i class="icon-trash"></i></a>
					</li>

				</ul>
			</div>
			<div class="col-md-3 rightLine">
				<div class="new-article">
					<a href="javascript:;"> <span
						class="glyphicon glyphicon-plus group-icon"></span> 新建文章
					</a>
				</div>
				
				
				<ul class="list-group article-list" ng-controller="articlesController">
					<li class="list-group-item article-item" ng-repeat="article in articles" ng-model="article" ng-class="{active1: $index == selected}" >
						<i class="icon-file-alt icon-3x article-icon"></i>
						<p class="article-desc">{{article.desc}}</p>
						<p class="text-count">字数：{{article.wordCount}}</p> 
						<a href="javascript:;" class="article-name" ng-click="articleClick($index, article)">{{article.title}}</a> 
						<a href="javascript:;" class="edit-article"> 
							<i class="icon-share"></i>
						</a> 
						<a href="javascript:;" class="delete-article"> 
							<i class="icon-trash"></i>
						</a>
					</li>
				</ul>
			</div>
			<div class="col-md-7 creator" ng-controller="articleController" ng-model="article">
				<input type="text" name="title" class="article-title" ng-model="article.title" value="{{article.title}}" ng-change="titleChange(article)">
				<textarea name="content" id="article-content" ng-model="article.content" autofocus ng-init="textAreaInit()">{{article.content}}</textarea>
			</div>
		</div>
	</div>


	<script src="resources/js/jquery-1.8.3.min.js"></script>
	<script src="resources/js/angular.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/simditor/scripts/js/simditor-all.min.js"></script>
	<script src="resources/js/article/article_editor.js"></script>
	<script>
		$(document).ready(function() {
			
		});
	</script>


</body>
</html>