package untitled.external;

import java.util.Date;
import lombok.Data;

@Data
public class Ticket {

    private Long id;
    private String name;
    private String train;
    private String seat;
    private String amount;
}
