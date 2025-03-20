package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long id;
    private String orderId;

    public OrderRejected(Cook aggregate) {
        super(aggregate);
    }

    public OrderRejected() {
        super();
    }
}
//>>> DDD / Domain Event
