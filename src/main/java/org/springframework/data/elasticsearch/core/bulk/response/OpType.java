package org.springframework.data.elasticsearch.core.bulk.response;

public enum OpType {
    /**
     * Index the source. If there an existing document with the id, it will
     * be replaced.
     */
    INDEX,
    /**
     * Creates the resource. Simply adds it to the index, if there is an existing
     * document with the id, then it won't be removed.
     */
    CREATE,
    /** Updates a document */
    UPDATE,
    /** Deletes a document */
    DELETE;
}
