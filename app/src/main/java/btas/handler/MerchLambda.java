package btas.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import btas.firebase.MerchDAO;
import btas.firebase.model.Merch;
import btas.handler.baseHandler.BtasLambda;
import btas.handler.baseHandler.BtasLambdaRequest;
import btas.handler.baseHandler.BtasLambdaResponse;

public class MerchLambda implements RequestHandler<BtasLambdaRequest<Merch>, BtasLambdaResponse<Merch>> {

    private MerchDAO dao = BtasLambda.injector.getInstance(MerchDAO.class);

    @Override
    public BtasLambdaResponse<Merch> handleRequest(BtasLambdaRequest<Merch> request, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Start Lambda Request: " + request.getOperation() + " " + request.getItem().getId() + "\n");

        BtasLambdaResponse<Merch> response = new BtasLambdaResponse<Merch>();
        BtasLambda.processRequest(dao, request, response);

        logger.log("Finish running Lambda. \n");
        return response;
    }

}
