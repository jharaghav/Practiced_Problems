package designPatterns.Factory.DIFramework;

/**
 * https://www.youtube.com/watch?v=qNMvv-6CtEU&list=PLJN9ydlFnJsi6-lev2fQ2f1X7YD-VPQVW&index=4
 */
public class FactoryMain {
    public static void main(String[] args) {

       // IngestionService onPremiseObject = new OnPremiseStorage();
       // onPremiseObject.ingestDataToMyDatabase("API");
        StorageFactory storageFactory = new StorageFactory();
        IngestionService cloudObject = storageFactory.getStorageService("CLOUD");
        cloudObject.ingestDataToMyDatabase("API");
        IngestionService onPremise = storageFactory.getStorageService("ONPREMISE");
        onPremise.ingestDataToMyDatabase("FILE");


    }
}
