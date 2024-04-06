Oblig 3
=======
OsloMet brukernavn: thlon2720

GitHub brukernavn: Loenning

Github repo URL: https://github.com/Loenning/data1700-oblig1

Fullt navn: Thomas Stavik Lønning

Kort beskrivelse av applikasjon (5-10 setninger):

In this assignment, the goal is to create a web application for ordering movie tickets.
It also allows for deleting the tickets that have been ordered.

This is done by the use of two main functions, buyTicket and deleteAll.
The function buyTicket gathers input values, while validating the input using regex, while
also checking for empty input fields.
If the input is validated as correct, an order is created and pushed into an array "tickets".
Following this, the value for each variable is reset, and the function showOrder prints out
the order with the validated inputs.

For some reason, the regex [a-åA-Å] did not include the character "øØ" which is why this is
written manually into the regex.
