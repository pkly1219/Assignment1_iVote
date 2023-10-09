import java.util.HashMap;
import java.util.List;
import java.util.Map;

class VotingService {
    private Question question;
    private Map<Integer, Integer> answerCounts; // Map option index to count

    public void configureQuestion(Question question) {
        this.question = question;
        this.answerCounts = new HashMap<>();
        for (int i = 0; i < question.getChoice().size(); i++) {
            answerCounts.put(i, 0);
        }
    }

    public void acceptSubmission(Student student) {
        List<Integer> answers = student.getAnswers();
        for (int answerIndex : answers) {
            answerCounts.put(answerIndex, answerCounts.get(answerIndex) + 1);
        }
    }

    public void displayResult() {
        if(question.isMultipleChoice())
            System.out.println("Multiple-choice question: ");
        else
            System.out.println ("Single-choice question: ");
        System.out.println("Results for question: " + question.getQuestion());
        for (int i = 0; i < question.getChoice().size(); i++) {

            System.out.println (question.getChoice().get(i) + " : " + answerCounts.get(i));
        }
        System.out.println("--------------------------------------------------");
    }
}
