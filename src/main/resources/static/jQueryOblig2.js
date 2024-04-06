//------Creating an empty array for ticket orders
var ticketsArray = []

//------function for buying tickets
function buyTicket() {
    const film = $("#film");
    const antall = $("#antall");
    const fornavn = $("#fornavn");
    const etternavn = $("#etternavn");
    const telefonnr = $("#telefonnr");
    const epost = $("#epost");
    const wrongFilm = $("#wrongFilm")
    const wrongAmount = $("#wrongAmount");
    const wrongFirstName = $("#wrongFirstName");
    const wrongLastName = $("#wrongLastName");
    const wrongNumber = $("#wrongNumber");
    const wrongEmail = $("#wrongEmail");

    var wrongInput = false;

    function validateInput(element, regex, errorElement, errorEmpty, errorRegex) {
        // If the value is validated, gives no error message
        if (regex.test(element.val())) {
            errorElement.text("");
            return;
        }
        // Else the wrongInput variable changes to true
        wrongInput = true;
        // Checks to see if the input field is empty or not and shows the correlated error message
        if (!element.val()) {
            errorElement.text(errorEmpty);
            return;
        }
        // Else the regex error message is shown
        errorElement.text(errorRegex);
    }

    validateInput(film, /^[^]+$/, wrongFilm, "Velg film", "Velg film")
    validateInput(antall, /^[1-99]+$/, wrongAmount, "Skriv inn antall", "Skriv inn gyldig antall")
    validateInput(fornavn, /^[a-zæøåA-ÅÆØÅ]+$/, wrongFirstName, "Skriv inn fornavn", "Skriv inn gyldig fornavn")
    validateInput(etternavn, /^[a-zæøåA-ZÆØÅ]+$/, wrongLastName, "Skriv inn etternavn", "Skriv inn gyldig etternavn")
    validateInput(telefonnr, /^\d{8}$/, wrongNumber, "Skriv inn telefonnr", "Skriv inn gyldig telefonnr (8 tall)")
    validateInput(epost, /^[a-zæøåA-ZÆØÅ0-9._%+-]+@[a-zæøåA-ZÆØÅ0-9.-]+\.[a-zæøåA-ZÆØÅ]+$/, wrongEmail, "Skriv inn epost", "Skriv inn gyldig epost")

    if (wrongInput === false) {
        var order = {
            film: film.val(),
            antall: antall.val(),
            fornavn: fornavn.val(),
            etternavn: etternavn.val(),
            telefonnr: telefonnr.val(),
            epost: epost.val()
        };

        ticketsArray.push(order);

        film.val("");
        antall.val("");
        fornavn.val("");
        etternavn.val("");
        telefonnr.val("");
        epost.val("");
    }

    function showOrder() {
        var ut = "<table id='table'><tr>" +
            "<th>Film</th><th>Antall</th><th>Navn</th><th>Etternavn</th><th>Telefonnr</th><th>Epost</th>" +
            "</tr>";
        for (let i of ticketsArray) {
            ut += "<tr>";
            ut += "<td>" + i.film + "</td><td>" + i.antall + "</td><td>"
                + i.fornavn + "</td><td>" + i.etternavn + "</td><td>"
                + i.telefonnr + "</td><td>" + i.epost + "</td>";
            ut += "</tr>";
        }
        $("#list").html(ut);
    }

    showOrder();
}

//------ Function that empties the array when the button is pressed
function deleteAll() {
    ticketsArray.length = 0;
    $("#list").html("");
}
