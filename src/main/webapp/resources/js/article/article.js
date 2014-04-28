var Article = {

	save : function() {
		console.log('sdfsdfsdfsadf/....');
		$.ajax({
			url : 'article',
			dataType : 'json',
			type : 'POST',
			success : function(json) {
				console.log(json);
			}
		});

		// $('#article_form').ajaxSubmit({
		// dataType : 'json',
		// url : 'acticle',
		// type : 'POST',
		// success : function(json) {
		// console.log('json : ', json);
		// }
		// });
	}

};

$(document).ready(function() {

	$('#article_group li').click(function(e) {
		var $t = $(this);
		$('#article_group_name').html($t.find('a').text());
		$('#article_group_id').val($t.attr('group'));
	});

	$('#publish_article').click(function(e) {
		Article.save();
	});
});