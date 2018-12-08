function [Betas] = BackPropagation(y, Betas, Weights, NodeValues, totalNodes,outputNodes,hiddenNodes,nInputVariables )
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here
for i = totalNodes:totalNodes
    error = y - NodeValues(i);
    Betas(i) = round(error,4);
end
for i = totalNodes - outputNodes:-1:nInputVariables
    for j = i + 1:totalNodes
        Betas(i) = round(Betas(i) + Weights(j,i) * Betas(j), 4);
    end
    Betas(i) = round(Betas(i) * NodeValues(i)*(1-NodeValues(i)), 4);
end

