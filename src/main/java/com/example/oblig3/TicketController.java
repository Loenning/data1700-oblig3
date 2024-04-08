package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TicketController {
    @Autowired
    TicketRepository rep;

    @PostMapping("/tickets/save")
    public void saveTicket(Ticket innTicket) {
        rep.saveTicket(innTicket);
    }
    @GetMapping("/tickets/getAll")
    public ArrayList<Ticket> getAllTickets() {
        return rep.getAllTickets();
    }

    @PostMapping("/tickets/clearAll")
    public void clearAllTickets() {
        rep.clearAllTickets();
    }

    @PostMapping("/receiveTicket")
    public void receiveTicket(Ticket ticket){
        System.out.println(ticket);
    }
}