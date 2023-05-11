package btas.handler.baseHandler;

import btas.firebase.model.BtasModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BtasLambdaRequest<T extends BtasModel> {
    
    public enum Operation {
        INSERT, DELETE, MODIFY, SEARCH, SEARCHALL
    }

    private Operation operation;
    private T item;
}