package org.springframework.data.elasticsearch.core.bulk.response;

public class BulkDeleteResponse extends BulkGenericResponse {
    private boolean found;
    public boolean isFound(){
        return this.found;
    }
    public void setFound(boolean found){
        this.found = found;
    }
}
