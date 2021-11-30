package com.webbdong.mongodb.messagelistener;

import com.mongodb.client.model.changestream.ChangeStreamDocument;
import org.bson.Document;
import org.springframework.data.mongodb.core.messaging.Message;
import org.springframework.data.mongodb.core.messaging.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author: Webb Dong
 * @date: 2021-11-30 2:18 PM
 */
@Component
public class DocumentMessageListener implements MessageListener<ChangeStreamDocument<Document>, Document> {

    @Override
    public void onMessage(Message<ChangeStreamDocument<Document>, Document> message) {
        System.out.println("Received Message in collection: "
                        + message.getProperties().getCollectionName()
                        + ", message raw: " + message.getRaw()
                        + ", message body: " + message.getBody());
    }

}
