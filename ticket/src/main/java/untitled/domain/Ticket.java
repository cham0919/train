package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.TicketApplication;

@Entity
@Table(name = "Ticket_table")
@Data
//<<< DDD / Aggregate Root
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String train;

    private String seat;

    private String amount;

    @PostPersist
    public void onPostPersist() {}

    public static TicketRepository repository() {
        TicketRepository ticketRepository = TicketApplication.applicationContext.getBean(
            TicketRepository.class
        );
        return ticketRepository;
    }

    public void decreaseTicket() {
        //implement business logic here:

    }
}
//>>> DDD / Aggregate Root
