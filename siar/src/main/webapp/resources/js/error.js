$( document ).ready(function() {
  if($("#error-container").text() == "" || $("#error-container").text() == null){
	  $("#error-container").css("display", "none");
  }else{
	  $("#error-container").css("display", "block");
  }
});