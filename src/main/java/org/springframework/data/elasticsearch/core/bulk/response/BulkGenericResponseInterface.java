package org.springframework.data.elasticsearch.core.bulk.response;

public interface BulkGenericResponseInterface {
    OpType getActionType();

    Integer getStatus();

    String getError();

    String getIndex();

    String getType();

    String getId();

    String getVersion();
}
