package train.domain;

import train.domain.Reserved;
import train.domain.Cancelreservation;
import train.ReservationApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Reserve_table")
@Data

//<<< DDD / Aggregate Root
public class Reserve  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private String name;
    
    
    
    
    private String train;
    
    
    
    
    private String time;
    
    
    
    
    private Integer cost;
    
    
    
    
    private String seat;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        train.external.Ticket ticket = new train.external.Ticket();
        // mappings goes here
        ReservationApplication.applicationContext.getBean(train.external.TicketService.class)
            .decreaseTicket(ticket);


        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();


        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        train.external.Ticket ticket = new train.external.Ticket();
        // mappings goes here
        ReservationApplication.applicationContext.getBean(train.external.TicketService.class)
            .addTicket(ticket);


        Cancelreservation cancelreservation = new Cancelreservation(this);
        cancelreservation.publishAfterCommit();

    
    }

    public static ReserveRepository repository(){
        ReserveRepository reserveRepository = ReservationApplication.applicationContext.getBean(ReserveRepository.class);
        return reserveRepository;
    }



    public void reserve(){
        //implement business logic here:
        
        
        
        train.external.TicketQuery ticketQuery = new train.external.TicketQuery();
        ReserveApplication.applicationContext
            .getBean(train.external.Service.class)
            .( ticketQuery);
    }
    public void cancelReservation(){
        //implement business logic here:
        
        
        
    }



}
//>>> DDD / Aggregate Root
