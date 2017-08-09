package com.github.transactions.resources;

import com.github.transactions.model.Transaction;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/transactions")
@Produces(MediaType.TEXT_HTML)
public class TransactionResource {

    private List<Transaction> transactions;

    public TransactionResource() {
        transactions = new ArrayList<>();
        transactions.add( new Transaction(1, false, "Laia", "Luna", 234.9) );
        transactions.add( new Transaction(2, true, "user1", "user2", 34456.) );
        transactions.add( new Transaction(3, true, "Pepito", "Ramon", 46835.8) );
        transactions.add( new Transaction(4, true, "Clara", "Pau", 2836.1) );
    }


    @GET
    public String viewTransactions() {
        String html = "<h1>Bitcoin Transactions</h1>";
        html += "<ul>";
        for (Transaction transaction : transactions) {
            html += "<li><a href='/transactions/" + transaction.getId() + "'>" + transaction.getId() + "- " + transaction.getTransmitter() +
                    " gives " + transaction.getAmount() + " bitcoins to " + transaction.getBeneficiary() +
                    "</a></li>";
        }
        html += "</ul>";

        return html;
    }

    @GET
    @Path("{id}")
    public String viewTransaction(@PathParam("id") int id) {
        Transaction transaction = transactions.get(id - 1);

        String html ="<h1>Transaction " + transaction.getId() + "</h1>";
        html += "<p>State: " + (transaction.isValidate()? "Received" : "Something went wrong") + "</p>";
        html += "<p>Beneficiary: <a>" + transaction.getBeneficiary() + "</a></p>";
        html += "<p>Transmitter: <a>" + transaction.getTransmitter() + "</a></p>";
        html += "<p>Amount: " + transaction.getAmount() + " Bitcoins</p>";

        return html;
    }

}
