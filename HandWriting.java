package MNIST;

import neuralnetwork.activatefunction.ReLU;
import neuralnetwork.activatefunction.Sigmoid;
import neuralnetwork.activatefunction.Softmax;
import neuralnetwork.dataset.Dataset;
import neuralnetwork.datasetload.LoadMNIST;
import neuralnetwork.initializemethod.HeInitialization;

import neuralnetwork.inputfunction.InputNormalize;
import neuralnetwork.machinelearning.NeuralNetwork;

import neuralnetwork.machinelearning.Train;

public class HandWriting {
    public static void main(String[] args) throws Exception {
        NeuralNetwork nn = new NeuralNetwork(0.01);
        nn.addInputLayer(new InputNormalize(), 784);
        nn.addHiddenLayer(new ReLU(), 300);
        nn.addHiddenLayer(new ReLU(), 70);
        nn.addOutputLayer(new Softmax(), 10);
        Dataset train = LoadMNIST.load("Java-Neural-Network/MNIST/data/train-images.idx3-ubyte", "C:/Users/Dell/Desktop/Java ANN final/Java-Neural-Network/MNIST/data/train-labels.idx1-ubyte");
        Dataset test = LoadMNIST.load("C:/Users/Dell/Desktop/Java ANN final/Java-Neural-Network/MNIST/data/t10k-images.idx3-ubyte", "C:/Users/Dell/Desktop/Java ANN final/Java-Neural-Network/MNIST/data/t10k-labels.idx1-ubyte");
        Train tr = new Train(nn);
        tr.Initialize(new HeInitialization());
        //tr.Initialize(new LoadSettingFile());
        tr.setTrainDataset(train);
        tr.setTestDataset(test);
        tr.run(4, 5, true);
        //tr.runTest();
        
    }
}
