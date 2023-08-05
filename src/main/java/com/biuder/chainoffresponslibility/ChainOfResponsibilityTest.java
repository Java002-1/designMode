package com.biuder.chainoffresponslibility;

/**
 * 责任链模式
 */
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {

    }
}

class Request{
    private  boolean loggedOn;
    private  boolean frequentOk;

    private boolean isPermits;

    private boolean containsSensitiveWords;

    private String requestBody;

    public Request(boolean loggedOn, boolean frequentOk, boolean isPermits, boolean containsSensitiveWords, String requestBody) {
        this.loggedOn = loggedOn;
        this.frequentOk = frequentOk;
        this.isPermits = isPermits;
        this.containsSensitiveWords = containsSensitiveWords;
        this.requestBody = requestBody;
    }


    static class RequestBuilder{
        private  boolean loggedOn;
        private  boolean frequentOk;

        private boolean isPermits;

        private boolean containsSensitiveWords;

        private String requestBody;

        public RequestBuilder loggedOn(boolean loggedOn) {
            this.loggedOn = loggedOn;
            return this;
        }

        public RequestBuilder frequentOk(boolean frequentOk) {
            this.frequentOk = frequentOk;
            return this;
        }

        public RequestBuilder isPermits(boolean isPermits) {
            this.isPermits = isPermits;
            return this;
        }

        public RequestBuilder containsSensitiveWords(boolean containsSensitiveWords) {
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }

        public RequestBuilder requestBody(String requestBody) {
            this.requestBody = requestBody;
            return this;
        }

        public Request build(){
            return new Request(this.loggedOn,this.frequentOk,this.isPermits,this.containsSensitiveWords,this.requestBody);
        }

    }

    public boolean isLoggedOn() {
        return loggedOn;
    }

    public void setLoggedOn(boolean loggedOn) {
        this.loggedOn = loggedOn;
    }

    public boolean isFrequentOk() {
        return frequentOk;
    }

    public void setFrequentOk(boolean frequentOk) {
        this.frequentOk = frequentOk;
    }

    public boolean isPermits() {
        return isPermits;
    }

    public void setPermits(boolean permits) {
        isPermits = permits;
    }

    public boolean isContainsSensitiveWords() {
        return containsSensitiveWords;
    }

    public void setContainsSensitiveWords(boolean containsSensitiveWords) {
        this.containsSensitiveWords = containsSensitiveWords;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }
}


abstract class Handler{
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean handleRequest(Request request);
}

class RequestFrequentHandler extends Handler{


    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean handleRequest(Request request) {
        System.out.println("控制访问频率");
        if(request.isFrequentOk()){
            Handler next1 = getNext();
            if(next1 == null){
                return true;
            }
            return next1.handleRequest(request);
        }
        return false;
    }
}

class LoggingHandler extends Handler{

    public LoggingHandler(Handler next) {
        super(next);
    }

    @Override
    boolean handleRequest(Request request) {
        System.out.println("登录验证...");
        if (request.isLoggedOn()) {
            Handler next1 = getNext();
            if(next1 == null){
                return true;
            }
            return next1.handleRequest(request);
        }
        return false;
    }
}