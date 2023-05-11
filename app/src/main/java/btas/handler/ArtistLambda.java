package btas.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import btas.firebase.ArtistsDAO;
import btas.firebase.model.Artist;
import btas.handler.baseHandler.BtasLambda;
import btas.handler.baseHandler.BtasLambdaRequest;
import btas.handler.baseHandler.BtasLambdaResponse;

public class ArtistLambda implements RequestHandler<BtasLambdaRequest<Artist>, BtasLambdaResponse<Artist>> {

    private ArtistsDAO dao = BtasLambda.injector.getInstance(ArtistsDAO.class);

    @Override
    public BtasLambdaResponse<Artist> handleRequest(BtasLambdaRequest<Artist> request, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Start Lambda Request: " + request.getOperation() + " " + request.getItem().getId() + "\n");

        BtasLambdaResponse<Artist> response = new BtasLambdaResponse<Artist>();
        BtasLambda.processRequest(dao, request, response);

        logger.log("Finish running Lambda. \n");
        return response;
    }

}
