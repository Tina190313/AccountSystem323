package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.util.Objects;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ACCOUNT_TRANSACTION", schema = "HR")
public class AccountTransaction implements Serializable  {

    private static final long serialVersionUID = 3833725316797154577L;

    private Long transactionID;
    private AccountType accountType;
    private Long memberID;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransaction() {

    }
    public AccountTransaction(Long transactionID, AccountType accountType, Long memberID, Long amount, LocalDate transactionDate) {
        this.transactionID = transactionID;
        this.accountType = accountType;
        this.memberID = memberID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @SequenceGenerator(name= "SEQ_TRANSACTION_ID", sequenceName = "HR.SEQ_TRANSACTION_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRANSACTION_ID")
    @Column(name = "TRANSACTION_ID")
    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }
    @Column(name = "AMOUNT")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
    @Column(name = "TX_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    public AccountType getAccountType()
    {
        return accountType;
    }

    public void setAccountType(AccountType accountType)
    {
        this.accountType = accountType;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionID, that.transactionID) && Objects.equals(accountType, that.accountType) && Objects.equals(memberID, that.memberID) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, accountType, memberID, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionID=" + transactionID +
                ", accountType=" + accountType +
                ", memberID=" + memberID +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
