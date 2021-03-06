package com.raulavila.refactor.legacy.fines.legacy;

import com.google.common.collect.Lists;
import com.raulavila.refactor.legacy.fines.model.Fine;
import com.raulavila.refactor.legacy.fines.model.Person;

import java.util.List;

import static com.raulavila.refactor.legacy.fines.PersonDAO.JOHN;
import static com.raulavila.refactor.legacy.fines.PersonDAO.RAUL;
import static java.math.BigDecimal.valueOf;

public class FineDAO {

    private static List<Fine> fines = Lists.newArrayList();
    
    static {
        fines.add(new Fine(1, JOHN, valueOf(100), true));
        fines.add(new Fine(2, JOHN, valueOf(110), true));
        fines.add(new Fine(3, RAUL, valueOf(120), true));
        fines.add(new Fine(4, RAUL, valueOf(130), false));
        fines.add(new Fine(5, RAUL, valueOf(140), false));
    }
    
    
    public static List<Fine> getFines(Person person) {
        List<Fine> output = Lists.newArrayList();

        for (Fine fine : fines) {
            if (fine.getPerson().equals(person)) {
                output.add(fine);
            }
        }
        
        return output;
    }
}
