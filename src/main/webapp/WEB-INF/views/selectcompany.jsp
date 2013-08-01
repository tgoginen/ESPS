<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html lang="en">
<head>
  <meta charset="utf-8" />
  <title>ESPS</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
 
 <script type="text/javascript">
 var availableTags = [];

 </script>	
  <c:choose>
		<c:when
			test="${model.getCompanyInfoList() != null}">
			<c:forEach
				items="${model.getCompanyInfoList()}"
				var="item">
			 <script type="text/javascript">
			 var companydetails = '${item.getCompanyName() }'+'  ('+'${item.companySymbol}'+')';
			 availableTags.push(companydetails);
			 </script>
			</c:forEach>
		</c:when>
</c:choose>
  <script>
  $(function() {
    $( "#tags" ).autocomplete({
      source: availableTags
    });
  });
  
  $(function() {
	  $( "#getPrices" ).click(function() {
		  
		  if($('#tags').val()){
			  var inputStock = $('#tags').val();
			  var startIndex = inputStock.indexOf("(");
			  var endIndex = inputStock.indexOf(")",startIndex);
			  var stockSymbol = '';
			  if(endIndex != -1){
				 stockSymbol = inputStock.substring(startIndex+1,endIndex); 
			//	alert();  
		         window.open('/ESPS/company/'+stockSymbol,'_blank');

			  }
		  }else{
			  alert(' Input cant be empty');
		  }
		  
		});
	  });

  </script>
</head>
<body>
 
<div class="ui-widget">
  <label for="tags">Tags: </label>
  <input id="tags" />
  <button id="getPrices">Get prices</button>
</div>
 
 
</body>
</html>