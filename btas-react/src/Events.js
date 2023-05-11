import { invokeLambdaFunction } from './lambda/lambdaFunctions';


var eventlambda = "EventLambda"

function Events(payload) {
    const handleClick = async () => {
      const lambdaResponse = await invokeLambdaFunction(eventlambda, payload);
      console.log(lambdaResponse);
    };
  
    return (
      <button onClick={handleClick}>Add</button>
    );
}