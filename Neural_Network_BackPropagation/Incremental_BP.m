%This is a script to call forward propagation and incremental back
%propagation

outputNodes = 1;

nInputVariables = 2;

hiddenLayers = 1;

hiddenNodes = 3;

totalNodes = nInputVariables + hiddenNodes + outputNodes;

eta = 1;

Inputs = [0,1;1,0];

nInputs = 2;

Desired = [0,1];

Weights = zeros(totalNodes);
Weights(3,1) = 0.15;
Weights(6,1) = 0.1;
Weights(4,1) = -0.2;
Weights(4,2) = 0.2;
Weights(6,2) = -0.2;
Weights(5,2) = -0.1;
Weights(6,3) = -0.3;
Weights(6,4) = 0.1;
Weights(6,5) = -0.15;

NodeValues = [];

Betas = zeros([1 totalNodes]);

epochs = 100;

Errors = [];

Deltas = zeros(totalNodes);

MSE = 0;
for n = 1:epochs
    for in = 1:nInputs
        NodeValues = ForwardPropagation(Inputs(in,:), nInputVariables,totalNodes , Weights);
        Betas = BackPropagation(Desired(in), Betas,Weights, NodeValues, totalNodes, outputNodes, hiddenNodes, nInputVariables);
        
    for i = 1:totalNodes
        for j = 1:i
            if Weights(i,j) ~= 0
                wDelta = round(Betas(i) * eta * NodeValues(j),4);
                Deltas(i,j) = wDelta;
                Weights(i,j) = Weights(i,j) + wDelta;
            end
        end
    end
    Errors(i) = Betas(6);
    Betas = zeros([1 totalNodes]);
    Deltas = zeros([1 totalNodes]);
    end    
    MSE = sum(Errors.^2) / length(Errors);
    disp(MSE);
end
    

