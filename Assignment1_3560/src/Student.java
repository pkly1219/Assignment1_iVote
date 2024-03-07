import java.util.ArrayList;
import java.util.List;

class Student {
    
    private String id;
    private List<Integer> answers; // Indices of chosen options

    public Student(String id) {
        this.id = id;
        this.answers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public void submitAnswer(int answerIndex) {
        answers.clear(); // For single-choice questions
        answers.add(answerIndex);
    }

    public void submitAnswers(List<Integer> answerIndices) {
        answers.clear(); // Clear previous answers for multiple-choice questions
        answers.addAll(answerIndices);
    }
}
