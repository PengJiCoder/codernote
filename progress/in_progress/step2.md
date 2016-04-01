setup user register
- should display user register UI in the webpage
- should complete the user schema in mongo
- should update data in mongo DB


# register
  * username
  * passwd
  * repeat passwd
  * validate passwd:
    * use [bootstrap validator](http://1000hz.github.io/bootstrap-validator/)
  * post form to addUser
  

# save user in MongoDB
  * install mongodb: brew install mongodb
  * start mongodb: mongod --dbpath pathToDbFolder
  * check databse in mongodb shell: mongodb
  * Employ [play-jongo](https://github.com/alexanderjarvis/play-jongo) for using mongodb in play
  * modify build.sbt: libraryDependencies ++= Seq("uk.co.panaxiom" %% "play-jongo" % "1.0.1-jongo1.2")
  * modify application.conf: 
    * playjongo.uri="mongodb://127.0.0.1:27017/play"
    * playjongo.gridfs.enabled=false
  * add User class which called PlayJongo
  ```Java
  public class User {
    public static PlayJongo jongo = Play.application().injector().instanceOf(PlayJongo.class);
    public static MongoCollection users() {
        return jongo.getCollection("users");
    }
    @JsonProperty("_id")
    public ObjectId id;

    public String name;
    public String password;

    public void insert() {
        users().save(this);
    }

    public void remove() {
        users().remove(this.id);
    }

    public static User findByName(String name) {
        return users().findOne("{name: #}", name).as(User.class);
    }
  }
  ```
  
 
  

