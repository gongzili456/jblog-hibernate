var writer_app = angular.module('writer_app', []);

writer_app.factory('writerService', [ '$http', function($http) {

	return {
		editor : null,
		groups : [],
		articles : [],
		setArticle:function(article){
			for (key in article) {
				this.article[key] = article[key];
			}
		},
		setEditorValue : function(value) {
			this.editor.setValue(value);
			this.editor.focus();
		},
		article : {
			collectCount : 0,
			commentCount : 0,
			content : "",
			createTime : null,
			desc : null,
			id : 0,
			modifyTime : null,
			status : 1,
			title : "无标题文章",
			type : 1,
			wordCount : 0,
		},
		getGroups : function() {
			return $http({
				url : 'writer/groups',
				method : 'GET',
				responseType : 'json'
			});
		},
		getArticles : function(groupId) {
			return $http({
				url : 'writer/group/articles/' + groupId,
				method : 'GET',
				responseType : 'json'
			});
		},
		getAtricle : function(atricleId) {
			return $http({
				url : 'writer/articles/' + atricleId,
				method : 'GET',
				responseType : 'json'
			});
		}
	};
} ]);

writer_app.controller('groupsController', [
		'$http',
		'$scope',
		'writerService',
		function($http, $scope, writerService) {

			writerService.getGroups().success(function(data, status) {
				writerService.groups = data;
				$scope.groups = writerService.groups;
				$scope.groupClick(0, data[0].id);
			}).error(function(data, status) {
			});

			$scope.selected = 0;
			$scope.groupClick = function(index, groupId) {
				$scope.selected = index;
				writerService.getArticles(groupId).success(
						function(data, status) {
							writerService.articles.splice(0,
									writerService.articles.length);
							for (a in data) {
								writerService.articles.push(data[a]);
							}

							writerService.setArticle(data[0]);
							writerService.setEditorValue(writerService.article.content);
						}).error(function(data, status) {
				});
			};
		} ]);

writer_app.controller('articlesController', [ '$scope', '$http',
		'writerService', function($scope, $http, writerService) {

			$scope.selected = 0;
			$scope.articles = writerService.articles;
			$scope.article = writerService.article;
			
			$scope.articleClick = function(index, article) {
				$scope.selected = index;

				writerService.setEditorValue(article.content);
				writerService.setArticle(article);
			};
		} ]);

writer_app.controller('articleController', [ '$scope', '$http',
		'writerService', function($scope, $http, writerService) {
			$scope.article = writerService.article;

			
			$scope.titleChange = function(article){
				syncArticleModel(article);
			};
			
			function syncArticleModel(article){
				for(key in writerService.articles){
					var a = writerService.articles[key];
					if(a.id == article.id){
						for(k in article){
							a[k] = article[k];
						}
						return false;
					}
				}
			};
			
			function removeHTMLTag(str){
				return str.replace(/<\/?[^>]*>/g,'');
			}
			
			$scope.textAreaInit = function() {
				var editor = new Simditor({
					textarea : $('#article-content'),
					placeholder : '请输入文章正文...',
					params : {
						key : 'val'
					},
					upload : {
						url : '',
						params : null,
						connectionCount : 3,
						leaveConfirm : '正在上传文件，如果离开上传会自动取消'
					},
					tabIndent : true,
					toolbar : true,
					toolbarFloat : true,
					pasteImage : false
				});
				writerService.editor = editor;
				

				var times = 0;
				var timeout = null;
				writerService.editor.on('valuechanged', function(e) {
					console.log('content: ', writerService.article);
					
					var content = removeHTMLTag(writerService.editor.getValue());
					writerService.article.content = content;
					writerService.article.wordCount = content.length;
					writerService.article.desc = content.length > 100 ? content.substring(0, 100) : content;
					syncArticleModel(writerService.article);
					
					if (times > 0) {
						timeout != null ? clearTimeout(timeout) : '';
						timeout = setTimeout(function(){
							console.log('正在保存。。。');
							writerService.article.content = writerService.editor.sync();
							saveArticle();
						}, 1000);
					}
					times++;
				});

				function saveArticle() {
					var article = writerService.article;
					$http({
						url : 'writer/articles/' + article.id,
						data : JSON.stringify(article),
						method : 'PUT',
						responseType : 'json',
					}).success(function(data, status){
						console.log(data);
					});
				};
				
				

			};
		} ]);
