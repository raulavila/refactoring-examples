package com.raulavila.refactor.legacy.fines.model;

import java.math.BigDecimal;

public class Fine {
    
    private int id;
    private Person person;
    private BigDecimal amount;
    private boolean paid;

    public Fine(int id, Person person, BigDecimal amount, boolean paid) {
        this.id = id;
        this.person = person;
        this.amount = amount;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fine)) return false;

        Fine fine = (Fine) o;

        if (id != fine.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
