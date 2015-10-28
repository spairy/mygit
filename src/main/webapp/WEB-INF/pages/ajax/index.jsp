<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
  <script src="../resources/js/jquery-1.11.3.min.js"></script>
  <!-- 
  <script type="text/javascript"
	src="<c:url value='./SpringRESTWithAjax.js'/>">
  </script>
   -->  
  <title>Welcome To REST With Ajax !!!</title>
</head>
<body>
  <h1>Welcome To REST With Ajax !!!</h1>
  <button type="button" onclick="RestPut()">PUT</button>
  <!-- 
  <button type="button" onclick="RestGet()">GET</button>
  <button type="button" onclick="RestPost()">POST</button>
  <button type="button" onclick="RestDelete()">DELETE</button>
   -->
</body>
<script type="text/javascript">
var prefix = "/SpringMVC";

var RestPut = function() {
	
	var JSONObject= {
		"time": Date.now(),
		"message": "User PUT call !!!",
		"name" : "CHENDUXXX"
	};
	
    $.ajax({
        type: 'PUT',
        url:  prefix + "/ajax/CHENDU",
		contentType: "application/json; charset=utf-8",		
		data: JSON.stringify(JSONObject),
		dataType: 'json',
        async: true,
        success: function(result) {
			alert("At " + result.name
				+ ": " + result.staffName);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + " " + jqXHR.responseText);
        }
    });
    
}

/**
var RestGet = function() {
	
    $.ajax({
        type: 'GET',
        url:  prefix + "/json/" + Date.now(),
		dataType: 'json',
        async: true,
        success: function(result) {
			alert("At " + result.time
				+ ": " + result.message);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + " " + jqXHR.responseText);
        }
    });
    
}
var RestPost = function() {
	
    $.ajax({
        type: 'POST',
        url:  prefix + "/MyData",
		dataType: 'json',
        async: true,
        success: function(result) {
			alert("At " + result.time
				+ ": " + result.message);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + " " + jqXHR.responseText);
        }
    });
    
}

var RestDelete = function() {
	
    $.ajax({
        type: 'DELETE',
        url:  prefix + "/MyData/" + Date.now(),
		dataType: 'json',
        async: true,
        success: function(result) {
			alert("At " + result.time
				+ ": " + result.message);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + " " + jqXHR.responseText);
        }
    });
    
}
**/
</script>
</html>