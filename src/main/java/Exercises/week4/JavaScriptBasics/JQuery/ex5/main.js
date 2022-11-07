const fruits = [
	{ name: "Orange", color: "orange" },
	{ name: "Banana", color: "yellow" },
	{ name: "Coconut", color: "brown" },
	{ name: "Kiwi", color: "brown" },
	{ name: "Lemon", color: "yellow" },
	{ name: "Cucumber", color: "green" },
	{ name: "Persimmon", color: "orange" },
	{ name: "Pumpkin", color: "orange" },
];

for (const fruit of fruits) {
	$("body").append(`<div class=${fruit.color}>${fruit.name}<div>`);
}
