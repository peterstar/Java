/**
 * 
 */

document.write("hello world<br>");
document.getElementById('message');
// jQuery
var messagePara = $('#message');
$(document).ready(function() {
	$('body').hide().fadeIn(3000);
});