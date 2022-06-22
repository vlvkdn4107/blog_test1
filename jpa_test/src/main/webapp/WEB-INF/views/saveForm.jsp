<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "layout/header.jsp" %>
<div class = "container">
	<form>
		<div class ="form-gruoup">
			<label for = "title">Title : </label>
			<input type ="text" placeholder="title" id ="title" class = "form-control">
		</div>
		<br/>
		<div class = "form-group">
			<label for = "content">Content : </label>
			<textarea class = "form-control summernote" rows="5" id = "content" ></textarea>
		</div>
		<br/>
		<button type="button" onclick ="saveBoard()" class = "btn btn-primary">글쓰기</button>
		
	</form>
</div>
 <script>
 	function saveBoard(){
 		let title = document.querySelector("#title").value;
 	    let content = document.querySelector("#content").value;
 	    console.log(title);
 	    console.log(content);
 	 
 	    let board = {
 	    		title: title,
 	    		content: content
 	    }
 	 	fetch("/save",{
 	 		method: "post",
 	 		headers:{
 	 			'content-type': 'application/json; charset=utf-8'
 	 		},
 	 		body: JSON.stringify(board)
 	 	})
 	 	  .then(res => res.text())
 	 	  .then(res => {
 	 		if(res == "ok"){
 	 			alert("글쓰기 성공");
 	 		}else{
 	 			alert("글쓰기 실패");
 	 		}
 	 	});
 	  
 	   
 	} // end of saveBoard
  
    $('.summernote').summernote({
	        placeholder: 'Hello Bootstrap 4',
	        tabsize: 2,
	        height: 100
	      });
</script>
<%@ include file = "layout/footer.jsp" %>