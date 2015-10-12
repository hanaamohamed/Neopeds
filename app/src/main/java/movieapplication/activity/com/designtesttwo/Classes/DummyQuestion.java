package movieapplication.activity.com.designtesttwo.Classes;


public class DummyQuestion {
    String question;
    int priority;

    public DummyQuestion(int priority, String question) {
        this.priority = priority;
        this.question = question;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
