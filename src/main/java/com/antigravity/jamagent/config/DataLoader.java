package com.antigravity.jamagent.config;

import com.antigravity.jamagent.models.Question;
import com.antigravity.jamagent.models.Subject;
import com.antigravity.jamagent.models.Topic;
import com.antigravity.jamagent.modules.exam.QuestionRepository;
import com.antigravity.jamagent.modules.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void run(String... args) throws Exception {
        if (topicRepository.count() == 0) {
            System.out.println("Loading sample JAM Chemistry data...");

            // Create a Subject
            Subject organic = new Subject();
            organic.setName("Organic Chemistry");
            organic.setCode("OC");
            organic.setJamWeightage(35.0);
            organic.setColorCode("#10B981");

            // In a real app we'd save Subject first, but we don't have SubjectRepository yet, 
            // and we set cascade or just save topic. Actually we need SubjectRepository or we can just leave it null for this dummy data.
            // Let's just create Topics without saving Subject for the sake of this mock data since it's nullable by default.

            // Topic 1
            Topic topic1 = new Topic();
            topic1.setTitle("Nucleophilic Substitution (SN1 vs SN2)");
            topic1.setContentJson("{ \"summary\": \"SN1 is a two-step mechanism favored by tertiary substrates. SN2 is a one-step concerted mechanism favored by primary substrates.\", \"formulas\": [\"Rate(SN1) = k[R-X]\", \"Rate(SN2) = k[R-X][Nu]\"] }");
            topic1.setDifficulty("INTERMEDIATE");
            topic1.setSequenceNo(1);
            topicRepository.save(topic1);

            // Topic 2
            Topic topic2 = new Topic();
            topic2.setTitle("Chemical Thermodynamics");
            topic2.setContentJson("{ \"summary\": \"First Law: dU = dq + dw. Second Law: Entropy of an isolated system always increases.\", \"formulas\": [\"ΔG = ΔH - TΔS\"] }");
            topic2.setDifficulty("ADVANCED");
            topic2.setSequenceNo(2);
            topicRepository.save(topic2);

            // Question 1
            Question q1 = new Question();
            q1.setTopic(topic1);
            q1.setText("Which of the following alkyl halides undergoes SN1 reaction most rapidly?");
            q1.setOptionsJson("{\"A\": \"CH3Cl\", \"B\": \"CH3CH2Cl\", \"C\": \"(CH3)2CHCl\", \"D\": \"(CH3)3CCl\"}");
            q1.setCorrectAnswer("D");
            q1.setType("MCQ");
            q1.setDifficulty("EASY");
            q1.setExamYear(2022);
            questionRepository.save(q1);

            // Question 2
            Question q2 = new Question();
            q2.setTopic(topic2);
            q2.setText("For a spontaneous process at constant temperature and pressure, the change in Gibbs free energy (ΔG) must be:");
            q2.setOptionsJson("{\"A\": \"Positive\", \"B\": \"Zero\", \"C\": \"Negative\", \"D\": \"Cannot be determined\"}");
            q2.setCorrectAnswer("C");
            q2.setType("MCQ");
            q2.setDifficulty("BASIC");
            q2.setExamYear(2023);
            questionRepository.save(q2);

            System.out.println("Sample data loaded successfully.");
        }
    }
}
