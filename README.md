Oblig 3
=======
OsloMet username: thlon2720

GitHub username: Loenning

Github repo URL: https://github.com/Loenning/data1700-oblig3

Full name: Thomas Stavik Lønning

Short description (5-10 sentences):

In this assignment, the goal is to create a web application for ordering movie tickets.
The tickets are in this instance Java objects, and instead of having the tickets in an array on the server
the tickets are now stored in an ER database.
The tickets are then fetched from the database and displayed on the website in alphabetical order based on last names
It also allows for deleting single tickets or all the tickets from the database.

Tickets are created in the Ticket Java class using the "buyTicket function" and inputs are validated using regex.
Tickets are added, fetched and deleted from the H2-database using JDBC, which is done for learning purposes. 
The TicketRepository class includes all functions that interacts with the database using SQL segments

For some reason, the regex [a-åA-Å] did not include the character "øØ" which is why this is
written manually into the regex.
