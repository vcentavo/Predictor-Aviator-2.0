package com.exemplo.aviatorpredictor.service;

import com.exemplo.aviatorpredictor.model.Prediction;
import org.springframework.stereotype.Service;
import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

@Service
public class PredictorService {
    private Classifier model;

    public PredictorService() throws Exception {
        // Carregar o modelo treinado
        model = (Classifier) weka.core.SerializationHelper.read("src/main/resources/aviator_model.model");
    }

    public Prediction predict() {
        try {
            // Carregar novos dados para previsão
            DataSource source = new DataSource("src/main/resources/novos_dados.arff");
            Instances newData = source.getDataSet();
            newData.setClassIndex(newData.numAttributes() - 1);

            // Fazer previsão
            double prediction = model.classifyInstance(newData.instance(0));
            return new Prediction(prediction);
        } catch (Exception e) {
            e.printStackTrace();
            return new Prediction(-1); // valor de erro
        }
    }

    public void resetModel() {
        // Implementação para resetar ou recalcular o modelo, se necessário
    }
}
