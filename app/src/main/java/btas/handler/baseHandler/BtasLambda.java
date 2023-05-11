package btas.handler.baseHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import com.google.inject.Guice;
import com.google.inject.Injector;

import btas.firebase.FirestoreDAO;
import btas.firebase.model.BtasModel;
import btas.module.AppModule;

public class BtasLambda {

    public final static Injector injector = Guice.createInjector(new AppModule());

    public static <T extends BtasModel> void processRequest(
                                        FirestoreDAO<T> dao, 
                                        BtasLambdaRequest<T> request, 
                                        BtasLambdaResponse<T> response) {        
        BtasLambdaRequest.Operation operation = request.getOperation();
        T item = (T) request.getItem();

        try {
            final List<T> items = new ArrayList<>();
            if (operation == BtasLambdaRequest.Operation.INSERT) {
                items.add(dao.addOrUpdate(item, item.getId()));
                response.setMessage("Finish adding: " + item.getId());
            } else if (operation == BtasLambdaRequest.Operation.DELETE) {
                items.add(dao.delete(item, item.getId()));
                response.setMessage("Finish deleting: " + item.getId());
            } else if (operation == BtasLambdaRequest.Operation.SEARCH) {
                items.add(dao.getDocById(item, item.getId()));
                response.setMessage("Finish searching: " + item.getId());
            } else if (operation == BtasLambdaRequest.Operation.SEARCHALL) {
                items.addAll(dao.getAll(item.getClass()));
                response.setMessage("Finish searching all.");
            } else {
                response.setMessage("Invaild operation: " + operation);
            }
            response.setItems(items);
        } catch (InterruptedException|ExecutionException e) {
            response.setMessage("Error: \n" + e.getMessage());
        }

    }

}
