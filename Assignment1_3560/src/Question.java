import java.util.List;

class Question
{
    private String question;
    private List<String> choice;

    private boolean multipleChoice;

    public Question(String question, List<String> choice, boolean multipleChoice) {
        this.question = question;
        this.choice = choice;
        this.multipleChoice = multipleChoice;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getChoice() {
        return choice;
    }

    public boolean isMultipleChoice() {
        return multipleChoice;
    }


}
