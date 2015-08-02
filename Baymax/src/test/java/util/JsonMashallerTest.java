package util;

import com.baymax.baymax.model.User;
import com.baymax.baymax.servlet.identity.request.UserRequest;
import com.baymax.baymax.utils.marshaller.JsonMarshaller;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * IDEA 14
 * Created by qiqidone on 15-7-22.
 */
public class JsonMashallerTest {
    private JsonMarshaller marshaller = new JsonMarshaller();

    @Before
    public void init(){
    }


    @Test
    public void testFromJson(){
        UserRequest userRequest = new UserRequest();
        userRequest.setName("nameA");
        userRequest.setPass("passA");
        String request = String.format("{\"name\":\"%s\",\"pass\":\"%s\"}", userRequest.getName(), userRequest.getPass());
        UserRequest res = (UserRequest)marshaller.fromJson(request, UserRequest.class);

        Assert.assertEquals(res.toString(), userRequest.toString());
    }

    @Test
    public void testToJson(){
        UserRequest userRequest = new UserRequest();
        userRequest.setName("nameA");
        userRequest.setPass("passA");
        String request = String.format("{\"name\":\"%s\",\"pass\":\"%s\"}", userRequest.getName(), userRequest.getPass());
        String res = marshaller.toJson(userRequest);

        Assert.assertEquals(res, request);
    }

    @Test
    public void testFromJsonNull(){
        UserRequest userRequest = new UserRequest();
        userRequest.setName("nameA");
        userRequest.setPass("passA");
        String request = null;
        UserRequest res = (UserRequest)marshaller.fromJson(request, UserRequest.class);

        Assert.assertEquals(null, res);
    }

    @Test
    public void testToJsonNull(){
        UserRequest userRequest = null;
        String res = marshaller.toJson(userRequest);

        Assert.assertEquals(res, "");
    }

    @Test
    public void testFromJsonError(){
        UserRequest userRequest = new UserRequest();
        userRequest.setName("nameA");
        userRequest.setPass("passA");

        // Case sensitive
        String request = String.format("{\"Name\":\"%s\",\"paSs\":\"%s\"}", userRequest.getName(), userRequest.getPass());
        UserRequest res = (UserRequest)marshaller.fromJson(request, UserRequest.class);

        Assert.assertNull(res.getName());
        Assert.assertNull(res.getPass());
    }

    @Test
    public void testToJsonError(){
        UserRequest userRequest = new UserRequest();
        String res = marshaller.toJson(userRequest);

        /* return "{}" when null */
        Assert.assertEquals(res, "{}");
    }
}
