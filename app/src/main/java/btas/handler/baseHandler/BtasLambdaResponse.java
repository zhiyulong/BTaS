package btas.handler.baseHandler;

import java.util.List;

import btas.firebase.model.BtasModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BtasLambdaResponse<T extends BtasModel> {
    private String message;
    private List<T> items;
}
