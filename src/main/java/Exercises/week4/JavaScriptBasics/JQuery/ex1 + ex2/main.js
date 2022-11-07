$("button").on("click", function () {
	const inputElement = $("input");
	const newIl = `<li>${inputElement.val()}</li>`;
	$("ul").append(newIl);
	inputElement.val("");
});

$("ul").on("click", "li", function () {
	$(this).remove();
});
