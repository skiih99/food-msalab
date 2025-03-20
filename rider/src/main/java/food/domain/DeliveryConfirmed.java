package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryConfirmed extends AbstractEvent {

    private Long id;
    private String orderId;
    private String address;

    public DeliveryConfirmed(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryConfirmed() {
        super();
    }
}
//>>> DDD / Domain Event
