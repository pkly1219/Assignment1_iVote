
import java.util.*;
import java.util.List;


class SimulationDriver {
    public static void main(String[] args) {
        VotingService votingService = new VotingService();

        //Create a list of single-choice and multiple-choice question
        List<Question> questions = new ArrayList<>();
        //Multiple-choice questions
        questions.add(new Question("What are your favorite places?",
                Arrays.asList("A. New York", "B. San Jose", "C. Houston", "D. San Diego"), true));
        questions.add(new Question("What countries are in Asia?",
                Arrays.asList("A. Korea", "B. India", "C. New Zealand", "D. Egypt"), true));

        //Single-choice questions
        questions.add(new Question("Which human activity is the largest contributor to " +
                "the increase in atmospheric carbon dioxide levels?",
                Arrays.asList("A. Deforestation", "B. Burning fossil fuels", "C. Agriculture", "D. Industrial waste"), false));
        questions.add(new Question("Which one is the capital of Canada?",
                Arrays.asList("A. Ottawa", "B. Vancouver", "C. Ontario", "D. Quebec"), false));

        Random rand = new Random();

        //Random generate the number of student
        int numStudents = rand.nextInt(95) + 5;
        System.out.println("The number of student is: "+ numStudents);

        for (Question question : questions) {
            votingService.configureQuestion(question);

            for (int i = 1; i <= numStudents; i++) {
                Student student = new Student("Student" + i);

                // Simulate single-choice or multiple-choice answers
                if (!question.isMultipleChoice()) {
                    student.submitAnswer(rand.nextInt(question.getChoice().size()));
                } else {
                    List<Integer> answerIndices = new ArrayList<>();
                    int numChoices = rand.nextInt(question.getChoice().size()) + 1;
                    for (int j = 0; j < numChoices; j++) {
                        answerIndices.add(rand.nextInt(question.getChoice().size()));
                    }
                    student.submitAnswers(answerIndices);
                }

                votingService.acceptSubmission(student);
            }

            votingService.displayResult();
        }
    }
}

