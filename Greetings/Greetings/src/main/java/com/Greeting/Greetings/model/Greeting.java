package com.Greeting.Greetings.model;

public class Greeting {
    private int greetId;
    private String message;

    public Greeting(int greetId, String message) {
        this.greetId = greetId;
        this.message = message;
    }
    public Greeting() {}

    public int getGreetId() {
        return greetId;
    }

    public void setGreetId(int greetId) {
        this.greetId = greetId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
