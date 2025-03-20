package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    private Long id;
    private String orderId;

    public OrderAccepted(Cook aggregate) {
        super(aggregate);
    }

    public OrderAccepted() {
        super();
    }
}
//>>> DDD / Domain Event
