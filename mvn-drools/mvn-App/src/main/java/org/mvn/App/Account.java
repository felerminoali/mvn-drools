/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mvn.App;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Lenovo
 */
public class Account {

    private long balance;

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Account)) {
            return false;
        }
        Account castOther = (Account) other;
        return new EqualsBuilder().append(balance,
                castOther.balance).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(1450207409, -1692382659).append(balance).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("balance", balance).toString();
    }
}
