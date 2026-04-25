package com.antigravity.jamagent.modules.chatbot;

import org.springframework.stereotype.Service;

@Service
public class KnowledgeBaseService {

    public String retrieveContext(String userMessage) {
        String msgLower = userMessage.toLowerCase();
        
        if (msgLower.contains("sn1") || msgLower.contains("sn2")) {
            return "CONTEXT: SN1 is a two-step mechanism, favored by tertiary substrates. SN2 is one-step, favored by primary substrates.";
        }
        if (msgLower.contains("thermodynamics") || msgLower.contains("gibbs") || msgLower.contains("entropy")) {
            return "CONTEXT: For a spontaneous process at constant T and P, Gibbs free energy change (ΔG) must be negative. ΔG = ΔH - TΔS.";
        }
        if (msgLower.contains("jam") || msgLower.contains("syllabus")) {
            return "CONTEXT: IIT JAM Chemistry covers Physical, Organic, and Inorganic Chemistry. The exam is 3 hours long with 60 questions.";
        }
        
        return "CONTEXT: General Chemistry principles apply.";
    }
}
