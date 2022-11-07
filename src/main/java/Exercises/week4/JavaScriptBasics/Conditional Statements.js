let boughtTesla = true;
const yearOfTeslaPurchase = 2014;
let isUSCitizen = true;
let currentYear = 2022;

function Tesla(boughtTesla, yearOfTeslaPurchase, isUSCitizen, currentYear) {
	if (boughtTesla) {
		if (isUSCitizen) {
			if (currentYear - yearOfTeslaPurchase >= 4) {
				console.log("Would you like an upgrade?");
			} else {
				console.log("Is satisfied with the car?");
			}
		} else {
			console.log("would you like to move to the US>");
		}
	} else {
		console.log("Are interested in buying one?");
	}
}

Tesla(boughtTesla, yearOfTeslaPurchase, isUSCitizen, currentYear);
