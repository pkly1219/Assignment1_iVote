// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
import java.util.List;


class SimulationDriver {
    public static void main(String[] args) {
        VotingService votingService = new VotingService();

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What are your favorite places?",
                Arrays.asList("New York", "San Jose", "Houston", "San Diego")));
        questions.add(new Question("Which human activity is the largest contributor to the increase in atmospheric carbon dioxide levels?",
                Arrays.asList("Deforestation", "Burning fossil fuels", "Agriculture", "Industrial waste")));

        Random rand = new Random();

        for (Question question : questions) {
            votingService.configureQuestion(question);

            int numStudents = rand.nextInt(95) + 5;
            System.out.println("The number of student is: "+ numStudents);
            for (int i = 1; i <= numStudents; i++) {
                Student student = new Student("Student" + i);

                // Simulate single-choice or multiple-choice answers
                if (rand.nextBoolean()) {
                    student.submitAnswer(rand.nextInt(question.getOptions().size()));
                } else {
                    List<Integer> answerIndices = new ArrayList<>();
                    int numChoices = rand.nextInt(question.getOptions().size()) + 1;
                    for (int j = 0; j < numChoices; j++) {
                        answerIndices.add(rand.nextInt(question.getOptions().size()));
                    }
                    student.submitAnswers(answerIndices);
                }

                votingService.acceptSubmission(student);
            }

            votingService.outputStatistics();
        }
    }
}

