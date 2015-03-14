package com.raulavila.refactor.legacy.fines.improved;

import com.raulavila.refactor.legacy.fines.PersonDAO;
import com.raulavila.refactor.legacy.fines.model.Fine;
import com.raulavila.refactor.legacy.fines.model.Person;
import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.api.Assertions.*;
import static org.junit.Assert.*;

public class FineDAOTest {

    private Person JOHN;
    private Person RAUL;

    @Before
    public void setUp() throws Exception {
        JOHN = PersonDAO.JOHN;
        RAUL = PersonDAO.RAUL;
    }

    @Test
    public void testGetFinesByPerson() throws Exception {
        FineDAO fineDAO = new FineDAO();
        
        List<Fine> finesJohn = fineDAO.getFines(JOHN);
        assertThat(finesJohn).hasSize(2);

        List<Fine> finesRaul = fineDAO.getFines(RAUL);
        assertThat(finesRaul).hasSize(3);
    }
}