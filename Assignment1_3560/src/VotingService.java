import java.util.HashMap;
import java.util.List;
import java.util.Map;

class VotingService {
    private Question question;
    private Map<Integer, Integer> answerCounts; // Map option index to count

    public void configureQuestion(Question question) {
        this.question = question;
        this.answerCounts = new HashMap<>();
        for (int i = 0; i < question.getOptions().size(); i++) {
            answerCounts.put(i, 0);
        }
    }

    public void acceptSubmission(Student student) {
        List<Integer> answers = student.getAnswers();
        for (int answerIndex : answers) {
            answerCounts.put(answerIndex, answerCounts.get(answerIndex) + 1);
        }
    }

    public void outputStatistics() {
        System.out.println("Results for question: " + question.getQuestionText());
        for (int i = 0; i < question.getOptions().size(); i++) {
            System.out.println((i + 1) + ". " + question.getOptions().get(i) + " : " + answerCounts.get(i));
        }
        System.out.println("--------------------------------------------------");
    }
}