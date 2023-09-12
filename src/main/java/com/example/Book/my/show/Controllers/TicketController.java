package com.example.Book.my.show.Controllers;

import com.example.Book.my.show.ReqDTOs.TicketDTO;
import com.example.Book.my.show.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tickets")
@CrossOrigin
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping("book_ticket")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<String> bookTicket(@RequestBody()TicketDTO ticketDTO) throws Exception {
        try{
            ticketService.BookTickets(ticketDTO);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully tickets Booked" , HttpStatus.OK);

    }
    @DeleteMapping("cancel_ticket")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Integer> cancelTicket(@RequestParam("Id") int ticketId){
        int refund=ticketService.cancelTicket(ticketId);
        return new ResponseEntity<>(refund,HttpStatus.OK);
    }
}
