package br.com.raphaelneves.microservices.currencyexchangeservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ExchangeValue implements Serializable {

    @Id
    private Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    private BigDecimal convertionMultiple;

    @Transient
    private Date cotationDate;

    @Transient
    private int port; // attribute to distinguish wich instance is been used

    public ExchangeValue(Long id, String from, String to, Date cotationDate, BigDecimal convertionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.cotationDate = cotationDate;
        this.convertionMultiple = convertionMultiple;
    }

    public ExchangeValue(){}

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getCotationDate() {
        return cotationDate;
    }

    public void setCotationDate(Date cotationDate) {
        this.cotationDate = cotationDate;
    }

    public BigDecimal getConvertionMultiple() {
        return convertionMultiple;
    }

    public void setConvertionMultiple(BigDecimal convertionMultiple) {
        this.convertionMultiple = convertionMultiple;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
