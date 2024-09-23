package train.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import train.domain.*;
import train.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Reserved extends AbstractEvent {

    private Long id;
    private String name;
    private String train;
    private String time;
    private Integer cost;
    private String seat;

    public Reserved(Reserve aggregate) {
        super(aggregate);
    }

    public Reserved() {
        super();
    }
}
//>>> DDD / Domain Event
