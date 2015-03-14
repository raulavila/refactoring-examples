package com.raulavila.refactor.legacy.fines;

import com.google.common.collect.Lists;
import com.raulavila.refactor.legacy.fines.model.Fine;
import com.raulavila.refactor.legacy.fines.model.Person;

import java.util.List;

public class FineService {

    public List<Fine> getUnpaidFines(Person person) {
        List<Fine> output = Lists.newArrayList();

        List<Fine> fines = FineDAO.getFines(person);

        for (Fine fine : fines) {
            if (!fine.isPaid()) {
                output.add(fine);
            }
        }

        return output;
    }
}
