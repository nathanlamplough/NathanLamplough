function [NodeValues] = ForwardPropagation(x, nInputVariables,totalNodes , Weights)
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
NodeValues = zeros([1 totalNodes]);
for i = 1:nInputVariables
    NodeValues(i) = x(i);

end

for i = nInputVariables+1:totalNodes 
    sum = 0;
    for j = 1:i
        sum = sum + Weights(i,j) * NodeValues(j);
    end
    if i ~= totalNodes
        NodeValues(i) = round(1 / (1 + exp(-sum)),4);
    else
         NodeValues(i) = round(sum, 4);
    end
end


