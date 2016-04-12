package org.youngapple.taskmaster.server.persistence.mongo;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.youngapple.taskmaster.server.service.Task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 *
 */
public class MongoDbClient {

  private static final String MONGO_SERVER = "localhost";
  private static final String MONGO_IP = "27017";
  private static final String MONGO_SERVER_SPEC = String.format(
      "mongodb://%s:%s", MONGO_SERVER, MONGO_IP);

  private static final String DB_NAME = "taskmaster";
  private static final String COLLECTION_NAME = "tasks";
  private final static DateFormat dateFormat =
      new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);

  private final MongoClient mongoClient;
  private final MongoCollection<Document> mongoCollection;

  @Inject
  public MongoDbClient() {
    mongoClient = new MongoClient(MONGO_SERVER_SPEC);
    MongoDatabase dataBase = mongoClient.getDatabase(DB_NAME);
    Preconditions.checkNotNull(dataBase);
    mongoCollection = dataBase.getCollection(COLLECTION_NAME);
    Preconditions.checkNotNull(mongoCollection);
  }

  public void saveTask(List<Task> tasks) {
    mongoCollection.insertMany(convertToDocuments(tasks));
  }

  private List<? extends Document> convertToDocuments(List<Task> tasks) {
    List<Document> documents = Lists.transform(tasks, new Function<Task, Document>() {
      @Override
      public Document apply(Task input) {
        return new Document().append("TaskId", input.getId());
      }
    });
    return documents;
  }

  public static void main(String[] args) {
    MongoClient mongoClient = new MongoClient(MONGO_SERVER);
    MongoDatabase database = mongoClient.getDatabase("local");
//    MongoIterable<String> a = mongoClient.listDatabaseNames();
//    a.forEach(
//        s -> System.out.println("DataBase:" + s),
//        (result, t) -> System.out.println("Finished:" + result)
//    );
//
//    DateFormat format = new SimpleDateFormat(
//        "yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
//    try {
//      database.getCollection("google").insertOne(
//          new Document("address",
//              new Document()
//                  .append("street", "2 Avenue")
//                  .append("zipcode", "10075")
//                  .append("building", "1480")
//                  .append("coord", asList(-73.9557413, 40.7720266)))
//              .append("borough", "Manhattan")
//              .append("cuisine", "Italian")
//              .append("grades", asList(
//                  new Document()
//                      .append("date", format.parse("2014-10-01T00:00:00Z"))
//                      .append("grade", "A")
//                      .append("score", 11),
//                  new Document()
//                      .append("date", format.parse("2014-01-16T00:00:00Z"))
//                      .append("grade", "B")
//                      .append("score", 17)))
//              .append("name", "Vella")
//              .append("restaurant_id", "41704620"),
//          new SingleResultCallback<Void>() {
//            @Override
//            public void onResult(Void result, Throwable t) {
//              System.out.println("Write finished!!");
//              FindIterable<Document> iterable = database.getCollection("google").find();
//              iterable.forEach(new Block<Document>() {
//                @Override
//                public void apply(Document document) {
//                  System.out.println("book!!");
//                  System.out.println(document);
//                }
//              }, (aVoid, throwable) -> System.out.println("Applied!!"));
//            }
//          });
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
  }
}
