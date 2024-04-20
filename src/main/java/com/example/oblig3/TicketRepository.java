package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

//--------Class is used to call the database
@Repository
public class TicketRepository {

//--------Spring handles the start-up of the database, and uses the "db"-object to access it
    @Autowired
    private JdbcTemplate db;

//--------Function for saving tickets in the database.
    public void saveTicket(Ticket ticket) {
        String ticketSQL = "INSERT INTO tickets (film,antall,fornavn,etternavn,telefonnr,epost) VALUES(?,?,?,?,?,?)";
        db.update(ticketSQL,ticket.getFilm(),ticket.getAntall(),ticket.getFornavn(),ticket.getEtternavn(),ticket.getTelefonnr(),ticket.getEpost());
    }

//--------Function for retrieving all the tickets from the database, where the tickets will be ordered by last names (converted to upper-case) alphabetically
    public ArrayList<Ticket> getAllTickets() {
        String ticketSQL = "SELECT * FROM tickets ORDER BY UPPER(etternavn) ASC";
        List<Ticket> allTickets = db.query(ticketSQL,new BeanPropertyRowMapper<>(Ticket.class));
        return new ArrayList<>(allTickets);
    }

//--------Function for deleting all the tickets from the database
    public void clearAllTickets () {
        String ticketSQL = "DELETE from tickets";
        db.update(ticketSQL);
    }

    public void clearTicket (Long id) {
        String ticketSQL = "DELETE from tickets WHERE id = "+id;
        db.update(ticketSQL);
    }
}