package btas.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import btas.firebase.EventsDAO;
import btas.firebase.model.Event;
import btas.handler.baseHandler.BtasLambda;
import btas.handler.baseHandler.BtasLambdaRequest;
import btas.handler.baseHandler.BtasLambdaResponse;

public class EventLambda implements RequestHandler<BtasLambdaRequest<Event>, BtasLambdaResponse<Event>> {

    private EventsDAO dao = BtasLambda.injector.getInstance(EventsDAO.class);

    @Override
    public BtasLambdaResponse<Event> handleRequest(BtasLambdaRequest<Event> request, Context context) {
        BtasLambdaResponse<Event> response = new BtasLambdaResponse<Event>();

        LambdaLogger logger = context.getLogger();
        if (request == null) {
            response.setMessage("Request can't be NONE. ");
            return response;
        }

        logger.log("Start Lambda Request: " + request.getOperation() + " " + request.getItem().getId() + "\n");
        BtasLambda.processRequest(dao, request, response);
        logger.log("Finish running Lambda. \n");
        return response;
    }

}