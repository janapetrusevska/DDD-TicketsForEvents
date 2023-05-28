package mk.ukim.finki.ordermanagment.service.form;

import com.sun.istack.NotNull;
import lombok.Data;
import mk.ukim.finki.ordermanagment.domain.model.Ticket;

@Data
public class TicketForm {

    @NotNull
    private Ticket ticket;

    private int orderedQuantity = 1;
}
