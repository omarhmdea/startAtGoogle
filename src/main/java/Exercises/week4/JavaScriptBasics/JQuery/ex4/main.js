const boxDiv = "<div class='box'><div>";
$("body").append(boxDiv);
$("body").append(boxDiv);

let $boxes = $(".box");

$(".box").hover(function () {
	$boxes.css("background-color", "#8e44ad");
	$(this).css("background-color", "orange");
});
