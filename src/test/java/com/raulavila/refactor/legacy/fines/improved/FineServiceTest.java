package com.raulavila.refactor.legacy.fines.improved;

import com.google.common.collect.Lists;
import com.raulavila.refactor.legacy.fines.PersonDAO;
import com.raulavila.refactor.legacy.fines.model.Fine;
import com.raulavila.refactor.legacy.fines.model.Person;
import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.raulavila.refactor.legacy.fines.PersonDAO.JOHN;
import static com.raulavila.refactor.legacy.fines.PersonDAO.RAUL;
import static java.math.BigDecimal.valueOf;
import static org.fest.assertions.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FineServiceTest {

    private Person JOHN;
    private Person RAUL;

    @Mock
    private FineDAO fineDAO;
    @InjectMocks
    private FineService fineService = new FineService();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        JOHN = PersonDAO.JOHN;
        RAUL = PersonDAO.RAUL;
    }

    @Test
    public void testGetUnpaidFines() throws Exception {
        when(fineDAO.getFines(RAUL)).thenReturn(
                Lists.newArrayList(
                        new Fine(3, RAUL, valueOf(120), true),
                        new Fine(4, RAUL, valueOf(130), false),
                        new Fine(5, RAUL, valueOf(140), false)));
        
        List<Fine> unpaidFines = fineService.getUnpaidFines(RAUL);
        assertThat(unpaidFines).hasSize(2);
    }

    @Test
    public void testNoUnpaidFines() throws Exception {
        when(fineDAO.getFines(JOHN)).thenReturn(
                Lists.newArrayList(
                        new Fine(1, RAUL, valueOf(100), true),
                        new Fine(2, RAUL, valueOf(110), true)));
        
        List<Fine> unpaidFines = fineService.getUnpaidFines(JOHN);
        assertThat(unpaidFines).isEmpty();
    }
}