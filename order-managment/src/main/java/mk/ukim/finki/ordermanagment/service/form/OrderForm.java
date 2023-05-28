package mk.ukim.finki.ordermanagment.service.form;

import com.sun.istack.NotNull;
import lombok.Data;
import mk.ukim.finki.sharedkernel.domain.financial.Currency;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderForm {
    @NotNull
    private Currency currency;

    private List<TicketForm> tickets = new ArrayList<>();
}
