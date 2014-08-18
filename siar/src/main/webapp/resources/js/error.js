$( document ).ready(function() {
  if($("#error-container").hasClass("success") || $("#error-container").hasClass("error")){
	  $("#error-container").css("display", "block");
  }else{
	  $("#error-container").css("display", "none");
  }
  
  $("input[type=submit]").addClass("disabled");
  
  $("form").hover(function() {
	  var disable = false;
	  $("form input").each(function(){
		 if($(this).val() == ""){
			 disable = true;
		 } 
	  });
	  
	  $("form select").each(function(){
		  if($(this).val() == ""){
			  disable = true;
		  } 
	  });
	  
	  if(disable)
		  $("input[type=submit]").addClass("disabled");
	  else
		  $("input[type=submit]").removeClass("disabled");
		  
      
  });
});