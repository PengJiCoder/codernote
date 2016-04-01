package models;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import play.Play;
import uk.co.panaxiom.playjongo.PlayJongo;

/**
 * Created by Peng on 3/31/16.
 */

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
