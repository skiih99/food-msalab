package food.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import food.StoreApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cook_table")
@Data
//<<< DDD / Aggregate Root
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    @ElementCollection
    private List<String> foodId;

    private String option;

    private String status;

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    //<<< Clean Arch / Port Method
    public void isAccept(IsAcceptCommand isAcceptCommand) {
        //implement business logic here:

        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();
        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void startCook() {
        //implement business logic here:

        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void finishCook() {
        //implement business logic here:

        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void loadOrderInfo(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        

        repository().findById(orderPlaced.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
