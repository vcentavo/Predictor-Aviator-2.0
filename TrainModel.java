import weka.classifiers.Classifier;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class TrainModel {
    public static void main(String[] args) throws Exception {
        // Carregar dados históricos
        DataSource source = new DataSource("src/main/resources/historical_data.arff");
        Instances data = source.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);

        // Treinar o modelo de regressão linear
        Classifier model = new LinearRegression();
        model.buildClassifier(data);

        // Salvar o modelo treinado
        weka.core.SerializationHelper.write("src/main/resources/aviator_model.model", model);
    }
}
