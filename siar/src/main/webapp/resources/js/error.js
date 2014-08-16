$( document ).ready(function() {
  if($("#error-container").hasClass("success") || $("#error-container").hasClass("error")){
	  $("#error-container").css("display", "block");
  }else{
	  $("#error-container").css("display", "none");
  }
  
  $("input[type=submit]").addClass("disabled");
  
  $("form").keyup(function() {
      if ($("input").val() == "" || $("select#tipoMissaoId").val() == "") {
    	  $("input[type=submit]").addClass("disabled");
      } else {
    	  $("input[type=submit]").removeClass("disabled");
      }
  });
});