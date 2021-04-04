package com.ldbc.driver.workloads.simple.db;

import com.ldbc.driver.Db;
import com.ldbc.driver.DbConnectionState;
import com.ldbc.driver.DbException;
import com.ldbc.driver.OperationHandler;
import com.ldbc.driver.ResultReporter;
import com.ldbc.driver.control.LoggingService;
import com.ldbc.driver.workloads.simple.InsertOperation;
import com.ldbc.driver.workloads.simple.ReadModifyWriteOperation;
import com.ldbc.driver.workloads.simple.ReadOperation;
import com.ldbc.driver.workloads.simple.ScanOperation;
import com.ldbc.driver.workloads.simple.UpdateOperation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class XgtDb extends Db {
    static class BasicClient {
        BasicClient(String connectionUrl) {
            // TODO add actual initialization
        }
        Object execute(String queryString, Map<String, Object> queryParams) {
            // TODO add actual logic
            return null;
        }
    }

    static class XgtDbConnectionState extends DbConnectionState {
        private final BasicClient basicClient;
        private XgtDbConnectionState(String connectionUrl) {
            basicClient = new BasicClient(connectionUrl);
        }
        BasicClient client() {
            return basicClient;
        }
    }

    private XgtDbConnectionState connectionState = null;

    @Override
    public void onInit(Map<String, String> properties) throws DbException {
        String connectionUrl = properties.get("url");
        connectionState = new XgtDbConnectionState(connectionUrl);
        registerOperationHandler(ReadOperation.class, ReadOperationHandler.class);
        registerOperationHandler(UpdateOperation.class, UpdateOperationHandler.class);
    }

    @Override
    public void onCleanup() throws DbException {
        // perform any necessary cleaning up
    }

    public static class ReadOperationHandler extends OperationHandler<ReadOperation> {
        @Override
        public OperationResultReport executeOperation(ReadOperation operation) {
            Map<String, Object> queryParams = new HashMap<>();
            queryParams.put("table", operation.getTable());
            queryParams.put("key", operation.getKey());
            queryParams.put("fields", operation.getFields());

            // TODO replace with actual query string
            String queryString = null;

            BasicClient client = ((XgtDbConnectionState) dbConnectionState()).client();
            Integer result = (Integer) client.execute(queryString, queryParams);

            return operation.buildResult(0, result);
        }
    }

    public static class InsertOperationHandler extends OperationHandler<InsertOperation> {
        @Override
        public OperationResultReport executeOperation(ReadOperation operation) {
            Map<String, Object> queryParams = new HashMap<>();
            queryParams.put("table", operation.getTable());
            queryParams.put("key", operation.getKey());
            queryParams.put("fields", operation.getFields());

            // TODO replace with actual query string
            String queryString = null;

            BasicClient client = ((XgtDbConnectionState) dbConnectionState()).client();
            Integer result = (Integer) client.execute(queryString, queryParams);

            return operation.buildResult(0, result);
        }
    }

    @Override
    protected DbConnectionState getConnectionState() throws DbException {
        return connectionState;
    }
}
