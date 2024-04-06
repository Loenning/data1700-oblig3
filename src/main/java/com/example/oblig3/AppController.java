package com.example.oblig3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AppController {
    private final ArrayList<Ticket> tickets = new ArrayList<>();

    @PostMapping("/tickets/add")
    public ArrayList<Ticket> addTicketToList(Ticket ticket) {
        tickets.add(ticket);
        System.out.println(ticket);
        System.out.println(tickets);
        return tickets;
    }

    @GetMapping("/tickets/list")
    public ArrayList<Ticket> listTickets() {
        return tickets;
    }

    @PostMapping("/tickets/clear")
    public void deleteAll() {
        tickets.clear();
    }

    @PostMapping("/receiveTicket")
    public void receiveTicket(Ticket ticket){
        System.out.println(ticket);
    }
}