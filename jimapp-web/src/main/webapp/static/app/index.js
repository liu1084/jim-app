/**
 * Created by jim on 2017/4/2.
 *
 */
$(function () {
	function doAjaxPost() {
		var data = {
			"title":2222222222,
			"content":11,
			"background":"back",
			"userId":1,
			"status":1,
			"password":"p1",
			"sticky":1,
			"rating":0,
			"parentId":1
		};
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/jimapp/api/blog/article/37",
			data: data,
			dataType: "json",
			success: function(response){
				// we have the response
				console.log(response);
				if(response.code == 500){

				}
			},
			error: function(e){
				console.error(e.responseText);
			}
		});
	}

	doAjaxPost();
});