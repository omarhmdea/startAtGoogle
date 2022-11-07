const colors = $("span");

for (const color of colors) {
	$(color).addClass("picker");
	$(color).css("background-color", $(color).text().toLowerCase());
}

$("#colors").on("click", ".picker", function () {
	$(".box").css("background-color", $(this).css("background-color"));
});
