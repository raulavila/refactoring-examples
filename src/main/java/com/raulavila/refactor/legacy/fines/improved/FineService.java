package com.raulavila.refactor.legacy.fines.improved;

import com.google.common.collect.Lists;
import com.raulavila.refactor.legacy.fines.model.Fine;
import com.raulavila.refactor.legacy.fines.model.Person;

import java.util.List;

public class FineService {
    
    private FineDAO fineDAO;
    
    public List<Fine> getUnpaidFines(Person person) {
        List<Fine> output = Lists.newArrayList();

        List<Fine> fines = getFines(person);

        for (Fine fine : fines) {
            if (!fine.isPaid()) {
                output.add(fine);
            }
        }

        return output;
    }

    protected List<Fine> getFines(Person person) {
        return fineDAO.getFines(person);
    }

    public void setFineDAO(FineDAO fineDAO) {
        this.fineDAO = fineDAO;
    }
}
