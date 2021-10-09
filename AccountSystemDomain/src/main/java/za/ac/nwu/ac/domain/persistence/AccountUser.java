package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.util.Objects;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "ACCOUNT_TRANSACTION", schema = "HR")

public class AccountUser implements Serializable  {
    private static final long serialVersionUID = 3833725316797154577L;

    private Long accUserID;
    private Long accountTypeID;
    private Long currentbalance;

    public AccountUser()
    {

    }
    public AccountUser(Long accUserID, Long accountTypeID, Long currentBalance) {
        this.accUserID = accUserID;
        this.accountTypeID = accountTypeID;
        this.currentbalance = currentBalance;

    }
    @Id
    @SequenceGenerator(name = "SEQ_ACC_USER_ID", sequenceName = "HR.SEQ_ACC_USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACC_USER_ID")
    @Column(name = "ACC_USER_ID")

    public Long getAccUserID() {
        return accUserID;
    }

    public void setAccUserID(Long accUserID) {
        this.accUserID = accUserID;
    }
    @Column(name = "ACCOUNT_ID")
    public Long getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }
    @Column(name = "CURRENT_BALANCE")
    public Long getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(Long currentbalance) {
        this.currentbalance = currentbalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountUser that = (AccountUser) o;
        return Objects.equals(accUserID, that.accUserID) && Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(currentbalance, that.currentbalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accUserID, accountTypeID, currentbalance);
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "accUserID=" + accUserID +
                ", accountTypeID=" + accountTypeID +
                ", currentbalance=" + currentbalance +
                '}';
    }
}
