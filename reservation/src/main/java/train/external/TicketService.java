package train.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ticket", url = "${api.url.ticket}")
public interface TicketService {
    @RequestMapping(method = RequestMethod.POST, path = "/tickets")
    public void decreaseTicket(@RequestBody Ticket ticket);

    @RequestMapping(method = RequestMethod.POST, path = "/tickets")
    public void addTicket(@RequestBody Ticket ticket);
}
