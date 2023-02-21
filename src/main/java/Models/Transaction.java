/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author apexb
 */
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Transaction {
    private String transactionid;
    private String description;
    private Date date;
    private Time time;
    private String location;
    private String cashier;
    private String itemListJson;

    private List<Item> _itemsList;
    public Transaction() {
    }

    public Transaction(String transactionid, String description, Date date, Time time, String location, String cashier) {
        this.transactionid = transactionid;
        this.description = description;
        this.date = date;
        this.time = time;
        this.location = location;
        this.cashier = cashier;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }
    
     public List<Item> getItems() {
        if (_itemsList == null) {
            if (itemListJson != null && !itemListJson.isEmpty()) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    _itemsList = mapper.readValue(itemListJson, new TypeReference<List<Item>>(){});
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                _itemsList = new ArrayList<>();
            }
        }
        return _itemsList;
    }
}