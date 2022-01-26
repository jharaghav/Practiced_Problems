package designPatterns.Factory.SimpleFactoryPattern;

public class FactoryOfSource {
    IngestToDatabase ingestToDatabase = null;
    public IngestToDatabase getInstanceOfSource(String source){
        if (source.equals("API"))  ingestToDatabase = new SourceDataFromAPI();
        else if (source.equals("FILE"))  ingestToDatabase = new SourceDataFromFile();
        else if (source.equals("DATALAKE"))  ingestToDatabase = new SourceDataFromDataLake();
        else if(source.equals("DATABASE")) ingestToDatabase = new SourceFromDataBase();
        return ingestToDatabase;
    }
}
