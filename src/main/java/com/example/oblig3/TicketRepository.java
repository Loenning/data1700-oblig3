package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepository {

    @Autowired
    private JdbcTemplate db;
    public void saveTicket(Ticket ticket) {
        String sql = "INSERT INTO tickets (film,antall,fornavn,etternavn,telefonnr,epost) VALUES(?,?,?,?,?,?)";
        db.update(sql,ticket.getFilm(),ticket.getAntall(),ticket.getFornavn(),ticket.getEtternavn(),ticket.getTelefonnr(),ticket.getEpost());
    }
    public ArrayList<Ticket> getAllTickets() {
        String sql = "SELECT * FROM tickets ORDER BY etternavn ASC";
        List<Ticket> allTickets = db.query(sql,new BeanPropertyRowMapper<>(Ticket.class));
        return new ArrayList<>(allTickets);
    }
    public void clearAllTickets () {
        String sql = "DELETE from tickets";
        db.update(sql);
    }


}