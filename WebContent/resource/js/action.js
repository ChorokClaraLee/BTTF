$(document).ready(function(){

	$('.navbar-nav .dropdown-menu').hide();

	$('.drop1').mouseover(function(){
		$('.dropdown-menu').slideDown();

	});
	$('.dropdown-menu').mouseleave(function(){
		$('.dropdown-menu').hide();
	});
});


$(document).ready(function(){

	$('#drop_menu_1').hide();

	$('#drop_2').mouseover(function(){
		$('#drop_menu_1').slideDown();

	});
	$('#drop_menu_1').mouseleave(function(){
		$('#drop_menu_1').hide();
	});
});

