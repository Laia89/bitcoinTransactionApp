package com.github.transactions;

import com.github.transactions.resources.TransactionResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class TransactionApp extends Application<TransactionConf> {
    public static void main(String[] args) throws Exception {
        new TransactionApp().run(args);
    }

    @Override
    public String getName() {
        return "the transaction app";
    }

    @Override
    public void initialize(Bootstrap<TransactionConf> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(TransactionConf configuration, Environment environment) throws Exception{

        final TransactionResource transactionResource = new TransactionResource();
        environment.jersey().register(transactionResource);
    }

}