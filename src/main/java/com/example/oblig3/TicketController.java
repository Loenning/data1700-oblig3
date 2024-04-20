package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//------- Controller class

//------- Handles HTTP requests and returns JSON responses
@RestController
public class TicketController {
    //------- Injecting the TicketRepository as a dependency into the controller
    @Autowired
    TicketRepository rep;

    //------- Takes the input when ordering a ticket and calls the saveTicket function to save the ticket
    @PostMapping("/tickets/save")
    public void saveTicket(Ticket innTicket) {
        rep.saveTicket(innTicket);
    }

    //------- Calls getAllTickets function to retrieve tickets in the repository and put them in an ArrayList<Ticket>
    @GetMapping("/tickets/getAll")
    public ArrayList<Ticket> getAllTickets() {
        return rep.getAllTickets();
    }

    //------- Calls the clearAllTickets to delete all tickets
    @PostMapping("/tickets/clearAll")
    public void clearAllTickets() {
        rep.clearAllTickets();
    }

    @DeleteMapping("/tickets/clearTicket/{id}")
    public void clearTicket(@PathVariable String id){
        rep.clearTicket(Integer.parseInt(id));
    }
}