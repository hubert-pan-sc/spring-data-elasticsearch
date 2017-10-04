package org.springframework.data.elasticsearch.core.bulk.response;

public class BulkGenericResponse implements BulkGenericResponseInterface {

    //Operation type
    OpType actionType;
    //http status code
    Integer status;
    //error message
    String error;
    //ES index
    String index;
    //ES index subtype
    String type;
    //ES document id
    String id;
    //ES index version
    String version;

    @Override
    public OpType getActionType(){
        return actionType;
    }
    @Override
    public Integer getStatus(){
        return status;
    }
    @Override
    public String getError(){
        return error;
    }
    @Override
    public String getIndex(){
        return index;
    }
    @Override
    public String getType(){
        return type;
    }
    @Override
    public String getId(){
        return id;
    }
    @Override
    public String getVersion(){
        return version;
    }

    public void setActionType(OpType actionType){
        this.actionType = actionType;
    }

    public void setStatus(Integer status){
        this.status = status;
    }

    public void setError(String error){
        this.error = error;
    }

    public void setIndex(String index){
        this.index = index;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setVersion(String version){
        this.version = version;
    }

}
