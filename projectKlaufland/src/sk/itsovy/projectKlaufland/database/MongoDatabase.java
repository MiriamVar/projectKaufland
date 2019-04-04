package sk.itsovy.projectKlaufland.database;

public class MongoDatabase {

    private static MongoDatabase mongo = new MongoDatabase();

    private MongoDatabase(){

    }

    public static MongoDatabase getInstanceMongoDB(){
        return mongo;
    }

}
