$( document ).ready(function() {
  if($("#error-container").hasClass("success") || $("#error-container").hasClass("error")){
	  $("#error-container").css("display", "block");
  }else{
	  $("#error-container").css("display", "none");
  }
  
  $("input").on("keypress", function(){
	  if(
			  $('input#descricao').val() == "" || $('input#latitude').val() == "" ||
			  $('input#longitude').val() == "" || $('input#logradouro').val() == "" ||
			  $('input#numero').val() == "" || $('input#referencia').val() == "" || $('input#cidade').val() == "" )
	  { 
		  $("button[type=submit]").addClass("disabled");
	  }else{
		  $("button[type=submit]").removeClass("enabled");
	  } 
  });
  
});

