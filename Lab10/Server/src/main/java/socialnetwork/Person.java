package socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private List<Person> friendList = new ArrayList<Person>();
    private List<String> messageList = new ArrayList<String>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Person> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Person> friendList) {
        this.friendList = friendList;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    public void addMessage(String x) {
        messageList.add(x);
    }
}
