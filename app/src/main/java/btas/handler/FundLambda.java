package btas.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import btas.firebase.EventFundDAO;
import btas.firebase.model.EventFund;
import btas.handler.baseHandler.BtasLambda;
import btas.handler.baseHandler.BtasLambdaRequest;
import btas.handler.baseHandler.BtasLambdaResponse;

public class FundLambda implements RequestHandler<BtasLambdaRequest<EventFund>, BtasLambdaResponse<EventFund>> {

    private EventFundDAO dao = BtasLambda.injector.getInstance(EventFundDAO.class);

    @Override
    public BtasLambdaResponse<EventFund> handleRequest(BtasLambdaRequest<EventFund> request, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Start Lambda Request: " + request.getOperation() + " " + request.getItem().getId() + "\n");

        BtasLambdaResponse<EventFund> response = new BtasLambdaResponse<EventFund>();
        BtasLambda.processRequest(dao, request, response);

        logger.log("Finish running Lambda. \n");
        return response;
    }

}
