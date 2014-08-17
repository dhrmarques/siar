$( document ).ready(function() {
  if($("#error-container").hasClass("success") || $("#error-container").hasClass("error")){
	  $("#error-container").css("display", "block");
  }else{
	  $("#error-container").css("display", "none");
  }
});